package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Tests have been refactored, originally all tests were designed to just work with integers.
 * However after creating the Entry class, the tests were changed to work with Entry.
 */
class TestStack {
  private Stack stack;

  @BeforeEach
  public void setup() {
    stack = new Stack(); // create a new stack before each test is ran.
  }

  // Test 1
  @Test
  void testSize() {
    assertEquals(stack.size(), 0, "Test a newly created stack to see that it has size zero.");
  }

  // Test 2
  @Test
  void testPush() {
    stack.push(new Entry(5f));
    assertEquals(stack.size(), 1, "Test that push increases the size of an empty stack.");
  }

  // Test 9
  @Test
  void sizeThenPush() {
    assertEquals(stack.size(), 0, "initial size should be 0");
    stack.push(new Entry(Symbol.DIVIDE));
    assertEquals(stack.size(), 1, "Symbol was pushed, size should be 1");
    /*
     * Test to see if size changes after something is pushed originally test was only designed to
     * check for size 0 but now for size to increase.
     */
  }



  // Test 3
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> stack.pop(), "You cannot pop from an empty stack");
    /*
     * This test was designed to see if an EmptyStackException was thrown if you pop an empty list
     * this test was necessary to discover the exception.
     */
  }

  // Test 4
  @Test
  void pushThenPop() {
    Entry value = new Entry(5f);
    stack.push(value);
    assertEquals(stack.pop(), value, "Pushing a five then popping it should return 5");
    assertEquals(stack.size(), 0, "Stack should be empty after pop.");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Popping the empty stack should throw an exception.");
  }


  // Test 5
  @Test
  void pushTwice() {
    Entry value = new Entry(5f);
    Entry value2 = new Entry(17f);
    stack.push(value);
    stack.push(value2);
    assertEquals(stack.size(), 2, " Pushing twice makes stack size 2");
    assertEquals(stack.pop(), value2,
        "Second thing pushed should be returned");
    assertEquals(stack.pop(), value,
        "Pushing twice then popping should return  the first thing pushed");
    assertEquals(stack.size(), 0, "Pushing twice then popping twice should give an empty stack");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "popping an empty stack should throw an exception");
  }

  // Test 6
  @Test
  void pushLots() {
    for (int index = 0; index < 1000; index++) {
      stack.push(new Entry(index + 5));
      assertEquals(stack.size(), index + 1, "size should increase by 1 with every step in the loop");
    }
    /*
     * This test was designed to see the limit of how many items could be on the stack. Originally
     * the test was made with an integer list of fixed size so the test would fail. to get it to
     * pass I had to use an array list as they can be resized.
     */
  }

  // Test 7
  @Test
  void testTop() {
    Entry value1 = new Entry(5f);
    Entry value2= new Entry(35f);
    stack.push(value2);
    stack.push(value1);
    assertEquals(stack.top(), value1,"top should return value1 as it is the top of the stack.");
  }

  // Test 8
  @Test
  void emptyTop() {
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "Doing top on an empty stack should throw an exception");
  }
  /*
   * initially would throw IndexOutOfBoundsException because we cannot return a negative, However I
   * added to check for an empty stack first so that EmptyStackException is thrown instead
   */

}
