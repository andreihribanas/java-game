package terminatorGame;

import city.cs.engine.*;

public class TerminatorHero extends DynamicBody {
    
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
    
    private static final BodyImage terminatorImageLeft = new BodyImage("data/terminator-left.png", 3.25f);
    private static final BodyImage terminatorImageRight = new BodyImage("data/terminator-right.png", 3.25f);
    
    public TerminatorHero(World w) {
        super(w);       
        SolidFixture f = new SolidFixture(this, terminatorShape);
        f.setFriction(100);
        f.setDensity(0);
        f.setRestitution(0);
        this.setImage(terminatorImageLeft);
        this.setFixedRotation(true);
        this.score = 0;
        this.health = 100;
        this.xP = 0;
        this.ammoCount = 100;
        this.direction = "left";
        this.heroLevel = 1;
        this.robotsDestroyed = 0;
        this.turretsDestroyed = 0;
        this.helicopterDestroyed = 0;
    }
 
 public void setGunAngle(){
 }   
  
   public void setDirectionLeft(){
      this.direction = "left";
  }
   
  public void setDirectionRight(){
      this.direction = "right";
  }
  
  public String getDirection() {
      return this.direction;
  }
  
    public void addScore(){
        this.score += 10;
        System.out.println("Hero's score is: " + score);
    }
    
    public void decreaseScore() {
        score -= 10;
    }
    
    public void increaseAmmo() {
        this.ammoCount += 25;
    }
    
    public void decreaseAmmo() {
        this.ammoCount -= 1;
    }
    
    public int getAmmoCount() {
        return this.ammoCount;
    }
    
    public void setAmmo(int ammo) {
        this.ammoCount = ammo;
    }
    
    public void increaseHealth(){
        if (health == 0) {
            health = 100;
        } else if (health > 0 && health <= 90){
            health += 10;
        } else if (health >= 100){
             health = 100;
             System.out.println("Hero's life is already full. You just wasted a health potion.");
        }
    }
    
    public void decreaseHealth(){
        if (health > 0) {
            health -= 10;
        }
        
    }
   
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void increaseXP(){
        this.xP += 50;
    }
    
    public void decreaseXP() {
        this.xP -= 50;
    }
    
    public void resetXP() {
        this.xP = 0;
    }
    
    public void increaseHeroLevel() {
        this.heroLevel += 1;
    }
    
    public void setHeroLevel(int level) {
        this.heroLevel = level;
    }
    
    public int getHeroLevel() {
        return this.heroLevel;
    }
    
    public void setXP(int xp) {
        this.xP = xp;
    }
    
    public int getXP() {
        return xP;
    }
    
    public void increaseRobotsDestroyed() {
        this.robotsDestroyed += 1;
    }
    
    public int getRobotsDestroyed() {
        return this.robotsDestroyed;
    }
    
    public void resetRobotsDestroyed() {
        this.robotsDestroyed = 0;
    }
    
    public void increaseTurretsDestroyed() {
        this.turretsDestroyed += 1;
    }
    
    public int getTurretsDestroyed() {
        return this.turretsDestroyed;
    }
    
    public void resetTurretsDestroyed() {
        this.turretsDestroyed = 0;
    }
    
    public void increaseHelicopterDestroyed() {
        this.helicopterDestroyed += 1;
    }
    
    public int getHelicopterDestroyed() {
        return this.helicopterDestroyed;
    }
}
