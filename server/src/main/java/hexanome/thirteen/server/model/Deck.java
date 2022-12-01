package hexanome.thirteen.server.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Stack;


/**
 * Represents a deck of cards which can hold vanilla cards, nobles, or orient cards.
 */
public class Deck {

  private final Stack<Card> cards = new Stack<>();

  /**
   * Constructs a deck based on the type of deck and rank of the deck.
   * If the type of deck is noble the rank is ignored.
   * The deck is initialized and shuffled when constructed.
   *
   * @param deckType The type of deck needed, either vanilla, noble, or orient.
   * @param rank     The rank of the deck, a number between 1 and 3.
   */
  public Deck(DeckType deckType, Rank rank) {
    fillDeck(deckType, rank);
    shuffle();
  }

  /**
   * Draws a card from the top of the deck.
   *
   * @return a card from the top of the deck.
   */
  public Card draw() {
    return cards.pop();
  }

  /**
   * Shuffles the deck of cards.
   */
  private void shuffle() {
    Collections.shuffle(cards);
  }

  /**
   * Initializes a deck based off of the provided deck type and rank.
   * Each card in the Splendor game is built
   * by parsing information in a json file and then added to the deck.
   *
   * @param deckType The type of deck needed, either vanilla, noble, or orient.
   * @param deckRank The rank of the deck, a number between 1 and 3.
   */
  private void fillDeck(DeckType deckType, Rank deckRank) {

    String resource;  // Represents the path to the resource cards
    String contents;  // Represents the name of the list of cards

    // Change the path of the card files based on the desired deck and rank
    if (deckType == DeckType.VANILLA) {
      if (deckRank == Rank.ONE) {
        resource = "json/cards1.json";
      } else if (deckRank == Rank.TWO) {
        resource = "json/cards2.json";
      } else if (deckRank == Rank.THREE) {
        resource = "json/cards3.json";
      } else {
        throw new IllegalArgumentException();
      }
      contents = "cards";
    } else if (deckType == DeckType.NOBLE) {
      resource = "json/nobles.json";
      contents = "nobles";
    } else {
      throw new IllegalArgumentException();
    }

    // Finds the specified json file in the resources directory
    // and stores its contents in an input stream
    InputStream is = getClass().getClassLoader().getResourceAsStream(resource);

    // Throws exception if the input stream is null
    if (is == null) {
      throw new IllegalArgumentException();
    }

    // Create a buffed reader with the contents of the json
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    // Getting the contents of the json file and storing it as a json array
    Gson gson = new Gson();
    JsonObject json = gson.fromJson(br, JsonObject.class);

    JsonArray arr = json.get(contents).getAsJsonArray();

    // Iterate through each element in the file
    for (JsonElement element : arr) {
      JsonObject object = element.getAsJsonObject();

      // Getting the prestige entry
      int prestige = object.get("prestige").getAsInt();

      // Getting the cost entry
      JsonArray costs = object.get("cost").getAsJsonArray();

      // Assign the costs
      EnumMap<Token, Integer> cost = new EnumMap<>(Token.class);
      cost.put(Token.DIAMOND, costs.get(0).getAsInt());
      cost.put(Token.SAPPHIRE, costs.get(1).getAsInt());
      cost.put(Token.EMERALD, costs.get(2).getAsInt());
      cost.put(Token.RUBY, costs.get(3).getAsInt());
      cost.put(Token.ONYX, costs.get(4).getAsInt());

      int cardId = object.get("id").getAsInt(); // Assign the card id

      // Insert the card to the deck if it's nobles
      if (deckType == DeckType.NOBLE) {
        Noble noble = new Noble(prestige, cost, cardId);
        cards.push(noble);
      } else { // Assign the bonus entry
        String tokenTag = object.get("bonus").getAsString();
        Token bonus;

        switch (tokenTag) {
          case "white":
            bonus = Token.DIAMOND;
            break;
          case "blue":
            bonus = Token.SAPPHIRE;
            break;
          case "green":
            bonus = Token.EMERALD;
            break;
          case "red":
            bonus = Token.RUBY;
            break;
          case "black":
            bonus = Token.ONYX;
            break;
          default:
            throw new IllegalArgumentException();
        }

        // Assign the rank entry
        String rankTag = object.get("rank").getAsString();
        Rank rank;

        switch (rankTag) {
          case "1":
            rank = Rank.ONE;
            break;
          case "2":
            rank = Rank.TWO;
            break;
          case "3":
            rank = Rank.THREE;
            break;
          default:
            throw new IllegalArgumentException();
        }

        // Inserting the vanilla card to the deck
        VanillaCard card = new VanillaCard(prestige, cost, bonus, rank, cardId);
        cards.push(card);
      }
    }
  }

  /**
   * Gets the deck of cards.
   *
   * @return a stack of cards.
   */
  public Stack<Card> getCards() {
    return cards;
  }
}
