package ohtu.kivipaperisakset;

public class KPSBetterAI extends Game {
    BetterAI ai;

    public KPSBetterAI(IO io) {
        this.io = io;
        this.ai = new BetterAI(20);
    }

    @Override
    public Move choices() {
        String moveP1 = io.prompt("Pelaajan 1 siirto");
        String moveAI;

        moveAI = ai.giveMove();
        io.println("Tietokone valitsi: " + moveAI);
        ai.setMove(moveP1);

        return new Move(moveP1, moveAI);
    }
}
