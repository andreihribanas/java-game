package terminatorGame;

import city.cs.engine.*;

public class TerminatorHeroJetPack extends DynamicBody {
    
    private int score;
    private int health;
    private int xP;
    private int ammoCount;
    private int heroLevel;
    private int robotsDestroyed;
    private int turretsDestroyed;
    private int helicopterDestroyed;
    private String direction;
   
    
    private Shape terminatorShape = new BoxShape(1.0f, 1.5f);
    
    private static final BodyImage terminatorJP = new BodyImage("data/terminator-jetpack.png", 3.25f);

    
    public TerminatorHeroJetPack(World w) {
        super(w);       
        SolidFixture f = new SolidFixture(this, terminatorShape);
        f.setFriction(100);
        f.setDensity(0);
        f.setRestitution(0);
        this.setImage(terminatorJP);
        this.setFixedRotation(true);
      
    }
 
}
