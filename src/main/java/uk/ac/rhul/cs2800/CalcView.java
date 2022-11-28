package uk.ac.rhul.cs2800;


import java.util.function.Consumer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;


/**
 * The CalcView class that is filled by the fxml loader. This class was inspired by Dave Cohen's
 * MVC-separated code.
 * 
 * @author zkac151
 *
 */
public class CalcView implements ViewInterface {

  @FXML
  private Pane pane;

  @FXML
  private ToggleGroup calc;

  @FXML
  private Button calcButton;

  @FXML
  private TextField answerField;

  @FXML
  private Label answerLabel;

  @FXML
  private TextField expressionField;

  @FXML
  private Label expressionLabel;

  @FXML
  private RadioButton infixButton;

  @FXML
  private RadioButton postfixButton;

  @FXML
  void pressed(ActionEvent event) {

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
   * @param l The observer that is to be notified
   */
  public void addTypeObserver(Consumer<OpType> l) {
    calc.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        l.accept(to == infixButton ? OpType.INFIX : OpType.POSTFIX);
      }
    });
  }

}

