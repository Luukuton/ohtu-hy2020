package ohtu;

import java.util.HashMap;

public class TennisGame {
    private final Player player1, player2;
    private final HashMap<Integer, String> scoreAsString;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);

        scoreAsString = new HashMap<>();
        scoreAsString.put(0, "Love");
        scoreAsString.put(1, "Fifteen");
        scoreAsString.put(2, "Thirty");
        scoreAsString.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.setScore(player1.getScore() + 1);
        } else if (playerName.equals(player2.getName())) {
            player2.setScore(player2.getScore() + 1);
        }
    }

    public String getScore() {
        StringBuilder spokenScore = new StringBuilder();

        if (player1.getScore() == player2.getScore()) {
            spokenScore.append(scoreAsString.getOrDefault(player1.getScore(), "Deuce"));

            if (player1.getScore() < 4) spokenScore.append("-All");

        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            int resultDiff = player1.getScore() - player2.getScore();

            if (resultDiff == 1) {
                spokenScore = new StringBuilder("Advantage " + player1.getName());
            } else if (resultDiff == -1) {
                spokenScore = new StringBuilder("Advantage " + player2.getName());
            } else if (resultDiff >= 2) {
                spokenScore = new StringBuilder("Win for " + player1.getName());
            } else {
                spokenScore = new StringBuilder("Win for " + player2.getName());
            }

        } else {
            spokenScore.append(scoreAsString.getOrDefault(player1.getScore(), "Deuce"));
            spokenScore.append("-");
            spokenScore.append(scoreAsString.getOrDefault(player2.getScore(), "Deuce"));
        }

        return spokenScore.toString();
    }
}
