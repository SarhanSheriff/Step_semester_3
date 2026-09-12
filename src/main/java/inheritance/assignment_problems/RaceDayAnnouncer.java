package inheritance.assignment_problems;

public class RaceDayAnnouncer {
    public static String announceAll(RaceEntry[] entries) {
        StringBuilder report = new StringBuilder();

        for (RaceEntry entry : entries) {
            entry.announce();
            if (entry instanceof RelayTeamEntry) {
                RelayTeamEntry relay = (RelayTeamEntry) entry;
                report.append("Relay Team | Bib: ")
                        .append(entry.getBibNumber())
                        .append(" | Team Size: ").append(relay.getTeamSize())
                        .append(" | Balance: ").append(entry.getBalanceDue())
                        .append(" [Team size via downcast: ")
                        .append(relay.getTeamSize()).append("] | ");
            } else {
                report.append(entry.getClass().getSimpleName())
                        .append(" | Bib: ").append(entry.getBibNumber())
                        .append(" | Balance: ").append(entry.getBalanceDue()).append(" | ");
            }
        }
        return report.toString();
    }
}
