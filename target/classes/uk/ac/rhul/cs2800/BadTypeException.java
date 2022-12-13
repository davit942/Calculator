package uk.ac.rhul.cs2800;

/**
 * BadTypeException class, used when types do not match for getters.
 * @author zkac151
 *
 */
public class BadTypeException extends Exception {

  
  private static final long serialVersionUID = 902259016746188985L;

  /**
   * Constructs a new exception with the error message.
   * @param errorMessage takes an error message to display
   */
  public BadTypeException(final String errorMessage) {
    super(errorMessage);
  }
}
