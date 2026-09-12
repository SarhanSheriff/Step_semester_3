package inheritance.class_problems;

public class GroupTicket extends EventTicket {
    private final int groupSize;

    public GroupTicket(double price, int groupSize) {
        super(price);
        if (groupSize <= 0)
            throw new IllegalArgumentException("Group size must be positive");
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}
