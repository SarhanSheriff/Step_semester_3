public class BookCopyCirculationGuard {
    static class BookInventory {
        private final int copiesTotal;
        private int copiesAvailable;

        BookInventory(int copiesTotal) {
            if (copiesTotal <= 0) {
                throw new IllegalArgumentException("copiesTotal must be positive");
            }
            this.copiesTotal = copiesTotal;
            this.copiesAvailable = copiesTotal;
        }

        void checkOut() {
            if (copiesAvailable > 0) {
                copiesAvailable--;
            }
        }

        void checkIn() {
            if (copiesAvailable < copiesTotal) {
                copiesAvailable++;
            }
        }

        int getCopiesAvailable() {
            return copiesAvailable;
        }
    }
}
