

package terminatorGame;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;


public class Turret extends DynamicBody{
    
    public static final Shape shape = new BoxShape(1.0f, 1.5f);
    
    public static final BodyImage turretLeft = new BodyImage("data/turret-left.png",3.0f);
    public static final BodyImage turretRight = new BodyImage("data/turret-right.png",3.0f);
    
    private String direction;
    private boolean destroyed;
    
    public Turret(World w, String turretDirection){
        super(w);
        SolidFixture f = new SolidFixture(this, shape);
        f.setDensity(10);
        
        this.direction  = turretDirection;
        
        // Set turret image according to direction
            if (turretDirection.equalsIgnoreCase("left")) {
                this.setImage(turretLeft);
            } else if (turretDirection.equalsIgnoreCase("right")){
                this.setImage(turretRight);
            }
            
        this.destroyed = false;
    }
    
    public void setTurretDirectionLeft() {
        this.direction = "left";
        this.setImage(turretLeft);
    }
    
    public void setTurretDirectionRight() {
        this.direction = "right";
        this.setImage(turretRight);
    }
    
    public String getDirection() {
        return direction;
    }
    
    public void isDestroyed() {
        this.destroyed = true;
    }
    
    public void isNotDestroyed() {
        this.destroyed = false;
    }
    
    public boolean destroyedStatus() {
        return this.destroyed;
    }
}
