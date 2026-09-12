package inheritance.assigment_problems;

public class EliteRunnerEntry extends RunnerEntry {
    private final double sponsorBonus;

    public EliteRunnerEntry(String bibNumber, double entryFee, String category, double sponsorBonus) {
        super(bibNumber, entryFee, category);
        this.sponsorBonus = sponsorBonus;
    }

    @Override
    public void announce() {
        System.out.println("Elite Runner | Category: " + getCategory()
                + " | Sponsor Bonus: " + sponsorBonus
                + " | Balance: " + getBalanceDue());
    }
}
