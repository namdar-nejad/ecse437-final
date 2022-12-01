package hexanome.thirteen.client;

import hexanome.thirteen.client.view.MainStage;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The temporal main class for launching the software.
 */
public class Main extends Application {
  private static Stage aStage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException {
    MainStage.stage = stage;
    MainStage.stage.setResizable(true);
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    Scene scene = new Scene(root, 800, 600);
    MainStage.stage.setTitle("Splendor");
    MainStage.stage.setScene(scene);
    MainStage.stage.show();
  }

  /**
   * Not used, left here just in case, the same code exists in the MainStageController class.
   *
   * @param fxml the fxml file to be loaded
   * @throws IOException throws ioeexception
   */
  public void changeScene(String fxml) throws IOException {
    Parent newRoot = FXMLLoader.load(getClass().getResource(fxml));
    MainStage.stage.getScene().setRoot(newRoot);
    if (fxml.equals("board.fxml")) {
      //aStage.setFullScreen(true);
      MainStage.stage.setWidth(1800);
      MainStage.stage.setHeight(805);
    }
  }

}