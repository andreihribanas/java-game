
package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that create collision between bullets and objects.
 */
public class BulletHitImmovableObjects implements CollisionListener {
    private Bullet bullet;
    private TerminatorWorld world;
    
    public BulletHitImmovableObjects(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void collide(CollisionEvent e) {
        
        if (e.getOtherBody() instanceof Bullet) {
            e.getOtherBody().destroy();
            System.out.println("Bullet hit the: " + e.getReceivingBody().getName());
        }
    }
    
}
