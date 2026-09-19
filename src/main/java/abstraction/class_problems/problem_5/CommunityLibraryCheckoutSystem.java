package abstraction.class_problems.problem_5;

public class CommunityLibraryCheckoutSystem {
    static abstract class LibraryItem {
        private static int nextId = 1001;
        private final String itemId = "LIB-" + nextId++;

        public abstract int getLoanPeriodDays();

        public String getItemId() {
            return itemId;
        }
    }

    interface Renewable {
        String renew();
    }

    interface Reservable {
        String reserve();
    }

    static class Textbook extends LibraryItem implements Renewable, Reservable {
        private final String title;

        Textbook(String title) {
            this.title = title;
        }

        @Override
        public int getLoanPeriodDays() {
            return 14;
        }

        @Override
        public String renew() {
            return title + " renewed";
        }

        @Override
        public String reserve() {
            return title + " reserved";
        }
    }

    static class Magazine extends LibraryItem implements Renewable {
        private final String title;

        Magazine(String title) {
            this.title = title;
        }

        @Override
        public int getLoanPeriodDays() {
            return 7;
        }

        @Override
        public String renew() {
            return title + " renewed";
        }
    }

    static class DigitalPass implements Renewable {
        private final String resourceName;

        DigitalPass(String resourceName) {
            this.resourceName = resourceName;
        }

        @Override
        public String renew() {
            return resourceName + " renewed";
        }
    }

    public static void processCheckouts(LibraryItem[] items) {
        for (LibraryItem item : items) {
            System.out.println(item.getLoanPeriodDays());
        }
    }

    public static String reserveIfSupported(Object item) {
        if (item instanceof Reservable) {
            return ((Reservable) item).reserve();
        }
        return "Reservation not supported";
    }
}
