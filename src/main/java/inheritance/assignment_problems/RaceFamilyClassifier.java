package inheritance.assignment_problems;

public class RaceFamilyClassifier {
    public static String classifyGeneration(RaceEntry entry) {
        if (entry instanceof EliteRunnerEntry) return "Multilevel descendant (3 generations deep)";
        if (entry instanceof RelayTeamEntry) return "Hierarchical sibling (independent branch)";
        if (entry instanceof RunnerEntry) return "Single-inheritance child";
        return "Base generation";
    }

    public static double getTotalBalanceDue(RaceEntry[] entries) {
        double total = 0;
        for (RaceEntry entry : entries) total += entry.getBalanceDue();
        return total;
    }
}
