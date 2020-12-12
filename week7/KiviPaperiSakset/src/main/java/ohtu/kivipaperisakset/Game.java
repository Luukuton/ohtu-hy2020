
package ohtu.kivipaperisakset;

public abstract class Game {
    protected IO io;

    public void play() {
        io.println("Peli loppuu, jos pelaaja antaa virheellisen siirron. Toisin sanoen jonkun muun kuin k, p tai s");
        Judge judge = new Judge();

        while (true) {
            Move s = choices();
            if (s.hasGameEnded()) {
                break;
            }

            judge.markMove(s);
            io.println(judge);
        }

        io.println();
        io.println("Kiitos!");
        io.println(judge);
    }

    public abstract Move choices();
}
