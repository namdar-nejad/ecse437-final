package hexanome.thirteen.client.component;

import javafx.scene.control.Label;

/**
 * A generic label class with dynamic number changing functionality.
 */
public class NumLabel extends Label {

  private int number;

  /**
   * create a label object with an int as input that represent the initial number to display.
   *
   * @param num integer to be displayed
   */
  public NumLabel(int num) {
    this.number = num;
    this.setText("" + this.number);
    this.setPrefSize(40, 20);
    this.setStyle("-fx-background-color: lightgreen");
  }

  public int getNumber() {
    return this.number;
  }

  public void setNumber(int num) {
    this.number = num;
    this.setText("" + this.number);
  }

  public void increase(int num) {
    this.number += num;
    this.setText("" + this.number);
  }

  public void reset() {
    this.number = 0;
    this.setText("" + this.number);
  }

}
