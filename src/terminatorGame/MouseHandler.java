package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MouseHandler extends MouseAdapter {

    private MyView view;
    
    private TerminatorWorld world;
    private Bullet bullet;
    private TerminatorHero hero;

    private int bulletCount = 0;
    
    private static final float bulletSpeed = 150.0f;
    
    public MouseHandler(TerminatorWorld world, MyView view, TerminatorHero hero) {
        this.view = view;
        this.world = world;
 
        this.bullet = bullet;
        this.hero = world.getHero2();
    }

    /**
     * Create bullet fire action when clicking the mouse.
     * @param e event object containing the mouse position
     */
    
    public void setHero(TerminatorHero hero) {
        this.hero = hero;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
   
        // Shoot only if the hero has ammo
            if (hero.getAmmoCount() > 0){
                Bullet bullet = new Bullet(view.getWorld());
                
                // Add bullet fired sound effect
                    try {
                        InputStream in = new FileInputStream("sounds/sb.wav");
                        AudioStream as = new AudioStream(in);         
                        AudioPlayer.player.start(as); 
                    } catch (Exception f) {
                        System.err.println(f.getMessage());
                    }

                // Setting bullet direction
                    if (world.getHero2().getDirection().equals("left")){
                        bullet.setPosition(new Vec2(hero.getPosition().x - 0.1f, hero.getPosition().y)); // bullet left
                        bullet.setLinearVelocity(new Vec2(- bulletSpeed, 0));
                    } else if (world.getHero2().getDirection().equals("right")) {
                        bullet.setPosition(new Vec2(hero.getPosition().x + 0.1f, hero.getPosition().y)); // bullet right
                        bullet.setLinearVelocity(new Vec2(bulletSpeed, 0));
                    }
            
                    // Decrease the total number of default ammo with the number of bullets fired
                         bulletCount++;
                         hero.decreaseAmmo();
        
                System.out.println("Bullet used: "  + bulletCount + ". Bullets left: " + hero.getAmmoCount()); 
                System.out.println("Bullet position: " + bullet.getPosition());
            } else {
                System.out.println("You ran out of bullets. Go find some, you don't want to be the one who let John Connor die!");
                
                // Add no bullets sound effect
                    try {
                        InputStream in = new FileInputStream("sounds/dry-fire.wav");
                        AudioStream as = new AudioStream(in);         
                        AudioPlayer.player.start(as); 
                    } catch (Exception f) {
                        System.err.println(f.getMessage());
                    }
            }
    }
    
}
