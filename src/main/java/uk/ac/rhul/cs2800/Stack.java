package uk.ac.rhul.cs2800;


import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This is a stack class that will 'stack' a list of entries.
 * This class was inspired by Dave Cohen in his TDD demo video.
 * 
 * @author zkac151
 * 
 */

public class Stack {

  private int size = 0; // initialises size of stack at 0 as it is empty.
  private ArrayList<Entry> values = new ArrayList<Entry>();
  // using an array list so the size of the list is not capped.


  /**
   * will calculate how many items in the stack.
   * 
   * @return the number of items in the stack.
   */
  public int size() {
    return size;
  }

  /**
   * Add a new entry to the top of the stack.
   * 
   * @param i the value to put in the stack
   */
  public void push(Entry i) {
    values.add(i);
    size = size + 1;
  }

  /**
   * Remove top entry from stack and return it.
   * 
   * @return top entry of stack
   * @throws EmptyStackException if the stack is empty it cannot be popped
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) { // Checks to see if stack is empty, if stack empty, exception is thrown
      throw new EmptyStackException();
    }
    Entry popped = values.get(size - 1); /* array list starts indexing from 0 so to find proper
                                            index must do size-1*/
    values.remove(size - 1); // removing the entry from the stack
    size = size - 1;

    return popped;
  }

  /**
   * Returns top entry from stack without removing it.
   * 
   * @return top of stack
   * @throws EmptyStackException if stack is empty there is no entry that can be returned
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return values.get(size - 1); // return top of stack without removing it from list

  }

}
