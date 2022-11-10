package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumStackTest { 

  public NumStack stack;
  private float number;

  @BeforeEach
  public void setup() {
    stack = new NumStack(); // create a new stack before each test is ran.
    number = 5f;
  }

  // Test 1
  @Test
  void testEmpty() {
    stack.push(3f);
    assertEquals(this.stack.isEmpty(), false,
        "Test that push increases the size of an empty stack.");
  }

  // Test 2
  @Test
  void testPush() {
    stack.push(number);
    assertEquals(this.stack.isEmpty(), false,
        "Test that push increases the size of an empty stack.");
  }

  // Test 3
  @Test
  void testPop() {
    stack.push(3f);
    try {
      assertEquals(this.stack.pop(), 3f, "Test that push increases the size of an empty stack.");
    } catch (EmptyStackException e) {
      fail("stack is empty, item was never pushed");
      e.printStackTrace();
    } catch (BadTypeException e) {
      fail("type not Number, doesn't have value");
      e.printStackTrace();
    }
    
  }

  // Test 4
  @Test
  void testManyPushAndPop() throws EmptyStackException, BadTypeException {
    for (int index = 0; index < 100; index++) {
      stack.push(index);

    }
    for (int index = 0; index < 100; index++) {
      stack.pop();
    }
    assertTrue(this.stack.isEmpty(),
        "stack should be empty after equal amount of push and pop");

  }

}
