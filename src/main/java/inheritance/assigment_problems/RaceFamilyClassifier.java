package inheritance.assigment_problems;

public class RaceFamilyClassifier {
    public static String classifyGeneration(RaceEntry entry) {
        if (entry instanceof EliteRunnerEntry)
            return "Multilevel descendant (3 generations deep)";
        if (entry instanceof RelayTeamEntry)
            return "Hierarchical sibling (independent branch)";
        if (entry instanceof RunnerEntry)
            return "Single-inheritance child";
        return "Base generation";
    }

    public static double getTotalBalanceDue(RaceEntry[] entries) {
        double total = 0;
        for (RaceEntry entry : entries)
            if (entry != null)
                total += entry.getBalanceDue();
        return total;
    }

    public static String announceAll(RaceEntry[] entries) {
        StringBuilder result = new StringBuilder();
        for (RaceEntry entry : entries) {
            entry.announce();
            result.append(entry.getClass().getSimpleName())
                    .append(" | Balance: ")
                    .append(entry.getBalanceDue());
            if (entry instanceof RelayTeamEntry)
                result.append(" [Team size via downcast: ")
                        .append(((RelayTeamEntry) entry).getTeamSize())
                        .append("]");
            result.append(" | ");
        }
        return result.toString();
    }
}
