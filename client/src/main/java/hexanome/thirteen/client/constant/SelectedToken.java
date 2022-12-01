package hexanome.thirteen.client.constant;

/**
 * Each player can at most pick two tokens of the same type.
 */
public enum SelectedToken {
  NONE,
  ONE,
  TWO;

  @Override
  public String toString() {
    return ("" + this.ordinal());
  }

}
