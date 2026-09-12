package inheritance.class_problems;

public final class TicketAnnouncer {
    private TicketAnnouncer() {
    }

    public static String batchPrint(EventTicket[] tickets) {
        StringBuilder result = new StringBuilder();

        for (EventTicket ticket : tickets) {
            ticket.printTicket();

            if (ticket instanceof WorkshopTicket) {
                WorkshopTicket w = (WorkshopTicket) ticket;
                result.append("Workshop | Track: ")
                        .append(w.getTrack())
                        .append(" | Balance: ")
                        .append(w.getBalanceDue())
                        .append(" | ");
            } else {
                result.append("Standard | Balance: ")
                        .append(ticket.getBalanceDue())
                        .append(" | ");
            }
        }

        return result.toString();
    }
}
