package hexanome.thirteen.client.constant;

/**
 * Enum for marking players moving sequence.
 */
public enum PlayerSequence {
  YOU, PLAYER_ONE, PLAYER_TWO, PLAYER_THREE;

  @Override
  public String toString() {
    if (this == YOU) {
      return "Your ";
    } else {
      return "Player" + this.ordinal() + "'s ";
    }
  }
}
