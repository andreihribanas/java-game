package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author absc869
 */
public abstract class TerminatorWorld extends World {
    
    // Declar common elements for all game levels
    private TerminatorWorld world;
    private MyView view;
    
    private TerminatorHero hero;
    private Robot robot1, robot2, robot3, robot4, robot5, robot6, robot7, robot8, robot9, robot10, robot11, robot12, robot13, robot14, robot15, robot16, robot17,
             robot18, robot19, robot20, robot21, robot22, robot23;;
    private MovingPlatform mp1, mp2, mp3, mp4, mp5, mp6;
    private Turret turret1, turret2, turret3, turret4, turret5;
    private TurretFire tf1, tf2, tf3, tf4, tf5;
    private Bullet  bullet;
    private Projectile projectile;
    
   public void populate(Terminator game, int health, int xp, int ammo, int level) {
        
        // CREATE HERO
            hero = new TerminatorHero(this);
            hero.setPosition(startPosition());
            hero.setName("hero");
            
            hero.setHealth(health);
            hero.setXP(xp);
            hero.setAmmo(ammo);
            hero.setHeroLevel(level);
        
        // CREATE MOVING PLATFORMS
                mp1 = new MovingPlatform(this);
                mp1.setPosition(mp1Position());
                mp1.setName("Moving platform 1");
                
                mp2 = new MovingPlatform(this);
                mp2.setPosition(mp2Position());
                mp2.setName("Moving platform 2");
                
                mp3 = new MovingPlatform(this);
                mp3.setPosition(mp3Position());
                mp3.setName("Moving platform 3");
                
                mp4 = new MovingPlatform(this);
                mp4.setPosition(mp4Position());
                mp4.setName("Moving platform 4");
                
                mp5 = new MovingPlatform(this);
                mp5.setPosition(mp5Position());
                mp5.setName("Moving platform 5");
                
                mp6 = new MovingPlatform(this);
                mp6.setPosition(mp6Position());
                mp6.setName("Moving platform 6");
      
            // CREATE ROBOTS
               robot1 = new Robot(this);
               robot1.setPosition(robot1Position());
               robot1.setName("Robot 1");
               
               robot2 = new Robot(this);
               robot2.setPosition(robot2Position());
               robot2.setName("Robot 2");
               
               robot3 = new Robot(this);
               robot3.setPosition(robot3Position());
               robot3.setName("Robot 3");
               
               robot4 = new Robot(this);
               robot4.setPosition(robot4Position());
               robot4.setName("Robot 4");
               
               robot5 = new Robot(this);
               robot5.setPosition(robot5Position());
               robot5.setName("Robot 5");
               
               robot6 = new Robot(this);
               robot6.setPosition(robot6Position());
               robot6.setName("Robot 6");
               
               robot7 = new Robot(this);
               robot7.setPosition(robot7Position());
               robot7.setName("Robot 7");
               
               robot8 = new Robot(this);
               robot8.setPosition(robot8Position());
               robot8.setName("Robot 8");
               
               robot9 = new Robot(this);
               robot9.setPosition(robot9Position());
               robot9.setName("Robot 9");
               
               robot10 = new Robot(this);
               robot10.setPosition(robot10Position());
               robot10.setName("Robot 10");
               
               robot11 = new Robot(this);
               robot11.setPosition(robot11Position());
               robot11.setName("Robot 11");
               
               robot12 = new Robot(this);
               robot12.setPosition(robot12Position());
               robot12.setName("Robot 12");
               
               robot13 = new Robot(this);
               robot13.setPosition(robot13Position());
               robot13.setName("Robot 13");
               
               robot14 = new Robot(this);
               robot14.setPosition(robot14Position());
               robot14.setName("Robot 14");
               
               robot15 = new Robot(this);
               robot15.setPosition(robot15Position());
               robot15.setName("Robot 15");
               
               robot16 = new Robot(this);
               robot16.setPosition(robot16Position());
               robot16.setName("Robot 16");
               
               robot17 = new Robot(this);
               robot17.setPosition(robot17Position());
               robot17.setName("Robot 17");
               
               robot18 = new Robot(this);
               robot18.setPosition(robot18Position());
               robot18.setName("Robot 18");
               
               robot19 = new Robot(this);
               robot19.setPosition(robot19Position());
               robot19.setName("Robot 19");
               
               robot20 = new Robot(this);
               robot20.setPosition(robot20Position());
               robot20.setName("Robot 20");
               
               robot21 = new Robot(this);
               robot21.setPosition(robot21Position());
               robot21.setName("Robot 21");
               
               robot22 = new Robot(this);
               robot22.setPosition(robot22Position());
               robot22.setName("Robot 22");
               
               robot23 = new Robot(this);
               robot23.setPosition(robot23Position());
               robot23.setName("Robot 23");
            
        // CREATE TURRETS
                turret1 = new Turret(this, "left");
                turret1.setPosition(turret1Position());
                turret1.setFixedRotation(true);
                turret1.setName("Turret 1");
                
                turret2 = new Turret(this, "right");
                turret2.setPosition(turret2Position());
                turret2.setFixedRotation(true);
                turret2.setName("Turret2");
                
                turret3 = new Turret(this, "right");
                turret3.setPosition(turret3Position());
                turret3.setFixedRotation(true);
                turret3.setName("Turret 3");
                
                turret4 = new Turret(this, "right");
                turret4.setPosition(turret4Position());
                turret4.setFixedRotation(true);
                turret4.setName("Turret 4");
                
                turret5 = new Turret(this, "left");
                turret5.setPosition(turret5Position());
                turret5.setFixedRotation(true);
                turret5.setName("Turret 5");
                
                    
      // CREATE COLLISIONS
            // Bullet hitting other platforms/objects
                mp1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                mp2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                mp3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                mp4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                mp5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                mp6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                
            // Create bullets collisions with robots (shoot robots and dissappear)
               getRobot1().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot1()));
               getRobot2().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot2()));
               getRobot3().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot3()));
               getRobot4().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot4()));
               getRobot5().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot5()));
               getRobot6().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot6()));
               getRobot7().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot7()));
               getRobot8().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot8()));
               getRobot9().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot9()));
               getRobot10().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot10()));
               getRobot11().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot11()));
               getRobot12().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot12()));
               getRobot13().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot13()));
               getRobot14().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot14()));
               getRobot15().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot15()));
               getRobot16().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot16()));
               getRobot17().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot17()));
               getRobot18().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot18()));
               getRobot19().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot19()));
               getRobot20().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot20()));
               getRobot21().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot21()));
               getRobot22().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot22()));
               getRobot23().addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot23()));

           // Physical collision between hero and robots
               getRobot1().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot2().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot3().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot4().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot5().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot6().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot7().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot8().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot9().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot10().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot11().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot12().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot13().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot14().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot15().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot16().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot17().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot18().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot19().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot20().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot21().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot22().addCollisionListener(new HeroRobotHit(getHero2()));
               getRobot23().addCollisionListener(new HeroRobotHit(getHero2()));
               
        // Create turret projectile collisions with hero (inflict damage to hero)
                getTurret1().addCollisionListener(new BulletHitTurret(bullet, getHero2(), getTurret1()));
                getTurret2().addCollisionListener(new BulletHitTurret(bullet, getHero2(), getTurret2()));
                getTurret3().addCollisionListener(new BulletHitTurret(bullet, getHero2(), getTurret3()));
                getTurret4().addCollisionListener(new BulletHitTurret(bullet, getHero2(), getTurret4()));
                getTurret5().addCollisionListener(new BulletHitTurret(bullet, getHero2(), getTurret5()));
                
                
                hero.addCollisionListener(new ProjectileHit(projectile, hero, tf1));
                robot3.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
               
    }
   
   /** Create hero getters */
    public DynamicBody getHero() {
        return hero;
    }
    
    public TerminatorHero getHero2(){
        return hero;
    }
    
    
    /** The initial position of the actor. */
    public abstract Vec2 startPosition();
   

    /** The initial position of moving platforms */
    public abstract Vec2 mp1Position();
    public abstract Vec2 mp2Position();
    public abstract Vec2 mp3Position();
    public abstract Vec2 mp4Position();
    public abstract Vec2 mp5Position();
    public abstract Vec2 mp6Position();
    
    /** The initial position of moving platforms */
    public abstract Vec2 robot1Position();
    public abstract Vec2 robot2Position();
    public abstract Vec2 robot3Position();
    public abstract Vec2 robot4Position();
    public abstract Vec2 robot5Position();
    public abstract Vec2 robot6Position();
    public abstract Vec2 robot7Position();
    public abstract Vec2 robot8Position();
    public abstract Vec2 robot9Position();
    public abstract Vec2 robot10Position();
    public abstract Vec2 robot11Position();
    public abstract Vec2 robot12Position();
    public abstract Vec2 robot13Position();
    public abstract Vec2 robot14Position();
    public abstract Vec2 robot15Position();
    public abstract Vec2 robot16Position();
    public abstract Vec2 robot17Position();
    public abstract Vec2 robot18Position();
    public abstract Vec2 robot19Position();
    public abstract Vec2 robot20Position();
    public abstract Vec2 robot21Position();
    public abstract Vec2 robot22Position();
    public abstract Vec2 robot23Position();
    
    
    /** The initial position of turrets */
    public abstract Vec2 turret1Position();
    public abstract Vec2 turret2Position();
    public abstract Vec2 turret3Position();
    public abstract Vec2 turret4Position();
    public abstract Vec2 turret5Position();
    
    
    // Create world getters for platforms
    public MovingPlatform getMP1() {
        return mp1;
    }
    
    public MovingPlatform getMP2() {
        return mp2;
    }
    
    public MovingPlatform getMP3() {
        return mp3;
    }
    
    public MovingPlatform getMP4() {
        return mp4;
    }
    
    public MovingPlatform getMP5() {
        return mp5;
    }
    
    public MovingPlatform getMP6() {
        return mp6;
    }
        
    // CREATE GETTERS FOR ROBOTS
    public Robot getRobot1() {
        return robot1;
    }
    
    public Robot getRobot2() {
        return robot2;
    }
    
    public Robot getRobot3() {
        return robot3;
    }
    
    public Robot getRobot4() {
        return robot4;
    }
    
    public Robot getRobot5() {
        return robot5;
    }
    
    public Robot getRobot6() {
        return robot6;
    }
    
    public Robot getRobot7() {
        return robot7;
    }
    
    public Robot getRobot8() {
        return robot8;
    }
    
    public Robot getRobot9() {
        return robot9;
    }
    
    public Robot getRobot10() {
        return robot10;
    }
    
    public Robot getRobot11() {
        return robot11;
    }
    
    public Robot getRobot12() {
        return robot12;
    }
    
    public Robot getRobot13() {
        return robot13;
    }
    
    public Robot getRobot14() {
        return robot14;
    }
    
    public Robot getRobot15() {
        return robot15;
    }
    
    public Robot getRobot16() {
        return robot16;
    }
    
    public Robot getRobot17() {
        return robot17;
    }
    
    public Robot getRobot18() {
        return robot18;
    }
    
    public Robot getRobot19() {
        return robot19;
    }
    
    public Robot getRobot20() {
        return robot20;
    }
    
    public Robot getRobot21() {
        return robot21;
    }
    
    public Robot getRobot22() {
        return robot22;
    }
    
    public Robot getRobot23() {
        return robot23;
    }
    
// CREATE GETTERS FOR TURRETS
   public Turret getTurret1() {
        return turret1;
    }
   
    public Turret getTurret2() {
        return turret2;
    }
      
    public Turret getTurret3() {
        return turret3;
    }
         
    public Turret getTurret4() {
        return turret4;
    }
            
    public Turret getTurret5() {
        return turret5;
    }
    
    public TurretFire getTf1() {
        return tf1;
    }
}