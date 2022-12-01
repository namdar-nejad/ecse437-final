package hexanome.thirteen.client.component;

/**
 * The class to store a single player's information.
 */
public class PlayerInfo {

  private String username;
  private String password;
  private long playerToken;

  public PlayerInfo(String name, long token) {
    username = name;
    playerToken = token;
  }
}
