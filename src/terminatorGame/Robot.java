
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;


public class Robot extends DynamicBody{
    
    public static final Shape shape = new PolygonShape(
    -1.0f,1.48f, 0.93f,1.48f, 0.91f,-1.45f, -0.91f,-1.45f);
    
    public static final BodyImage robotImage = new BodyImage("data/robot2.png", 3.0f);
    private int health;
    
    public Robot(World w){
        super(w);
        SolidFixture f = new SolidFixture(this, shape);
        this.setImage(robotImage);
        this.setFixedRotation(true);
        health = 100;
    }
    
    public void decreaseHealth() {
        this.health -= 25;
    }
    
    public int getHealth() {
        return this.health;
    }
}
