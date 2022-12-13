package uk.ac.rhul.cs2800;

/**
 * This class will create the required calculator depending on which type the user wants.
 * 
 * @author zkac151
 *
 */
public class CalcModel {

  private Calculator revPolish;
  private Calculator standard;

  /**
   * Initialise both types of calculator ready to evaluate expressions.
   */
  public CalcModel() {
    this.revPolish = new RevPolishCalc();
    this.standard = new StandardCalc();
  }

  /**
   * This method will choose the evaluation method.
   * 
   * @param question what will be calculated
   * @param type decides if the user has selected infix or postfix
   * @return the answer
   * @throws InvalidExpressionException when the expression is invalid
   * @throws BadTypeException when a wrong symbol is input
   */
  public float evaluate(String question, boolean type)
      throws InvalidExpressionException, BadTypeException {

    if (type == true) {
      return standard.evaluate(question);
    } else {
      return revPolish.evaluate(question);

    }
  }
}
