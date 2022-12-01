package hexanome.thirteen.client.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import hexanome.thirteen.client.component.CardsData;
import hexanome.thirteen.client.component.PlayerInfo;
import hexanome.thirteen.client.component.Session;
import hexanome.thirteen.client.constant.GameMode;
import hexanome.thirteen.client.constant.UriConstant;
import hexanome.thirteen.client.view.BoardView;
import hexanome.thirteen.client.view.MainStage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Controller class for lobby.fxml
 */
public class LobbyController {

  private static final MainStageController mainStageController = new MainStageController();


  @FXML
  Button createNewGameButton;
  @FXML
  ScrollPane allSessions;


  /**
   * initialize some dynamic components for the lobby screen.
   *
   * @throws IOException IOException
   */
  @FXML
  public void initialize() throws IOException {
    VBox sessionsBox = new VBox();
    sessionsBox.setId("sessionsBox");
    sessionsBox.setSpacing(5);
    sessionsBox.setAlignment(Pos.CENTER);
    sessionsBox.setPrefWidth(500);

    //getGameSessions();
    allSessions.setContent(sessionsBox);

    getGameSessions();

  }

  @FXML
  protected void userCreateSession() {
    Session temp = new Session(123, new PlayerInfo("maex", 123), 1, 4);
    addSession(temp);
  }


  @FXML
  protected void userLogout() throws IOException {
    mainStageController.fxmlSceneChange("login.fxml");
  }

  @FXML
  protected void userCreateNewGame() throws IOException {
    mainStageController.normalSceneChange(
        BoardView.createView(4, GameMode.Vanilla, CardsData.createStubDeck()));
  }

  // TODO change the return type of this method

  /**
   * Get a list of available sessions from the game server.
   *
   * @throws IOException IOException
   */
  public void getGameSessions() throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(UriConstant.LOBBYSERVICE_URL + "api/sessions");
    HttpResponse response = httpClient.execute(httpGet);
    String json = EntityUtils.toString(response.getEntity());

    Gson gson = new Gson();
    Session session = gson.fromJson(json, Session.class);

    JsonObject object1 = gson.fromJson(json, JsonObject.class);
    int sessionId = object1.get("sessions").getAsInt();
    JsonObject object2 = object1.get("sessions").getAsJsonObject();


    System.out.println(json);
    System.out.println(session.getSessionId());

    //System.out.println(json);
  }


  protected void addSession(Session session) {
    VBox sessionsBox = (VBox) MainStage.stage.getScene().lookup("#sessionsBox");
    sessionsBox.getChildren().add(session);
  }

}
