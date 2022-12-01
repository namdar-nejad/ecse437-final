package hexanome.thirteen.client.controller;

import hexanome.thirteen.client.component.CardsData;
import hexanome.thirteen.client.constant.GameMode;
import hexanome.thirteen.client.constant.UriConstant;
import hexanome.thirteen.client.view.BoardView;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * The controller class responsible for controlling actions related to the log in screen made
 * using fxml.
 */
public class LoginController {

  private static final MainStageController mainStageController = new MainStageController();

  @FXML
  private TextField username;
  @FXML
  private PasswordField password;
  @FXML
  private Label loginLabel;

  @FXML
  protected void userLogin() throws IOException {
    checkCredentials();
  }

  //  @FXML
  //  protected void userLogout() throws IOException {
  //    mainStageController.fxmlSceneChange("login.fxml");
  //  }

  private void checkCredentials() throws IOException {

    //    if (true) { //.getText().equals("hello_world") && password.getText().equals("group13"))
    //      loginLabel.setText("SUCCESSFUL!");
    //      mainStageController.fxmlSceneChange("lobby.fxml");
    //
    //    } else {
    //      loginLabel.setText("Username or Password incorrect");
    //    }
    //
    //    if (true) {
    //      return;
    //    }

    //
    // Creating the post parameters for the user
    ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
    postParameters.add(new BasicNameValuePair("username", username.getText()));
    postParameters.add(new BasicNameValuePair("password", password.getText()));
    postParameters.add(new BasicNameValuePair("grant_type", "password"));


    // Setting up basic authentication
    CredentialsProvider provider = new BasicCredentialsProvider();
    UsernamePasswordCredentials
        credentials = new UsernamePasswordCredentials("bgp-client-name", "bgp-client-pw");
    provider.setCredentials(AuthScope.ANY, credentials);

    HttpClient httpClient = HttpClientBuilder.create()
        .setDefaultCredentialsProvider(provider)
        .build();


    // Executing the POST request with basic authentication and the user as a JSON
    // object
    HttpPost post = new HttpPost(UriConstant.LOBBYSERVICE_URL + "oauth/token");
    post.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
    HttpResponse response = httpClient.execute(post);


    // Check the status code
    if (response.getStatusLine().getStatusCode() == 200) {
      loginLabel.setText("SUCCESSFUL!");
      mainStageController.fxmlSceneChange("lobby.fxml");
    } else {
      loginLabel.setText("Username or Password incorrect");
    }


  }

  @FXML
  protected void userCreateNewGame() throws IOException {
    mainStageController.normalSceneChange(
        BoardView.createView(4, GameMode.Vanilla, CardsData.createStubDeck()));
  }

}
