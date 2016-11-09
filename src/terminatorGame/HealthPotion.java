
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

public class HealthPotion extends DynamicBody {
    
    private static final Shape shape1 = new PolygonShape(-0.336f,0.081f, 0.386f,0.078f, 0.375f,-0.603f, -0.344f,-0.606f);
    private static final Shape shape2 = new PolygonShape(-0.117f,0.672f, 0.111f,0.669f, 0.117f,0.083f, -0.147f,0.083f);
    
    private static final BodyImage img = new BodyImage("data/health-potion.png", 1.5f);
    
        public HealthPotion(World world) {
            super(world);
            SolidFixture f1 = new SolidFixture(this, shape1);
            SolidFixture f2 = new SolidFixture(this, shape2);
            this.setImage(img);
        }
}
