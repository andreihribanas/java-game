
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author absc869
 */
public class TeleportationPortal extends StaticBody{
    
    private static final BodyImage bluePortal = new BodyImage("data/blue-portal.png", 7.0f);
    private static final BodyImage orangePortal = new BodyImage("data/orange-portal.png", 7.0f);
    
    private static final Shape shape = new BoxShape(3.0f, 3.0f);
    
    public TeleportationPortal(World w, String color) {
        super(w);
        
        SolidFixture f = new SolidFixture(this, shape);
        
        if (color.equalsIgnoreCase("blue")) {
            this.setImage(bluePortal);
        } else if (color.equalsIgnoreCase("orange")) {
            this.setImage(orangePortal);
        }
        
    }
}
