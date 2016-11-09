/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package terminatorGame;

import city.cs.engine.*;
import java.io.FileInputStream;
import java.io.InputStream;
import org.jbox2d.common.Vec2;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Collision listener that generates hero - robot physical collisions.
 */
public class HeroRobotHit implements CollisionListener {
    private TerminatorHero hero;

    public HeroRobotHit(TerminatorHero hero) {
        this.hero = hero;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == hero) {
            hero.increaseXP();
            hero.decreaseHealth();
            hero.increaseRobotsDestroyed();
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
    }
    
}
