package uk.ac.rhul.cs2800;


import java.io.IOException;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


/**
 * The CalcView class that is filled by the fxml loader. This class was inspired by Dave Cohen's
 * MVC-separated code and MVCJavaFX.
 * 
 * @author zkac151
 *
 */
public class CalcView extends Application implements ViewInterface {


  @FXML
  private ToggleGroup calc;

  @FXML
  private Button calcButton = null;

  @FXML
  private TextField answerField;

  @FXML
  private Label answerLabel;

  @FXML
  private TextField expressionField;

  @FXML
  private Label expressionLabel;

  @FXML
  private RadioButton infixButton = null;

  @FXML
  private RadioButton postfixButton = null;

  @FXML
  void calcPressed(ActionEvent event) {}

  private static volatile CalcView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /** Creates an instance of CalcView, goes through a while loop until the instance is not null.
   * @return the instance.
   */
  public static synchronized CalcView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalcView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }



  /**
   * A simple getter to make the expression visible to other classes.
   * 
   * @return the expression
   */
  public String getExpression() {
    return expressionField.getText();
  }

  /**
   * A simple setter to set the answer when it has been calculated.
   * 
   * @param str The answer
   */
  public void setAnswer(String str) {
    answerField.setText(str);
  }


  /**
   * This allows a new observer to be added to see if the calculate button was pressed.
   * 
   * @param f The observer that is notified
   */
  public void addCalcObserver(Observer f) {
    calcButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        f.notifyObservers();
      }
    });
  }

  /**
   * This allows a new observer to check which toggle button is selected.
   * 
   * @param l The observer that is to be notified5
   */
  public void addTypeObserver(Consumer<OpType> l) {
    calc.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        l.accept(to == infixButton ? OpType.INFIX : OpType.POSTFIX);
      }
    });
  }



  @Override
  public void start(Stage primaryStage) {
    FXMLLoader loader;

    loader = new FXMLLoader(getClass().getClassLoader().getResource("View.fxml"));

    Scene scene = null;
    try {
      scene = new Scene(loader.load(), 400, 400);
    } catch (IOException e) {
      //do nothing
    }
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Sets all the buttons to be activated.
   *
   */
  public void menu() {
    calcButton.setDisable(false);
    infixButton.setDisable(false);
    postfixButton.setDisable(false);

  }
}

