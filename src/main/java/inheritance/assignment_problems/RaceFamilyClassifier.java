package inheritance.assignment_problems;

public final class RaceFamilyClassifier {
    private RaceFamilyClassifier() {}

    public static String classify(RaceEntry entry) {
        if (entry instanceof EliteRunnerEntry)
            return "Multilevel descendant";
        if (entry instanceof RunnerEntry)
            return "Single-inheritance child";
        if (entry instanceof RelayTeamEntry)
            return "Hierarchical sibling";
        return "Base generation";
    }

    public static String batchPrint(RaceEntry[] entries) {
        StringBuilder result = new StringBuilder();
        for (RaceEntry entry : entries) {
            if (entry == null) continue;
            entry.printEntry();
            if (entry instanceof RunnerEntry) {
                RunnerEntry runner = (RunnerEntry) entry;
                result.append("Runner | Category: ")
                        .append(runner.getCategory())
                        .append(" | Fee: ")
                        .append(runner.getFee())
                        .append(" | ");
            } else {
                result.append("Race | Fee: ")
                        .append(entry.getFee())
                        .append(" | ");
            }
        }
        return result.toString();
    }

    public static String nightlySettlement(RaceEntry[] entries) {
        int processed = 0, skipped = 0, relay = 0, individual = 0;

        for (RaceEntry entry : entries) {
            if (entry == null) {
                skipped++;
                continue;
            }
            processed++;
            if (entry instanceof RelayTeamEntry) relay++;
            else individual++;
        }

        return processed + " processed | " + skipped + " skipped | "
                + relay + " relay | " + individual + " individual";
    }
}
