package hexanome.thirteen.server.model;

import java.util.EnumMap;

/**
 * Abstract class representing a generic card and all data associated with it.
 */
public abstract class Card {

  private final int prestigePoint;
  private final EnumMap<Token, Integer> cost;
  private final int cardId;

  /**
   * Constructor which provides generic card functionality that is inherited by all child classes.
   *
   * @param prestigePoint The number of prestige points that a card provides.
   * @param cardId        The ID of associated with a card.
   * @param cost          The cost associated with the card.
   */
  public Card(int prestigePoint, EnumMap<Token, Integer> cost, int cardId) {
    this.prestigePoint = prestigePoint;
    this.cost = cost;
    this.cardId = cardId;
  }

  /**
   * Gets the prestige of the card.
   *
   * @return an integer of prestige point
   */
  public int getPrestigePoint() {
    return prestigePoint;
  }

  /**
   * Gets the map of the cost of a card.
   *
   * @return a map of the card's cost
   */
  public EnumMap<Token, Integer> getCost() {
    return cost;
  }

  /**
   * Gets the id of a card.
   *
   * @return an integer of the card id
   */
  public int getCardId() {
    return cardId;
  }
}
