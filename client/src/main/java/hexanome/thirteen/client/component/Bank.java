package hexanome.thirteen.client.component;

import hexanome.thirteen.client.constant.TokenType;
import java.util.EnumMap;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * The componnet that represent the bank visual part shown on the left side of the screen.
 * Clicking it opens BankMenu.
 */
public class Bank extends AnchorPane {

  private EnumMap<TokenType, Integer> bankResource;

  /**
   * Creates the bank object.
   */
  public Bank() {

    this.prefHeight(300);
    this.prefWidth(50);
    this.setLayoutY(50);
    this.setLayoutX(50);
    setLayoutY(400);
    this.setStyle("-fx-background-color: lightgreen");
    createBank();


  }

  private void createBank() {
    VBox bankBox = new VBox();
    bankBox.setMaxHeight(300);
    setMaxWidth(50);
    bankBox.getChildren().add(new Label("Toggle Bank"));

    this.getChildren().add(bankBox);

    //

  }

}

