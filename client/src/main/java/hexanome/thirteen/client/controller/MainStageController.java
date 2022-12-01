package hexanome.thirteen.client.controller;

import hexanome.thirteen.client.constant.UriConstant;
import hexanome.thirteen.client.view.MainStage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
 * The controller class responsible for changing javafx scenes.
 */
public class MainStageController {


  /**
   * Change to a scene that is built with a fxml file.
   *
   * @param fxml the fxml file to be loaded.
   * @throws IOException throws IOException
   */
  public void fxmlSceneChange(String fxml) throws IOException {

    Parent newRoot = FXMLLoader.load(getClass().getResource(UriConstant.FXML_PATH + fxml));
    MainStage.stage.getScene().setRoot(newRoot);
    if (fxml.equals("board.fxml")) {
      //aStage.setFullScreen(true);
      MainStage.stage.setWidth(1800);
      MainStage.stage.setHeight(805);
    }

  }

  /**
   * Change to a scene that is built with java code with Vbox as the Parent node.
   *
   * @param vbox the parent node to be loaded
   */
  public void normalSceneChange(VBox vbox) {
    Parent newRoot = vbox;
    MainStage.stage.getScene().setRoot(newRoot);
  }


}
