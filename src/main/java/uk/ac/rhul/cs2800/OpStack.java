package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class OpStack {

  private Stack opStack;

  public OpStack() {
    this.opStack = new Stack();
  }

  public Boolean isEmpty() {
    return opStack.size() == 0;
  }

  public void push(Symbol i) {
    opStack.push(new Entry(i));
  }

  public Symbol pop() throws EmptyStackException, BadTypeException {
    try {
      return opStack.pop().getSymbol();
    } catch (BadTypeException e) {
      //This exception can never be thrown since we only pass through symbols.
      return opStack.pop().getSymbol();
    }
  }


}
