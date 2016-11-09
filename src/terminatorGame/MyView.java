
package terminatorGame;

import city.cs.engine.UserView;
import city.cs.engine.WorldView;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyView extends UserView {
    
    private TerminatorWorld world;
    private Terminator game;
    private TerminatorHero hero;
    private Robot robot;
    private Helicopter heli;
    private WorldView view;
    private JFrame frame;
    
    private int counter;
    
    String healthLabel, healthStatus, ammoLabel, ammoStatus, xpLabel, xpStatus, xpProgress;
    
    private Image healthBar;
    private int healthBarLength = 100;
    private Image image = new ImageIcon("data/city2.jpg").getImage();
    private Image ammoBar = new ImageIcon("data/bulletsCartuche.png").getImage();
    private Image xpBar = new ImageIcon("data/xp-bar.png").getImage();
    
    public MyView(Terminator game, TerminatorWorld world, int width, int height, TerminatorHero hero) {
        super(world, width, height);
        this.world = world;
        this.game = game;
        this.frame = frame;
        this.hero = hero;
        this.setForeground(Color.yellow);
    }
    
    public void setHero(TerminatorHero hero) {
        this.hero = hero;
    }
    
    public void setRobot(Robot robot) {
        this.robot = robot;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(image, WIDTH, HEIGHT, this);
               
    }
      
    @Override 
    protected void paintForeground(Graphics2D g) {
        
        int one = 0;
        int cl = 0;
        
        // Set text color
        g.setColor(Color.WHITE);
                 
        // Declare all the strings used in graphical bars (health + ammo + experience);
            healthLabel = "Health: ";
            healthStatus = Integer.toString(hero.getHealth()) + " hp";
            healthBar = new ImageIcon("data/hb-" + hero.getHealth() + ".png").getImage();
        
            ammoLabel = "Ammo: ";
            ammoStatus = Integer.toString(hero.getAmmoCount());    
           
            xpLabel = "xP level: "; 
            xpStatus = Integer.toString(hero.getXP());
            xpProgress = hero.getXP() + " / 500 | " + " Level: " + hero.getHeroLevel() ;
       
        // Draw health bar label
            g.drawString(healthLabel, 30, 33);
            g.drawString(healthStatus, healthBarLength + 85, 33);
            
            // Display health bar in real-time + current health points
                  for (int i=0; i<=hero.getHealth(); i++){
                      g.drawImage(healthBar, 80, 20, healthBarLength, 15, this);
                      // g.drawRect(80, 20, i, 15);
                  }
                
        // Draw ammo count label
             g.drawString(ammoLabel, 30, 53);
             
             // Display ammo count in real-time
                g.drawString(ammoStatus, 180, 53);
                g.drawImage(ammoBar, 80, 40, 100, 15, this);
             
        // Draw xP label
             g.drawString(xpLabel, 30, 73);
             
             // Display xP points in real-time
                // Draw experience level bar
                    if (hero.getXP() <= 500) {
                        g.drawRect(80, 60, 100, 15);

                        for (int j=0; j < hero.getXP(); j++) {
                            g.drawRect(80, 60, hero.getXP()/5, 15);
                            g.fill3DRect(80, 60, hero.getXP()/5, 15, false);
                        }

                        g.drawString(xpProgress, 190, 73);
                    } else if (hero.getXP() > 501) {
                        hero.resetXP();
                        hero.increaseHeroLevel();
                    }
                    
        // Draw objectives labels
            g.drawString("Objectives:", 500, 33);
            
                if (game.currentLevel ==1 ) {
                    g.drawString("Robots killed: " + hero.getRobotsDestroyed() + " /14", 510, 53);
                    g.drawString("Turrets destroyed: :" + hero.getTurretsDestroyed() + " /5", 510, 73);
                    g.drawString("Helicopter destroyed: :" + hero.getHelicopterDestroyed() + " /1", 510, 93);
                } else if (game.currentLevel == 2) {
                    g.drawString("Robots killed: " + hero.getRobotsDestroyed() + " /22", 510, 53);
                    g.drawString("Turrets destroyed: :" + hero.getTurretsDestroyed() + " /5", 510, 73);
                } else if (game.currentLevel == 3) {
                    g.drawString("Robots killed: " + hero.getRobotsDestroyed() + " /23", 510, 53);
                }
                
        // Display no bullets message
                if (hero.getAmmoCount() == 0) {
                    g.drawString("You ran out of bullets. Go collect some!", 250, 110);
                }
        
         
            // Advance to next level
               if (game.currentLevel == 1 & hero.getRobotsDestroyed() == 14 & hero.getTurretsDestroyed() == 5 & hero.getHelicopterDestroyed() == 1) {
                   
                        hero.resetRobotsDestroyed();
                        hero.resetTurretsDestroyed();
                        game.goNextLevel();
                
               } else if (game.currentLevel == 2 & hero.getRobotsDestroyed() == 22 && hero.getTurretsDestroyed() == 5) {

                   hero.resetRobotsDestroyed();
                   hero.resetTurretsDestroyed();
                   game.goNextLevel();
                   
               } else if (game.currentLevel == 3 & hero.getRobotsDestroyed() == 23) {
                   System.out.println("Game finished");
               }
               
               
        // END GAME
           if (hero.getHealth() <= 0 ) {
               if (one ==0 ) {
                    one = 1;
                    JOptionPane.showMessageDialog(null, "You have died, best luck next time.");
                    System.exit(0);
               }
           }
             
    }
}