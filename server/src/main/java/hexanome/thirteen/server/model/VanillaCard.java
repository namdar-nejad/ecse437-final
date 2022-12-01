package hexanome.thirteen.server.model;

import java.util.EnumMap;

/**
 * Represents a basic vanilla card which is part of the original game.
 */
public class VanillaCard extends Card {

  private final Token bonus;
  private final Rank rank;

  /**
   * Constructs a vanilla card.
   *
   * @param prestigePoint The number of prestige points that a card provides.
   * @param cost          The associated cost of a card which includes the type of tokens.
   * @param bonus         The bonus resource provided by a card.
   * @param rank          The rank of a card which is given by a number from 1 to 3.
   * @param cardId        The ID of associated with a card.
   */
  public VanillaCard(int prestigePoint, EnumMap<Token, Integer> cost, Token bonus, Rank rank,
                     int cardId) {
    super(prestigePoint, cost, cardId);
    this.bonus = bonus;
    this.rank = rank;
  }

  /**
   * Gets the bonus token of a vanilla card.
   *
   * @return a token of a card.
   */
  public Token getBonus() {
    return bonus;
  }

  /**
   * Gets the rank of a vanilla card.
   *
   * @return a rank of a card.
   */
  public Rank getRank() {
    return rank;
  }
}
