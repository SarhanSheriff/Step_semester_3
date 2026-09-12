package inheritance.class_problems;

public class EventTicket {
    private static int ticketsIssued = 0;

    private final String ticketId;
    private final double basePrice;
    private double balanceDue;
    private double[] lateFeeHistory = new double[10];
    private int lateFeeCount;

    public EventTicket(String attendeeId, double basePrice) {
        if (attendeeId == null || attendeeId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid attendee ID");
        }
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be positive");
        }

        ticketsIssued++;
        this.ticketId = "TCK-" + (1000 + ticketsIssued);
        this.basePrice = basePrice;
        this.balanceDue = basePrice;
    }

    public EventTicket(double basePrice) {
        this("GUEST" + (ticketsIssued + 1), basePrice);
    }

    public void pay(double amount) {
        if (amount <= 0) {
            return;
        }
        balanceDue -= amount;
        if (balanceDue < 0) {
            balanceDue = 0;
        }
    }

    public void pay(double amount, String mode) {
        System.out.println("Payment mode: " + mode);
        pay(amount);
    }

    protected void applyLateFee(double amount) {
        if (amount <= 0) {
            return;
        }
        balanceDue += amount;
        if (lateFeeCount == lateFeeHistory.length) {
            double[] expanded = new double[lateFeeHistory.length * 2];
            System.arraycopy(lateFeeHistory, 0, expanded, 0, lateFeeHistory.length);
            lateFeeHistory = expanded;
        }
        lateFeeHistory[lateFeeCount++] = amount;
    }

    public double[] getLateFeeHistory() {
        double[] copy = new double[lateFeeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, lateFeeCount);
        return copy;
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
        if (code == null || code.length() != 5) {
            return false;
        }
        if (code.charAt(0) != 'F') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1))
                || !Character.isDigit(code.charAt(2))
                || !Character.isDigit(code.charAt(3))) {
            return false;
        }
        return Character.isUpperCase(code.charAt(4));
    }

    public static String registerBatch(String[] attendeeIds, double basePrice) {
        int registered = 0;
        int rejected = 0;

        for (String attendeeId : attendeeIds) {
            try {
                new EventTicket(attendeeId, basePrice);
                registered++;
            } catch (IllegalArgumentException exception) {
                rejected++;
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }
}
