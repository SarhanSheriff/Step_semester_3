package inheritance.class_problems;

public final class TicketFamilyClassifier {
    private TicketFamilyClassifier() {
    }

    public static String classifyGeneration(EventTicket ticket) {
        if (ticket instanceof PremiumWorkshopTicket)
            return "Multilevel descendant (3 generations deep)";
        if (ticket instanceof HackathonTicket)
            return "Hierarchical sibling (independent branch)";
        if (ticket instanceof WorkshopTicket)
            return "Single-inheritance child";
        return "Base generation";
    }

    public static double getTotalBalanceDue(EventTicket[] tickets) {
        double total = 0;
        for (EventTicket ticket : tickets)
            if (ticket != null)
                total += ticket.getBalanceDue();
        return total;
    }
}
