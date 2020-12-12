package ohtu.kivipaperisakset;

public class Move {

    private final String moveP1;
    private final String moveP2;

    public Move(String moveP1, String moveP2) {
        this.moveP1 = moveP1;
        this.moveP2 = moveP2;
    }

    public String getMoveP1() {
        return this.moveP1;
    }

    public String getMoveP2() {
        return this.moveP2;
    }

    public boolean hasGameEnded() {
        return !(isMoveAcceptable(moveP1) && isMoveAcceptable(moveP2));
    }

    private boolean isMoveAcceptable(String move) {
        return "k".equals(move) || "p".equals(move) || "s".equals(move);
    }
}
