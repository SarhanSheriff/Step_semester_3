package inheritance.assignment_problems;

public class CirculationLedger {
    static {
        System.out.println("Nightly circulation ready");
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, skipped = 0, referenceOnly = 0, regular = 0;
        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                skipped++;
                continue;
            }
            processed++;
            if (receipt instanceof ReferenceOnlyLoanReceipt) referenceOnly++;
            else regular++;
        }
        return processed + " processed | " + skipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }
}
