
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;


public class Code extends StaticBody{
    
    private static final Shape shape = new BoxShape(0.5f, 0.5f);
    
    private static final BodyImage codeImage = new BodyImage("data/info.png", 1.0f);
    
    public Code(World w){
        super(w);
        SolidFixture ladder = new SolidFixture(this, shape);
        this.setImage(codeImage);
    }
}
