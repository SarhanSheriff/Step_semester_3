package inheritance.class_problems;

public class EventTicket {
    private static int ticketsIssued;
    private final String ticketId;
    private final double basePrice;
    private double balanceDue;

    public EventTicket(String attendeeId, double basePrice) {
        if (attendeeId == null || attendeeId.trim().length() < 4 || basePrice <= 0)
            throw new IllegalArgumentException();

        ticketsIssued++;
        ticketId = "TCK-" + (1000 + ticketsIssued);
        this.basePrice = basePrice;
        balanceDue = basePrice;
    }

    public EventTicket(double basePrice) {
        this("GUEST" + (ticketsIssued + 1), basePrice);
    }

    public void pay(double amount) {
        if (amount > 0)
            balanceDue = Math.max(0, balanceDue - amount);
    }

    public void pay(double amount, String mode) {
        System.out.println("Payment mode: " + mode);
        pay(amount);
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void printTicket() {
        System.out.println("Standard Event Ticket | Balance Due: " + balanceDue);
    }

    public static int getTicketsIssued() {
        return ticketsIssued;
    }

    public static boolean isValidPromoCode(String code) {
        return code != null && code.matches("F\\d{3}[A-Z]");
    }

    public static String registerBatch(String[] ids, double price) {
        int registered = 0, rejected = 0;

        for (String id : ids) {
            try {
                new EventTicket(id, price);
                registered++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    protected void applyLateFee(double amount) {
        if (amount > 0)
            balanceDue += amount;
    }
}
