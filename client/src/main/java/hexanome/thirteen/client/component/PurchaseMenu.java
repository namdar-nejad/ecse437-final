package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.UriConstant.CSS_PATH;

import hexanome.thirteen.client.controller.CardSlotController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The purchase menu to be displayed when player click on the card to buy.
 */
public class PurchaseMenu extends VBox {

  private CardSlot previewCardLoc;
  private ImageView cardPreview;
  private CardSlotController cardSlotController = new CardSlotController();

  public PurchaseMenu() {
    this.setPrefSize(800, 450);
    this.createPurchaseMenu();
  }

  private void createPurchaseMenu() {

    this.setVisible(false);
    this.setId("purchaseMenu");
    this.setSpacing(20);
    this.setLayoutX(400);
    this.setLayoutY(225);
    this.getStylesheets().add(getClass().getResource(CSS_PATH + "style.css").toExternalForm());
    this.getStyleClass().add("popup-background");

    //Create the first HBox for the label
    HBox labelBox = new HBox();
    labelBox.setAlignment(Pos.CENTER);
    Label label = CommonComponents.createPopUpLabel("Purchase Menu");
    labelBox.getChildren().add(label);

    HBox cardPreviewBox = new HBox();
    cardPreviewBox.setAlignment(Pos.TOP_CENTER);
    cardPreview = new ImageView();
    cardPreview.setFitHeight(200);
    cardPreview.setFitWidth(100);
    cardPreviewBox.getChildren().add(cardPreview);

    VBox buttonsBox = new VBox();
    buttonsBox.setSpacing(20);
    buttonsBox.setAlignment(Pos.CENTER);

    Button purchaseButton = CommonComponents.createPopUpButton("Purchase");
    purchaseButton.setOnAction(e -> cardSlotController.userPurchaseCard(previewCardLoc));

    Button reserveButton = CommonComponents.createPopUpButton("Reserve");
    reserveButton.setOnAction(e -> cardSlotController.userReserveCard(previewCardLoc));

    Button cancelButton = CommonComponents.createPopUpButton("Cancel");
    cancelButton.setOnAction(e -> this.setVisible(false));

    buttonsBox.getChildren().addAll(purchaseButton, reserveButton, cancelButton);


    this.getChildren().addAll(labelBox, cardPreviewBox, buttonsBox);


  }

  public void setCardPreview(CardSlot cardSlot) {
    this.previewCardLoc = cardSlot;
    this.cardPreview.setImage(cardSlot.getImage());
  }
}
