package uk.ac.rhul.cs2800;

/**A simple interface to allow each calculator to evaluate an expression.
 * @author zkac151
 * 
 */
public interface Calculator {

  /**This method will evaluate the expression.
   * @param what the expression
   * @return the answer
   * @throws InvalidExpressionException when a wrong expression form is inputed
   */
  float evaluate(String what) throws InvalidExpressionException, BadTypeException;

}
