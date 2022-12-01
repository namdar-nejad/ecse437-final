package hexanome.thirteen.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * This class deals with the Lobby Service functions.
 */
@Component
public class LobbyService {

  private static final Logger logger = LogManager.getLogger(Launcher.class);
  private String gameIp;
  private String lobbyIp;

  /**
   * LobbyService constructor.
   */
  public LobbyService() {

  }

  /**
   * Testing functionality of init function.
   */
  @PostConstruct
  public void init() {
    //registerGame();
  }

  /**
   * This function gets the access token of the user.
   *
   * @return a string representing the access token.
   */
  // Almost all code provided by arc
  public String getToken() {

    RestTemplate rest = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("authorization", "Basic YmdwLWNsaWVudC1uYW1lOmJncC1jbGllbnQtcHc=");

    String body =
        "user_oauth_approval=true&_csrf=19beb2db-3807-4dd5-9f64-6c733462281b&authorize=true";

    HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
    ResponseEntity<String> responseEntity = rest.exchange(
        "http://127.0.0.1:4242/oauth/token?grant_type=password&username=xox&password=laaPhie*aiN0",
        HttpMethod.POST, requestEntity, String.class);
    HttpStatus httpStatus = responseEntity.getStatusCode();
    int status = httpStatus.value();
    String response = responseEntity.getBody();
    System.out.println("Response status: " + status);
    System.out.println(response);

    // Extracting and returning the token from json
    Gson gson = new Gson();
    JsonObject object = gson.fromJson(response, JsonObject.class);
    return object.get("access_token").toString().replace("+", "%2B");
  }

  /**
   * This function registers the game to the lobby service.
   */
  // Almost all code provided by arc
  public void registerGame() {

    String url = "http://127.0.0.1:4242/api/gameservices/splendor?access_token="
        + getToken().replace("\"", "");

    RestTemplate rest = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("authorization", "Basic YmdwLWNsaWVudC1uYW1lOmJncC1jbGllbnQtcHc=");
    String body = "{\n"
        + "\t\"location\": \"http://127.0.0.1:8080/splendor\",\n"
        + "\t\"maxSessionPlayers\": 4,\n"
        + "\t\"minSessionPlayers\": 2,\n"
        + "\t\"name\": \"splendor\",\n"
        + "\t\"displayName\": \"Splendor game\",\n"
        + "\t\"webSupport\": \"true\"\n"
        + "}";

    HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
    ResponseEntity<String> responseEntity = rest.exchange(
        url,
        HttpMethod.PUT, requestEntity, String.class);

    HttpStatus httpStatus = responseEntity.getStatusCode();
    int status = httpStatus.value();
    String response = responseEntity.getBody();
    System.out.println("Response status: " + status);
    System.out.println(response);
  }

  /**
   * Unregisters the game from the lobby service.
   */
  public void unRegisterGame() {

  }
}
