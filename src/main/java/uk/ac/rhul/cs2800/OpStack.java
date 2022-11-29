package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**Class that will handle how operations are pushed onto the stack.
 * @author zkac151
 *
 */
public class OpStack {

  private Stack opStack;

  /**Creates a new stack.
   * 
   */
  public OpStack() {
    this.opStack = new Stack();
  }

  /** Checks if the opStack is empty.
   * @return boolean value for if it is empty.
   */
  public Boolean isEmpty() {
    return opStack.size() == 0;
  }

  /**Push a symbol onto the stack.
   * @param i the symbol to be pushed
   */
  public void push(Symbol i) {
    opStack.push(new Entry(i));
  }

  /** Pop a symbol out of the stack.
   * @return the symbol at the top of the stack.
   * @throws EmptyStackException when called on an empty stack
   * @throws BadTypeException when called on not a symbol
   */
  public Symbol pop() throws EmptyStackException, BadTypeException {
    try {
      return opStack.pop().getSymbol();
    } catch (BadTypeException e) {
      //This exception can never be thrown since we only pass through symbols.
      return opStack.pop().getSymbol();
    }
  }


}
