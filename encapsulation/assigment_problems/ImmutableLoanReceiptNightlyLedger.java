public final class ImmutableLoanReceiptNightlyLedger {
    public static final class LoanReceipt {
        private final String memberId;
        private final String[] bookIds;

        public LoanReceipt(String memberId, String[] bookIds) {
            if (bookIds == null) {
                throw new IllegalArgumentException("bookIds cannot be null");
            }

            String[] copy = bookIds.clone();
            for (String id : copy) {
                if (id == null || !id.matches("BK-\\d{3}")) {
                    throw new IllegalArgumentException("Invalid book ID");
                }
            }

            this.memberId = memberId;
            this.bookIds = copy;
        }

        public String[] getBookIds() {
            return bookIds.clone();
        }

        public LoanReceipt withCorrectedBookId(int index, String newId) {
            if (index < 0 || index >= bookIds.length || newId == null
                    || !newId.matches("BK-\\d{3}")) {
                throw new IllegalArgumentException("Invalid correction");
            }

            String[] corrected = bookIds.clone();
            corrected[index] = newId;
            return new LoanReceipt(memberId, corrected);
        }
    }

    public static final class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }
    }

    private static final String LEDGER_NAME;

    static {
        LEDGER_NAME = "Nightly Circulation Ledger";
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts != null) {
            for (LoanReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnly++;
                } else {
                    regular++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }
}
