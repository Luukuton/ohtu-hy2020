package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;

public class GameFactory {
    private final Map<String, Game> games;

    public GameFactory(IO io) {
        this.games = new HashMap<>();
        this.games.put("a", new KPSPlayerVSPlayer(io));
        this.games.put("b", new KPSAI(io));
        this.games.put("c", new KPSBetterAI(io));
    }

    public Game search(String response) {
        return games.getOrDefault(response.trim(), null);
    }
}
