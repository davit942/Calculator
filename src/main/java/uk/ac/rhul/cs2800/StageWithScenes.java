package uk.ac.rhul.cs2800;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is created to allow us to have multiple scenes.
 * 
 * @author zkac151
 *
 */
public class StageWithScenes extends Stage {
  public HashMap<String, Scene> scenes = new HashMap<String, Scene>();

}
