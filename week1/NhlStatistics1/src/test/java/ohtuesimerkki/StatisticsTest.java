package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class StatisticsTest {

    Reader readerStub = () -> {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        return players;
    };

    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchFindsCorrectPlayer() {
        String player = "Kurri";

        assertEquals(player, stats.search(player).getName());
    }

    @Test
    public void nullWhenNoPlayerFound() {
        assertNull(stats.search("öyh"));
    }

    @Test
    public void correctPlayersBelongingToTeam() {
        List<Player> team = stats.team("EDM");

        assertEquals("Semenko", team.get(0).getName());
        assertEquals("Kurri", team.get(1).getName());
        assertEquals("Gretzky", team.get(2).getName());
        assertEquals(3, team.size());
    }

    @Test
    public void correctTopScorers() {
        List<Player> topScorers = stats.topScorers(1);

        assertEquals("Gretzky", topScorers.get(0).getName());
        assertEquals("Lemieux", topScorers.get(1).getName());
        assertEquals(2, topScorers.size());
    }
}
