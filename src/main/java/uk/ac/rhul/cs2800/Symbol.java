package uk.ac.rhul.cs2800;


/**
 * A simple enum to store special characters that will never change.
 * @author zkac151
 *
 */
public enum Symbol {
  LEFT_BRACKET("("),
  RIGHT_BRACKET(")"),
  TIMES("*"),
  DIVIDE("/"),
  PLUS("+"),
  MINUS("-"),
  INVALID("!");

  private String special;

  Symbol(final String special) {
    this.special = special;
  }
  
  @Override
  public String toString() { // prints the symbols in a readable way
    return special;
    
  }
  
}
