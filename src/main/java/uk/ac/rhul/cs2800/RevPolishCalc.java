package uk.ac.rhul.cs2800;

public class RevPolishCalc implements Calculator {

  private NumStack values;

  public RevPolishCalc() {
    this.values = null;
  }

  @Override
  public float evaluate(String what) throws InvalidExpressionException {
    if (what == null || what.equals("")) {
      throw new InvalidExpressionException("string is empty or null");
    }
    return 0;
  }


}
