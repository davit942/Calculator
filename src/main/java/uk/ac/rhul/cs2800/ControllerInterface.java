package uk.ac.rhul.cs2800;

/**
 * This interface is created so a view can add itself to the controller.
 * 
 * @author zkac151
 *
 */
public interface ControllerInterface {

  /**
   * A View will all this method to add itself to the controller.
   * 
   * @param view a new view that will be added to the controller
   */
  public void addView(ViewInterface view);
}
