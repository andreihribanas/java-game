

package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;


public class Projectile extends DynamicBody{
    
    public static final Shape shape = new CircleShape(0.25f);
    
    public static final BodyImage projectileImage = new BodyImage("data/bullet-right.png", 0.25f);
    
    public Projectile(World w){
        super(w);
        Fixture f = new SolidFixture(this, shape);
        setName("Enemy projectile");

    }

    public void setBulletLeftDirection() {
        this.setLinearVelocity(new Vec2(-50, 0));
    }
    
    public void setBulletRightDirection() {
        this.setLinearVelocity(new Vec2(50, 0));
    }
}
