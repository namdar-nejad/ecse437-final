package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.UriConstant.CSS_PATH;

import hexanome.thirteen.client.constant.PlayerSequence;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * This class represents the Inventory Menu of the player, will be created by BoardView.
 */
public class InventoryMenu extends VBox {
  private PlayerSequence playerSequence;
  private List<InventorySlot> purchasedCards;
  private int numOfCards;

  /**
   * Create the inventory menu component for the player.
   */
  public InventoryMenu(PlayerSequence player) { //not finalized, could PlayerInfo Player
    this.playerSequence = player;
    purchasedCards = new ArrayList<>();
    numOfCards = 0;
    this.setPrefSize(800, 450);

    this.createInventoryMenu();
  }

  /**
   * Creates the visual aspect of the inventory.
   */
  private void createInventoryMenu() {

    // Create and add the button for closing Inventory
    HBox buttonBox = new HBox();
    buttonBox.setAlignment(Pos.TOP_RIGHT);
    Button closeButton = CommonComponents.createPopUpButton("X");
    //closeButton.getStylesheets()
    //   .add(this.getClass().getResource(CSS_PATH + "button-style.css").toExternalForm());
    //  closeButton.getStyleClass().add("standard-popup-button");
    closeButton.setOnAction(e -> this.setVisible(false));
    buttonBox.getChildren().add(closeButton);

    // For inventory menu title
    HBox labelBox = new HBox();
    labelBox.setSpacing(10);
    labelBox.setAlignment(Pos.CENTER);
    Label label = CommonComponents.createPopUpLabel(playerSequence.toString() + "Resources");
    label.setAlignment(Pos.CENTER);
    label.setPrefSize(300, 61);
    label.setFont(new Font("Arial", 20));
    labelBox.getChildren().add(label);
    label.getStylesheets().add(CSS_PATH + "style.css");
    label.getStyleClass().add("popup-text");


    // For all the purchased cards
    HBox collectedCards = new HBox();
    collectedCards.setAlignment(Pos.CENTER);
    collectedCards.setId("collectedCards" + playerSequence.ordinal());
    collectedCards.setSpacing(10);
    collectedCards.setLayoutX(400);
    collectedCards.setLayoutY(225);
    collectedCards.setStyle("-fx-background-color: lightgreen");
    collectedCards.setPrefSize(this.widthProperty().doubleValue(),
        this.heightProperty().doubleValue());

    // Finalize the Inventory Vbox attribute and add all previously declared items
    this.setLayoutX(400);
    this.setLayoutY(225);
    this.getStylesheets().add(getClass().getResource(CSS_PATH + "style.css").toExternalForm());
    this.getStyleClass().add("popup-background");
    this.getChildren().addAll(buttonBox, labelBox, collectedCards);

  }

}
