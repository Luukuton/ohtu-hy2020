package ohtu.kivipaperisakset;

public class GameInit {

    private final IO io;

    public GameInit(IO io) {
        this.io = io;
    }

    public void chooseGameLoop() {
        GameFactory gameFactory = new GameFactory(io);
        while (true) {
            io.println(
                    "\nValitse, pelataanko"
                    + "\n  (a) ihmistä vastaan "
                    + "\n  (b) tekoälyä vastaan"
                    + "\n  (c) parannettua tekoälyä vastaan?"
                    + "\nMuilla valinnoilla lopetataan."
            );

            Game game = gameFactory.search(io.nextLine());
            if (game == null) {
                break;
            }
            game.play();
        }
    }

}
