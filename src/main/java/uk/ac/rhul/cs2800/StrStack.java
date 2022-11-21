package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * StrStack class which will handle how strings enter the stack.
 * 
 * @author zkac151
 *
 */
public class StrStack {

  private Stack strStack;

  /**
   * Initialise a new Stack object.
   */
  public StrStack() {
    this.strStack = new Stack();
  }

  /**
   * Checks if the stack is empty.
   * 
   * @return boolean if at least one item in list
   */
  public boolean isEmpty() {
    return strStack.size() == 0;
  }

  /**
   * The push method to push an item into the stack.
   * 
   * @param i string that will be pushed into the stack
   */
  public void push(String i) {
    strStack.push(new Entry(i));
  }

  /**
   * The pop method will take items out of the list.
   * 
   * @return the string
   * @throws BadTypeException when called on not a string
   * @throws EmptyStackException when popping an empty stack.
   */
  public String pop() throws BadTypeException, EmptyStackException {
    try {
      return strStack.pop().getString();
    } catch (BadTypeException e) {
      return strStack.pop().getString();
    }

  }

}
