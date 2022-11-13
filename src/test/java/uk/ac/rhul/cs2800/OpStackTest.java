package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {

  private OpStack stack;

  @BeforeEach
  public void setup() {
    stack = new OpStack(); // create a new stack before each test is ran.
  }

  // Test 1
  @Test
  public void testConstructor() {
    assertTrue(stack instanceof OpStack);
  }

  // Test 2
  @Test
  public void testPush() {
    stack.push(Symbol.DIVIDE);
    assertFalse(stack.isEmpty(),
        "will be false if stack has been pushed to. This also tests isEmpty method.");

  }

  // Test 3
  @Test
  public void testPop() throws EmptyStackException, BadTypeException {
    stack.push(Symbol.LEFT_BRACKET);
    Symbol tester = stack.pop();
    assertEquals(tester, Symbol.LEFT_BRACKET, "tester should hold left bracket if pop worked.");

  }
}
