
package terminatorGame;

import city.cs.engine.*;
import java.io.FileInputStream;
import java.io.InputStream;
import org.jbox2d.common.Vec2;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Collision listener that creates collisions between turret projectiles and robots
 */
public class BulletHitTurret implements CollisionListener {
    private Bullet bullet;
    private TerminatorWorld world;
    private TerminatorHero hero;
    private Turret turret;
    
    public BulletHitTurret(Bullet bullet, TerminatorHero hero, Turret turret) {
        this.bullet = bullet;
        this.hero = hero;
        this.turret = turret;
    }

    @Override
    public void collide(CollisionEvent e) {
 
        if (e.getOtherBody() instanceof Bullet) {
            e.getOtherBody().destroy();

           //     if (turret.getHealth() == 0){
                    hero.increaseXP();
                    e.getReceivingBody().destroy();
                    turret.isDestroyed();
                    hero.increaseTurretsDestroyed();
                    System.out.println("Turret " + turret.getName() + " , has been destroyed. Go for the next one.");
                    
                    // Add bullet fire sound effect
                        try {
                           InputStream in = new FileInputStream("sounds/robot-explosion.wav");
                           AudioStream as = new AudioStream(in);         
                           AudioPlayer.player.start(as); 
                       } catch (Exception f) {
                           System.err.println(f.getMessage());
                       }
                    
                    // Add robot hit sound effect
                        try {
                            InputStream in = new FileInputStream("sounds/metal.wav");
                            AudioStream as = new AudioStream(in);         
                            AudioPlayer.player.start(as); 
                       } catch (Exception f) {
                           System.err.println(f.getMessage());
                       }

            System.out.println("Bullet hit the: " + e.getReceivingBody().getName());
        }
    }
    
}
