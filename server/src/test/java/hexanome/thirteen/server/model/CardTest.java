package hexanome.thirteen.server.model;
import java.util.EnumMap;
import java.util.List;

import hexanome.thirteen.server.model.Card;
import hexanome.thirteen.server.model.Noble;
import hexanome.thirteen.server.model.Token;
import org.junit.Test;

public class CardTest {

    private static EnumMap<Token, Integer> my_map = new EnumMap<Token, Integer>(Token.class);

    /**
     * Testing the VanillaCard getter functionality
     */
    @Test
    public void testVanillaCard(){
        my_map.put(Token.GOLD, 100);
        Token my_bonus = Token.RUBY;
        Rank my_rank = Rank.TWO;
        VanillaCard my_card = new VanillaCard(100, my_map,  my_bonus, my_rank, 1);
        assert my_card.getBonus().equals(my_bonus);
        assert my_card.getRank().equals(my_rank);
        assert my_card.getPrestigePoint() == 100;
        assert my_card.getCost().equals(my_map);
        assert my_card.getCardId() == 1;
    }

    /**
     * Testing the abstract Card class getter functionality
     */
    @Test
    public void testCard(){
        my_map.put(Token.GOLD, 100);
        Card my_card = new Noble(100, my_map, 1);
        assert my_card.getPrestigePoint() == 100;
        assert my_card.getCost().equals(my_map);
        assert my_card.getCardId() == 1;
    }

}