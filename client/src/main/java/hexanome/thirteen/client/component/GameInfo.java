package hexanome.thirteen.client.component;

import hexanome.thirteen.client.constant.PlayerSequence;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * The class that stores the meta information of the current game and display whose turn it is.
 */
public class GameInfo extends Label {

  private PlayerSequence curPlayer;
  private ArrayList<PlayerSequence> allPlayers;
  private int numOfPlayer;
  private boolean isYourTurn;

  /**
   * Create the GameInfo label object.
   *
   * @param players a list of Players that are playing the game
   */
  public GameInfo(ArrayList<PlayerInfo> players) {
    //temp
    this.curPlayer = PlayerSequence.YOU;
    this.isYourTurn = true;
    //temp
    this.numOfPlayer = 4;
    //temp
    allPlayers = new ArrayList<>();
    allPlayers.add(PlayerSequence.YOU);
    allPlayers.add(PlayerSequence.PLAYER_ONE);
    allPlayers.add(PlayerSequence.PLAYER_TWO);
    allPlayers.add(PlayerSequence.PLAYER_THREE);
    //not temp
    this.setId("gameInfo");
    // temp text
    this.setText(PlayerSequence.YOU.toString() + " Turn!");
    // not temp
    this.setPrefSize(200, 80);
    this.setLayoutX(700);
    this.setLayoutY(100);
    this.setAlignment(Pos.CENTER);
    this.setFont(new Font("Arial", 20));
    this.setStyle("-fx-background-color: lightblue");
  }

  public PlayerSequence getCurPlayer() {
    return curPlayer;
  }

  /**
   * Change the turn to the next player. Invoked on every successful action performed.
   */
  public void toggleTurn() {
    this.curPlayer = PlayerSequence.values()[(curPlayer.ordinal() + 1) % numOfPlayer];
    this.setText(curPlayer.toString() + " Turn!");
    if (curPlayer == PlayerSequence.YOU) {
      isYourTurn = true;
    } else {
      isYourTurn = false;
    }
  }


}
