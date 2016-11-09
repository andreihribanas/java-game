package terminatorGame;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author absc869
 */
public class GameLevel_3 extends TerminatorWorld {
    
    private TerminatorHero hero;
    private Robot robot;
    private Bullet bullet;
    
    private StaticBody ground, leftWall, rightWall, topWall;
    private StaticBody enclosedAreaTopLeft, enclosedAreaBottomLeft;
    private StaticBody ecTL1, ecTL2, ecTL3, ecTL4, ecTL5, ecTL6, ecTL7, ecTL8, ecTL9, ecTL10, ecTL11, ecTL12, ecTL13, ecTL14, ecTL15, ecTL16;
    private StaticBody SDL1, SDL2, SDL3, SDL4, SDL5, SDL6, SDL7, SDL8, SDM1, SDM2, SDM3, SDM4, SDS1, SDS2, SDS3, SDS4, SDS5, SDS6, SDS7, SDS8;
    private StaticBody ecTL17, ecTL18, vWallRight, vWallLeft2, vWallRight2, vWallBottomUp, vWallBottom, vWallBottom2, insideMiddle, insideMiddleStair1, insideMiddleStair2;
    private HealthPotion hp1, hp2, hp3, hp4, hp5, hp6, hp7, hp8;
    private AmmoPack amp1, amp2, amp3, amp4, amp5, amp6, amp7, amp8;
    private TeleportationPortal tpStart, tpEnd, tp1Orange, tp1Blue, tp2Orange, tp2Blue, tp3Orange, tp3Blue, tp4Orange, tp4Blue, tp5Orange, tp5Blue, tp6Orange, tp6Blue;
    
    private float ecHX1 = -20.0f;
    private float ecHX2 = -35.0f;
    private float ecHY1 = 10.0f;
    private float ecHY2 = -10.0f;
    
   @Override
   public void populate(Terminator game, int health, int xp, int ammo, int heroLevel){
        super.populate(game, health, xp, ammo, heroLevel);
        
        Shape horizontalWallEnclosedArea = new BoxShape(15.0f, 0.25f);
        Shape verticalWallEnclosedArea = new BoxShape(0.25f, 10.0f);
        Shape sideWall = new BoxShape(0.5f, 40.5f);
        Shape staticDeckLarge = new BoxShape(7.0f, 0.25f);
        Shape staticDeckMedium = new BoxShape(4.0f, 0.25f);
        Shape staticDeckSmall = new BoxShape(2.0f, 0.25f);
        
        // Build ground and world side walls
            ground = new StaticBody(this, new BoxShape(60.0f, 0.5f));
            ground.setPosition(new Vec2(5.0f, -40.0f));
            
            leftWall = new StaticBody(this, sideWall);
            leftWall.setPosition(new Vec2(-54.5f, 0.0f));
            
            rightWall = new StaticBody(this, sideWall);
            rightWall.setPosition(new Vec2(64.5f, 0.0f));
            
            topWall = new StaticBody(this, new BoxShape(60.0f, 0.5f));
            topWall.setPosition(new Vec2(5.0f, 40.0f));
        
            // BUILD FIRST ENCLOSED AREA (left top side)
                ecTL1 = new StaticBody(this,horizontalWallEnclosedArea);
                    ecTL1.setPosition(new Vec2(-10.0f, 30.0f));
                ecTL2 = new StaticBody(this, horizontalWallEnclosedArea);
                    ecTL2.setPosition(new Vec2(-10.0f, 10.0f));
                ecTL3 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL3.setPosition(new Vec2(-24.75f, 20.0f));
                ecTL4 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL4.setPosition(new Vec2(4.75f, 20.0f));
                    
                    // Build decks
                        SDL1 = new StaticBody(this, staticDeckLarge);
                        SDL1.setPosition(new Vec2(-2.0f, 22.5f));
                        
                        SDL2 = new StaticBody(this, staticDeckLarge);
                        SDL2.setPosition(new Vec2(-17.5f, 18.0f));
                        
                        SDM1 = new StaticBody(this, staticDeckMedium);
                        SDM1.setPosition(new Vec2(-21.0f, 22.5f));
                        
                        SDS1 = new StaticBody(this, staticDeckSmall);
                        SDS1.setPosition(new Vec2(-8.0f, 16.0f));
                        
                        SDS2 = new StaticBody(this, staticDeckSmall);
                        SDS2.setPosition(new Vec2(-3.0f, 14.0f));
                    
                    // Build teleportation portals
                        tp1Orange = new TeleportationPortal(this, "orange");
                        tp1Orange.setPosition(new Vec2(-22.0f, 14.0f));
                        tp1Orange.setName("tp1Orange");
                  
                        tp1Blue = new TeleportationPortal(this, "blue");
                        tp1Blue.setPosition(new Vec2(2.0f, 26.0f));
                        tp1Blue.setName("tp1Blue");
                        
                  
                    // Add health bottles and ammo packs
                        hp1 = new HealthPotion(this);
                            hp1.setPosition(new Vec2(-23.0f, 24.26f));
                        hp2 = new HealthPotion(this);
                            hp2.setPosition(new Vec2(-23.0f, 19.76f));
                        
                        amp1 = new AmmoPack(this);
                            amp1.setPosition(new Vec2(-21.0f, 24.26f));
                        amp2 = new AmmoPack(this);
                            amp2.setPosition(new Vec2(-21.0f, 19.76f));
                    
            // BUILD THE SECOND ENCLOSED AREA (left bottom side)
                ecTL5 = new StaticBody(this,horizontalWallEnclosedArea);
                    ecTL5.setPosition(new Vec2(-20.0f, 0.0f));
                ecTL6 = new StaticBody(this,horizontalWallEnclosedArea);
                    ecTL6.setPosition(new Vec2(-20.0f, -20.0f));
                ecTL7 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL7.setPosition(new Vec2(-34.75f, -10.0f));
                ecTL8 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL8.setPosition(new Vec2(-4.75f, -10.0f));
                    
                    // Build decks
                        SDL3 = new StaticBody(this, staticDeckLarge);
                        SDL3.setPosition(new Vec2(-27.5f, -7.5f));
                        
                        SDL4 = new StaticBody(this, staticDeckLarge);
                        SDL4.setPosition(new Vec2(-12.0f, -12.0f));
                        
                        SDM2 = new StaticBody(this, staticDeckMedium);
                        SDM2.setPosition(new Vec2(-9.0f, -7.5f));
                        
                        SDS3 = new StaticBody(this, staticDeckSmall);
                        SDS3.setPosition(new Vec2(-25.0f, -14.0f));
                        
                        SDS4 = new StaticBody(this, staticDeckSmall);
                        SDS4.setPosition(new Vec2(-20.0f, -16.0f));
                    
                    // Build teleportation portals
                        tp2Orange = new TeleportationPortal(this, "orange");
                        tp2Orange.setPosition(new Vec2(-32.0f, -16.0f));
                        tp2Orange.setName("tp2Orange");
                    
                        tp2Blue = new TeleportationPortal(this, "blue");
                        tp2Blue.setPosition(new Vec2(-32.0f, -3.75f));
                        tp2Blue.setName("tp2Blue");
                        
                  
                    // Add health bottles and ammo packs
                        hp5 = new HealthPotion(this);
                            hp5.setPosition(new Vec2(-7.06f, -5.73f));
                        hp6 = new HealthPotion(this);
                            hp6.setPosition(new Vec2(-5.46f, -10.23f));
                        amp5 = new AmmoPack(this);
                            amp5.setPosition(new Vec2(-6.06f, -5.73f));
                        amp6 = new AmmoPack(this);
                            amp6.setPosition(new Vec2(-7.46f, -10.23f));
                    
            // BUILD THE THIRD ENCLOSED AREA (right top side)
                    ecTL9 = new StaticBody(this,horizontalWallEnclosedArea);
                        ecTL9.setPosition(new Vec2(30.0f, 30.0f));
                ecTL10 = new StaticBody(this, horizontalWallEnclosedArea);
                    ecTL10.setPosition(new Vec2(30.0f, 10.0f));
                ecTL11 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL11.setPosition(new Vec2(15.25f, 20.0f));
                ecTL12 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL12.setPosition(new Vec2(44.75f, 20.0f));
            
                    // Build decks
                        SDL5 = new StaticBody(this, staticDeckLarge);
                        SDL5.setPosition(new Vec2(22.0f, 22.5f));
                        
                        SDL6 = new StaticBody(this, staticDeckLarge);
                        SDL6.setPosition(new Vec2(37.5f, 18.0f));
                        
                        SDM3 = new StaticBody(this, staticDeckMedium);
                        SDM3.setPosition(new Vec2(40.5f, 22.5f));
                        
                        SDS5 = new StaticBody(this, staticDeckSmall);
                        SDS5.setPosition(new Vec2(28.0f, 16.0f));
                        
                        SDS6 = new StaticBody(this, staticDeckSmall);
                        SDS6.setPosition(new Vec2(24.0f, 14.0f));
                    
                    // Build teleportation portals
                        tp3Orange = new TeleportationPortal(this, "orange");
                        tp3Orange.setPosition(new Vec2(18.0f, 26.0f));
                        tp3Orange.setName("tp3Orange");
                    
                        tp3Blue = new TeleportationPortal(this, "blue");
                        tp3Blue.setPosition(new Vec2(42.0f, 14.0f));
                        tp3Blue.setName("tp3Blue");
                        
                    
                // Add health bottles and ammo packs
                        hp3 = new HealthPotion(this);
                            hp3.setPosition(new Vec2(41.28f, 24.26f));
                        hp4 = new HealthPotion(this);
                            hp4.setPosition(new Vec2(41.33f, 19.76f));
                        amp3 = new AmmoPack(this);
                            amp3.setPosition(new Vec2(42.28f, 24.26f));
                        amp4 = new AmmoPack(this);
                            amp4.setPosition(new Vec2(42.33f, 19.76f));
                            
                            
            // BUILD THE FORTH ENCLOSED AREA (right bottom side)
                ecTL13 = new StaticBody(this,horizontalWallEnclosedArea);
                    ecTL13.setPosition(new Vec2(20.0f, 0.0f));
                ecTL14 = new StaticBody(this,horizontalWallEnclosedArea);
                    ecTL14.setPosition(new Vec2(20.0f, -20.0f));
                ecTL15 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL15.setPosition(new Vec2(5.25f, -10.0f));
                ecTL16 = new StaticBody(this, verticalWallEnclosedArea);
                    ecTL16.setPosition(new Vec2(34.75f, -10.0f));
            
                    // Build decks
                        SDL7 = new StaticBody(this, staticDeckLarge);
                        SDL7.setPosition(new Vec2(27.5f, -7.5f));
                        
                        SDL8 = new StaticBody(this, staticDeckLarge);
                        SDL8.setPosition(new Vec2(12.5f, -12.0f));
                        
                        SDM4 = new StaticBody(this, staticDeckMedium);
                        SDM4.setPosition(new Vec2(9.0f, -7.5f));
                        
                        SDS7 = new StaticBody(this, staticDeckSmall);
                        SDS7.setPosition(new Vec2(25.0f, -14.0f));
                        
                        SDS8 = new StaticBody(this, staticDeckSmall);
                        SDS8.setPosition(new Vec2(21.0f, -16.0f));
                    
                    // Build teleportation portals
                        tp4Orange = new TeleportationPortal(this, "orange");
                        tp4Orange.setPosition(new Vec2(32.0f, -16.0f));
                        tp4Orange.setName("tp4Orange");
                    
                        tp4Blue = new TeleportationPortal(this, "blue");
                        tp4Blue.setPosition(new Vec2(32.0f, -3.75f));
                        tp4Blue.setName("tp4Blue");
                  
                    // Add health bottles and ammo packs
                        hp7 = new HealthPotion(this);
                            hp7.setPosition(new Vec2(7.19f, -5.73f));
                        hp8 = new HealthPotion(this);
                            hp8.setPosition(new Vec2(10.26f, -10.23f));
                        amp7 = new AmmoPack(this);
                            amp7.setPosition(new Vec2(6.19f, -5.73f));
                        amp8 = new AmmoPack(this);
                            amp8.setPosition(new Vec2(9.26f, -10.23f));
                        
        // Build above ground platform
            StaticBody aboveGround = new StaticBody(this, new BoxShape(20.0f, 0.5f));
            aboveGround.setPosition(new Vec2(-35.0f, -30.0f));
            
                // Build above ground platform stairs
                    Shape stairShape = new BoxShape(3.0f, 0.5f);
                    
                    Body stair1 = new StaticBody(this, stairShape);
                    stair1.setPosition(new Vec2(-12.0f, -32.5f));
                    
                    Body stair2 = new StaticBody(this, stairShape);
                    stair2.setPosition(new Vec2(-5.0f, -35.0f));
                    
                // Build above the platform
                    StaticBody aboveGround2 = new StaticBody(this, new BoxShape(7.0f, 0.5f));
                    aboveGround2.setPosition(new Vec2(-47.0f, -25.0f));
                    
                    // Build the starting destination teleportation portal
                        tpStart = new TeleportationPortal(this, "blue");
                        tpStart.setPosition(new Vec2(-49.0f, -21.0f));
                        tpStart.setName("origins");
                        
       
         // BUILD THE END GAME AREA
                    ecTL17 = new StaticBody(this, new BoxShape(3.0f, 0.25f));
                    ecTL17.setPosition(new Vec2(0.25f, -5.25f));
                    
                    ecTL18 = new StaticBody(this, new BoxShape(0.25f, 12.0f));
                    ecTL18.setPosition(new Vec2(-2.50f, -17.0f));
                    
                    vWallLeft2 = new StaticBody(this, new BoxShape(0.25f, 4.0f));
                    vWallLeft2.setPosition(new Vec2(17.5f, -32.5f));
                    vWallLeft2.setFillColor(Color.yellow);
                    
                    vWallRight = new StaticBody(this, new BoxShape(0.25f, 8.0f));
                    vWallRight.setPosition(new Vec2(3.10f, -13.0f));
                    
                    vWallRight2 = new StaticBody(this, new BoxShape(0.25f, 8.0f));
                    vWallRight2.setPosition(new Vec2(53.0f, -29.0f));
                    
                    vWallBottomUp = new StaticBody(this, new BoxShape(25.0f, 0.25f));
                    vWallBottomUp.setPosition(new Vec2(27.75f, -21.25f));
                    
                    vWallBottom = new StaticBody(this, new BoxShape(10.0f, 0.25f));
                    vWallBottom.setPosition(new Vec2(7.5f, -28.75f));
                    
                    insideMiddle = new StaticBody(this, new BoxShape(8.0f, 0.25f));
                    insideMiddle.setPosition(new Vec2(45.0f, -28.75f));
                                      
                    
                    insideMiddleStair1 = new StaticBody(this, new BoxShape(2.0f, 0.25f));
                    insideMiddleStair1.setPosition(new Vec2(35.0f, -31.0f));
                    
                    insideMiddleStair2 = new StaticBody(this, new BoxShape(2.0f, 0.25f));
                    insideMiddleStair2.setPosition(new Vec2(29.5f, -33.0f));
                    
                    vWallBottom2 = new StaticBody(this, new BoxShape(18.0f, 0.25f));
                    vWallBottom2.setPosition(new Vec2(35.25f, -36.75f));           
                    
                    
                    // Build the final destination teleportation portal
                        tpEnd = new TeleportationPortal(this, "orange");
                        tpEnd.setPosition(new Vec2(50.0f, -25.0f));
                        tpEnd.setName("end");
           
        // COLLISIONS
            // Add health and ammo pickup collisions
                hp1.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp2.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp3.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp4.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp5.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp6.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp7.addCollisionListener(new HeroPickHealth(getHero2()));
                    hp8.addCollisionListener(new HeroPickHealth(getHero2()));
                    
                    amp1.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp2.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp3.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp4.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp5.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp6.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp7.addCollisionListener(new HeroPickAmmo(getHero2()));
                    amp8.addCollisionListener(new HeroPickAmmo(getHero2()));
            
            // Add teleportations portals actions
                tpStart.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp1Orange.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp1Blue.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp2Orange.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp2Blue.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp3Orange.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp3Blue.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp4Orange.addCollisionListener(new ListenerTeleportation(getHero2()));
                tp4Blue.addCollisionListener(new ListenerTeleportation(getHero2()));
                tpEnd.addCollisionListener(new ListenerTeleportation(getHero2()));
   
                
            // Destroy bullet when hits the world elements
                    ground.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    leftWall.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    rightWall.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    topWall.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    ecTL1.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    ecTL2.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    ecTL3.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    ecTL4.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    ecTL5.addCollisionListener(new BulletHitImmovableObjects(bullet));  
                    ecTL6.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    ecTL7.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL8.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    ecTL9.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL10.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    ecTL11.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL12.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    ecTL13.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL14.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    ecTL15.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL16.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    SDL1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL7.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDL8.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDM1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDM2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDM3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDM4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDS1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDS2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDS3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDS4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDS5.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    SDS6.addCollisionListener(new BulletHitImmovableObjects(bullet)); 
                    SDS7.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    SDS8.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tpStart.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tpEnd.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp1Orange.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp1Blue.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp2Orange.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp2Blue.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp3Orange.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp3Blue.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp4Orange.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    tp4Blue.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp7.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    hp8.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp7.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    amp8.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    stair1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    stair2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    aboveGround.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    aboveGround2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL18.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    vWallRight.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    vWallLeft2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    vWallRight2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    ecTL17.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    vWallBottom.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    vWallBottomUp.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    vWallBottom2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    insideMiddle.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    insideMiddleStair1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    insideMiddleStair2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                           
                    
               // Destroy unneeded moving platforms
                        getMP1().destroy();
                        getMP2().destroy();
                        getMP3().destroy();
                        getMP4().destroy();
                        getMP5().destroy();
                        getMP6().destroy();
                        
                        getTurret1().destroy();
                        getTurret2().destroy();
                        getTurret3().destroy();
                        getTurret4().destroy();
                        getTurret5().destroy();
                        
    }
   
   
   /* SET HERO STARTING POSITION FOR GAME LEVEL 3 */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-40, -35); // origin coordinates
    //    return new Vec2(30.0f, 25.0f);
    }
    
    
   /* SET TURRETS POSITION FOR GAME LEVEL 3 */
    @Override
    public Vec2 turret1Position() {
        return new Vec2(4.0f, -32.0f);
    }
    
    @Override
    public Vec2 turret2Position() {
        return new Vec2(0.0f, 0.0f);
    }
    
    @Override
    public Vec2 turret3Position() {
        return new Vec2(0.0f, 0.0f);
    }
    
    @Override
    public Vec2 turret4Position() {
        return new Vec2(0.0f, 0.0f);
    }
    
    @Override
    public Vec2 turret5Position() {
        return new Vec2(0.0f, 0.0f);
    }
  
    /* SET MOVING PLATFORMS POSITION FOR GAME LEVEL 3 */
        @Override
    public Vec2 mp1Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 mp2Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 mp3Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 mp4Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 mp5Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 mp6Position() {
        return new Vec2();
    }

   /* SET ROBOTS POSITION FOR GAME LEVEL 3 */
    @Override
    public Vec2 robot1Position() {
        return new Vec2(-17.15f, 24.26f);
    }

    @Override
    public Vec2 robot2Position() {
        return new Vec2(-3.6f, 24.26f);
    }
    
    @Override
    public Vec2 robot3Position() {
        return new Vec2(-14.91f, 19.76f);
    }
    
    @Override
    public Vec2 robot4Position() {
        return new Vec2(1.90f, 11.76f);
    }
    
    @Override
    public Vec2 robot5Position() {
        return new Vec2(28.65f, 24.26f);
    }
    
    @Override
    public Vec2 robot6Position() {
        return new Vec2(38.28f, 24.26f );
    }
    
    @Override
    public Vec2 robot7Position() {
        return new Vec2(32.33f, 19.76f);
    }
    
    @Override
    public Vec2 robot8Position() {
        return new Vec2(35.63f, 11.76f);
    }
    
    @Override
    public Vec2 robot9Position() {
        return new Vec2(-25.85f, -5.73f);
    }
    
    @Override
    public Vec2 robot10Position() {
        return new Vec2(-12.06f, -5.73f);
    }
    
    @Override
    public Vec2 robot11Position() {
        return new Vec2(-15.46f, -10.23f);
    }
    
    @Override
    public Vec2 robot12Position() {
        return new Vec2(-13.42f, -18.23f);
    }
    
    @Override
    public Vec2 robot13Position() {
        return new Vec2(11.19f, -5.73f);
    }
    
    @Override
    public Vec2 robot14Position() {
        return new Vec2(26.21f, -5.73f);
    }
    
    @Override
    public Vec2 robot15Position() {
        return new Vec2(17.26f, -10.23f);
    }
    
    @Override
    public Vec2 robot16Position() {
        return new Vec2(12.02f, -18.23f);
    }
    
    @Override
    public Vec2 robot17Position() {
        return new Vec2(-43.09f, -22.98f);
    }
    
    @Override
    public Vec2 robot18Position() {
        return new Vec2(-36.18f, -27.98f);
    }
    
    @Override
    public Vec2 robot19Position() {
        return new Vec2(-23.89f, -27.98f);
    }
    
    @Override
    public Vec2 robot20Position() {
        return new Vec2(1.96f, -37.98f);
    }
    
    @Override
    public Vec2 robot21Position() {
        return new Vec2(7.74f, -26.98f);
    }
    
    @Override
    public Vec2 robot22Position() {
        return new Vec2(15.98f, -26.98f);
    }
    
    @Override
    public Vec2 robot23Position() {
        return new Vec2(42.99f, -26.98f);
    }
   
}