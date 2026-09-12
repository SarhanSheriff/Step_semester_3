package inheritance.class_problems;

public class HackathonTicket extends EventTicket {
    private final String teamName;

    public HackathonTicket(String id, double price, String teamName) {
        super(id, price);
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public void printTicket() {
        System.out.println("Hackathon Ticket | Team: " + teamName
                + " | Balance Due: " + getBalanceDue());
    }
}
