package inheritance.class_problems;

public class WorkshopTicket extends EventTicket {
    private final String track;

    public WorkshopTicket(String id, double price, String track) {
        super(id, price);
        this.track = track;
    }

    public WorkshopTicket(double price, String track) {
        super(price);
        this.track = track;
    }

    public String getTrack() {
        return track;
    }

    @Override
    public void printTicket() {
        System.out.println("Workshop Ticket | Track: " + track
                + " | Balance Due: " + getBalanceDue());
    }

    @Override
    protected void applyLateFee(double amount) {
        super.applyLateFee(amount * 2);
    }
}
