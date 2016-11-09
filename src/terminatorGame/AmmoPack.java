
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;


public class AmmoPack extends DynamicBody{
    private static final Shape shape = new PolygonShape(-0.633f,0.483f, 0.617f,0.483f, 0.614f,-0.47f, -0.635f,-0.47f);

    private static final BodyImage img = new BodyImage("data/ammo-pack.png", 1.0f);
    
    public AmmoPack(World w) {
        super(w);
        
        SolidFixture f = new SolidFixture(this, shape);
        this.setImage(img);
    }
}
