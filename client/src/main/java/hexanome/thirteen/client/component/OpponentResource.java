package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.UriConstant.CSS_PATH;

import hexanome.thirteen.client.constant.PlayerSequence;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * The component for displaying opponents resources.
 */
public class OpponentResource extends AnchorPane {

  private static int numOfOpponents = 0;
  private PlayerSequence opponentInfo;
  private InventoryMenu opponentInventory;
  private PlayerTokWidget tokWidget;

  /**
   * Create the widget that displays the info about the opponents.
   *
   * @param opponent the opponent we are creating the widget for
   * @pre numOfOpponents < 4
   */
  public OpponentResource(PlayerSequence opponent, InventoryMenu opponentInventory) {
    assert numOfOpponents < 4;
    this.opponentInfo = opponent;
    this.opponentInventory = opponentInventory;
    this.setPrefSize(300, 100);
    numOfOpponents++;
    createOpponentResource(numOfOpponents);


  }

  private void createOpponentResource(int opponentNum) {

    opponentInventory.setVisible(false);

    tokWidget = new PlayerTokWidget(this.opponentInfo);

    Button opponentButton = CommonComponents.createPopUpButton("Inventory");
    opponentButton.setOnAction(e -> opponentInventory.setVisible(!opponentInventory.isVisible()));
    opponentButton.getStylesheets()
        .add(this.getClass().getResource(CSS_PATH + "button-style.css").toExternalForm());
    opponentButton.getStyleClass().add("standard-popup-button");


    // change layout location base on how many players' resource are already created
    this.setLayoutX(400 * (numOfOpponents - 1));
    this.setLayoutY(20);
    this.setStyle("-fx-background-color:  lightgreen");

    opponentButton.setLayoutX(280);
    HBox containerBox = new HBox();
    this.getChildren().addAll(tokWidget, opponentButton);

  }

  public InventoryMenu getOpponentInventory() {
    return opponentInventory;
  }
}
