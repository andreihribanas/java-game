

package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Create platforms movement.
 */
public class ListenerPlatformMoving implements StepListener {
    /** The view */
    private WorldView view;
    private Terminator game;
    private TerminatorWorld world;
 
    /** The body */
    private DynamicBody body;
    private float platformSpeed = 5.0f;

    public ListenerPlatformMoving(Terminator game, WorldView view, DynamicBody body) {
        this.view = view;
        this.body = body;
        this.game = game;
    }

    public void preStep(StepEvent e) {
       
    }
 
    public void postStep(StepEvent e) {
        
        if (game.currentLevel == 1) {
            body.setLinearVelocity(new Vec2(platformSpeed, 0));
            body.setGravityScale(0);

            if (platformSpeed < 0) {
                if (body.getPosition().x < -44) {
                    platformSpeed *= (-1);
                }
            }

            if (platformSpeed > 0) {
                if (body.getPosition().x > -20) {
                    platformSpeed *= (-1);
                }
            }
            
        } else if (game.currentLevel == 2) {
            body.setLinearVelocity(new Vec2(platformSpeed, 0));
            body.setGravityScale(0);

            if (platformSpeed > 0) {
                if (body.getPosition().x > 47) {
                    platformSpeed *= (-1);
                }
            }

            if (platformSpeed < 0) {
                if (body.getPosition().x < 14) {
                    platformSpeed *= (-1);
                }
            }
        }
    }
       

}