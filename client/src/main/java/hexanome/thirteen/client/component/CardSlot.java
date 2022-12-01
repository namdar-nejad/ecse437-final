package hexanome.thirteen.client.component;

import hexanome.thirteen.client.controller.CardSlotController;
import javafx.scene.image.ImageView;

/**
 * The class that represent the card slot in the board center where all the neutral card are placed.
 */
public class CardSlot extends ImageView {

  private int[] position = new int[2];
  private boolean hasCard;
  private Card curCard;
  private CardSlotController cardSlotController = new CardSlotController();

  /**
   * Construct a new CardSlot with the position index that is a 2D array.
   *
   * @param iniPosition the fixed position of the card in the board center.
   */
  public CardSlot(int[] iniPosition) {
    this.position = iniPosition;
    this.setOnMouseClicked(e -> cardSlotController.userToggleCard(e));
    hasCard = false;
    curCard = null;
    this.setFitWidth(80);
    this.setFitHeight(150);
  }

  public int[] getPosition() {
    return position;
  }

  /**
   * Remove the card from the specific card slot and replace it with empty image.
   *
   * @return the card being taken
   */
  public Card takeCard() {
    Card taken = this.curCard;
    this.curCard = null;
    this.setImage(null);
    return taken;
  }

  /**
   * Put a specific card on the specific card slot.
   *
   * @param card the card to be put on the card slot.
   */
  public void putCard(Card card) {
    this.curCard = card;
    this.setImage(card.getCardImage());
  }

}
