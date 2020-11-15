package ohtu;

public class Player {
    private String name, team;
    private int goals, assists;

    public Player() {}

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
}
