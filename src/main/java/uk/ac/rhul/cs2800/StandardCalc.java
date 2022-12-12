package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * This class will handle Infix evaluations of the calculator. This class was created using the
 * shunting yard algorithm to convert an infix expression to a postfix expression.
 * 
 * @author zkac151
 *
 */
public class StandardCalc implements Calculator {
  private RevPolishCalc rpCalc;
  private OpStack opStack;

  /**
   * Initialise a RevPolishCalc which will be used to handle final evaluation of expression, also
   * initialise our opStack as null.
   * 
   */
  public StandardCalc() {
    this.rpCalc = new RevPolishCalc();
    this.opStack = null;
  }


  @Override
  public float evaluate(String string)
      throws EmptyStackException, BadTypeException, InvalidExpressionException {
    // create an opStack to hold operators
    this.opStack = new OpStack();
    if (string == "") {
      throw new InvalidExpressionException("Empty expression cannot evaluate");
    }
    // split the expression into a string array based on where a space is present
    String[] seperated = string.split(" ");
    String nextToken = null;
    // create a StringBuilder to hold the postfix string
    StringBuilder postfix = new StringBuilder();

    boolean lastFloat = false;
    // loop through each item in the string array
    for (int i = seperated.length - 1; i >= 0; i--) {
      nextToken = seperated[i];
      // if the character is a digit, append it to the postfix string
      if (Character.isDigit(nextToken.charAt(0))) {
        if (lastFloat) {
          // checking to make sure a postfix expression wasnt passed as the param, if so it throws
          // an exception
          throw new InvalidExpressionException("Invalid expression, wrong syntax");
        }
        lastFloat = true;
        //add our float to the postfix string that will be evaluated by rpCalc
        postfix.append(Float.parseFloat(nextToken) + " ");
      } else if (!Character.isDigit(nextToken.charAt(0))) {
        lastFloat = false;
        Symbol symb = Symbol.INVALID;
        Symbol[] symbols;
        // set symb to invalid in case a match is not found.
        for (int length = (symbols = Symbol.values()).length, s = 0; s < length; ++s) {
          Symbol val = symbols[s];
          if (val.toString().equals(nextToken)) {
            symb = val;
            break;
          }
        }
        // if the character is an opening bracket, push it onto the this.opStack
        if (symb == Symbol.LEFT_BRACKET) {
          this.opStack.push(Symbol.LEFT_BRACKET);

          // if the character is a closing parenthesis, pop all operators from the opStack and
          // append them
          // to the postfix string until an opening bracket is found
        } else if (symb == Symbol.RIGHT_BRACKET) {
          while (this.opStack.top() != Symbol.LEFT_BRACKET) {
            postfix.append(this.opStack.pop());
          }
          this.opStack.pop();
        } else if (symb == Symbol.MINUS) {
          symb = Symbol.IMINUS;
          // have to reverse the minus for infix since the numbers are
          // acted on flipped, and subtraction is not commutative.
        } else if (symb == Symbol.DIVIDE) {
          symb = Symbol.IDIVIDE;
          // have to reverse the divide for infix since the numbers are
          // acted on flipped, and division is not commutative.
        }
        this.opStack.push(symb);

        // if the character is an operator, pop all operators from the this.opStack with greater or
        // equal
        // precedence and append them to the postfix string before pushing the operator onto the
        // this.opStack
      } else {
        while (!this.opStack.isEmpty()) {
          postfix.append(this.opStack.pop());
        }
      }

    }


    // after the loop is finished, pop all remaining operators from the this.opStack and append them
    // to the
    // postfix string
    while (!this.opStack.isEmpty()) {

      Symbol current = Symbol.INVALID;
      try {
        // popping the current operation off the stack, if the stack is empty,
        // the exception is thrown.
        current = this.opStack.pop();
      } catch (EmptyStackException e) {
        throw new InvalidExpressionException("invalid string");
      }
      postfix.append(String.valueOf(current.toString()) + " ");
    }

    // return the postfix string as a string
    return this.rpCalc.evaluate(postfix.toString());
  }


}
