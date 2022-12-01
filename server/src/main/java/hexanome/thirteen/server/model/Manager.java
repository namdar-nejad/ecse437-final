package hexanome.thirteen.server.model;

import hexanome.thirteen.server.controller.Player;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Controls each game of splendor.
 */
@Component
public class Manager {

  /**
   * Manager constructor.
   */
  public Manager() {

  }

  private final Map<Integer, Splendor> games = new Hashtable<>();

  /**
   * Gets the map of each splendor games.
   *
   * @return a game map.
   */
  // Delete after testing
  public Map<Integer, Splendor> getGames() {
    return games;
  }

  /**
   * Adds the game to the game map.
   *
   * @param gameId  Represents the id of a game
   * @param players Represents the list of players.
   */
  public void addGame(int gameId, List<Player> players) {
    Splendor splendor = new Splendor(players);
    games.put(gameId, splendor);
  }

  /**
   * Removes the game from the map.
   *
   * @param gameId Represents the id of a game.
   */
  public void removeGame(int gameId) {
    games.remove(gameId);
  }
}
