package hexanome.thirteen.client.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * A temporal dummy controller class for board.fxml just so that there's a backup.
 */
public class SomeController {
  private ImageView selectedCard;
  private int counter = 0;

  @FXML
  private Label stageReference;
  @FXML
  private ImageView slotOne;
  @FXML
  private ImageView invSlot1;
  @FXML
  private ImageView invSlot2;
  @FXML
  private ImageView invSlot3;
  @FXML
  private AnchorPane invMenu;
  @FXML
  private AnchorPane purMenu;
  @FXML
  private ImageView cardOverview;
  @FXML
  private Button purchaseConfirm;
  @FXML
  private Button purchaseCancel;
  private HBox hbox;

  /**
   * Initialize some attributes for the fxml class.
   */
  @FXML
  public void initialize() {
    invMenu.setVisible(false);
    purMenu.setVisible(false);
    hbox = new HBox(10);
    hbox.setAlignment(Pos.CENTER);
    hbox.setMaxHeight(100);
    invMenu.getChildren().add(hbox);
    // tempView.setImage(new Image("../../../../resources/assets/images/green_card4.jpg"));

  }

  @FXML
  protected void userToggleCard(MouseEvent event) throws IOException {

    purMenu.setVisible(true);
    ImageView target = (ImageView) event.getSource();
    selectedCard = target;
    cardOverview.setImage(new Image(selectedCard.getImage().getUrl()));
  }

  @FXML
  protected void userPurchaseCard(ActionEvent event) throws IOException {

    Image image = new Image(cardOverview.getImage().getUrl());
    ImageView imageview = new ImageView(image);
    imageview.setFitHeight(150);
    imageview.setFitWidth(70);

    hbox.getChildren().add(imageview);
    //    if(counter == 0)
    //    {
    //      invSlot1.setImage(new Image(cardOverview.getImage().getUrl()));
    //      counter += 1;
    //    } else if (counter == 1)
    //    {
    //      invSlot2.setImage(new Image(cardOverview.getImage().getUrl()));
    //      counter += 1;
    //    } else if(counter == 2)
    //    {
    //      invSlot3.setImage(new Image(cardOverview.getImage().getUrl()));
    //      counter += 1;
    //    }
    // invSlot1.setImage(new Image(cardOverview.getImage().getUrl()));
    selectedCard.setImage(new Image(slotOne.getImage().getUrl()));
    purMenu.setVisible(false);
  }

  @FXML
  protected void userCancelCard(ActionEvent event) throws IOException {
    purMenu.setVisible(false);
  }

  /**
   * Opens the inventory menu for player.
   */
  @FXML
  public void userOpenInventory() {

    if (invMenu.isVisible()) {
      invMenu.setVisible(false);
    } else {
      invMenu.setVisible(true);
    }

  }


}
