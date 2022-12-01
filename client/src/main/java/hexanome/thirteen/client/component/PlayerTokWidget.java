package hexanome.thirteen.client.component;

import hexanome.thirteen.client.constant.PlayerSequence;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The player token resource widget to be displayed on top or on the bottom depending on if it's
 * the player or the opponents.
 */
public class PlayerTokWidget extends VBox {

  private PlayerSequence widgetOwner;
  private ArrayList<ImageView> tokenViews = new ArrayList<>(6);
  private ArrayList<NumLabel> tempTokLabels = new ArrayList<>(6);
  private ArrayList<NumLabel> permTokLabels = new ArrayList<>(6);

  /**
   * Constructor to create the token widget depending on the player type.
   *
   * @param player depending on the player type the location of the widget might change
   */
  public PlayerTokWidget(PlayerSequence player) { // not finalized, could be PlayerInfo player
    tokenViews.addAll(Arrays.stream(Token.createAllTokens()).toList());
    widgetOwner = player;

    this.setId("tokWid" + player.ordinal());
    this.setPrefSize(240, 60);
    this.createPlayerTokWidget();

  }

  private void createPlayerTokWidget() {

    HBox tokenBox = new HBox();
    tokenBox.setSpacing(5);
    tokenBox.setAlignment(Pos.CENTER);

    HBox permBox = new HBox();
    permBox.setSpacing(20);
    tokenBox.setAlignment(Pos.CENTER);

    HBox tempBox = new HBox();
    tempBox.setSpacing(20);
    tempBox.setAlignment(Pos.CENTER);

    for (int i = 0; i < 6; i++) {
      tokenBox.getChildren().add(tokenViews.get(i));

      tempTokLabels.add(i, new NumLabel(3));
      tempBox.getChildren().add(tempTokLabels.get(i));

      permTokLabels.add(i, new NumLabel(0));
      permBox.getChildren().add(permTokLabels.get(i));
    }

    this.getChildren().addAll(tokenBox, permBox, tempBox);
  }

  public ArrayList<NumLabel> getTempNumLabels() {
    return tempTokLabels;
  }
}
