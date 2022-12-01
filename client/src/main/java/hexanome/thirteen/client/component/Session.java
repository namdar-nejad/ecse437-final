package hexanome.thirteen.client.component;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * The visual representation of individual game session sessions.
 */
public class Session extends HBox {

  public static ArrayList<Session> sessions;

  public int sessionId;
  public PlayerInfo creator;
  public List<String> playerList;
  public int numOfPlayers;
  public int maxPlayerNum;

  /**
   * Session class for individual game sessions to be displayed.
   *
   * @param sessionId    sessionID
   * @param creator      creator name
   * @param numOfPlayers num of player
   * @param maxPlayerNum max player num
   */
  public Session(int sessionId, PlayerInfo creator, int numOfPlayers, int maxPlayerNum) {
    this.sessionId = sessionId;
    this.creator = creator;
    this.numOfPlayers = numOfPlayers;
    this.maxPlayerNum = maxPlayerNum;

    this.setId("" + sessionId);
    this.setPrefSize(200, 50);
    this.setSpacing(5);
    this.setStyle("-fx-background-color: lightgrey");

    Label idLabel = CommonComponents.createPopUpLabel("" + sessionId);
    idLabel.setPrefSize(40, 40);
    Label creatorLabel = CommonComponents.createPopUpLabel("maex");
    creatorLabel.setPrefSize(40, 40);
    Label numPlayerLabel = CommonComponents.createPopUpLabel(numOfPlayers + "/" + maxPlayerNum);
    numPlayerLabel.setPrefSize(40, 40);
    Button launchButton = new Button("Launch");
    launchButton.setPrefSize(60, 40);
    Button joinButton = new Button("Join");
    joinButton.setPrefSize(80, 40);
    Button leaveButton = new Button("Leave");
    leaveButton.setPrefSize(80, 40);

    this.getChildren()
        .addAll(idLabel, creatorLabel, numPlayerLabel, launchButton, joinButton, leaveButton);

    //sessions.add(this);


  }

  public int getSessionId() {
    return sessionId;
  }

  public PlayerInfo getCreator() {
    return creator;
  }

  public List<String> getPlayerList() {
    return playerList;
  }

  public int getNumOfPlayers() {
    return numOfPlayers;
  }

  public int getMaxPlayerNum() {
    return maxPlayerNum;
  }


}
