
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.GhostlyFixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;



public class Elevator extends DynamicBody{
    
    private static final Shape elevatorBody = new PolygonShape(
    -0.9f,1.46f, 0.91f,1.45f, 0.91f,-1.23f, -0.88f,-1.25f);
    
    private static final Shape elevatorBase = new PolygonShape(
    -0.89f,-1.26f, 0.93f,-1.24f, 0.92f,-1.31f, -0.88f,-1.32f);

    private static final BodyImage elevatorImage = new BodyImage("data/elevator.png", 3.5f);
    
    public Elevator(World w){
        super(w);
        GhostlyFixture f1 = new GhostlyFixture(this, elevatorBody);
        f1.setDensity(1000);
        
        SolidFixture f2 = new SolidFixture(this, elevatorBase);
        f2.setDensity(100);
        f2.setRestitution(1);
        f2.setFriction(1);
        
        this.setImage(elevatorImage);
    }
}
