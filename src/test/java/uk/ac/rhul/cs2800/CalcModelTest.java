package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CalcModelTest {

  private CalcModel calc;
  
  public CalcModelTest() {
    this.calc = new CalcModel();
  }
  
  //Test 1
  @Test
  void standardTest() throws InvalidExpressionException, BadTypeException {
    boolean type = true;
    assertEquals(this.calc.evaluate("5 + 6", type), 11,"should evaluate with standard calc");
  }

  @Test
  void infixException() throws InvalidExpressionException, BadTypeException {
    boolean type = false;
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate("5 + 6", type),"shoudl throw exception as wrong type of expression");
  }
  
  @Test
  void revPolishTest() throws InvalidExpressionException, BadTypeException {
    boolean type = false;
    assertEquals(this.calc.evaluate("5 6 +", type), 11,"should evaluate using reverse polish calc");

  }
}
