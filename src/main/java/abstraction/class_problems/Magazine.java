package abstraction.class_problems;

public class Magazine extends LibraryItem implements Renewable {
    private final String title;

    public Magazine(String title) {
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