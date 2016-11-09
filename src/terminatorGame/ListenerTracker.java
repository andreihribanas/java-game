package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class ListenerTracker implements StepListener {
    /** The view */
    private WorldView view;
   
    private TerminatorWorld world;
 
    /** The body */
    private Body body;

    public ListenerTracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
        this.world = new GameLevel_3();
    }

    /**
     */
    public void preStep(StepEvent e) {
       
    }
       
    /**
     */
    public void postStep(StepEvent e) {
        
        view.setCentre(new Vec2(body.getPosition())); // camera follows player
      
        if (body.getPosition().y < -55) {
            body.setPosition(new Vec2(20.0f, 20.0f));
            System.out.println("Hero died. The mankind is doomed!!!");
            
        }
//        System.out.println("Hero position: " + body.getPosition().x);
    }
    
}
