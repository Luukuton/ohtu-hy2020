package ohtu.kivipaperisakset;

public class Judge {
    private int pointsP1, pointsP2, ties;

    public Judge() {
        this.pointsP1 = 0;
        this.pointsP2 = 0;
        this.ties = 0;
    }

    public void markMove(Move move) {
        String moveP1 = move.getMoveP1();
        String move2P = move.getMoveP2();
        if (tie(moveP1, move2P)) {
            ties++;
        } else if (winnerIsP1(moveP1, move2P)) {
            pointsP1++;
        } else {
            pointsP2++;
        }
    }

    private static boolean tie(String P1, String P2) {
        return P1.equals(P2);
    }

    private static boolean winnerIsP1(String P1, String P2) {
        if ("k".equals(P1) && "s".equals(P2)) {
            return true;
        } else if ("s".equals(P1) && "p".equals(P2)) {
            return true;
        }

        return "p".equals(P1) && "k".equals(P2);
    }

    public String toString() {
        return "Pelitilanne: " + pointsP1 + " - " + pointsP2 + "\n" + "Tasapelit: " + ties;
    }
}
