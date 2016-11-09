

package terminatorGame;

import city.cs.engine.*;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 * Collision listener that generates random door code.
 */
public class ListenerCodeGenerate implements CollisionListener {
    private TerminatorHero hero;
    private ListenerSafeDoor lsf;

    public ListenerCodeGenerate(TerminatorHero hero, ListenerSafeDoor lsf) {
        this.hero = hero;
        this.lsf = lsf;
    }

    
    @Override
    public void collide(CollisionEvent e) {
        
        // Generate random door code
        Random random = new Random();
        int x = random.nextInt(10000);
        
        // Assign a 4 digit door code
        if (x > 1000 & x < 10000) {
            lsf.doorCode = x;
        } else {
            x = random.nextInt(10000);
            lsf.doorCode = x;
        }
        
        // Print code message
        if (e.getOtherBody() == hero) {
            JOptionPane.showMessageDialog(null, "The door code is: " + x);
        }
    }
    
}
