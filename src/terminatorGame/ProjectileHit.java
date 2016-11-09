
package terminatorGame;

import city.cs.engine.*;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Collision listener that inflicts damage to hero.
 */
public class ProjectileHit implements CollisionListener {
    private Projectile projectile;
    private Body body;
    private TerminatorWorld world;
    private TerminatorHero hero;
    private Turret turret;
    private TurretFire tf;
    
    public ProjectileHit(Projectile projectile, TerminatorHero hero, TurretFire tf) {
        this.projectile = projectile;
        this.hero = hero;
        this.tf = tf;
    }

    @Override
    public void collide(CollisionEvent e) {
 
        if (e.getOtherBody() instanceof Projectile) {
            
            if (e.getReceivingBody() == hero) {
                    hero.setHealth(hero.getHealth() - 1 );
                    e.getOtherBody().destroy();
                    
                // Add hero impact sound effect
                        try {
                            InputStream in = new FileInputStream("sounds/hero-impact.wav");
                            AudioStream as = new AudioStream(in);         
                            AudioPlayer.player.start(as); 
                        } catch (Exception f) {
                            System.err.println(f.getMessage());
                        }

                System.out.println("Damaged caused: +1. Hero health remaining: " + hero.getHealth());
                 System.out.println("Turret hit: " + e.getReceivingBody().getName());
                
            } else {
                e.getOtherBody().destroy();
            } 
            
        }
    }
    
}
