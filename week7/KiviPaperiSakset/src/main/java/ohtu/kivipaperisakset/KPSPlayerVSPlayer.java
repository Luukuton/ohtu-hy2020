package ohtu.kivipaperisakset;

public class KPSPlayerVSPlayer extends Game {

    public KPSPlayerVSPlayer(IO io) {
        this.io = io;
    }

    @Override
    public Move choices() {
        return new Move(
                io.prompt("Pelaajan 1 siirto"),
                io.prompt("Pelaajan 2 siirto")
        );
    }
}
