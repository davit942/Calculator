package uk.ac.rhul.cs2800;

/**
 * This class deals with adding the observers and setting the answer. It was inspired by
 * MVC-seperated and MVCJavaFX given to us by Dave Cohen.
 * 
 * @author zkac151
 *
 */
public class CalcController {
  private CalcModel model;
  private ViewInterface myView = null;
  private boolean isInfix;

  /**
   * This method will set the answer when it is calculated.
   * 
   * @throws BadTypeException when a string is not passed in
   * @throws InvalidExpressionException when an invalid expression is input
   */
  private void calculate() {
    String userInput = myView.getExpression();
    float result;
    try {
      result = model.evaluate(userInput, isInfix);
      myView.setAnswer(String.valueOf(result));
    } catch (InvalidExpressionException | BadTypeException e) {
      myView.setAnswer("error");
    }

  }

  /**
   * This method will display to the user that the type of expression has changed.
   * 
   * @param t the operation type selected.
   */
  private void expressionType(OpType t) {
    if (t == OpType.INFIX) {
      isInfix = true;
    } else {
      isInfix = false;
    }
    myView.setAnswer("Changed to " + t);
  }

  /**
   * The constructor that will add a new view to the controller.
   * 
   * @param view The interface to be added.
   */
  public CalcController(CalcModel model, ViewInterface view) {
    this.model = model;
    this.myView = view;
    view.addCalcObserver(this::calculate);
    view.addTypeObserver(this::expressionType);
  }

}
