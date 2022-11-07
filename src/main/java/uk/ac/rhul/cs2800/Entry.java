package uk.ac.rhul.cs2800;

/**
 * Entry class that will handle processing inputs.
 * 
 * @author zkac151
 *
 */
public class Entry {

  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Float constructor for Entry that creates an object.
   * 
   * @param value the float that becomes an instance of Entry
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }


  /**
   * A constructor that will create an object from a Symbol.
   * 
   * @param which the symbol that becomes an instance of Entry
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * A constructor that will create an object from a string.
   * 
   * @param string the string that becomes an instance of Entry
   */
  public Entry(String string) {
    this.str = string;
    this.type = Type.STRING;
    /*
     * This constructor was not in the UML I decided to create it in order to further test the
     * getString() method and think it will have further use in the future.
     */
  }


  /**
   * Returns the value of an object if it is a number.
   * 
   * @return the number in the object
   * @throws BadTypeException when called by an object that is not of Type NUMBER
   */
  public Float getValue() throws BadTypeException {
    if (this.type != Type.NUMBER) {
      throw new BadTypeException("asked for a float, you inputted a " + this.type);
    }
    return number;
    /*
     * BadTypeException is thrown when trying to get a value from any type that is not of type
     * Number.
     */
  }


  /**
   * Returns what symbol the object is.
   * 
   * @return the symbol
   * @throws BadTypeException when called by an object that is not of Type SYMBOL
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      throw new BadTypeException("asked for a symbol you inputted a " + this.type);
    }
    return other;
  }


  /**
   * Returns the type of the object.
   * 
   * @return the type
   */
  public Type getType() {
    return type;

  }


  /**
   * Returns the string in the object.
   * 
   * @return the string
   * @throws BadTypeException when called by an object not of Type STRING
   */
  public String getString() throws BadTypeException {
    if (this.type != Type.STRING) {
      throw new BadTypeException("asked for a string you inputted a " + this.type);
    }

    return this.str;
  }

}
