package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfixTest {

  private Calculator calc;


  @BeforeEach
  public void setUp() {
    this.calc = new StandardCalc();
  }

  //Test 1
  @Test
  public final void emptyStackTest() throws InvalidExpressionException, BadTypeException {
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate(""),
        "Stack is empty it should throw exception.");
  }

  //Test 2
  @Test
  public final void oneDigit() throws BadTypeException {
    try {
      assertEquals(this.calc.evaluate("0"),0);
    } catch (InvalidExpressionException e) {
      fail("evaluated 0");
    }
  }
  
  //Test 3
  @Test
  public void twoDigits() throws InvalidExpressionException {
      assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("0 0"),
          "Stack has no operation should throw exception.");    
  }

  // Test 4, Haven't implemented order of operations so it is currently just evaluating from left to right.
  @Test
  public void simpleExp() throws InvalidExpressionException, BadTypeException{
    assertEquals(this.calc.evaluate("12 / 6"),2);
    assertEquals(this.calc.evaluate("2 + 5 - 3"),4);
    assertEquals(this.calc.evaluate("6 * 5 + 2 "),32);
    assertEquals(this.calc.evaluate("100 / 5 + 5 * 3"),75);

  }
  
//Test 5 Now passes due to me checking if a float is followed by a float which is invalid syntax for infix
 @Test
 public void postfixFailTest() throws InvalidExpressionException {
   assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("1 1 +"),
       "wrong format for infix, should throw exception.");
 }


}
