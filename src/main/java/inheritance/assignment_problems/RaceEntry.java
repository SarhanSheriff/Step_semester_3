package inheritance.assignment_problems;

public class RaceEntry {
    private static int bibCounter = 1000;
    private final int bibNumber;
    private final String runnerId;
    private double fee;

    public RaceEntry(String runnerId, double fee) {
        if (runnerId == null || runnerId.trim().length() < 4 || fee <= 0)
            throw new IllegalArgumentException();
        this.runnerId = runnerId;
        this.fee = fee;
        bibNumber = ++bibCounter;
    }

    public RaceEntry(double fee) {
        this("RUN" + (bibCounter + 1), fee);
    }

    public void pay(double amount) {
        if (amount > 0)
            fee = Math.max(0, fee - amount);
    }

    public void pay(double amount, String mode) {
        System.out.println("Paid by: " + mode);
        pay(amount);
    }

    public int getBibNumber() { return bibNumber; }
    public double getFee() { return fee; }
    public String getRunnerId() { return runnerId; }

    public void printEntry() {
        System.out.println("Race Entry | Bib: " + bibNumber + " | Fee: " + fee);
    }

    public static boolean isValidDiscount(String code) {
        return code != null && code.matches("R\\d{3}[A-Z]");
    }

    public static String registerBatch(String[] ids, double fee) {
        int ok = 0, rejected = 0;
        for (String id : ids) {
            try {
                new RaceEntry(id, fee);
                ok++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Registered: " + ok + " | Rejected: " + rejected;
    }

    protected void applyLateFee(double amount) {
        if (amount > 0)
            fee += amount;
    }
}
