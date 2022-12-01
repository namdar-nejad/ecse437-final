package hexanome.thirteen.server.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeckTest {

    /**
     * Test Deck initialization
     */
    @Test
    public void deckInitialization(){
        Deck my_deck = new Deck(DeckType.VANILLA, Rank.ONE);
        assertNotNull(my_deck.getCards());
    }


}
