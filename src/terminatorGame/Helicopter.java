
package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;


public class Helicopter extends DynamicBody {
    
    private static final Shape bodyShape = new PolygonShape(-1.33f,0.17f, -2.47f,-0.84f, -1.5f,-1.33f, 0.2f,-1.03f, 3.36f,0.34f, 3.29f,0.7f, 0.1f,0.56f);
    private static final Shape rotorShape = new PolygonShape(4.0f,1.6f, 3.89f,0.09f, 3.34f,0.17f, 3.41f,1.56f);
    private static final Shape propellerShape = new PolygonShape(0.16f,0.61f, 1.66f,1.34f, -2.36f,0.73f, -1.44f,0.29f);
   
    private static final BodyImage helicopterImage = new BodyImage("data/helicopter-animation-left.gif", 8.0f);
    private int health;
    
    public Helicopter(World w) {
        super(w);
        SolidFixture f1 = new SolidFixture(this, bodyShape);
        f1.setDensity(0.5f);
        f1.setFriction(1);
        
        SolidFixture f2 = new SolidFixture(this, propellerShape);
        f2.setDensity(1);
        
        SolidFixture f3 = new SolidFixture(this, rotorShape);
        f3.setDensity(0.2f);
        f3.setFriction(0.2f);
        
        this.setImage(helicopterImage);
        this.setFixedRotation(true);
        this.health = 100;
    }
    
    public void setNewImage(BodyImage newImage){
        this.setImage(newImage);
    }
    
    public void decreaseHealth() {
        this.health -= 25;
    }
    
    public int getHealth() {
        return this.health;
    }
   
}
