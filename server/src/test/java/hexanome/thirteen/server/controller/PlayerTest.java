package hexanome.thirteen.server.controller;

import hexanome.thirteen.server.model.Token;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.EnumMap;

public class PlayerTest extends TestCase {

    /**
     * Test Player initialization
     */
    @Test
    public void testInitialPlayer() {
        Player my_player = new Player("player1", true);
        assert my_player.getInventory().isEmpty();
        assert my_player.getNobleInventory().isEmpty();
        assert my_player.getReservedCards().isEmpty();
        assert my_player.getName().equals("player1");
        assert my_player.getTokens().size() == 6;
        assert my_player.getBonusTokens().size() == 6;
        assert my_player.getPrestigePoint() == 0;
        assert my_player.getBalance().size() == 6;
    }

    /**
     * Test Player host functionality
     */
    @Test
    public void testHost() {
        Player my_player = new Player("player1", true);
        assertTrue(my_player.isHost());
        my_player = new Player("player1", false);
        assertFalse(my_player.isHost());
    }

    /**
     * Test Player not purchasable
     */
    @Test
    public void testNotPurchasable() {
        Player my_player = new Player("player1", true);
        EnumMap<Token, Integer> my_balance = new EnumMap<Token, Integer>(Token.class);
        my_balance.put(Token.EMERALD, 3);
        my_balance.put(Token.DIAMOND, 3);
        my_balance.put(Token.SAPPHIRE, 3);
        my_balance.put(Token.ONYX, 3);
        my_balance.put(Token.RUBY, 3);
        my_balance.put(Token.GOLD, 3);

        EnumMap<Token, Integer> my_cost = new EnumMap<Token, Integer>(Token.class);
        my_cost.put(Token.EMERALD, 0);
        my_cost.put(Token.DIAMOND, 0);
        my_cost.put(Token.SAPPHIRE, 0);
        my_cost.put(Token.ONYX, 0);
        my_cost.put(Token.RUBY, 0);
        my_cost.put(Token.GOLD, 0);

        assertTrue(my_player.purchasable(my_balance, my_cost));
    }

    /**
     * Test Player purchasable
     */
    @Test
    public void testPurchasable() {
        Player my_player = new Player("player1", true);
        EnumMap<Token, Integer> my_cost = new EnumMap<Token, Integer>(Token.class);
        my_cost.put(Token.EMERALD, 3);
        my_cost.put(Token.DIAMOND, 3);
        my_cost.put(Token.SAPPHIRE, 3);
        my_cost.put(Token.ONYX, 3);
        my_cost.put(Token.RUBY, 3);
        my_cost.put(Token.GOLD, 3);

        EnumMap<Token, Integer> my_balance = new EnumMap<Token, Integer>(Token.class);
        my_balance.put(Token.EMERALD, 0);
        my_balance.put(Token.DIAMOND, 0);
        my_balance.put(Token.SAPPHIRE, 0);
        my_balance.put(Token.ONYX, 0);
        my_balance.put(Token.RUBY, 0);
        my_balance.put(Token.GOLD, 0);

        assertFalse(my_player.purchasable(my_balance, my_cost));
    }
}