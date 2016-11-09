
package terminatorGame;

import city.cs.engine.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows hero to open the door.
 */
public class ListenerSafeDoor implements CollisionListener {
    private Body body;
    public int doorCode;

    public ListenerSafeDoor(Body body) {
        this.body = body;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == body) {
            
            String n = JOptionPane.showInputDialog(null, "Please enter the code");
           
             if (n.equals("")) {
               System.out.println("EXIT");
               
             } else if (!n.equals("") & n.equals(Integer.toString(doorCode))) {
                e.getOtherBody().destroy();
                JOptionPane.showMessageDialog(null, "Door opened!");
                System.out.println("Door opened!");
                
            } else {
                JOptionPane.showMessageDialog(null, "The code you entered is wrong, please try again.");
            }
            
        }
    }
    
}
