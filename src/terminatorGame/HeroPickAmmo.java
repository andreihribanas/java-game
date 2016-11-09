/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package terminatorGame;

import city.cs.engine.*;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Collision listener that allows the bird to collect things.
 */
public class HeroPickAmmo implements CollisionListener {
    private TerminatorHero hero;

    public HeroPickAmmo(TerminatorHero hero) {
        this.hero = hero;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == hero) {
            hero.increaseAmmo();
            e.getReceivingBody().destroy();
            System.out.println("Hero picked +25 bullets. Hero's current ammo is: " + hero.getAmmoCount());
            
            // Add sound effect
                try {
                    InputStream in = new FileInputStream("sounds/ammo-pickup.wav");
                    AudioStream as = new AudioStream(in);         
                    AudioPlayer.player.start(as); 
                } catch (Exception f) {
                    System.err.println(f.getMessage());
                }
        }
    }
    
}
