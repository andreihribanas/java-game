/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package terminatorGame;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author absc869
 */
public class GameLevel_2 extends TerminatorWorld {
    
    private WorldView view;
    private TerminatorHero hero;
    private GameLevel_3 world3;
    
    private float wallWidth = 0.5f;
    private float wallHeight = 35.25f;
    
    private float leftWallX = -65.0f;
    private float leftWallY = -5.0f;
    
    private float rightWallX = 65.0f;
    private float rightWallY = -5.0f;
    
    private float midPlatformLeftPosX = -37.0f;
    private float midPlatformRightPosX = -28.5f;
    private float midPlatformLevelExtraDistance = 0;
    
    private float platformPosX = 15.0f;
    private float platformPosX2 = 50.0f;
    
    private StaticBody ground, leftWall, rightWall, centreWall;
    private StaticBody entryTunnelTopSide, entryTunnelBottomSide1, entryTunnelBottomSide2, entryTunnelBottomSide3, entryTunnelBottomSide4, entryTunnelBottomSide5, 
            entryTunnelBottomSide6, safeDoorGround, topPlatform;
    private StaticBody sD1, sD2, sD3, sD4, sD5, sD6, sD7, sD8, sD9;
    private StaticBody L1H, L1V, L2H, L2V, L3H, L3V, L4H, L4V, L5H, L5V;     
    private StaticBody mp1, mp2, mp3, mp4, mp5, mp6, mp7;
    
    private HealthPotion hp1, hp2, hp3, hp4, hp5, hp6, hp7, hp8;
    private AmmoPack amp1, amp2, amp3, amp4, amp5, amp6, amp7, amp8;
    
    private BoxImmovable boxBottomSide1_1, boxBottomSide1_2, boxBottomSide1_3, boxBottomSide1_4, boxBottomSide1_5, boxBottomSide1_6;
    private BoxImmovable boxBottomSide2_1, boxBottomSide2_2, boxBottomSide2_3, boxBottomSide2_4, boxBottomSide2_5, boxBottomSide2_6;
    private BoxImmovable boxBottomSide3_1, boxBottomSide3_2, boxBottomSide3_3, boxBottomSide3_4, boxBottomSide3_5, boxBottomSide3_6;
    private BoxImmovable boxBottomSide4_1, boxBottomSide4_2, boxBottomSide4_3, boxBottomSide4_4, boxBottomSide4_5, boxBottomSide4_6;
    private BoxImmovable boxBottomSide5_1, boxBottomSide5_2, boxBottomSide5_3, boxBottomSide5_4, boxBottomSide5_5, boxBottomSide5_6;
    private BoxImmovable boxBottomSide6_1, boxBottomSide6_2, boxBottomSide6_3, boxBottomSide6_4, boxBottomSide6_5, boxBottomSide6_6;
    
    private Bullet bullet;
    
    private ListenerSafeDoor lsf;
    
    private Projectile projectile;
    private TurretFire tf;
         
    @Override
    public void populate(Terminator game, int health, int xp, int ammo, int heroLevel) {
            super.populate(game, health, xp, ammo, heroLevel);

        // Unload unused robots
            getRobot23().destroy();
            
        // Build ground and world walls
            Shape horizontalPlatform = new BoxShape(5.0f, 0.5f);
            Shape verticalPlatform = new BoxShape(0.5f, 5.0f);
            Shape staticDeck = new BoxShape(3.0f, 0.5f);
        
            Shape groundShape = new BoxShape(40.00f, 0.5f);
            ground = new StaticBody(this,groundShape);
            ground.setPosition(new Vec2(-25.5f, -40.0f));
        
            Shape sideWall = new BoxShape(wallWidth, wallHeight);
            leftWall = new StaticBody(this, sideWall);
            leftWall.setPosition(new Vec2(leftWallX, leftWallY));
            
            rightWall = new StaticBody(this, sideWall);
            rightWall.setPosition(new Vec2(rightWallX, rightWallY));

            
        //LEFT SIDE
            // Vertical level wall
                Shape cD = new BoxShape(0.5f, 30.5f);
                centreWall = new StaticBody(this, cD);
                centreWall.setPosition(new Vec2(0,0));
            
            // Build starting position - tunnel
                entryTunnelTopSide = new StaticBody(this, new BoxShape(65.5f, 0.5f));
                entryTunnelTopSide.setPosition(new Vec2(0.0f, 30.0f));

                entryTunnelBottomSide1 = new StaticBody(this, new BoxShape(28.0f, 0.5f));
                entryTunnelBottomSide1.setPosition(new Vec2(midPlatformLeftPosX, 20.0f + midPlatformLevelExtraDistance));
                
                    // Create immovable boxes
                        boxBottomSide1_1 = new BoxImmovable(this);
                        boxBottomSide1_1.setPosition(new Vec2(-1.75f, 11.75f));
                        boxBottomSide1_2 = new BoxImmovable(this);
                        boxBottomSide1_2.setPosition(new Vec2(-1.75f, 14.25f));
                        boxBottomSide1_3 = new BoxImmovable(this);
                        boxBottomSide1_3.setPosition(new Vec2(-1.75f, 16.75f));

                        boxBottomSide1_4 = new BoxImmovable(this);
                        boxBottomSide1_4.setPosition(new Vec2(-4.25f, 11.75f));
                        boxBottomSide1_5 = new BoxImmovable(this);
                        boxBottomSide1_5.setPosition(new Vec2(-4.25f, 14.25f));

                        boxBottomSide1_6 = new BoxImmovable(this);
                        boxBottomSide1_6.setPosition(new Vec2(-6.75f, 11.75f));

                
                entryTunnelBottomSide2 = new StaticBody(this, new BoxShape(28.0f, 0.5f));
                entryTunnelBottomSide2.setPosition(new Vec2(midPlatformRightPosX, 10.0f + midPlatformLevelExtraDistance));
                
                    // Build static deck
                        sD1 = new StaticBody(this, staticDeck);
                        sD1.setPosition(new Vec2(-3.0f, 5.0f));
                        
                    // Create immovable boxes
                        boxBottomSide2_1 = new BoxImmovable(this);
                        boxBottomSide2_1.setPosition(new Vec2(-63.25f, 1.75f));
                        boxBottomSide2_2 = new BoxImmovable(this);
                        boxBottomSide2_2.setPosition(new Vec2(-63.25f, 4.0f));
                        boxBottomSide2_3 = new BoxImmovable(this);
                        boxBottomSide2_3.setPosition(new Vec2(-63.25f, 6.25f));

                        boxBottomSide2_4 = new BoxImmovable(this);
                        boxBottomSide2_4.setPosition(new Vec2(-60.75f, 1.75f));
                        boxBottomSide2_5 = new BoxImmovable(this);
                        boxBottomSide2_5.setPosition(new Vec2(-60.75f, 4.0f));

                        boxBottomSide2_6 = new BoxImmovable(this);
                        boxBottomSide2_6.setPosition(new Vec2(-58.25f, 1.75f));
                
                entryTunnelBottomSide3 = new StaticBody(this, new BoxShape(28.0f, 0.5f));
                entryTunnelBottomSide3.setPosition(new Vec2(midPlatformLeftPosX, 0.0f + midPlatformLevelExtraDistance));
                
                    // Build static deck
                        sD2 = new StaticBody(this, staticDeck);
                        sD2.setPosition(new Vec2(-62.0f, -5.0f));
                        
                    // Create immovable boxes
                        boxBottomSide3_1 = new BoxImmovable(this);
                        boxBottomSide3_1.setPosition(new Vec2(-1.75f, -8.25f));
                        boxBottomSide3_2 = new BoxImmovable(this);
                        boxBottomSide3_2.setPosition(new Vec2(-1.75f, -6.0f));
                        boxBottomSide3_3 = new BoxImmovable(this);
                        boxBottomSide3_3.setPosition(new Vec2(-1.75f, -3.75f));

                        boxBottomSide3_4 = new BoxImmovable(this);
                        boxBottomSide3_4.setPosition(new Vec2(-4.25f, -8.25f));
                        boxBottomSide3_5 = new BoxImmovable(this);
                        boxBottomSide3_5.setPosition(new Vec2(-4.25f, -6.0f));

                        boxBottomSide3_6 = new BoxImmovable(this);
                        boxBottomSide3_6.setPosition(new Vec2(-6.75f, -8.25f));

                
                entryTunnelBottomSide4 = new StaticBody(this, new BoxShape(28.0f, 0.5f));
                entryTunnelBottomSide4.setPosition(new Vec2(midPlatformRightPosX, -10.0f + midPlatformLevelExtraDistance));

                    // Build static deck
                        sD3 = new StaticBody(this, staticDeck);
                        sD3.setPosition(new Vec2(-3.0f, -15.0f));
                        
                    // Create immovable boxes
                        boxBottomSide4_1 = new BoxImmovable(this);
                        boxBottomSide4_1.setPosition(new Vec2(-63.25f, -18.25f));
                        boxBottomSide4_2 = new BoxImmovable(this);
                        boxBottomSide4_2.setPosition(new Vec2(-63.25f, -16.0f));
                        boxBottomSide4_3 = new BoxImmovable(this);
                        boxBottomSide4_3.setPosition(new Vec2(-63.25f, -13.75f));

                        boxBottomSide4_4 = new BoxImmovable(this);
                        boxBottomSide4_4.setPosition(new Vec2(-60.75f, -18.25f));
                        boxBottomSide4_5 = new BoxImmovable(this);
                        boxBottomSide4_5.setPosition(new Vec2(-60.75f, -16.0f));

                        boxBottomSide4_6 = new BoxImmovable(this);
                        boxBottomSide4_6.setPosition(new Vec2(-58.25f, -18.25f));

                entryTunnelBottomSide5 = new StaticBody(this, new BoxShape(28.0f, 0.5f));
                entryTunnelBottomSide5.setPosition(new Vec2(midPlatformLeftPosX, -20.0f + midPlatformLevelExtraDistance));
                
                    // Build static deck
                        sD4 = new StaticBody(this, staticDeck);
                        sD4.setPosition(new Vec2(-62.0f, -25.0f));
                        
                    // Create immovable boxes
                        boxBottomSide5_1 = new BoxImmovable(this);
                        boxBottomSide5_1.setPosition(new Vec2(-1.75f, -28.25f));
                        boxBottomSide5_2 = new BoxImmovable(this);
                        boxBottomSide5_2.setPosition(new Vec2(-1.75f, -23.25f));
                        boxBottomSide5_3 = new BoxImmovable(this);
                        boxBottomSide5_3.setPosition(new Vec2(-1.75f, -25.75f));


                        boxBottomSide5_3 = new BoxImmovable(this);
                        boxBottomSide5_3.setPosition(new Vec2(-4.25f, -28.25f));
                        boxBottomSide5_4 = new BoxImmovable(this);
                        boxBottomSide5_4.setPosition(new Vec2(-4.25f, -25.75f));

                        boxBottomSide5_5 = new BoxImmovable(this);
                        boxBottomSide5_5.setPosition(new Vec2(-6.75f, -28.25f));

                
                entryTunnelBottomSide6 = new StaticBody(this, new BoxShape(28.0f, 0.5f));
                entryTunnelBottomSide6.setPosition(new Vec2(midPlatformRightPosX, -30.0f + midPlatformLevelExtraDistance));
                
                    // Create immovable boxes
                        boxBottomSide6_1 = new BoxImmovable(this);
                        boxBottomSide6_1.setPosition(new Vec2(-63.25f, -38.25f));
                        boxBottomSide6_2 = new BoxImmovable(this);
                        boxBottomSide6_2.setPosition(new Vec2(-63.25f, -36.0f));
                        boxBottomSide6_3 = new BoxImmovable(this);
                        boxBottomSide6_3.setPosition(new Vec2(-63.25f, -33.75f));

                        boxBottomSide6_4 = new BoxImmovable(this);
                        boxBottomSide6_4.setPosition(new Vec2(-60.75f, -38.25f));
                        boxBottomSide6_5 = new BoxImmovable(this);
                        boxBottomSide6_5.setPosition(new Vec2(-60.75f, -36.0f));

                        boxBottomSide6_6 = new BoxImmovable(this);
                        boxBottomSide6_6.setPosition(new Vec2(-58.25f, -38.25f));
        
                
            // Wall to be destroyed (access to new part - right side of the map)
               safeDoorGround = new StaticBody(this, new BoxShape(5.0f, 5.0f));
               safeDoorGround.setPosition(new Vec2(0.5f, -35.0f));
               safeDoorGround.setImage(new BodyImage("data/door2.jpg", 9.0f));
               
                lsf = new ListenerSafeDoor(safeDoorGround);
        
              // Create random door code generator
               Code code = new Code(this);
               code.setPosition(new Vec2(-10.0f, -35.0f));
               code.addCollisionListener(new ListenerCodeGenerate(getHero2(), lsf));
               
        // RIGHT SIDE
               topPlatform = new StaticBody(this, new BoxShape(27.5f, 0.5f));
               topPlatform.setPosition(new Vec2(37.5f, 20.0f));
               topPlatform.setFillColor(Color.yellow);
               
               
               L1H = new StaticBody(this, horizontalPlatform);
               L1V = new StaticBody(this, verticalPlatform);
               L1H.setPosition(new Vec2(6.5f, -30.0f));
               L1V.setPosition(new Vec2(2.0f, -25.0f));
               
                    // Build static deck
                        sD5 = new StaticBody(this, staticDeck);
                        sD5.setPosition(new Vec2(5.5f, -22.5f));
                        
                    L2H = new StaticBody(this, horizontalPlatform);
                    L2V = new StaticBody(this, verticalPlatform);
                    L2H.setPosition(new Vec2(58.0f, -20.0f));
                    L2V.setPosition(new Vec2(62.5f, -15.0f));
               
                        // Build static deck
                            sD6 = new StaticBody(this, staticDeck);
                            sD6.setPosition(new Vec2(59.0f, -12.5f));
                            
               L3H = new StaticBody(this, horizontalPlatform);
               L3V = new StaticBody(this, verticalPlatform);
               L3H.setPosition(new Vec2(10.0f, -10.0f));
               L3V.setPosition(new Vec2(5.5f, -5.0f));
               
                    // Build static deck
                         sD7 = new StaticBody(this, staticDeck);
                         sD7.setPosition(new Vec2(9.0f, -2.5f));
               
                    L4H = new StaticBody(this, horizontalPlatform);
                    L4V = new StaticBody(this, verticalPlatform);
                    L4H.setPosition(new Vec2(55.0f, 0.0f));
                    L4V.setPosition(new Vec2(59.5f, 5.0f));
        
                        // Build static deck
                            sD8 = new StaticBody(this, staticDeck);
                            sD8.setPosition(new Vec2(56.0f, 7.5f));
                        
                // Platform to final stage
                    L5H = new StaticBody(this, horizontalPlatform);
                    L5H.setPosition(new Vec2(5.5f, 13.0f));
        
            // Add health bottles and ammo packs to static decks on the right side (moving platforms)
                    hp1 = new HealthPotion(this);
                    hp1.setPosition(new Vec2(3.5f, -21.5f));

                    amp1 = new AmmoPack(this);
                    amp1.setPosition(new Vec2(4.5f, -21.5f));

                    hp2 = new HealthPotion(this);
                    hp2.setPosition(new Vec2(60.0f, -11.5f));

                    amp2 = new AmmoPack(this);
                    amp2.setPosition(new Vec2(61.0f, -11.5f));
                    
                    hp3 = new HealthPotion(this);
                    hp3.setPosition(new Vec2(7.5f, -1.5f));
                    
                    amp3 = new AmmoPack(this);
                    amp3.setPosition(new Vec2(8.0f, -1.5f));
                    
                    hp4 = new HealthPotion(this);
                    hp4.setPosition(new Vec2(58.5f, 8.5f));
                    
                    amp4 = new AmmoPack(this);
                    amp4.setPosition(new Vec2(57.5f, 8.5f));
                    
            // Add health bottles and ammo packs to static decks on the left side (static platforms - tunnels)
                    hp5 = new HealthPotion(this);
                    hp5.setPosition(new Vec2(-2.0f, 6.0f));
                        
                    amp5 = new AmmoPack(this);
                    amp5.setPosition(new Vec2(-4.0f, 6.0f));
                    
                    hp6 = new HealthPotion(this);
                    hp6.setPosition(new Vec2(-64.0f, -4.0f));
                        
                    amp6 = new AmmoPack(this);
                    amp6.setPosition(new Vec2(-62.0f, -4.0f));
                    
                    hp7 = new HealthPotion(this);
                    hp7.setPosition(new Vec2(-2.0f, -14.0f));
                        
                    amp7 = new AmmoPack(this);
                    amp7.setPosition(new Vec2(-4.0f, -14.0f));
                    
                    hp8 = new HealthPotion(this);
                    hp8.setPosition(new Vec2(-64.0f, -24.0f));
                        
                    amp8 = new AmmoPack(this);
                    amp8.setPosition(new Vec2(-62.0f, -24.0f));
                    
        
        // COLLISIONS
            // Create hero pickup life bottles + ammo packs collisions  
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
                    
            
            // Open safe door collision
                    getHero2().addCollisionListener(lsf);
                    
            // Create collision to destroy bullet when colliding with other immovable objects (immovable boxes and world ground/walls/platforms)
                // Bullet - walls and ground collisions (destroy bullet)
                    ground.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    leftWall.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    rightWall.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    centreWall.addCollisionListener(new BulletHitImmovableObjects(bullet));

                    entryTunnelTopSide.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    entryTunnelBottomSide1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    entryTunnelBottomSide2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    entryTunnelBottomSide3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    entryTunnelBottomSide4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    entryTunnelBottomSide5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    entryTunnelBottomSide6.addCollisionListener(new BulletHitImmovableObjects(bullet));

                    safeDoorGround.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    topPlatform.addCollisionListener(new BulletHitImmovableObjects(bullet));

                    L1H.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L1V.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L2H.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L2V.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L3H.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L3V.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L4H.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L4V.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    L5H.addCollisionListener(new BulletHitImmovableObjects(bullet));       

                    getMP1().addCollisionListener(new BulletHitImmovableObjects(bullet));
                    getMP2().addCollisionListener(new BulletHitImmovableObjects(bullet));
                    getMP3().addCollisionListener(new BulletHitImmovableObjects(bullet));
                    getMP4().addCollisionListener(new BulletHitImmovableObjects(bullet));
                    getMP5().addCollisionListener(new BulletHitImmovableObjects(bullet));
                    getMP6().addCollisionListener(new BulletHitImmovableObjects(bullet));
                
                // Set turrets direction
                    getTurret1().setTurretDirectionRight();
                    getTurret2().setTurretDirectionLeft();
                    getTurret3().setTurretDirectionRight();
                    getTurret4().setTurretDirectionLeft();
                    getTurret5().setTurretDirectionRight();
                
               // Turret projectile damage hero
                   getHero2().addCollisionListener(new ProjectileHit(projectile, getHero2(), tf));
                    
                    System.out.println("Current level: 2");
                
                    centreWall.addCollisionListener(new ProjectileHit(projectile, getHero2(), getTf1()));
                    rightWall.addCollisionListener(new ProjectileHit(projectile, getHero2(), getTf1()));
                    L2H.addCollisionListener(new ProjectileHit(projectile, getHero2(), getTf1()));
                    L3H.addCollisionListener(new ProjectileHit(projectile, getHero2(), getTf1()));
                    L4H.addCollisionListener(new ProjectileHit(projectile, getHero2(), getTf1()));
    }

// SET HERO STARTING POSITION FOR GAME LEVEL 2
 @Override
    public Vec2 startPosition() {
          return new Vec2(-50, 30.f); // origin point coordinates
     //   return new Vec2(-20.0f, -35.0f); // door position
    //    return new Vec2(40.0f, 25.0f); // portal position
    }
    
 
   // SET TURRETS POSITION FOR GAME LEVEL 2
    @Override
    public Vec2 turret1Position() {
        return new Vec2(57.35f, -10.48f);
    }
    
    @Override
    public Vec2 turret2Position() {
        return new Vec2(7.64f, -20.48f);
    }
    
    @Override
    public Vec2 turret3Position() {
        return new Vec2(11.30f, -0.48f);
    }
    
    @Override
    public Vec2 turret4Position() {
        return new Vec2(9.95f, 15.01f);
    }
    
    @Override
    public Vec2 turret5Position() {
        return new Vec2(54.05f, 9.51f);
    }
    
    // SET MOVING PLATFORMS POSITION FOR GAME LEVEL 2
        @Override
    public Vec2 mp1Position() {
        return new Vec2(15.0f, -35.0f);
    }
    
    @Override
    public Vec2 mp2Position() {
        return new Vec2(50.0f, -25.0f);
    }
    
    @Override
    public Vec2 mp3Position() {
        return new Vec2(15.0f, -15.0f);
    }
    
    @Override
    public Vec2 mp4Position() {
        return new Vec2(50.0f, -5.0f);
    }
    
    @Override
    public Vec2 mp5Position() {
        return new Vec2(15.0f, 5.0f);
    }
    
    @Override
    public Vec2 mp6Position() {
        return new Vec2(50.0f, 13.0f);
    }
    
    // SET ROBOTS POSITION FOR GAME LEVEL 2
    @Override
    public Vec2 robot1Position() {
        return new Vec2(-30.0f, 21.0f);
    }

    @Override
    public Vec2 robot2Position() {
        return new Vec2(-10.0f, 21.0f);
    }
    
    @Override
    public Vec2 robot3Position() {
        return new Vec2(-50.0f, 11.0f);
    }
    
    @Override
    public Vec2 robot4Position() {
        return new Vec2(-35.0f, 11.0f);
    }
    
    @Override
    public Vec2 robot5Position() {
        return new Vec2(-20.0f, 11.0f);
    }
    
    @Override
    public Vec2 robot6Position() {
        return new Vec2(-40.0f, 1.0f);
    }
    
    @Override
    public Vec2 robot7Position() {
        return new Vec2(-25.0f, 1.0f);
    }
    
    @Override
    public Vec2 robot8Position() {
        return new Vec2(-15.0f, 1.0f);
    }
    
    @Override
    public Vec2 robot9Position() {
        return new Vec2(-30.0f, -9.0f);
    }
    
    @Override
    public Vec2 robot10Position() {
        return new Vec2(-15.0f, -9.0f);
    }
    
    @Override
    public Vec2 robot11Position() {
        return new Vec2(-40.0f, -9.0f);
    }
    
    @Override
    public Vec2 robot12Position() {
        return new Vec2(-30.0f, -19.0f);
    }
    
    @Override
    public Vec2 robot13Position() {
        return new Vec2(-20.0f, -19.0f);
    }
    
    @Override
    public Vec2 robot14Position() {
        return new Vec2(-15.0f, -19.0f);
    }
    
    @Override
    public Vec2 robot15Position() {
        return new Vec2(-50.0f, -29.0f);
    }
    
    @Override
    public Vec2 robot16Position() {
        return new Vec2(-40.0f, -29.0f);
    }
    
    @Override
    public Vec2 robot17Position() {
        return new Vec2(-30.0f, -29.0f);
    }
    
    @Override
    public Vec2 robot18Position() {
        return new Vec2(8.0f, -29.0f);
    }
    
    @Override
    public Vec2 robot19Position() {
        return new Vec2(55.0f, -19.0f);
    }
    
    @Override
    public Vec2 robot20Position() {
        return new Vec2(12.0f, -9.0f);
    }
    
    @Override
    public Vec2 robot21Position() {
        return new Vec2(52.0f, 1.0f);
    }
    
    @Override
    public Vec2 robot22Position() {
        return new Vec2(4.0f, 16.0f);
    }
    
    @Override
    public Vec2 robot23Position() {
        return new Vec2();
    }
}