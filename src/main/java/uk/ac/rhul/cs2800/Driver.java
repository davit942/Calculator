package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Driver extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
    start(new StageWithScenes());
  }

  public void start(StageWithScenes primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("View.fxml"));
    Scene scene1 = new Scene(pane, 1000, 1000);
    primaryStage.scenes.put("calcScene", scene1);
    
    primaryStage.setScene(scene1);
    primaryStage.show();
  }
}
