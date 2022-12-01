package hexanome.thirteen.client.component;

import static hexanome.thirteen.client.constant.UriConstant.CSS_PATH;

import hexanome.thirteen.client.view.BoardView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * A helper class that has some static method that generates some commonly used visual component.
 */
public class CommonComponents {

  /**
   * Create a button object with a commonly used visual style in the game.
   *
   * @param buttonText the text to be displayed on the button
   * @return a button that was created
   */
  public static Button createPopUpButton(String buttonText) {
    Button button = new Button(buttonText);
    button.getStylesheets()
        .add(BoardView.class.getResource(CSS_PATH + "button-style.css").toExternalForm());
    button.getStyleClass().add("standard-popup-button");
    return button;
  }

  /**
   * Create a label object with a commonly used visual style in the game.
   *
   * @param labelText the text to be displayed on the label
   * @return a label object that was created
   */
  public static Label createPopUpLabel(String labelText) {
    Label label = new Label(labelText);
    label.setAlignment(Pos.CENTER);
    label.setPrefSize(300, 61);
    label.setFont(new Font("Arial", 20));
    return label;
  }
}
