package hexanome.thirteen.server.model;

import java.util.EnumMap;

/**
 * A class which represents a Noble in the game of splendor.
 */
public class Noble extends Card {

  /**
   * Constructs a noble card.
   *
   * @param nobleId       The ID of associated with a noble.
   * @param prestigePoint The number of prestige points that a noble provides.
   * @param cost          The cost associated with the noble card
   */
  public Noble(int prestigePoint, EnumMap<Token, Integer> cost, int nobleId) {
    super(prestigePoint, cost, nobleId);
  }
}
