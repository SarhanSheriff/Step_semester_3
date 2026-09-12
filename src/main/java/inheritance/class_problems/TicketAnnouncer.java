package inheritance.class_problems;

public final class TicketAnnouncer {
    private TicketAnnouncer() {
    }

    public static String batchPrint(EventTicket[] tickets) {
        StringBuilder report = new StringBuilder();

        for (EventTicket ticket : tickets) {
            ticket.printTicket();

            if (ticket instanceof WorkshopTicket) {
                WorkshopTicket workshopTicket = (WorkshopTicket) ticket;
                report.append("Workshop | Track: ")
                        .append(workshopTicket.getTrack())
                        .append(" | Balance: ")
                        .append(workshopTicket.getBalanceDue())
                        .append(" [Track via downcast: ")
                        .append(workshopTicket.getTrack())
                        .append("] | ");
            } else {
                report.append("Standard | Balance: ")
                        .append(ticket.getBalanceDue())
                        .append(" | ");
            }
        }

        return report.toString();
    }
}
