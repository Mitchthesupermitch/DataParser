import java.util.ArrayList;

/***
 * main class for data parser
 */
public class Main {
    public static void main(String[] args){
        //Test of utils

        String electionData = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String educationData = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String employmentData = Utils.readFileAsString("data/2016_Presidential_Results.csv");


        DataManager dataManager = new DataManager();
        dataManager = Utils.parseAll(electionData, educationData, employmentData);
    }
}
