package abstraction.class_problems;

public abstract class LibraryItem {
    private static int nextId = 1001;
    private final String itemId;

    protected LibraryItem() {
        itemId = "LIB-" + nextId++;
    }

    public abstract int getLoanPeriodDays();

    public String getItemId() {
        return itemId;
    }
}