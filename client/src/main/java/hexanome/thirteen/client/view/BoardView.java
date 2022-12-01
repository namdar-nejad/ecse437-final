package hexanome.thirteen.client.view;

import static hexanome.thirteen.client.constant.UriConstant.CSS_PATH;

import hexanome.thirteen.client.component.Bank;
import hexanome.thirteen.client.component.BankMenu;
import hexanome.thirteen.client.component.BoardCenter;
import hexanome.thirteen.client.component.Card;
import hexanome.thirteen.client.component.CommonComponents;
import hexanome.thirteen.client.component.GameInfo;
import hexanome.thirteen.client.component.InventoryMenu;
import hexanome.thirteen.client.component.OpponentInfo;
import hexanome.thirteen.client.component.OpponentResource;
import hexanome.thirteen.client.component.PlayerTokWidget;
import hexanome.thirteen.client.component.PurchaseMenu;
import hexanome.thirteen.client.constant.GameMode;
import hexanome.thirteen.client.constant.PlayerSequence;
import hexanome.thirteen.client.controller.GameStateController;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * This class consists most of the components that would be displayed when the game launches.
 */
public class BoardView {

  public static GameInfo gameInfo;

  /**
   * The main method to create the game board, initialize most of static visual aspects and create
   * class objects to correspond to the dynamic ones.
   *
   * @return a Vbox object that represents the entire board view.
   */
  // List<Playes>, int NumofPlayer, GameType, List<CardSlot>
  //GameType gametype -> Orient / Vanilla
  public static VBox createView(int numOfPlayers, GameMode gameMode, List<List<Card>> cards) {
    VBox mainBox = new VBox();
    mainBox.setAlignment(Pos.CENTER);
    mainBox.setPrefHeight(900.0);
    mainBox.setPrefWidth(1600.0);
    mainBox.getStylesheets().add("/hexanome/thirteen/client/assets/css/style.css");
    mainBox.getStyleClass().add("game-board-background");

    AnchorPane mainAnchor = new AnchorPane();
    mainAnchor.setPrefHeight(800);
    mainAnchor.setPrefWidth(1500);
    mainAnchor.setLayoutX(800);
    mainAnchor.setLayoutY(450);
    mainAnchor.getStylesheets()
        .add(BoardView.class.getResource(CSS_PATH + "style.css").toExternalForm());
    mainAnchor.getStyleClass().add("game-board-background");

    //Create game info class to store the meta information about the current game state
    gameInfo = new GameInfo(new ArrayList<>());
    mainAnchor.getChildren().add(gameInfo);

    // Create the main board part where most public cards are displayed
    BoardCenter boardCenter = new BoardCenter(gameMode, cards);
    boardCenter.setId("board-center");

    // Create new user inventory
    InventoryMenu invMenu = new InventoryMenu(PlayerSequence.YOU);
    invMenu.setVisible(false);
    invMenu.setId("inventory");

    // Button for toggling inventory visibility
    Button invButton = new Button("...");
    invButton.setLayoutX(350);
    invButton.setLayoutY(700);
    invButton.getStylesheets()
        .add(BoardView.class.getResource(CSS_PATH + "button-style.css").toExternalForm());
    invButton.getStyleClass().add("standard-popup-button");
    invButton.setOnAction(x -> invMenu.setVisible(!(invMenu.isVisible())));

    // Add all previously created items to the mainAnchor class
    mainAnchor.getChildren().addAll(boardCenter, invMenu, invButton);

    // Create widget and inventory for all opponents
    for (int i = 1; i < numOfPlayers; i++) {
      InventoryMenu tempInventory = new InventoryMenu(PlayerSequence.values()[i]);
      OpponentInfo tempOpponent = new OpponentInfo();
      OpponentResource tempResource =
          new OpponentResource(PlayerSequence.values()[i], tempInventory);

      mainAnchor.getChildren().addAll(tempResource, tempResource.getOpponentInventory());
    }

    // create purchase menu for the user
    PurchaseMenu purchaseMenu = new PurchaseMenu();
    mainAnchor.getChildren().add(purchaseMenu);

    // create the bank widget on the left of the board screen
    Bank bank = new Bank();
    BankMenu bankMenu = new BankMenu();
    bank.setOnMouseClicked(e -> bankMenu.setVisible(!bankMenu.isVisible()));

    mainAnchor.getChildren().addAll(bank, bankMenu);

    // temp testing playertokwidget
    PlayerTokWidget userWidget = new PlayerTokWidget(PlayerSequence.YOU);
    userWidget.setLayoutX(50);
    userWidget.setLayoutY(700);
    mainAnchor.getChildren().add(userWidget);

    // temp Refresh button for refreshing game state
    Button refreshButton = CommonComponents.createPopUpButton("Refresh");
    refreshButton.setOnAction(e -> new GameStateController().refreshGameState());
    refreshButton.setLayoutX(1500);
    refreshButton.setLayoutY(400);
    refreshButton.setPrefSize(100, 40);
    mainAnchor.getChildren().add(refreshButton);

    mainBox.getChildren().add(mainAnchor);

    MainStage.stage.setHeight(900);
    MainStage.stage.setWidth(1600);
    return mainBox;


  }


}
