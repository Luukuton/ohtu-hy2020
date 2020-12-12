package ohtu.kivipaperisakset;

public class Main {
    public static void main(String[] args) {
        new GameInit(new IO(System.in, System.out)).chooseGameLoop();
    }
}
