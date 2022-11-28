package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * This interface controls how we link to the calculator.
 * 
 * @author zkac151
 *
 */
public interface ViewInterface {

  /**
   * Add an observer for the calculate button.
   * 
   * @param f the observer
   */
  void addCalcObserver(Observer f);

  /**
   * Add an observer that checks if the expression type has changed.
   * 
   * @param l the observer
   */
  void addTypeObserver(Consumer<OpType> l);

  /**
   * Gets the expression that the calculator will have to solve.
   * 
   * @return the expression
   */
  String getExpression();

  /**
   * Sets the answer for the user.
   * 
   * @param ans the answer.
   */
  void setAnswer(String ans);


}
