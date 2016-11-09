
package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Create robots movement.
 */
public class ListenerRobotMoving implements StepListener {
    /** The view */
    private WorldView view;
 
    private TerminatorWorld world;
 
    /** The body */
    private Robot robot;

    private int moveSpeed = 5;
    
    public ListenerRobotMoving(WorldView view, Robot robot) {
        this.view = view;
        this.robot = robot;
    }

    /**
     */
    public void preStep(StepEvent e) {
       
    }
       
    /**
     */
    public void postStep(StepEvent e) {

        
        robot.setLinearVelocity(new Vec2(moveSpeed, 0));
       
        if (moveSpeed > 0)
            if (robot.getPosition().x == -11) {
                moveSpeed *= (-1);
                System.out.println("go left");
            }
        
        if (moveSpeed < 0) {
            if (robot.getPosition() .x < -23) {
                 moveSpeed *= (-1);
            }
        }
    }
    
}
