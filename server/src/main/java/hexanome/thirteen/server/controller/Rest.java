package hexanome.thirteen.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hexanome.thirteen.server.model.Board;
import hexanome.thirteen.server.model.Card;
import hexanome.thirteen.server.model.Manager;
import hexanome.thirteen.server.model.Noble;
import hexanome.thirteen.server.model.Token;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A test Rest controller for Splendor game.
 */
@RestController
public class Rest {

  private static final Logger logger = LogManager.getLogger(Launcher.class);
  private final Manager myManager;

  /**
   * A Rest controller for Splendor game.
   *
   * @param myManager The state of the game
   */
  public Rest(@Autowired Manager myManager) {
    this.myManager = myManager;
  }

  /**
   * A game registrator with lobby service.
   *
   * @param gameId           The id of a game assigned on registration.
   * @param registrationInfo The info that is needed to register a game service.
   */
  @PutMapping("splendor/api/games/{gameId}")
  public void createGame(@PathVariable("gameId") int gameId, @RequestBody String registrationInfo) {
    System.out.print(registrationInfo);

    // Parsing the json request body received with the put request
    Gson gson = new Gson();
    JsonObject object = gson.fromJson(registrationInfo, JsonObject.class);

    // Extracting the necessary data from the json
    String creator = object.get("creator").toString();
    //String gameServer = object.get("gameServer").toString();
    JsonArray arr = object.get("players").getAsJsonArray();

    // Creating all players in the game
    List<Player> players = new ArrayList<>();

    for (JsonElement element : arr) {
      boolean isHost = false;
      JsonObject playerInfo = element.getAsJsonObject();
      String name = playerInfo.get("name").toString();
      name = name.replace("\"", "");

      if (name.equals(creator)) {
        isHost = true;
      }

      Player player = new Player(name, isHost);
      players.add(player);
    }

    this.myManager.addGame(gameId, players);
  }

  /**
   * Deletes a specific game from the game list.
   *
   * @param gameId Represents the id of the game.
   */
  @DeleteMapping("splendor/api/games/{gameId}")
  public void deleteGame(@PathVariable("gameId") int gameId) {
    this.myManager.removeGame(gameId);
  }

  /**
   * Gets a specific board given the id of the game.
   *
   * @param gameId Represents the id of the game.
   * @return a board object
   */
  @GetMapping("splendor/api/games/{gameId}/board")
  public Board getBoard(@PathVariable int gameId) {
    return this.myManager.getGames().get(gameId).getBoard();
  }

  /**
   * Gets the map of the bank in the board.
   *
   * @param gameId Represents the id of the game.
   * @return a map of the bank
   */
  @GetMapping("splendor/api/games/{gameId}/board/tokens")
  public EnumMap<Token, Integer> getTokens(@PathVariable("gameId") int gameId) {
    return this.myManager.getGames().get(gameId).getBoard().getBank();
  }

  /**
   * Gets a 2D arrayList of the card slots.
   *
   * @param gameId Represents the id of the game.
   * @return a 2D arrayList of slots
   */
  @GetMapping("splendor/api/games/{gameId}/board/slots")
  public List<List<Card>> getSlots(@PathVariable("gameId") int gameId) {
    return this.myManager.getGames().get(gameId).getBoard().getSlots();
  }

  /**
   * Gets a card object.
   *
   * @param gameId Represents the id of the game.
   * @param slotId Represents the id of the slot
   * @return a card object
   */
  @GetMapping("splendor/api/games/{gameId}/board/slots/{slotId}/Card")
  public Card getCard(@PathVariable("gameId") int gameId, @PathVariable("slotId") int slotId) {
    // WE CAN MAYBE MAKE A HELPER FUNCTION THAT RETURNS THE SPECIFIC BOARD OR PLAYER.
    Board board = this.myManager.getGames().get(gameId).getBoard(); // Board object
    String slotIdString = String.valueOf(slotId);

    // Index conversion
    int row = Character.digit(slotIdString.charAt(0), 10) - 1;
    int column = Character.digit(slotIdString.charAt(1), 10) - 1;

    Card card = board.getSlots().get(row).get(column);  // Get card
    return card;
  }

  /*
  @PostMapping("/splendor/api/games/{gameId}/board/slots/{slotId}")
  public void updateVanillaSlot(@PathVariable("gameId") int gameId, @PathVariable("slotId")
  int slotId) {

    Board board = this.myManager.getGames().get(gameId).getBoard();
    List<List<Card>> slots = board.getSlots();

    if(slotId > 0 && slotId <= 4)
    {
      Deck deck = board.getDecks().get(0);
      Card card = deck.draw();
      slots.get(0).set(slotId - 1, card);
    } else if (slotId > 4 && slotId <= 8)
    {
      Deck deck = board.getDecks().get(1);
      Card card = deck.draw();
      slots.get(1).set(slotId - 1, card);
    } else if (slotId > 8 && slotId <= 12) {
      Deck deck = board.getDecks().get(3);
      Card card = deck.draw();
      slots.get(0).set(slotId, card);
    } else {
      throw new IllegalArgumentException();
    }
  }
   */


  /**
   * Gets a list of players in game.
   *
   * @param gameId Represents the id of the game.
   * @return a list of players
   */
  @GetMapping("splendor/api/games/{gameId}/players")
  public List<Player> getPlayers(@PathVariable("gameId") int gameId) {
    return this.myManager.getGames().get(gameId).getPlayers();
  }

  /**
   * Gets a specific player in game.
   *
   * @param gameId Represents the id of the game.
   * @return a player object
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}")
  private Player getPlayer(@PathVariable("gameId") int gameId,
                           @PathVariable("playerName") String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName);
  }

  /**
   * Gets the list of cards that a player has.
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @return A list of cards
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}/inventory")
  public List<Card> getPlayerInventory(@PathVariable("gameId") int gameId,
                                       @PathVariable("playerName") String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName).getInventory();
  }

  /**
   * Gets the list of nobles that a player has.
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @return A list of noble cards
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}/nobleInventory")
  public List<Noble> getNobleInventory(@PathVariable("gameId") int gameId,
                                       @PathVariable("playerName") String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName).getNobleInventory();
  }

  /**
   * Gets the player's map of bonus tokens (from resource cards).
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @return a map of the bonus tokens
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}/bonusTokens")
  public EnumMap<Token, Integer> getPlayerBonusToken(@PathVariable("gameId") int gameId,
                                                     @PathVariable("playerName")
                                                     String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName).getBonusTokens();
  }

  /**
   * Gets the player's map of tokens.
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @return a map of the tokens
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}/token")
  public EnumMap<Token, Integer> getPlayerToken(@PathVariable("gameId") int gameId,
                                                @PathVariable("playerName") String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName).getTokens();
  }

  /**
   * Gets the list of cards that a player reserved.
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @return a list of reserved cards
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}/reserved")
  public List<Card> getPlayerReserve(@PathVariable("gameId") int gameId,
                                     @PathVariable("playerName") String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName).getReservedCards();
  }

  /**
   * Gets the player's prestige point.
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @return a prestige point
   */
  @GetMapping("splendor/api/games/{gameId}/players/{playerName}/prestigePoints")
  public int getPlayerPrestige(@PathVariable("gameId") int gameId,
                               @PathVariable("playerName") String playerName) {
    return this.myManager.getGames().get(gameId).getPlayer(playerName).getPrestigePoint();
  }

  /**
   * Allows the player to purchase a card and add it to their inventory.
   *
   * @param gameId     Represents the id of the game.
   * @param playerName Represents the name of the player
   * @param slotId     Represents the id of the slot
   * @return a boolean that tells if the purchase was successful
   */
  @PostMapping("splendor/api/games/{gameId}/players/{playerName}/actions/purchase/{slot-id}")
  public boolean purchaseCard(@PathVariable("gameId") int gameId,
                              @PathVariable("playerName") String playerName,
                              @PathVariable("slot-id") int slotId) {
    Player player = this.myManager.getGames().get(gameId).getPlayer(playerName);  // Player object
    Board board = this.myManager.getGames().get(gameId).getBoard(); // Board object
    String slotIdString = String.valueOf(slotId);

    // Index conversion
    int row = Character.digit(slotIdString.charAt(0), 10) - 1;
    int column = Character.digit(slotIdString.charAt(1), 10) - 1;

    Card card = board.getSlots().get(row).get(column);  // Get card
    EnumMap<Token, Integer> balance = player.getBalance();  // Map of the player's balance
    EnumMap<Token, Integer> cost = card.getCost();
    EnumMap<Token, Integer> bank = board.getBank(); // Map of the bank

    // Check if the player can purchase the card
    if (player.purchasable(balance, cost)) {
      // Calculate the balance of the player and return the tokens back to the bank

      // Will have to modify for gold tokens
      for (Token key : cost.keySet()) {
        player.getTokens().put(key, player.getTokens().get(key) - cost.get(key));
        bank.put(key, bank.get(key) + cost.get(key));
      }
      // Add the card to the player's inventory and draw a new card to the slot
      player.getInventory().add(card);
      board.getSlots().get(row).set(column, board.getDecks().get(row).draw());
      return true;
    }
    return false;   // False if player cannot purchase it
  }
}
