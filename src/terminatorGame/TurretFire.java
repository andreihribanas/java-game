package terminatorGame;

import city.cs.engine.*;
import java.io.FileInputStream;
import java.io.InputStream;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Create turret fire
 */
public class TurretFire implements StepListener {
    /** The view */
    private WorldView view;
   
    private TerminatorWorld world;
 
    /** The body */
    private TerminatorHero hero;
    private Turret turret;
    private Projectile projectile;
    private final int projectileSpeed = 15;
    private int count;
    private int range;
    private int activateDistance;

    public TurretFire(TerminatorWorld world, WorldView view, TerminatorHero hero, Turret turret) {
        this.world = world;
        this.view = view;
        this.hero = hero;
        this.turret = turret;
        
        count = 0;
        range = 40;
        activateDistance = 3;
    }

    /**
     */
    public void preStep(StepEvent e) {
       
    }
       
    /**
     */
    public void postStep(StepEvent e) {
        float x = turret.getPosition().y - hero.getPosition().y;
        float y = turret.getPosition().x - hero.getPosition().x;
        
         count++;
    
        if (count > 45) {
            
            if (x < activateDistance & x > -activateDistance & Math.abs(y) < range & turret.destroyedStatus() == false) {
                
                
                if (hero.getPosition().x > turret.getPosition().x) {
                    turret.setTurretDirectionRight();
                    shootProjectile();
                } else {
                    turret.setTurretDirectionLeft();
                    shootProjectile();
                }
                
            }

            count = 0;
            
            }
        }
    
    
    public Projectile getProjectile() {
        return this.projectile;
    }
    
    public void shootProjectile() {
        
        System.out.println("Bullet fired. Time: " + count/20);
        
        projectile = new Projectile(view.getWorld());
        projectile.setGravityScale(0);
        
        if (turret.getDirection().equalsIgnoreCase("left")) {
            projectile.setPosition(new Vec2(turret.getPosition().x - 0.5f, turret.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-projectileSpeed, 0));
        }
        
        if (turret.getDirection().equalsIgnoreCase("right")) {
            projectile.setPosition(new Vec2(turret.getPosition().x + 0.5f, turret.getPosition().y));
            projectile.setLinearVelocity(new Vec2(projectileSpeed, 0));
        }
        
        // Add turret sound effect
                    try {
                        InputStream in = new FileInputStream("sounds/turret-fire.wav");
                        AudioStream as = new AudioStream(in);         
                        AudioPlayer.player.start(as); 
                    } catch (Exception f) {
                        System.err.println(f.getMessage());
                    }
    }
    

}
