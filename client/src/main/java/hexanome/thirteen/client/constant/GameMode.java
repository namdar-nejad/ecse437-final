package hexanome.thirteen.client.constant;

/**
 * The game mode (expansion) of the current game.
 */
public enum GameMode {
  Vanilla,
  Orient;

  /**
   * Return different attribute depends on which game mode the current game is.
   *
   * @return an int the indicates how many slots each row has.
   */
  public int boardDetail() {

    if (this == Vanilla) {
      return 4;
    } else {
      return 6;
    }
  }
}
