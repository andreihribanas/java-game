
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
public class BulletHitRobot implements CollisionListener {
    private Bullet bullet;
    private Body body;
    private TerminatorWorld world;
    private TerminatorHero hero;
    private Robot robot;
    
    public BulletHitRobot(Bullet bullet, TerminatorHero hero, Robot robot) {
        this.bullet = bullet;
        this.hero = hero;
        this.robot = robot;
    }

    @Override
    public void collide(CollisionEvent e) {
 
        if (e.getOtherBody() instanceof Bullet) {
            e.getOtherBody().destroy();
            
            if (e.getReceivingBody().getName().startsWith("Robot")) {
                robot.decreaseHealth();
           
                if (robot.getHealth() == 0){
                    hero.increaseXP();
                    hero.increaseRobotsDestroyed();
                    e.getReceivingBody().destroy();
                    System.out.println("Robot " + robot.getName() + " , has been destroyed. Go for the next one.");
                    
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
                 
            
                
            System.out.println("Damaged caused: +25. Robot remaining health: " + robot.getHealth());
            System.out.println("Bullet hit the: " + e.getReceivingBody().getName());
        } else {
                System.out.println("bullet hit other object");
            }
            
            
        }
    }
    
}
