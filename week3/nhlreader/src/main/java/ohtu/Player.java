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
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
}
