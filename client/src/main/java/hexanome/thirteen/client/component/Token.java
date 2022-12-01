package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.TokenType.BLACK;
import static hexanome.thirteen.client.constant.TokenType.BLUE;
import static hexanome.thirteen.client.constant.TokenType.GOLD;
import static hexanome.thirteen.client.constant.TokenType.GREEN;
import static hexanome.thirteen.client.constant.TokenType.RED;
import static hexanome.thirteen.client.constant.TokenType.WHITE;
import static hexanome.thirteen.client.constant.UriConstant.IMAGE_PATH;

import hexanome.thirteen.client.constant.TokenType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The token visual object class, it can be used whenever the visual of token is needed.
 * It also stores the token type of that particular token class.
 */
public class Token extends ImageView {

  //  private static ArrayList<TokenType> createdTokens = new ArrayList<>();
  private TokenType tokenType;
  private int numLeft; //num of tokens left in the bank // so far it's not really used.


  /**
   * Creates a token object.
   *
   * @param type the token type to be created
   * @param url  the url to the image file
   */
  public Token(TokenType type, String url) {
    // assert !createdTokens.contains(type);
    //createdTokens.add(type);
    this.setFitHeight(40);
    this.setFitWidth(40);
    this.setImage(new Image(this.getClass().getResource(IMAGE_PATH + url).toExternalForm()));
    numLeft = 6;
    tokenType = type;

  }

  /**
   * A factory method that returns an array of all six types of tokens.
   *
   * @return an array of the tokens in a fixed order.
   */
  public static Token[] createAllTokens() {

    Token[] allToks = new Token[6];

    allToks[0] = new Token(BLUE, "blue_token.jpg");

    allToks[1] = new Token(BLACK, "black_token.jpg");

    allToks[2] = new Token(RED, "red_token.jpg");

    allToks[3] = new Token(WHITE, "white_token.jpg");

    allToks[4] = new Token(GREEN, "green_token.jpg");

    allToks[5] = new Token(GOLD, "gold_token.jpg");

    return allToks;
  }

  public int getNumLeft() {
    return numLeft;
  }
}
