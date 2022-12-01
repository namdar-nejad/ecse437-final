package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.component.TokenData.BLACK_BANK;
import static hexanome.thirteen.client.component.TokenData.BLUE_BANK;
import static hexanome.thirteen.client.component.TokenData.GREEN_BANK;
import static hexanome.thirteen.client.component.TokenData.RED_BANK;
import static hexanome.thirteen.client.component.TokenData.WHITE_BANK;
import static hexanome.thirteen.client.constant.UriConstant.CSS_PATH;

import hexanome.thirteen.client.controller.BankController;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * The menu for selecting tokens to take by the player.
 */
public class BankMenu extends VBox {

  private Token[] bankTokens = {BLUE_BANK, BLACK_BANK, RED_BANK, WHITE_BANK, GREEN_BANK};
  private List<NumLabel> remainTokens = new ArrayList<>(5);
  private List<NumLabel> selectedTokens = new ArrayList<>(5);


  /**
   * creates the bank menu object.
   */
  public BankMenu() {

    this.setPrefSize(800, 450);
    this.setLayoutX(400);
    this.setLayoutY(225);
    this.setSpacing(30);
    this.setStyle("-fx-background-color: lightblue");

    this.createBankMenu();

    this.setVisible(false);
  }

  private void createBankMenu() {

    HBox labelBox = new HBox();
    labelBox.setSpacing(20);
    labelBox.setAlignment(Pos.CENTER);
    Label label = CommonComponents.createPopUpLabel("Bank");
    label.setAlignment(Pos.TOP_CENTER);
    label.setPrefSize(300, 60);
    label.setFont(new Font("Arial", 20));
    labelBox.getChildren().add(label);
    label.getStylesheets().add(CSS_PATH + "style.css");
    label.getStyleClass().add("popup-text");

    HBox infoBox = new HBox();
    infoBox.setAlignment(Pos.CENTER);
    infoBox.setSpacing(30);
    infoBox.setLayoutX(400);
    infoBox.setLayoutY(225);
    infoBox.setStyle("-fx-background-color: lightgreen");


    HBox tokenBox = new HBox();
    tokenBox.setAlignment(Pos.CENTER);
    tokenBox.setSpacing(35);
    tokenBox.setLayoutX(400);
    tokenBox.setLayoutY(225);
    tokenBox.setStyle("-fx-background-color: lightgreen");

    HBox selectedBox = new HBox();
    selectedBox.setAlignment(Pos.CENTER);
    selectedBox.setSpacing(30);
    selectedBox.setLayoutX(400);
    selectedBox.setLayoutY(225);
    selectedBox.setStyle("-fx-background-color: lightgreen");


    for (int i = 0; i < bankTokens.length; i++) {

      Token tempToken = this.bankTokens[i];
      NumLabel tempInfo = new NumLabel(6);
      remainTokens.add(i, tempInfo);
      NumLabel tempSelected = new NumLabel(0);
      selectedTokens.add(i, tempSelected);

      tempToken.setOnMouseClicked(e -> {
        tempSelected.increase(1);
        if (tempSelected.getNumber() >= 3) {
          tempSelected.reset();
        }

      });

      infoBox.getChildren().add(tempInfo);
      tokenBox.getChildren().add(tempToken);
      selectedBox.getChildren().add(tempSelected);

    }

    VBox buttonBox = new VBox();
    buttonBox.setSpacing(20);
    buttonBox.setAlignment(Pos.CENTER);

    Button confirmButton = CommonComponents.createPopUpButton("Confirm");
    confirmButton.setOnAction(e -> tryPurchase());

    Button resetButton = CommonComponents.createPopUpButton("Reset");
    resetButton.setOnAction(e -> resetAll());
    Button cancelButton = CommonComponents.createPopUpButton("Cancel");
    cancelButton.setOnAction(e -> {
      resetAll();
      this.setVisible(false);
    });

    buttonBox.getChildren().addAll(confirmButton, resetButton, cancelButton);

    this.getChildren().addAll(labelBox, infoBox, tokenBox, selectedBox, buttonBox);

  }

  private void resetAll() {
    selectedTokens.forEach(NumLabel::reset);
  }

  private boolean tryPurchase() {
    ArrayList<Integer> amount = new ArrayList<>();

    for (NumLabel numlabel : selectedTokens) {
      amount.add(numlabel.getNumber());
    }

    boolean result = new BankController().confirmTokens(amount);

    if (result) {
      resetAll();
      this.setVisible(false);
    }
    return result;
  }

}
