package inheritance.assignment_problems;

public class RunnerEntry extends RaceEntry {
    private final String category;

    public RunnerEntry(String id, double fee, String category) {
        super(id, fee);
        this.category = category;
    }

    public RunnerEntry(double fee, String category) {
        super(fee);
        this.category = category;
    }

    public String getCategory() { return category; }

    @Override
    public void printEntry() {
        System.out.println("Runner Entry | Category: " + category
                + " | Fee: " + getFee());
    }

    @Override
    protected void applyLateFee(double amount) {
        super.applyLateFee(amount * 2);
    }
}
