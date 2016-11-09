

package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;


public class Box extends DynamicBody{

    private static final Shape shape = new BoxShape(1.2f,1.2f);
    private static final BodyImage boxImage = new BodyImage("data/crate.jpg", 2.5f);
    
    public Box(World w) {
        super(w);
        SolidFixture f = new SolidFixture(this, shape);
        this.setImage(boxImage);
    }
}
