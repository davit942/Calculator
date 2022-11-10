package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/** NumStack class created as a facade class of Stack.
 * @author zkac151
 *
 */
public class NumStack { // extends Stack {

  private final Stack numStack;

  /**The constructor initialises the NumStack as a stack Object.
   * 
   */
  public NumStack() {
    this.numStack = new Stack();
  }

  /**Simple method to check if the numStack is empty.
   * @return a boolean value if the numStack is empty or not
   */
  public Boolean isEmpty() {
    return numStack.size() == 0;
  }

  /** push will push a float value to the top of the stack.
   * @param value the float that will be pushed onto the stack.
   */
  public void push(float value) {

    this.numStack.push(new Entry(value));

  }

  /** Pop will take the most recent item off the top of the stack.
   * @return the popped value or null if wrong type
   * @throws BadTypeException thrown when getValue is called on a type that isn't a number
   * @throws EmptyStackException thrown when trying to pop an empty stack
   */
  public Float pop() throws BadTypeException, EmptyStackException {
    try {
      return this.numStack.pop().getValue();
    } catch (BadTypeException e) {
      return null;
    }

  }


}
