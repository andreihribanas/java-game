package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 * Key handler to control a body.
 */
public class ListenerController extends KeyAdapter {
    private static final float JUMPING_SPEED = 14;
    private static final float WALKING_SPEED = 8;
    
    private DynamicBody body;
    private WorldView view;
    private TerminatorHero hero;

    private GameLevel_2 world2;

    private World world;
    private ListenerWalker walkLeft;
    private ListenerWalker walkRight;
    private ListenerWalker strafeLeft;
    private ListenerWalker strafeRight;
    private ListenerWalker currentWalker;

    private int zoom = 5;
    
    private static final BodyImage terminatorImageLeft = new BodyImage("data/terminator-left.png", 3.25f);
    private static final BodyImage terminatorImageRight = new BodyImage("data/terminator-right.png", 3.25f);
    
    public ListenerController(DynamicBody body, TerminatorHero hero) {
        this.body = body;
        this.world = body.getWorld(); 
        this.walkLeft = new ListenerWalker(body, - WALKING_SPEED);
        this.walkRight = new ListenerWalker(body, WALKING_SPEED);
        this.strafeLeft = new ListenerWalker(body, - WALKING_SPEED * 1.5f);
        this.strafeRight = new ListenerWalker(body, WALKING_SPEED * 1.5f);
        this.hero = hero;
        this.view = view;       
    }
    
    /** Handle key press events for walking and jumping. */
    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // UP = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.03f) {
                body.setLinearVelocity(new Vec2(v.x, JUMPING_SPEED));
            }        
            
        } else if (code == KeyEvent.VK_LEFT) {
            // LEFT ARROW = walk left
            body.setImage(terminatorImageLeft);     
            setWalker(walkLeft);
            hero.setDirectionLeft();
            
        } else if (code == KeyEvent.VK_RIGHT) {
            // RIGHT ARROW = walk right
            body.setImage(terminatorImageRight);
            setWalker(walkRight);
            hero.setDirectionRight();
            
        } else if (code == KeyEvent.VK_SHIFT) {
            if (hero.getDirection().equals("left")){
                world.addStepListener(strafeLeft);
            } else if (hero.getDirection().equals("right")) {
                world.addStepListener(strafeRight);
            }
     
        } else if (code == KeyEvent.VK_SPACE) {
           hero.applyImpulse(new Vec2(0, 5));
            
        }
    }
    
@Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            clearWalker(walkLeft);
        } else if (code == KeyEvent.VK_RIGHT) {
            clearWalker(walkRight);
        }
    }

     public void setBody(DynamicBody body) {
        if (currentWalker != null) {
            world.removeStepListener(currentWalker);
            currentWalker = null;
        }
        this.body = body;
        this.world = body.getWorld();
        walkLeft.setBody(body);
        walkRight.setBody(body);
    }
     
  /** Set the walker, unless already walking */
    void setWalker(ListenerWalker w) {
        if (currentWalker == null) {
            currentWalker = w;
            world.addStepListener(currentWalker);
        }
    }

    /** Clear the walker, if this is the one in effect. */
    void clearWalker(ListenerWalker w) {
        if (currentWalker == w) {
            world.removeStepListener(currentWalker);
            currentWalker = null;
        }
    }
}
