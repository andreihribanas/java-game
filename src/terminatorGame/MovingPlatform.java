
package terminatorGame;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;


public class MovingPlatform extends DynamicBody {
    private static final Shape shape = new BoxShape (3.0f, 0.5f);
    private float platformSpeed = -5.0f;
    
    public MovingPlatform(World w){
        super(w);
        
        SolidFixture platform = new SolidFixture(this, shape);
        
        this.setLinearVelocity(new Vec2(platformSpeed, 0));
        this.setGravityScale(0);
        this.setFixedRotation(true);
        
    }
}
