package hexanome.thirteen.client.controller;

import hexanome.thirteen.client.component.PlayerTokWidget;
import hexanome.thirteen.client.constant.PlayerSequence;
import hexanome.thirteen.client.view.BoardView;
import hexanome.thirteen.client.view.MainStage;
import java.util.ArrayList;

/**
 * The controller class for all the operation related to taking tokens from the bank or returning
 * tokens to the bank.
 */
public class BankController {

  /**
   * When player press confirm button on the bank menu the client will send a request to the server
   * to check if such actions is possible.
   *
   * @param tokens the list of tokens that the player wants to take
   */
  public boolean confirmTokens(ArrayList<Integer> tokens) {

    if (BoardView.gameInfo.getCurPlayer() != PlayerSequence.YOU) {
      return false;
    }

    // http request for confirming the current player's tokens to take


    // after http
    boolean tempResultFromServer = true;
    if (tempResultFromServer) {
      transferToken(PlayerSequence.YOU, tokens);
    }
    BoardView.gameInfo.toggleTurn();
    return true;


    //return false;
  }

  private void transferToken(PlayerSequence player, ArrayList<Integer> tokens) {
    PlayerTokWidget playerWidget =
        (PlayerTokWidget) MainStage.stage.getScene()
            .lookup("#tokWid" + player.ordinal());

    for (int i = 0; i < 5; i++) {
      playerWidget.getTempNumLabels().get(i).increase(tokens.get(i));
    }
  }

}
