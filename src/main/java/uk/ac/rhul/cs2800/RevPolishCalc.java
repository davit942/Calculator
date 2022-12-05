package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * This class handles the way to evaluate postfix expressions.
 * 
 * @author zkac151
 *
 */
public class RevPolishCalc implements Calculator {

  private NumStack values;

  /**
   * Initialise the calculator with an empty NumStack.
   * 
   */
  public RevPolishCalc() {
    this.values = null;
  }

  @Override
  public float evaluate(String what) throws InvalidExpressionException {
    if (what == null || what.equals("")) {
      throw new InvalidExpressionException("string is empty or null");
      // First check to see if an expression is input.
    }
    this.values = new NumStack();
    float evaluated;
    Scanner reader = new Scanner(what); // create a new scanner to take be able to parse the input.

    try {
      while (reader.hasNext()) { // a while loop to continue until last character is reached.
        if (reader.hasNextFloat()) {
          this.values.push(reader.nextFloat()); // pushes floats onto numstack values.
        } else {
          String nextToken = reader.next();
          // checks for the operation to be performed on the floats.
          Symbol symb = Symbol.INVALID;
          Symbol[] symbols;
          for (int len = (symbols = Symbol.values()).length, i = 0; i < len; ++i) {
            Symbol current = symbols[i];
            /*
             * checks to see if a valid operation was input if so symb is changed to that symbol.
             */
            if (current.toString().equals(nextToken)) {
              symb = current;
              break;
            }
          }
          switch (symb) {

            case MINUS: {
              float secondNum = this.values.pop(); // second number is always first out
              float firstNum = this.values.pop();
              this.values.push(firstNum - secondNum);
              // pushing the evaluated number back onto stack
              continue;
            }
            case PLUS: {
              float secondNum = this.values.pop();
              float firstNum = this.values.pop();
              this.values.push(firstNum + secondNum);
              continue;
            }
            case DIVIDE: {
              float secondNum = this.values.pop();
              float firstNum = this.values.pop();
              this.values.push(firstNum / secondNum);
              continue;
            }
            case TIMES: {
              float secondNum = this.values.pop();
              float firstNum = this.values.pop();
              this.values.push(firstNum * secondNum);
              continue;
            }
            default: {
              throw new InvalidExpressionException("Invalid.");
              // thrown when expression cannot be solved due to syntax.
            }
          }
        }
      }
      reader.close();
      evaluated = this.values.pop();
      if (this.values.isEmpty() == false) {
        throw new InvalidExpressionException("the expression isn't complete");
        // thrown when more than 1 item is in the stack and no more operators are there.
      }
    } catch (Exception e) {
      throw new InvalidExpressionException("unbalanced" + what);
    }
    return evaluated;
  }
}
