package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishTest {
  Calculator calc;

  @BeforeEach
  public void setUp() {
    this.calc = new RevPolishCalc();
  }

  // Test 1
  @Test
  void emptyStackTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate(""), "Stack is empty it should throw exception.");
  }

  // Test 2
  @Test
  void singleInput() throws BadTypeException {
    float num = 1;
    try {
      assertEquals(num, this.calc.evaluate("1"),"checking to see if it can evaluate single number input");
    } catch (InvalidExpressionException e) {
      fail("not a valid expression");
    }
  }

  // Test 3
  @Test
  void infixFailTest() {
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("8 - 3"),"wrong sytanx should throw exception.");
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("8 + 3"),"wrong sytanx should throw exception.");
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("8 * 3"),"wrong sytanx should throw exception.");
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("8 / 3"),"wrong sytanx should throw exception.");

  }

  // Test 4
  @Test
  void revPolishExp() throws InvalidExpressionException, BadTypeException {
    assertEquals(this.calc.evaluate("5 8 +"), 13,"postfix notation should work now.");
    assertEquals(this.calc.evaluate("3 5 9 + *"), 42,"A more complicated expression.");
    assertEquals(this.calc.evaluate("2 4 3 - * 2 /"), 1,"Very complex expression.");
  }
  //Test 5
  @Test
  void divideByZero() {
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("8 0 /"), "should throw an Exception as divide by 0 is infinity");
  }
  
}
