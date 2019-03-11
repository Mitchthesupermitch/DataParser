public class County {
    private String name;
    private int fips;
    private Election016 vote016;
    private Education016 educ016;
    private Employment016 employ016;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFips() {
        return fips;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public Election016 getVote016() {
        return vote016;
    }

    public void setVote016(Election016 vote016) {
        this.vote016 = vote016;
    }

    public Education016 getEduc016() {
        return educ016;
    }

    public void setEduc016(Education016 educ016) {
        this.educ016 = educ016;
    }

    public Employment016 getEmploy016() {
        return employ016;
    }

    public void setEmploy016(Employment016 employ016) {
        this.employ016 = employ016;
    }

    public County(String name, int fips, Election016 vote016, Education016 educ016, Employment016 employ016) {

        this.name = name;
        this.fips = fips;
        this.vote016 = vote016;
        this.educ016 = educ016;
        this.employ016 = employ016;
    }
}
