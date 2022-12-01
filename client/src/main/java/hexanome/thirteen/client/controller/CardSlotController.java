package hexanome.thirteen.client.controller;

import hexanome.thirteen.client.component.CardSlot;
import hexanome.thirteen.client.component.InventorySlot;
import hexanome.thirteen.client.component.PlayerTokWidget;
import hexanome.thirteen.client.component.PurchaseMenu;
import hexanome.thirteen.client.constant.PlayerSequence;
import hexanome.thirteen.client.constant.TokenType;
import hexanome.thirteen.client.view.BoardView;
import hexanome.thirteen.client.view.MainStage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * Handle all the logistics of anything related to Card Slots, like purchasing card.
 */
public class CardSlotController {

  /**
   * Opens purchase menu with information of the specific card clicked.
   * Right now it directly purchase the card, need modifications.
   *
   * @param event contains the specific card slot in the board center that was clicked on.
   */
  public void userToggleCard(MouseEvent event) {
    CardSlot curSlot = (CardSlot) event.getSource();
    PurchaseMenu purchaseMenu = (PurchaseMenu) MainStage.stage.getScene()
        .lookup("#purchaseMenu");

    purchaseMenu.setCardPreview(curSlot);
    purchaseMenu.setVisible(true);
  }

  /**
   * The function for user to purchase the card, put the card into user's inventory slot if true.
   *
   * @param cardToBuy the card to be bought.
   */
  public boolean userPurchaseCard(CardSlot cardToBuy) {
    if (BoardView.gameInfo.getCurPlayer() != PlayerSequence.YOU) {
      return false;
    }
    // send http request to the server for purchasing the card and return a boolean and maybe a card
    // to be replaced


    // if true
    if (true) {
      // get the data of the new player remaining tokens

      transferCard(PlayerSequence.YOU, cardToBuy, false); // ArrayList<> playerNewTokens
      return true;
    }

    return false;

  }

  /**
   * Send the card that user wants reserve to the serve and reserve it if server returns true.
   *
   * @param cardToReserve the card that user wants to reserve
   */
  public boolean userReserveCard(CardSlot cardToReserve) {
    if (BoardView.gameInfo.getCurPlayer() != PlayerSequence.YOU) {
      return false;
    }

    // send http request

    // if true
    if (true) {
      transferCard(PlayerSequence.YOU, cardToReserve, true);
    }

    return true;
  }

  /**
   * The function for actually transfering a card from board center to a specific player.
   * need player name, the card to transfer, the flag for if it's a reserve card (for gold token)
   * and maybe a list of tokens and their numbers to indicate the new state of player's resource.
   *
   * @param player       the player that intent to get the card.
   * @param cardTransfer the card to be transferred
   * @param isReserve    the flag to indicate if it's for reserve card
   */
  private void transferCard(PlayerSequence player, CardSlot cardTransfer, boolean isReserve) {
    CardSlot curSlot = cardTransfer;
    HBox curInventory = (HBox) MainStage.stage.getScene()
        .lookup("#collectedCards" + player.ordinal());

    InventorySlot cardView = new InventorySlot(curSlot.takeCard());
    curInventory.getChildren().add(cardView);

    if (isReserve) {
      PlayerTokWidget curPlayerWidget = (PlayerTokWidget) MainStage.stage.getScene()
          .lookup("#tokWid" + player.ordinal());
      curPlayerWidget.getTempNumLabels().get(TokenType.GOLD.ordinal()).increase(1);

    }


    PurchaseMenu purchaseMenu = (PurchaseMenu) MainStage.stage.getScene()
        .lookup("#purchaseMenu");
    purchaseMenu.setVisible(false);
    BoardView.gameInfo.toggleTurn();


  }

}
