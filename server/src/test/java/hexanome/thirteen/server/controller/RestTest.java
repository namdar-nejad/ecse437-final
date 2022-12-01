package hexanome.thirteen.server.controller;

import hexanome.thirteen.server.model.Manager;
import junit.framework.TestCase;

import java.io.DataOutputStream;

public class RestTest extends TestCase {
    private static Manager my_manager = new Manager();
    Rest my_rest = new Rest(my_manager);

    String input = "{\n" +
            "\"creator\": \"creator1\",\n" +
            "\"gamename\": \"DummyGame1\",\n" +
            "\"players\": [\n" +
                "{\n" +
                "\"name\": \"player1\"\n" +
                "}," +
                "{\n" +
                "\"name\": \"player2\"\n" +
                "}" +
            "] " +
            "}"
    ;


    /**
     * Test Rest creation and getter functionality
     */
    public void testCreateGame() {
        my_rest.createGame(1, input);
        assertNotNull(my_rest.getBoard(1));
        assertNotNull(my_rest.getSlots(1));
        assertNotNull(my_rest.getTokens(1));
        assert my_rest.getPlayers(1).size() == 2;
        assertNotNull(my_rest.getPlayerPrestige(1, "player2"));
        assertNotNull(my_rest.getNobleInventory(1, "player2"));
        assertNotNull(my_rest.getPlayerBonusToken(1, "player2"));
        assertNotNull(my_rest.getPlayerToken(1, "player2"));
        assertNotNull(my_rest.getPlayerBonusToken(1, "player2"));
        assertNotNull(my_rest.getPlayerReserve(1, "player2"));
        assertNotNull(my_rest.getPlayerInventory(1, "player2"));
//        assertFalse(my_rest.purchaseCard(1, "\"player2\"", 0));

    }

    /**
     * Test Rest creation and getter functionality
     */
    public void testCards() {
        my_rest.createGame(1, input);
        my_rest.purchaseCard(1, "player1", 31);
        my_rest.purchaseCard(1, "player1", 31);
    }
}