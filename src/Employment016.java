public class Employment016 {

    private int totalLaborForce;
    private int employedLaborForce;
    private int unemployedLaborForce;
    private int unemployedPercent;

    public Employment016(int totalLaborForce, int employedLaborForce, int unemployedLaborForce, int unemployedPercent) {
        this.totalLaborForce = totalLaborForce;
        this.employedLaborForce = employedLaborForce;
        this.unemployedLaborForce = unemployedLaborForce;
        this.unemployedPercent = unemployedPercent;
    }

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEmployedLaborForce() {
        return employedLaborForce;
    }

    public void setEmployedLaborForce(int employedLaborForce) {
        this.employedLaborForce = employedLaborForce;
    }

    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }

    public int getUnemployedPercent() {
        return unemployedPercent;
    }

    public void setUnemployedPercent(int unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
    }
}
