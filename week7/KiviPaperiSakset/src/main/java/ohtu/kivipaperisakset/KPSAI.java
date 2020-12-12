package ohtu.kivipaperisakset;

public class KPSAI extends Game {

    private final AI ai;

    public KPSAI(IO io) {
        this.io = io;
        this.ai = new AI();
    }

    @Override
    public Move choices() {
        String moveP1 = io.prompt("Pelaajan 1 siirto");
        String moveP2;

        moveP2 = ai.giveMove();
        io.println("AI valitsi: " + moveP2);
        ai.setMove(moveP1);

        return new Move(moveP1, moveP2);
    }
}
