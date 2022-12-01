package hexanome.thirteen.client.component;

import hexanome.thirteen.client.constant.GameMode;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The component that correspond to the middle of the board where all the neutral cards are being
 * displayed.
 */
public class BoardCenter extends VBox {

  private ArrayList<Card> tempTestCards = new ArrayList<>();

  private List<List<Card>> cardSlots;

  public BoardCenter(GameMode gameMode, List<List<Card>> cards) {
    this.setSpacing(80);
    this.createBoardCenter(gameMode, cards);
  }

  private void createBoardCenter(GameMode gameMode, List<List<Card>> cards) {

    HBox rowNoble = new HBox();
    rowNoble.setSpacing(20);
    rowNoble.setAlignment(Pos.CENTER);

    HBox rowTop = new HBox();
    rowTop.setSpacing(20);

    HBox rowMiddle = new HBox();
    rowMiddle.setSpacing(20);


    HBox rowBottom = new HBox();
    rowBottom.setSpacing(20);

    tempTestCards.add(CardsData.GREEN_ONE);
    tempTestCards.add(CardsData.GREEN_TWO);
    tempTestCards.add(CardsData.GREEN_THREE);

    for (int i = 0; i < gameMode.boardDetail(); i++) {
      int[] pos = {0, i};
      CardSlot temp = new CardSlot(pos);
      Card tempCard = cards.get(0).get(i);
      temp.putCard(tempCard);
      rowBottom.getChildren().add(temp);
    }

    // finalize attribute of Board Center
    this.setLayoutX(400);
    this.setLayoutY(250);
    this.getChildren().addAll(rowNoble, rowTop, rowMiddle, rowBottom);


  }
}
