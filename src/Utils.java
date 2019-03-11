import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static DataManager parseAll(String electionData, String educationData, String employmentData) {
        DataManager dataManager = new DataManager();
        Election016 election = new Election016(-1,-1,-1);
        Education016 education = new Education016(-1,-1,-1,-1);
        Employment016 employment = new Employment016(-1,-1,-1,-1);
        String[] initialElection = electionData.split(", ");
        ArrayList<String> valsElection = removeExtraPunctuation(initialElection);
        String[] initialEducation = electionData.split(", ");
        ArrayList<String> valsEducation = removeExtraPunctuation(initialEducation);
        String[] initialEmployment = electionData.split(", ");
        ArrayList<String> valsEmployment = removeExtraPunctuation(initialEmployment);

        for(int i = 1; i < valsElection.size(); i++) {
            election.setDemVotes(Double.parseDouble(valsElection.get(1)));
            election.setGopVotes(Double.parseDouble(valsElection.get(2)));
            election.setTotalVotes(Double.parseDouble(valsElection.get(3)));
            String state_abbr = valsElection.get(8);
            String county_name = valsElection.get(9);
            int combined_fips = Integer.parseInt(valsElection.get(10));
            int stateLoc = -1;
            if(dataManager.getStates().contains(state_abbr)==false) {
                State state = new State(state_abbr);
            }else{
                for(int j = 0; j <dataManager.getStates().size(); j++){
                    if(dataManager.getStates().get(j).getName()==state_abbr ){
                        stateLoc = j;
                    }
                }
            }
            int countyLoc = -1;
            if(dataManager.getStates().get(stateLoc).getCounties().contains(county_name)==false){
                County county = new County(county_name,combined_fips, election, education, employment);
            }else{
                for(int d = 0; d <dataManager.getStates().get(stateLoc).getCounties().size(); d++){
                    if(dataManager.getStates().get(stateLoc).getCounties().get(d).getName()==county_name ){
                        countyLoc = d;
                    }
                }
            }
            dataManager.getStates().get(stateLoc).getCounties().get(countyLoc).setFips(combined_fips);
            dataManager.getStates().get(stateLoc).getCounties().get(countyLoc).setVote016(election);
        }
        for(int i = 5; i< valsEducation.size(); i++){
            String countyName = valsEducation.get(1+1);
            education.setNoHighSchool(Integer.parseInt(valsEducation.get(7)));
            education.setOnlyHighSchool(Integer.parseInt(valsEducation.get(8)));
            education.setSomeCollege(Integer.parseInt(valsEducation.get(9)));
            education.setBachelorsOrMore(Integer.parseInt(valsEducation.get(10)));
            for(int j = 0; j < dataManager.getStates().size(){
                for(int d = 0; d < dataManager.getStates().get(j).getCounties().size()){
                    if(dataManager.getStates().get(j).getCounties().get(d).getName() == countyName){
                        dataManager.getStates().get(j).getCounties().get(d).setEduc016(education);
                    }
                }
            }
        }
        for(int i = 8; i< valsEducation.size(); i++){
            String countyName = valsEmployment.get(1+1);
            employment.setTotalLaborForce(Integer.parseInt(valsEmployment.get(7)));
            employment.setEmployedLaborForce(Integer.parseInt(valsEmployment.get(8)));
            employment.setUnemployedLaborForce(Integer.parseInt(valsEmployment.get(9)));
            employment.setUnemployedPercent(Integer.parseInt(valsEmployment.get(10)));
            for(int j = 0; j < dataManager.getStates().size(){
                for(int d = 0; d < dataManager.getStates().get(j).getCounties().size()){
                    if(dataManager.getStates().get(j).getCounties().get(d).getName() == countyName){
                        dataManager.getStates().get(j).getCounties().get(d).setEmploy016(employment);
                    }
                }
            }
        }

        return  dataManager;
    }

    private static ArrayList<String> removeExtraPunctuation(String[] initial) {
        ArrayList<String> output = new ArrayList<>();
        for(String value:initial){
            if(value.contains(",")) value = value.replace(",", "");
            if(value.contains("\"")) value = value.replace("\"", "");
            if(value.contains("%")) value = value.replace("%", "");
            //other punctuation for generalization
            if(value.contains("!")) value = value.replace("!", "");
            if(value.contains("#")) value = value.replace("#", "");
            if(value.contains("^")) value = value.replace("^", "");
            if(value.contains("$")) value = value.replace("$", "");
            if(value.contains("*")) value = value.replace("*", "");

            value = value.trim();

            output.add(value);
        }
        return output;
    }
}
