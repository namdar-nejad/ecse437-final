package hexanome.thirteen.client.component;

import javafx.scene.image.Image;

/**
 * Represents the card class on the client side, has a cardID that is sync with server to ensure
 * both side refers to the same card and a url for the image to be displayed.
 */
public class Card {
  private int cardId;
  private Image cardImage;
  private String imageUrl;

  protected Card(int id, String url) {

    this.cardId = id;
    cardImage = new Image(getClass().getResource(url).toExternalForm());
    this.imageUrl = url;
  }

  public String getCardUrl() {
    return this.imageUrl;
  }

  public Image getCardImage() {
    return cardImage;
  }
}
