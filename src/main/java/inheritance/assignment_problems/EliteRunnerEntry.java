package inheritance.assignment_problems;

public class EliteRunnerEntry extends RunnerEntry {
    private final double trainingFee;

    public EliteRunnerEntry(String id, double fee, String category, double trainingFee) {
        super(id, fee, category);
        if (trainingFee < 0)
            throw new IllegalArgumentException();
        this.trainingFee = trainingFee;
    }

    public double getTrainingFee() { return trainingFee; }

    @Override
    public double getFee() {
        return super.getFee() + trainingFee;
    }

    @Override
    public void printEntry() {
        System.out.println("Elite Runner | Category: " + getCategory()
                + " | Training Fee: " + trainingFee
                + " | Fee: " + getFee());
    }
}
