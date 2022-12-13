package uk.ac.rhul.cs2800;



/**
 * The main class of the calculator.
 * 
 * @author zkac151
 *
 */
public class Driver {



  /**
   * Launches the calculator.
   * 
   * @param args the command line arguments
   *
   */

  public static void main(String[] args) {

    CalcModel model = new CalcModel();
    ViewInterface view = CalcView.getInstance();
    CalcController controller = new CalcController(model, view);
    view.menu();
    
  }


}
