package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * This class will handle Infix evaluations of the calculator. This class was created with some
 * inspiration from the calculator.jar file given to us in the coursework section
 * 
 * @author zkac151
 *
 */
public class StandardCalc implements Calculator {
  private RevPolishCalc rpCalc;
  private OpStack opStack;
  private StrStack flipStack;

  /**
   * Initialise the stacks and postfix calculator.
   */
  public StandardCalc() {
    this.rpCalc = new RevPolishCalc();
    this.opStack = null;
    this.flipStack = null;
  }

  @Override
  public final float evaluate(String string) throws InvalidExpressionException, BadTypeException {
    this.flipStack = new StrStack();
    this.opStack = new OpStack();
    Scanner reader = new Scanner(string);
    // Create a scanner to parse the user input
    StringBuffer finEval = new StringBuffer();
    // Using StringBuffer so that we can modify the variable later

    while (reader.hasNext()) {
      this.flipStack.push(reader.next());
      // pushes the input in reverse to this stack
    }
    reader.close();
    while (this.flipStack.isEmpty() == false) {
      String nextToken = null;
      String afterToken = " ";
      try {
        nextToken = this.flipStack.pop();
        if (this.flipStack.isEmpty() != true) {
          afterToken = this.flipStack.top();
        }
        // holds top item of stack
      } catch (EmptyStackException e) {
        throw new InvalidExpressionException("Invalid Expression, stack empty");
      }
      if (Character.isDigit(nextToken.charAt(0)) && !Character.isDigit(afterToken.charAt(0))) {
        finEval.append(Float.parseFloat(nextToken) + " ");
        /*
         * checks if its a number, if it is it will append it to our final evaluation string. if it
         * is not a number, it must be a Symbol so we find out which symbol it is.
         */
      } else {
        Symbol symb = Symbol.INVALID;
        Symbol[] symbols;
        // set symb to invalid in case a match is not found.
        for (int length = (symbols = Symbol.values()).length, i = 0; i < length; ++i) {
          Symbol val = symbols[i];
          if (val.toString().equals(nextToken)) {
            symb = val;
            break;
            // iterates through the symbol list to make sure that a correct
            // symbol was input into the equation.
          }
        }

        if (symb == Symbol.MINUS) {
          symb = Symbol.IMINUS;
          // have to reverse the minus for infix since the numbers are
          // acted on flipped, and it is not commutative.
        } else if (symb == Symbol.DIVIDE) {
          symb = Symbol.IDIVIDE;
          // have to reverse the divide for infix since the numbers are
          // acted on flipped, and it is not commutative.
        }
        this.opStack.push(symb);

      }
    }
    while (this.opStack.isEmpty() == false) {
      Symbol current = Symbol.INVALID;
      try {
        // popping the current operation off the stack, if the stack is empty,
        // the exception is thrown.
        current = this.opStack.pop();
      } catch (EmptyStackException e) {
        throw new InvalidExpressionException("invalid expression");
      }


      finEval.append(String.valueOf(current.toString()) + " ");
      // adding the operation to the string buffer.
    }
    return this.rpCalc.evaluate(finEval.toString());
    // Evaluating the finEval string through postfix and returning it.
  }
}
