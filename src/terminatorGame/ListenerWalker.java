package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Class to make a body walk at a given speed.
 */
public class ListenerWalker implements StepListener {
    private DynamicBody body;
    private float speed;
    
    /**
     * Create a walker for the given body.
     * @param body the body to be made to walk
     * @param speed the speed at which it is to walk
     */
    ListenerWalker(DynamicBody body, float speed) {
        this.body = body;
        this.speed = speed;
    }
    
    public void setBody(DynamicBody body) {
        this.body = body;
    }
    /**
     * This method is called before each physics step, and sets the horizontal
     * component of the body's velocity to the required speed.
     * @param e description of the step
     */
    @Override
    public void preStep(StepEvent e) {
        Vec2 v = body.getLinearVelocity();
        body.setLinearVelocity(new Vec2(speed, v.y));
    }

    /**
     * This method is called after each physics step.
     * There is nothing to do here.
     * @param e description of the step
     */
    @Override
    public void postStep(StepEvent e) {
    }
}