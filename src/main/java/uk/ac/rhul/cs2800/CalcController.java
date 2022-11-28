package uk.ac.rhul.cs2800;

/**
 * This class deals with adding the observers and setting the answer.
 * 
 * @author zkac151
 *
 */
public class CalcController implements ControllerInterface {
  ViewInterface myView = null;

  /**
   * This method will set the answer when it is calculated.
   */
  private void calculate() {
    String userInput = myView.getExpression();
    myView.setAnswer(userInput);
  }

  /**
   * This method will display to the user that the type of expression has changed.
   * 
   * @param t the operation type selected.
   */
  private void expressionType(OpType t) {
    myView.setAnswer("Changed to " + t);
  }

  /**
   * The constructor that will add a new view to the controller.
   * 
   * @param v The interface to be added.
   */
  public CalcController(ViewInterface v) {
    addView(v);
  }


  /**
   * This method adds the observers to the ViewInterface.
   * 
   * @param v The interface that adds the observers to it
   */
  @Override
  public void addView(ViewInterface v) {
    myView = v;
    v.addCalcObserver(this::calculate);
    v.addTypeObserver(this::expressionType);
  }

}
