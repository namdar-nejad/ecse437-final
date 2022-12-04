package hexanome.thirteen.server.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

/**
 * Represents the game board of Splendor.
 */
public class Board {

  private final EnumMap<Token, Integer> bank = new EnumMap<>(Token.class);
  private final List<Deck> decks = new ArrayList<>();
  private final List<List<Card>> slots = new ArrayList<>();

  /**
   * Constructs the game board of Splendor.
   *
   * @param gameMode    Represents the game mode
   * @param playerCount Represents the number of players
   */
  public Board(Game gameMode, int playerCount) {
    initialize(gameMode, playerCount);
  }

  /**
   * This function initializes the board state, including decks, nobles, and bank.
   */
  private void initialize(Game gameMode, int playerCount) {

    int maxToken = 0; // Index to decide how many tokens should exist in the bank

    // Switch board state depending on the number of players
    int nobleSize;
    switch (playerCount) {
      case 2:
        maxToken = 4;
        nobleSize = 3;
        break;
      case 3:
        maxToken = 5;
        nobleSize = 4;
        break;
      case 4:
        maxToken = 7;
        nobleSize = 5;
        break;
      default:
        throw new IllegalArgumentException();
    }

    // Initialize the bank based on the maxToken
    bank.put(Token.EMERALD, maxToken);
    bank.put(Token.DIAMOND, maxToken);
    bank.put(Token.SAPPHIRE, maxToken);
    bank.put(Token.ONYX, maxToken);
    bank.put(Token.RUBY, maxToken);
    bank.put(Token.GOLD, 5);

    // Initialize the card decks
    decks.add(0, new Deck(DeckType.VANILLA, Rank.ONE));
    decks.add(1, new Deck(DeckType.VANILLA, Rank.TWO));
    decks.add(2, new Deck(DeckType.VANILLA, Rank.THREE));
    decks.add(3, new Deck(DeckType.NOBLE, Rank.ONE));

    // Assign the cards drawn from the deck to the card slots
    for (int i = 0; i < decks.size(); i++) {

      int indexSize;  // indicates the size of the slot (depends on the type of card)

      // Vanilla
      if (i < 3) {
        indexSize = 4;
      } else { // Noble
        indexSize = nobleSize;
      }

      Card[] tempSlot = new Card[indexSize]; // Temporary list of cards to add in the slots
      for (int j = 0; j < indexSize; j++) {
        tempSlot[j] = decks.get(i).draw();
      }
      slots.add(Arrays.asList(tempSlot));
    }
  }

  /**
   * Gets the map of the bank from the board.
   *
   * @return a map of bank
   */
  public EnumMap<Token, Integer> getBank() {
    return bank;
  }

  /**
   * Gets the decks of the board.
   *
   * @return a 2D arraylist of cards
   */
  public List<Deck> getDecks() {
    return decks;
  }

  /**
   * Gets the 2D arraylist of slots on the board.
   *
   * @return a 2D arraylist of slots
   */
  public List<List<Card>> getSlots() {
    return slots;
  }

  /**
   * Gets the deck based on the given rank.
   *
   * @param deckRank Represents the index a deck rank
   * @return a specified deck
   */
  public Deck getDeckFromRank(int deckRank) {
    return decks.get(deckRank);
  }

}
