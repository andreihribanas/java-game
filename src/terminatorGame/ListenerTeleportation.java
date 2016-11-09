

package terminatorGame;

import city.cs.engine.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows hero to change position on the map.
 */
public class ListenerTeleportation implements CollisionListener {
    private TerminatorHero hero;
    private TerminatorWorld world;
    private JFrame frame;

    public ListenerTeleportation(TerminatorHero hero) {
        this.hero = hero;
        this.world = world;
        this.frame = frame;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == hero) {

            if (e.getReceivingBody().getName().equalsIgnoreCase("origins")) {
                hero.setPosition(new Vec2(23.0f, 24.26f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp1Orange")) { 
                hero.setPosition(new Vec2(27.0f, -5.73f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp1Blue")) {
                hero.setPosition(new Vec2(1.5f, -9.81f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp2Orange")) {
                hero.setPosition(new Vec2(36.0f, 11.76f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp2Blue")) {
                hero.setPosition(new Vec2(26.0f, -18.23f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp3Orange")) {
                hero.setPosition(new Vec2(-44.0f, -22.0f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp3Blue")) {
                hero.setPosition(new Vec2(-27.0f, -18.23f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp4Orange")) {
                hero.setPosition(new Vec2(-27.0f, -5.73f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("tp4Blue")) {
                hero.setPosition(new Vec2(-17.0f, 11.76f));
                
            } else if (e.getReceivingBody().getName().equalsIgnoreCase("end")) {

                    JOptionPane pane = new JOptionPane("You are about to enter the final stage of the game, where you will face the ultimate robot."
                            + " Please make sure that you have enough health and ammo as you will not be able to comeback to pick some.", 
                            JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);
                    JDialog dialog = pane.createDialog(pane, "Warning before advancing to the next level");
                    dialog.show();

                        int value = ((Integer)pane.getValue()).intValue();

                            if (value == JOptionPane.YES_OPTION) {
                                JOptionPane paneNext = new JOptionPane("You are very brave, you saved the world. Good job!");
                                JDialog dialogNext = paneNext.createDialog(paneNext, "Advancing to final level");
                                dialogNext.show();
                               System.exit(0);
                               
                                    
                            } else if (value == JOptionPane.CANCEL_OPTION) {
                                JOptionPane paneCancel = new JOptionPane("You coward. Please come again when you feel up to the task!");
                                JDialog dialogCancel = paneCancel.createDialog(paneCancel, "Coward");
                                dialogCancel.show();
                                System.exit(0);
                            }
            }
                
        }
    }
    
}
