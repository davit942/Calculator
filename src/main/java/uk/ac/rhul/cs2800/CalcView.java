package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CalcView {

    @FXML
    private ToggleGroup Calc;

    @FXML
    private Button CalcButton;

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

}
