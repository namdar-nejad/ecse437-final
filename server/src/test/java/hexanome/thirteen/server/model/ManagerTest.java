package hexanome.thirteen.server.model;

import hexanome.thirteen.server.controller.Player;
import hexanome.thirteen.server.model.Manager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerTest {

    /* global manager instance */
    private static Manager my_manager;
    private static List<Player> players;

    /**
     * Setting up manager instance
     */
    @Before
    public void setupManager(){
        my_manager = new Manager();
        System.out.print("here");
        Player p1 = new Player("player1", true);
        Player p2 = new Player("player2", false);
        players= new ArrayList<>(
                Arrays.asList(p1, p2)
        );
    }

    /**
     * Test Manager functionality
     */
    @Test
    public void testManager() {
        assert my_manager.getGames().size() == 0;
        my_manager.addGame(1, players);
        assert my_manager.getGames().size() == 1;
        my_manager.removeGame(1);
        assert my_manager.getGames().size() == 0;
    }
}