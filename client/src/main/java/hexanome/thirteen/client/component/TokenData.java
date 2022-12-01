package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.TokenType.BLACK;
import static hexanome.thirteen.client.constant.TokenType.BLUE;
import static hexanome.thirteen.client.constant.TokenType.GOLD;
import static hexanome.thirteen.client.constant.TokenType.GREEN;
import static hexanome.thirteen.client.constant.TokenType.RED;
import static hexanome.thirteen.client.constant.TokenType.WHITE;

import java.util.ArrayList;

/**
 * A list of constant tokens for the public bank class.
 */
public class TokenData {

  public static final ArrayList<Token> ALL_TOKENS = new ArrayList<>();

  public static final Token BLUE_BANK = new Token(BLUE, "blue_token.jpg");

  public static final Token BLACK_BANK = new Token(BLACK, "black_token.jpg");

  public static final Token RED_BANK = new Token(RED, "red_token.jpg");

  public static final Token WHITE_BANK = new Token(WHITE, "white_token.jpg");

  public static final Token GREEN_BANK = new Token(GREEN, "green_token.jpg");

  public static final Token GOLD_BANK = new Token(GOLD, "gold_token.jpg");
}
