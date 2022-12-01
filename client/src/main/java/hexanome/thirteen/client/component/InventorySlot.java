package hexanome.thirteen.client.component;

import javafx.scene.image.ImageView;

/**
 * This class stores the card purchased by any player and get stored at the corresponding inventory.
 */
public class InventorySlot extends ImageView {

  private Card invCard;

  /**
   * Create a new inventory slot when the player purchase a new card and insert the card in it.
   *
   * @param card the card that is purchased and ready to put into the inventory.
   */
  public InventorySlot(Card card) {
    this.setFitWidth(80);
    this.setFitHeight(150);
    this.invCard = card;
    this.setImage(invCard.getCardImage());
  }

}
