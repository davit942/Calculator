package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class EntryTest {

  // Test 1
  @Test
  void testFloatConst() {
    Entry entryFloat = new Entry((float) 25.4);
    try {
      assertEquals(entryFloat.getValue(), (float) 25.4,
          "checks if the float constructor is working");
    } catch (BadTypeException e) {
      fail("only a float is put in, shouldn't fail");
      e.printStackTrace();
    }
    /*
     * surrounded in a try and catch block as getValue() can throw a BadTypeException. Originally
     * this test was a lot simpler and only tested entry with float values.
     */
  }

  // Test 2
  @Test
  void testSymbolConst() {
    Entry entrySymbol = new Entry(Symbol.LEFT_BRACKET);
    try {
      assertEquals(entrySymbol.getSymbol(), Symbol.LEFT_BRACKET,
          "checks if symbol constructor is working");
    } catch (BadTypeException e) {
      fail("only a symbol is put in, shouldn't fail");
      e.printStackTrace();
    }
    /*
     * This test followed essentially the same growth as the previous test.
     */
  }

  // Test 7
  @Test
  void testStringConst() {
    Entry entryString= new Entry("(6+7)-5");
    try {
      assertEquals(entryString.getString(),"(6+7)-5","test to see if third constructor works");
    } catch (BadTypeException e) {
      fail("A string is put in, shouldn't fail");
      e.printStackTrace();
    }
    /*
     * Testing the String version of the constructor.
     */
  }

  // Test 3
  @Test
  void testBadValue() {
    Entry bracket = new Entry(Symbol.LEFT_BRACKET);
    assertThrows(BadTypeException.class, () -> bracket.getValue(),
        "Symbol has no method getValue() hence should throw the exception.");
  }

  // Test 4
  @Test
  void testBadSymbol() {
    Entry number = new Entry(45.5f);
    assertThrows(BadTypeException.class, () -> number.getSymbol(),
        "Float has no method getSymbol() hence should throw the exception.");
  }

  // Test 5
  @Test
  void testGetString() {
    Entry number = new Entry("(+-)");
    try {
      assertEquals(number.getString(), "(+-)",
          "String was never initialised with a value so will return null for now");
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    /*
     * originally created to pass with getString() being null, I then created another constructor in
     * Entry to initialise a string entry and further test it.
     */
  }

  // Test 6
  @Test
  void getStringException() {
    Entry number = new Entry(10f);
    assertThrows(BadTypeException.class, () -> number.getString(),
        "float is of wrong type, should throw the exception");
    /*
     * This test was created to discover that getString() will throw an exception if the type of the
     * Entry is not of type STRING.
     */
  }



}
