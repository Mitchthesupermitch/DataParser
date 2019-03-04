public class ElectionResult {
    private double votes_dem, votes_gop, total_votes, per_dem, per_gop, per_point_diff, diff;
    private String state_abbr, county_name;
    private int combined_fips;

    public ElectionResult(double votes_dem, double votes_gop, double total_votes, double per_dem, double per_gop, double diff, double per_point_diff, String state_abbr, String county_name, int combined_fips){
        votes_dem = this.votes_dem;
        votes_gop = this.votes_gop;
        total_votes = this.total_votes;
        per_dem = this.per_dem;
        per_gop = this.per_gop;
        diff = this.diff;
        per_point_diff = this.per_point_diff;
        state_abbr = this.state_abbr;
        county_name = this.county_name;
        combined_fips = this.combined_fips;
    }
}
