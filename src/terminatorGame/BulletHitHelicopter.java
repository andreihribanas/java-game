
package terminatorGame;

import city.cs.engine.*;
import java.io.FileInputStream;
import java.io.InputStream;
import org.jbox2d.common.Vec2;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Collision listener that create collisions between bullets and robots.
 */
public class BulletHitHelicopter implements CollisionListener {
    private Bullet bullet;
    private Body body;
    private TerminatorWorld world;
    private TerminatorHero hero;
    private Helicopter heli;
    
    public BulletHitHelicopter(Bullet bullet, TerminatorHero hero, Helicopter heli) {
        this.bullet = bullet;
        this.hero = hero;
        this.heli = heli;
    }

    @Override
    public void collide(CollisionEvent e) {
 
        if (e.getOtherBody() instanceof Bullet) {
            e.getOtherBody().destroy();

                heli.decreaseHealth();
           
                if (heli.getHealth() == 0){
                    hero.increaseXP();
                    hero.increaseHelicopterDestroyed();
                    e.getReceivingBody().destroy();

                    
                    // Add bullet shot sound effect
                        try {
                           InputStream in = new FileInputStream("sounds/robot-explosion.wav");
                           AudioStream as = new AudioStream(in);         
                           AudioPlayer.player.start(as); 
                       } catch (Exception f) {
                           System.err.println(f.getMessage());
                       }
                }
  
                 try {
                InputStream in = new FileInputStream("sounds/metal.wav");
                AudioStream as = new AudioStream(in);         
                AudioPlayer.player.start(as); 
                } catch (Exception f) {
                    System.err.println(f.getMessage());
                }
                 
            
                
            System.out.println("Damaged caused: +25. Helicopter's remaining health: " + heli.getHealth());

        }
    }
    
}
