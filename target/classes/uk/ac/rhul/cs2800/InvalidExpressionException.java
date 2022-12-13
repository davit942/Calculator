package uk.ac.rhul.cs2800;

/**Exception created to handle if the expression is valid or not.
 * @author zkac151
 *
 */
public class InvalidExpressionException extends Exception {


  private static final long serialVersionUID = -9001860817336438137L;

  /**Constructs a new exception with an error message.
   * @param message the error message
   */
  public InvalidExpressionException(final String message) {
    super(message);
  }
}
