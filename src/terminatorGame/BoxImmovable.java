
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;


public class BoxImmovable extends StaticBody{

    private static final Shape shape = new BoxShape(1.2f,1.2f);
    private static final BodyImage boxImage = new BodyImage("data/box.gif", 2.5f);
    
    public BoxImmovable(World w) {
        super(w);
        SolidFixture f = new SolidFixture(this, shape);
        this.setImage(boxImage);
    }
}
