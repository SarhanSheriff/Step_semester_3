package inheritance.assignment_problems;

public class RaceEntry {
    private static int bibCounter;
    private final String bibNumber;
    private final double entryFee;
    private double balanceDue;
    private final double[] lateFeeHistory = new double[10];
    private int feeCount;

    public RaceEntry(String bibNumber, double entryFee) {
        if (bibNumber == null || bibNumber.trim().length() < 4 || entryFee <= 0)
            throw new IllegalArgumentException();
        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
        balanceDue = entryFee;
        bibCounter++;
    }

    public void pay(double amount) {
        if (amount > 0) balanceDue = Math.max(0, balanceDue - amount);
    }

    public void pay(double amount, String mode) {
        System.out.println("Paying via " + mode);
        pay(amount);
    }

    protected void applyLateFee(double amount) {
        balanceDue += amount;
        if (feeCount < lateFeeHistory.length) lateFeeHistory[feeCount++] = amount;
    }

    public double[] getLateFeeHistory() {
        double[] copy = new double[feeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, feeCount);
        return copy;
    }

    public double getBalanceDue() { return balanceDue; }
    public String getBibNumber() { return bibNumber; }
    public double getEntryFee() { return entryFee; }

    public void announce() {
        System.out.println("Race Entry | Bib: " + bibNumber + " | Balance: " + balanceDue);
    }

    public static int getBibCounter() { return bibCounter; }

    public static boolean isValidDiscountCode(String code) {
        if (code == null || code.length() != 5 || code.charAt(0) != 'M') return false;
        return Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isDigit(code.charAt(3))
                && Character.isUpperCase(code.charAt(4));
    }

    public static String registerBatch(String[] bibNumbers, double entryFee) {
        int registered = 0, rejected = 0;
        for (String bib : bibNumbers) {
            try { new RaceEntry(bib, entryFee); registered++; }
            catch (IllegalArgumentException e) { rejected++; }
        }
        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public static String settleNight(RaceEntry[] entries) {
        int processed = 0, skipped = 0, relay = 0, individual = 0;
        for (RaceEntry entry : entries) {
            if (entry == null) { skipped++; continue; }
            processed++;
            if (entry instanceof RelayTeamEntry) relay++; else individual++;
        }
        return processed + " processed | " + skipped + " null skipped | "
                + relay + " relay | " + individual + " individual";
    }
}
