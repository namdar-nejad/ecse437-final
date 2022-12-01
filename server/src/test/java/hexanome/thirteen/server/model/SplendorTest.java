package hexanome.thirteen.server.model;

//import static org.junit.jupiter.api.Assertions.assertThrows;
import hexanome.thirteen.server.controller.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SplendorTest {

    /*static variable definitions*/
    private static Player p1;
    private static Player p2;
    private static List<Player> players;
    
    /**
     * Initialize Players
     */
    @Before
    public void createPlayers(){
        p1 = new Player("player1", true);
        p2 = new Player("player2", false);
        players = new ArrayList<>(
                Arrays.asList(p1, p2)
        );
    }

    /**
     * Tests new game initialization
     */
    @Test
    public void testGameCreation() {
        Splendor my_splendor = new Splendor(players);
        assert my_splendor.getPlayers().equals(players);
        assertNotNull(my_splendor.getBoard());
    }

    /**
     * Tests game player list setup
     */
    @Test
    public void testGamePlayer() {
        Splendor my_splendor = new Splendor(players);
        assert my_splendor.getPlayer("player1").equals(p1);
        assert my_splendor.getPlayer("player2").equals(p2);
        assertThrows(RuntimeException.class, () -> {
            my_splendor.getPlayer("player3");
        });
    }
}