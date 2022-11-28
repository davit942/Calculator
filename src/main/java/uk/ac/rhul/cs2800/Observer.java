package uk.ac.rhul.cs2800;

/**
 * A functional interface that we can then use to name an observer notification.
 * 
 * @author zkac151
 *
 */
@FunctionalInterface
public interface Observer {
  /**
   * This method will be called when notifying observers.
   */
  public void notifyObservers();

}
