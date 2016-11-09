
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;


public class Bullet extends DynamicBody{
    
    public static final Shape shape = new PolygonShape(
    -0.1009f,0.105f, 0.1286f,0.1059f, 0.1723f,0.0064f, 0.125f,-0.1191f, -0.0986f,-0.1164f, -0.1736f,0.0059f);
    
    public static final BodyImage bulletRight = new BodyImage("data/bullet-right.png", 0.25f);
    public static final BodyImage bulletLeft = new BodyImage("data/bullet-left.png", 0.25f);
    
    public Bullet(World w){
        super(w);
        Fixture f = new SolidFixture(this, shape);
        setName("Bullet");
        this.setImage(bulletLeft);
    }

    public void setBulletLeftDirection() {
        this.setLinearVelocity(new Vec2(-50, 0));
    }
    
    public void setBulletRightDirection() {
        this.setLinearVelocity(new Vec2(50, 0));
    }
}
