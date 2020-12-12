package ohtu.kivipaperisakset;

public class AI {

    private int move;

    public AI() {
        move = 0;
    }

    public String giveMove() {
        move++;
        move = move % 3;

        if (move == 0) {
            return "k";
        } else if (move == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    void setMove(String move) {}
}
