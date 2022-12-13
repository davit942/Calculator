package uk.ac.rhul.cs2800;

/**
 * A simple enum to store the types of entries in the stack.
 * @author zkac151
 *
 */
public enum Type {
NUMBER("Number"),
SYMBOL("Symbol"),
STRING("String"),
INVALID("Invalid");

  private String name;

  private Type(final String name) {
    this.name = name;
  }
  
  @Override
  public String toString() { // prints the enum in a readable way.
    return name;  
  }
}
