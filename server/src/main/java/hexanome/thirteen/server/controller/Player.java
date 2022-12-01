package hexanome.thirteen.server.controller;

import hexanome.thirteen.server.model.Card;
import hexanome.thirteen.server.model.Noble;
import hexanome.thirteen.server.model.Token;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Represents each player information.
 */
public class Player {

  private final List<Card> inventory = new ArrayList<>();
  private final List<Noble> nobleInventory = new ArrayList<>();
  private final List<Card> reservedCards = new ArrayList<>();
  private final String name;
  private final EnumMap<Token, Integer> tokens = new EnumMap<Token, Integer>(Token.class);
  private final EnumMap<Token, Integer> bonusTokens = new EnumMap<Token, Integer>(Token.class);
  private final boolean isHost;
  private final int prestigePoint = 0;

  /**
   * Constructs a Player and all data associated with it.
   *
   * @param name   The player's name.
   * @param isHost The boolean that indicates whether a player is the host.
   */
  public Player(String name, boolean isHost) {
    this.name = name;
    this.isHost = isHost;

    tokens.put(Token.EMERALD, 3);
    tokens.put(Token.DIAMOND, 3);
    tokens.put(Token.SAPPHIRE, 3);
    tokens.put(Token.ONYX, 3);
    tokens.put(Token.RUBY, 3);
    tokens.put(Token.GOLD, 3);

    bonusTokens.put(Token.EMERALD, 0);
    bonusTokens.put(Token.DIAMOND, 0);
    bonusTokens.put(Token.SAPPHIRE, 0);
    bonusTokens.put(Token.ONYX, 0);
    bonusTokens.put(Token.RUBY, 0);
    bonusTokens.put(Token.GOLD, 0);
  }

  /**
   * Gets the list of cards that a player owns.
   *
   * @return a list of cards
   */
  public List<Card> getInventory() {
    return inventory;
  }

  /**
   * Gets the list of noble cards that a player owns.
   *
   * @return a list of noble cards
   */
  public List<Noble> getNobleInventory() {
    return nobleInventory;
  }

  /**
   * Gets the list of reserved cards that a player owns.
   *
   * @return a list of reserved cards
   */
  public List<Card> getReservedCards() {
    return reservedCards;
  }

  /**
   * Gets the name of a player.
   *
   * @return a string of a player's name
   */
  public String getName() {
    return this.name;
  }


  /**
   * Gets the mapping of the tokens that a player owns.
   *
   * @return a map of tokens
   */
  public EnumMap<Token, Integer> getTokens() {
    return tokens;
  }

  /**
   * Gets the mapping of the bonus tokens (permanent tokens from resource cards) of a player.
   *
   * @return a map of bonus tokens
   */
  public EnumMap<Token, Integer> getBonusTokens() {
    return bonusTokens;
  }

  /**
   * Gets the boolean that tells if the player is the host.
   *
   * @return a host boolean
   */
  public boolean isHost() {
    return isHost;
  }

  /**
   * Gets the prestige point of a player.
   *
   * @return an integer of prestige point
   */
  public int getPrestigePoint() {
    return prestigePoint;
  }

  /**
   * Gets the map of a player's balance (token + bonus tokens).
   *
   * @return a mapping of player's total balance.
   */
  public EnumMap<Token, Integer> getBalance() {
    EnumMap<Token, Integer> tokenSum = tokens.clone();

    // We need to implement gold coin too
    for (Token key : tokenSum.keySet()) {
      tokenSum.put(key, tokens.get(key) + bonusTokens.get(key));
    }
    return tokenSum;
  }

  /**
   * Gets the boolean that checks if a player can purchase a specified card.
   *
   * @param balance Represents the map of a player's balance
   * @param cost    Represents the map of a card's cost
   * @return a boolean that tells if the card is purchasable.
   */
  public Boolean purchasable(EnumMap<Token, Integer> balance, EnumMap<Token, Integer> cost) {

    for (Token key : cost.keySet()) {
      if (balance.get(key) < cost.get(key)) {
        return false;
      }
    }
    return true;
  }
}
