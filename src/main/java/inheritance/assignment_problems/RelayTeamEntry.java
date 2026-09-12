package inheritance.assignment_problems;

public class RelayTeamEntry extends RaceEntry {
    private final int teamSize;

    public RelayTeamEntry(double fee, int teamSize) {
        super(fee);
        if (teamSize <= 0)
            throw new IllegalArgumentException();
        this.teamSize = teamSize;
    }

    public int getTeamSize() { return teamSize; }
}
