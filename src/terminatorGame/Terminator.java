package terminatorGame;


import java.awt.BorderLayout; 
import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * A world with some bodies.
 */
public class Terminator {

    /** The World in which the bodies move and interact. */
    private TerminatorWorld world;
    private MouseHandler mouseHandler;
    private TopControlPanel topControlPanel;
    private ListenerController controller;
    private TurretFire tf1, tf2, tf3, tf4, tf5;
    private int health, xp, ammo, heroLevel;
    
    public int currentLevel;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    final JFrame frame;
        
    /** Initialise a new Demo. */
    public Terminator() {
        // make the world
            currentLevel = 1;
            world = new GameLevel_1();
            world.populate(this, 100,0, 100, 1);
        
            frame = new JFrame("Terminator game");
            
        // make a view
            view = new MyView(this, world, 700, 500, world.getHero2());
            view.setBackground(Color.white);
            
            view.setRobot(world.getRobot1());
        // uncomment this to draw a 1-metre grid over the view
        //  view.setGridResolution(1);

        // Create a zoomable map
//        UserView wideView = new MyView(world, 500, 100, world.getHero2(), world.getRobot_1_1());
//        wideView.setZoom(4);
        
        
        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        
        mouseHandler = new MouseHandler(world, view, world.getHero2());
        mouseHandler.setHero(getHero());
        view.addMouseListener(mouseHandler);
        
        
        // display the view in a frame   
        frame.setFocusable(true);
        frame.add(view, BorderLayout.CENTER);
            
        
        
        
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
  
        // display the world in the window
        topControlPanel = new TopControlPanel(view, world.getHero2(), this);
        frame.add(topControlPanel, BorderLayout.NORTH);
       
   //     frame.add(wideView, BorderLayout.SOUTH);
      //  world.setGravity(0.5f);
        
        // don't let the game window be resized
        frame.setResizable(false);
        
        // size the game window to fit the world view
        frame.pack();
        
        // make the window visible
        frame.setVisible(true);
        
        view.setZoom(20);
    
        // add key and step listener to the view
         controller = new ListenerController(world.getHero(), world.getHero2());
         frame.addKeyListener(controller);

         
        // Moving platforms listener
         movingPlatformStepListener();
         turretStepListener();
         robotsMovingListener();
  
         // Camera tracking player
         world.addStepListener(new ListenerTracker(view,world.getHero2()));
         
        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);
        // add a wide angle view of the world

         
         // Add background music
  
         
        // start!
        world.start();
    }
 
    public TerminatorHero getHero() {
        return world.getHero2();
    }
    
    public void robotsMovingListener() {
       // world.addStepListener(new ListenerRobotMoving(view, world.getRobot3()));
    }
    
    public void movingPlatformStepListener() {
         world.addStepListener(new ListenerPlatformMoving(this,view, world.getMP1()));
         world.addStepListener(new ListenerPlatformMoving(this,view, world.getMP2()));
         world.addStepListener(new ListenerPlatformMoving(this,view, world.getMP3()));
         world.addStepListener(new ListenerPlatformMoving(this,view, world.getMP4()));
         world.addStepListener(new ListenerPlatformMoving(this,view, world.getMP5()));
         world.addStepListener(new ListenerPlatformMoving(this,view, world.getMP6()));
    }
    
    public void turretStepListener() {
         tf1 = new TurretFire(world, view, world.getHero2(), world.getTurret1());
         tf2 = new TurretFire(world, view, world.getHero2(), world.getTurret2());
         tf3 = new TurretFire(world, view, world.getHero2(), world.getTurret3());
         tf4 = new TurretFire(world, view, world.getHero2(), world.getTurret4());
         tf5 = new TurretFire(world, view, world.getHero2(), world.getTurret5());
        
         world.addStepListener(tf1);
         world.addStepListener(tf2);
         world.addStepListener(tf3);
         world.addStepListener(tf4);
         world.addStepListener(tf5);
         
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        
        
        health = getHero().getHealth();
        xp = getHero().getXP();
        ammo = getHero().getAmmoCount();
        heroLevel = getHero().getHeroLevel();
        world.setPaused(true);
        
        if (currentLevel == 3 ) {
            System.exit(0);
        }
        if (currentLevel == 2) {
            currentLevel++;
            // get a new world
            world = new GameLevel_3();
            
            // fill it with bodies
            world.populate(this, health, xp, ammo, heroLevel);
            view.setHero(getHero());
            mouseHandler.setHero(getHero());
           
            // switch the keyboard control to the new actor
            controller.setBody(world.getHero2());
            
            world.addStepListener(new ListenerTracker(view,world.getHero2()));

            // show the new world in the view
            view.setWorld(world);
             
            world.start();
            System.out.println(" " + currentLevel); 
            
        } else if (currentLevel == 1){
            currentLevel++;
            // get a new world
            world = new GameLevel_2();
            
            // fill it with bodies
            world.populate(this, health, xp, ammo, heroLevel);
            mouseHandler.setHero(getHero());
            view.setHero(getHero());
            
            // switch the keyboard control to the new actor
            controller.setBody(world.getHero());
            world.addStepListener(new ListenerTracker(view,world.getHero2()));
            
            // set platforms and turrets listener
            movingPlatformStepListener();
            turretStepListener();
            
            // show the new world in the view
            view.setWorld(world);
                
          //  view.addMouseListener(new MouseHandler(view, world.getHero(), world.getHero2()));
            world.start();
        }
    }
    
    
    /** Run the demo. */
    public static void main(String[] args) {
        new Terminator();
    }

}
