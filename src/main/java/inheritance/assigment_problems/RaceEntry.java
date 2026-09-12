package inheritance.assigment_problems;

public class RaceEntry {
    private static int bibCounter;
    private final String entryCode;
    private final double entryFee;
    private double balanceDue;
    private final double[] lateFeeHistory = new double[10];
    private int lateFeeCount;

    public RaceEntry(String bibNumber, double entryFee) {
        if (bibNumber == null || bibNumber.trim().length() < 4 || entryFee <= 0)
            throw new IllegalArgumentException("Invalid race entry");
        bibCounter++;
        entryCode = "RACE-" + bibCounter;
        this.entryFee = entryFee;
        balanceDue = entryFee;
    }

    public void pay(double amount) {
        if (amount > 0)
            balanceDue = Math.max(0, balanceDue - amount);
    }

    public void pay(double amount, String mode) {
        System.out.println("Paying via " + mode);
        pay(amount);
    }

    protected void applyLateFee(double amount) {
        balanceDue += amount;
        lateFeeHistory[lateFeeCount++] = amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public double[] getLateFeeHistory() {
        double[] copy = new double[lateFeeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, lateFeeCount);
        return copy;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public void announce() {
        System.out.println("Race Entry | Code: " + entryCode + " | Balance: " + balanceDue);
    }

    public static boolean isValidDiscountCode(String code) {
        if (code == null || code.length() != 5 || code.charAt(0) != 'M')
            return false;
        return Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isDigit(code.charAt(3))
                && Character.isUpperCase(code.charAt(4));
    }

    public static int getBibCounter() {
        return bibCounter;
    }

    public static String settleNight(RaceEntry[] entries) {
        int processed = 0, skipped = 0, relay = 0, individual = 0;
        for (RaceEntry entry : entries) {
            if (entry == null) {
                skipped++;
                continue;
            }
            processed++;
            if (entry instanceof RelayTeamEntry)
                relay++;
            else
                individual++;
        }
        return processed + " processed | " + skipped + " null skipped | "
                + relay + " relay | " + individual + " individual";
    }

    public static String registerBatch(String[] bibNumbers, double entryFee) {
        int registered = 0, rejected = 0;
        for (String bib : bibNumbers) {
            try {
                new RaceEntry(bib, entryFee);
                registered++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Registered: " + registered + " | Rejected: " + rejected;
    }
}
