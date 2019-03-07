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

    public static ArrayList<ElectionResult> parse2016ElelectionResults(String data) {
        ArrayList<ElectionResult> results = new ArrayList<>();
        String[] initial = data.split(", ");
        ArrayList<String> vals = removeExtraPunctuation(initial);
        for(int i = 1; i < vals.size(); i++) {
            double votes_dem = Double.parseDouble(vals.get(1));
            double votes_gop = Double.parseDouble(vals.get(2));
            double total_votes = Double.parseDouble(vals.get(3));
            double per_dem = Double.parseDouble(vals.get(4));
            double per_gop = Double.parseDouble(vals.get(5));
            double diff = Double.parseDouble(vals.get(6));
            double per_point_diff = Double.parseDouble(vals.get(7)) / 100;
            String state_abbr = vals.get(8);
            String county_name = vals.get(9);
            int combined_fips = Integer.parseInt(vals.get(10));
            ElectionResult result = new ElectionResult(votes_dem, votes_gop, total_votes, per_dem,per_gop,diff,per_point_diff,state_abbr,county_name,combined_fips);
            results.add(result);
        }
        return  results;
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
