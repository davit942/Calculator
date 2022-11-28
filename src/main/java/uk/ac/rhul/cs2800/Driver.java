package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The main class of the calculator.
 * 
 * @author zkac151
 *
 */
public class Driver extends Application {

  /**
   * Launches the calculator.
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * The main entry point for javaFX applications.
   * 
   * @param primaryStage the main stage
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    start(new StageWithScenes());
  }

  /**
   * The second start method. This is made so that we can have multiple scenes.
   * 
   * @param primaryStage the main stage
   * @throws Exception when the FXML loader cannot find the fxml file.
   */
  public void start(StageWithScenes primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
    Scene scene1 = new Scene(pane, 400, 400);
    primaryStage.scenes.put("calcScene", scene1);

    primaryStage.setScene(scene1);
    primaryStage.show();
  }
}
