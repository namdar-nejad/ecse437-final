package hexanome.thirteen.server.model;

import hexanome.thirteen.server.controller.Player;
import java.util.List;

/**
 * Represents a game of splendor and data associated with it.
 */
public class Splendor {

  private final List<Player> players;
  private final Board board;

  /**
   * Constructs a game of Splendor.
   *
   * @param players Represents the list of players in a game of Splendor.
   */
  public Splendor(List<Player> players) {
    this.players = players;
    this.board = new Board(Game.Splendor, players.size());
  }

  /**
   * Gets the board object.
   *
   * @return a board object for splendor.
   */
  public Board getBoard() {
    return this.board;
  }

  /**
   * Gets the list of players in a game of splendor.
   *
   * @return a list of players.
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Gets a specific player given the player's name.
   *
   * @param playerName Represents the name of a player
   * @return a player object
   */
  public Player getPlayer(String playerName) {
    for (Player player : players) {
      if (player.getName().equals(playerName)) {
        return player;
      }
    }
    throw new RuntimeException("Player not found");
  }
}
