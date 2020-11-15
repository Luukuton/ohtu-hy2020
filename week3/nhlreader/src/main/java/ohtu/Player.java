package ohtu;

public class Player {
    private String name, team, nationality;
    private int goals, assists;

    public Player() {
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        int sum = goals + assists;
        return String.format("%-20s %-5s %-3s %-5s %-5s", name, team, goals, "+ " + assists, "= " + sum);
    }
}
