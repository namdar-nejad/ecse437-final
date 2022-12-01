package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.UriConstant.IMAGE_PATH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains the collection of all cards in the splendor card bank.
 */
public class CardsData {

  public static final Card GREEN_ONE = new Card(1, IMAGE_PATH + "green_card1.jpg");
  public static final Card GREEN_TWO = new Card(2, IMAGE_PATH + "green_card2.jpg");
  public static final Card GREEN_THREE = new Card(2, IMAGE_PATH + "green_card3.jpg");
  public static final Card GREEN_FOUR = new Card(2, IMAGE_PATH + "green_card4.jpg");


  /**
   * A stub factory method that creates a stub card deck to be put on the board.
   *
   * @return a stub card deck
   */
  public static List<List<Card>> createStubDeck() {

    ArrayList<Card> rowBot = new ArrayList<>();
    rowBot.add(GREEN_THREE);
    rowBot.add(GREEN_FOUR);
    rowBot.add(GREEN_ONE);
    rowBot.add(GREEN_TWO);

    List<List<Card>> stubDeck = new ArrayList<>(4);

    stubDeck.add(rowBot);

    //    for(int i = 0; i < 3; i++) {
    //     stubDeck.add(new ArrayList<Card>());
    //      for (int j = 0; j < 4; j++) {
    //        stubDeck.get(i);
    //      }
    //    }
    return stubDeck;
  }

}
