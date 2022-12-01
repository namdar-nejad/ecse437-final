package hexanome.thirteen.server.model;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest extends TestCase {
    Board my_board;

    /**
     * Test Board creation and initialization functionality
     */
    @Test
    public void testBoardCreation(){

        assertThrows(IllegalArgumentException.class, () -> {
            my_board = new Board(Game.Splendor, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            my_board = new Board(Game.Splendor, 5);
        });

        my_board = new Board(Game.Splendor, 2);
        assert my_board.getBank().size() == 6;

        my_board = new Board(Game.Splendor, 3);
        assert my_board.getBank().size() == 6;

        my_board = new Board(Game.Splendor, 4);
        assert my_board.getBank().size() == 6;
    }

    /**
     * Test Board functionality
     */
    @Test
    public void testBoardAttributes(){
        my_board = new Board(Game.Splendor, 3);
        assert my_board.getBank().size() == 6;
        assertNotNull(my_board.getSlots());
        assertNotNull(my_board.getBank());
        assertNotNull(my_board.getDecks());
        assertNotNull(my_board.getDeckFromRank(1));
    }
}