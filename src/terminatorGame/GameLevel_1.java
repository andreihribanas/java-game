
package terminatorGame;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author absc869
 */
public class GameLevel_1 extends TerminatorWorld {
 private WorldView view;
         
 private TerminatorHero hero;
 private Helicopter helicopter, helicopter_2;
 
 private Box box_1, box_2, box_3, box_4, box_5, box_6, box_7, box_8, box_9, box_10;
 private Bullet bullet;
 private HealthPotion potion_1, potion_2, potion_3, potion_4, potion_5, potion_6, potion_7, potion_8;
 private AmmoPack ammo_1, ammo_2, ammo_3, ammo_4, ammo_5, ammo_6, ammo_7, ammo_8, ammo_9, ammo_10, ammo_11, ammo_12;
  
 private StaticBody leftWall, rightWall, ground,level_2_connector, secret_3_connector_1, secret_3_connector_2, secret_3_connector_3, middlePlatform1, 
         middlePlatform2, platformUP, level4Deck;
 private StaticBody dWall_1, dWall_2, dWall_3, dWall_4, dWall_5, dWall_6, dWall_7, dWall_8, dWall_9, dWall_10, dWall_11, dWall_12, dWall_13, dWall_14, dWall_15;
 private StaticBody p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33;
 
 private Box boxLevel1Tunnel, boxSecretZoneCentreLevel1, boxSecretZone2;
 private BoxImmovable boxGround, boxLadder1, boxLadder2, boxLadder3, boxLadder4, boxLadder5, boxLadder6, boxLeftDelimiter, boxRightDelimiter;

 private Projectile projectile;
 private TurretFire tf1, tf2, tf3, tf4, tf5;

 private float groundWidth = 67.5f;
 private float groundHeight = 0.5f;
 private float groundPosX = 0.0f;
 private float groundPosY = -50.5f;
 
 private float sideWallWidth = 0.5f;
 private float sideWallHeight = 40;
 
 private float deckPosX = 1.8f;
 private float deckHeight = 15.0f;
 
 private float mpPosX = -20.5f;
 private float mpPosX2 = -42.5f;
 
 
  @Override
          public void populate(Terminator game, int health, int xp, int ammo, int heroLevel){
                super.populate(game, health, xp, ammo, heroLevel);
                
            // Unload the unused objects
                getRobot15().destroy();
                getRobot16().destroy();
                getRobot17().destroy();
                getRobot18().destroy();
                getRobot19().destroy();
                getRobot20().destroy();
                getRobot21().destroy();
                getRobot22().destroy();
                getRobot23().destroy();
                
           // BUILD WORLD WALLS AND PLATFORMS
                Shape sideWall = new BoxShape(sideWallWidth, sideWallHeight );

                leftWall = new StaticBody(this, sideWall);
                leftWall.setPosition(new Vec2(-67, -10));
                leftWall.setName("Left world wall");

                rightWall = new StaticBody(this, sideWall);
                rightWall.setPosition(new Vec2(67, -10));  
                rightWall.setName("Right world wall");
            
            // BUILD GAME LEVELS
                Shape upperPlatform = new BoxShape(15.0f, 0.5f);
                Shape movingPlatform = new BoxShape(1.7f, 0.2f);
                Shape verticalWall = new BoxShape(0.5f, 12.5f);
                Shape ladderShape = new BoxShape(2.5f, 5.0f);
           
                // BUILD GROUND LEVEL
                    Shape groundPlatform = new BoxShape(groundWidth, groundHeight);
                    ground = new StaticBody(this, groundPlatform);
                    ground.setPosition(new Vec2(groundPosX, groundPosY));
                    ground.setName("World ground");
                    
                    // Platform 1
                        Shape P1 = new BoxShape(5.0f, 2.5f);
                        p1 = new StaticBody(this, P1);
                        p1.setPosition(new Vec2(-45.0f, -47.5f));
                        p1.setName("platform 1");
                        p1.setFillColor(Color.red);
                
                    // Platform 2
                        Shape P2 = new BoxShape(7.5f, 5.5f);
                        p2 = new StaticBody(this, P2);
                        p2.setPosition(new Vec2(-32.5f, -45.5f));
                        p2.setName("platform 2");
                        p2.setFillColor(Color.green);
                        
                    // Vertical wall 1 (vWall)
                        Shape vWall_1 = new BoxShape(0.5f, 2.5f);
                        dWall_1 = new StaticBody(this, vWall_1);
                        dWall_1.setPosition(new Vec2(-24.5f, -37.5f));
                        dWall_1.setName("wall 1");
                        dWall_1.setFillColor(Color.yellow);
                        
                // BUILD LEVEL 1     
                    // Platform 3
                        p3 = new StaticBody(this,upperPlatform);
                        p3.setPosition(new Vec2(-10.0f, -35.0f));
                        p3.setName("platform 3");
                        p3.setFillColor(Color.blue); 
                        
                    // Vertical wall 2 (ground)
                        Shape vWall_2 = new BoxShape(0.5f,5.5f);
                        dWall_2 = new StaticBody(this, vWall_2);
                        dWall_2.setPosition(new Vec2(4.5f, -40.0f));
                        dWall_2.setName("wall 2");
                        dWall_2.setFillColor(Color.red);
                
                    // Platform 4
                        Shape P4 = new BoxShape(27.5f, 0.5f);
                        p4 = new StaticBody(this, P4);
                        p4.setPosition(new Vec2(32.5f, -45.0f));
                        p4.setName("platform 4");
                        p4.setFillColor(Color.black);
                        
                   // Platform 5
                        Shape P5 = new BoxShape(5.0f, 5.5f);
                        p5 = new StaticBody(this, P5);
                        p5.setPosition(new Vec2(62.0f, -40.0f));
                        p5.setName("platform5");
                        p5.setFillColor(Color.yellow);     
                        
                   // Platform 6 (Level 1 right side secret zone)
                        Shape P6 = new BoxShape(20.5f, 0.5f);
                        p6 = new StaticBody(this, P6);
                        p6.setPosition(new Vec2(32.5f, -35.0f));
                        p6.setName("platform 6");
                        p6.setFillColor(Color.red);
                        
                        // Platform 7
                            Shape P7 = new BoxShape(11.0f, 0.5f);
                            p7 = new StaticBody(this, P7);
                            p7.setPosition(new Vec2(38.5f, -30.0f));
                            p7.setName("platform 7");
                            p7.setFillColor(Color.magenta);
                            
                        // Vertical wall 3 (Level 1 right secret zone)
                            Shape vWall_3 = new BoxShape(0.5f, 2.5f);
                            dWall_3 = new StaticBody(this, vWall_3);
                            dWall_3.setPosition(new Vec2(50.0f, -28.0f));
                            dWall_3.setName("wall 3");
                            dWall_3.setFillColor(Color.cyan);
                       
                    // Vertical wall 4 (secret middle level 1 delimiter)
                        Shape vWall_4 = new BoxShape(0.5f, 5.0f);
                        dWall_4 = new StaticBody(this, vWall_4);
                        dWall_4.setPosition(new Vec2(21.0f, -30.0f));
                        dWall_4.setName("wall 4");
                        dWall_4.setFillColor(Color.blue);
                        
                        // Platform 8
                            Shape P8 = new BoxShape(11.0f, 0.5f);
                            p8 = new StaticBody(this, P8);
                            p8.setPosition(new Vec2(-2.5f, -27.0f));
                            p8.setName("platform 8");
                            p8.setFillColor(Color.black);
                        
                        // Verticall wall 5 (Level 1 centre secret zone)
                        Shape vWall_5 = new BoxShape(0.5f, 3.5f);
                        dWall_5 = new StaticBody(this, vWall_5);
                        dWall_5.setPosition(new Vec2(-14.0f, -24.0f));
                        dWall_5.setName("wall 5");
                        dWall_5.setFillColor(Color.yellow);
                
                        // Platform 9 (Level 1 left centre secret zone connector)
                            Shape P9 = new BoxShape(2.0f, 0.5f);
                            p9 = new StaticBody(this, P9);
                            p9.setPosition(new Vec2(12.0f, -29.0f));
                            p9.setName("platform 9");
                            p9.setFillColor(Color.black);
  
                    
                // BUILD LEVEL 2
                    // Platform 10 (Upper level 2 platorm1)
                        Shape P10 = new BoxShape(18.0f, 0.5f);
                        p10 = new StaticBody(this, P10);
                        p10.setPosition(new Vec2(39.5f, -25.0f));
                        p10.setName("platform 10");
                        p10.setFillColor(Color.cyan);
                    
                    // Upper Level 2 connector
                        Shape connectorShape = new BoxShape(5.0f, 0.5f);
                        level_2_connector = new StaticBody(this, connectorShape);
                        level_2_connector.setPosition(new Vec2(17.5f, -22.7f));
                        level_2_connector.setAngleDegrees(-28);
                        level_2_connector.setName("Level 2 connector");
                        level_2_connector.setFillColor(Color.yellow);
                                
                   // Platform 11 (Upper level 2 platform 2)
                        p11 = new StaticBody(this, upperPlatform);
                        p11.setPosition(new Vec2(-deckPosX, groundPosY + 2 * deckHeight));
                        p11.setName("Platform 11");
                        p11.setFillColor(Color.red);
                        
                  // Level 2 secret zone
                        // Vertical wall 6 
                            Shape vWall_6 = new BoxShape(0.5f, 3.5f);
                            dWall_6 = new StaticBody(this, vWall_6);
                            dWall_6.setPosition(new Vec2(-10.0f, -9.0f));
                            dWall_6.setName("Wall 6");
                            dWall_6.setFillColor(Color.yellow);
                        
                        // Platform 12
                            Shape P12 = new BoxShape(10.0f, 0.5f);
                            p12 = new StaticBody(this, P12);
                            p12.setPosition(new Vec2(0.0f, -12.0f));
                            p12.setName("Platform 12");
                            p12.setFillColor(Color.red);

                       // Level 2 secret zone connectors/stairs
                            Shape B7 = new BoxShape(2.0f, 0.5f);
                            secret_3_connector_1 = new StaticBody(this, B7);
                            secret_3_connector_1.setPosition(new Vec2(20.0f, -16.0f));
                            secret_3_connector_1.setName("Secret 3 connector 1");

                            secret_3_connector_2 = new StaticBody(this, B7);
                            secret_3_connector_2.setPosition(new Vec2(14.0f, -13.0f));
                            secret_3_connector_2.setName("Secret 3 connector 2");

                            secret_3_connector_3 = new StaticBody(this, B7);
                            secret_3_connector_3.setPosition(new Vec2(26.0f, -19.0f));
                            secret_3_connector_3.setName("Secret 3 connector 3");

                            
                    // Level 2 left side platforms 19, 20, 21
                        Shape P19 = new BoxShape(10.0f, 0.5f);
                        p19 = new StaticBody(this, P19);
                        p19.setPosition(new Vec2(-56.5f, -20.5f));
                        p19.setName("Platform 19");
                        p19.setFillColor(Color.cyan);

                        Shape P20 = new BoxShape(9.0f, 0.5f);
                        p20 = new StaticBody(this, P20);
                        p20.setPosition(new Vec2(-57.5f, -10.5f));
                        p20.setName("Platform 20");
                        p20.setFillColor(Color.cyan);

                        Shape P21 = new BoxShape(7.0f, 0.5f);
                        p21 = new StaticBody(this, P21);
                        p21.setPosition(new Vec2(-59.5f, -0.5f));
                        p21.setName("Platform 21");
                        p21.setFillColor(Color.cyan);
                                
                        // Level 2 left side middle platforms
                            Shape middlePlatform = new BoxShape(5.0f, 0.5f);
                            
                            middlePlatform1 = new StaticBody(this, middlePlatform);
                            middlePlatform1.setPosition(new Vec2(-62.0f, -15.5f));
                            middlePlatform1.setName("Middle platform 1");
                            middlePlatform1.setFillColor(Color.yellow);
                            
                            middlePlatform2 = new StaticBody(this, middlePlatform);
                            middlePlatform2.setPosition(new Vec2(-62.0f, -5.5f));
                            middlePlatform2.setName("Middle platform 2");
                            middlePlatform2.setFillColor(Color.red);
                           
                        
                // BUILD LEVEL 3
                    // Level 3 platform 22
                        p22 = new StaticBody(this, upperPlatform);
                        p22.setPosition(new Vec2(deckPosX, groundPosY + 3 * deckHeight));
                        p22.setName("Platform 22");
                        p22.setFillColor(Color.blue);   
     
                    // Level 3 connector platform 23
                        Shape P23 = new BoxShape(5.0f, 0.5f);
                        p23 = new StaticBody(this, P23);
                        p23.setPosition(new Vec2( 21.0f, -8.0f));
                        p23.setName("Platform 23");
                        p23.setAngleDegrees(-30);
                        
                    // Level 3 platform 24
                       Shape P24 = new BoxShape(21.0f, 0.5f);
                       p24 = new StaticBody(this, P24);
                       p24.setPosition(new Vec2(46.0f, -10.5f));
                       p24.setName("Platform 24");
                       p24.setFillColor(Color.red);
               
                // BUILD LEVEL 4
                       
                    // Upper Level 4
                     Shape upP4 = new BoxShape(50.0f, 0.5f);
                     level4Deck = new StaticBody(this, upP4);
                     level4Deck.setPosition(new Vec2(-deckPosX, groundPosY + 4 * deckHeight));
                     level4Deck.setName("Final deck");

                   
                  //   MovingPlatform platformUP = new MovingPlatform(this);
                     platformUP = new StaticBody(this, new BoxShape(3.0f, 0.5f));
                     platformUP.setPosition(new Vec2(-64.0f, 5.0f));
                     platformUP.setFillColor(Color.yellow);
                     
              // BUILD WORLD OBJECTS AND CHARACTERS
                     // Ground level static box
                        boxGround = new BoxImmovable(this); 
                        boxGround.setPosition(new Vec2(-51.0f, -49.0f));
                        boxGround.setName("Box ground");
                     
                     // Level 1 right side ladder static boxes (stair)
                        boxLadder1 = new BoxImmovable(this);
                        boxLadder1.setPosition(new Vec2(61.0f, -33.5f));
                        boxLadder1.setName("Box ladder 1");
                        boxLadder2 = new BoxImmovable(this);
                        boxLadder2.setPosition(new Vec2(63.0f, -33.5f));
                        boxLadder2.setName("Box ladder 2");
                        boxLadder3 = new BoxImmovable(this);
                        boxLadder3.setPosition(new Vec2(65.5f, -33.5f));
                        boxLadder3.setName("Box ladder 3");
                        
                        boxLadder4 = new BoxImmovable(this);
                        boxLadder4.setPosition(new Vec2(63.0f, -31.5f));
                        boxLadder4.setName("Box ladder 4");
                        boxLadder5 = new BoxImmovable(this);
                        boxLadder5.setPosition(new Vec2(65.5f, -31.5f));
                        boxLadder5.setName("Box ladder 5");
                        
                        boxLadder6 = new BoxImmovable(this);
                        boxLadder6.setPosition(new Vec2(65.5f, -29.5f));
                        boxLadder6.setName("Box ladder 6");
                        
                     // Level 1 left side delimiter
                            boxLeftDelimiter = new BoxImmovable(this);
                            boxLeftDelimiter.setPosition(new Vec2(19.5f,-33.5f));
                            boxLeftDelimiter.setName("Box left delimiter");
                        
                     // Level 1 right side delimiter
                            boxRightDelimiter = new BoxImmovable(this);
                            boxRightDelimiter.setPosition(new Vec2(22.5f,-33.5f));
                            boxRightDelimiter.setName("Box Right Delimiter");
                     
                    // Level 1 tunnel dynamic box
                            boxLevel1Tunnel = new Box(this); // level 1 tunnel box
                            boxLevel1Tunnel.setPosition(new Vec2(30,-40));
                            boxLevel1Tunnel.setFixedRotation(true);
                            boxLevel1Tunnel.setName("Box tunnel");

                     // Level 1 centre secret zone 
                            potion_1 = new HealthPotion(this);
                            potion_1.setPosition(new Vec2(-7.0f, -26.0f));

                            potion_2 = new HealthPotion(this);
                            potion_2.setPosition(new Vec2(-2.0f, -26.0f));

                            ammo_1 = new AmmoPack(this);
                            ammo_1.setPosition(new Vec2(-9.0f, -26.0f));

                            ammo_2 = new AmmoPack(this);
                            ammo_2.setPosition(new Vec2(-4.0f, -26.0f));
                            
                            boxSecretZoneCentreLevel1 = new Box(this); // level 1 box 1
                            boxSecretZoneCentreLevel1.setPosition(new Vec2(6,-25));
                            boxSecretZoneCentreLevel1.setFixedRotation(true);
                            boxSecretZoneCentreLevel1.setName("Box secret zone centre level 1");
                            
                      // Level 1 right secret zone
                            potion_3 = new HealthPotion(this);
                            potion_3.setPosition(new Vec2(45.0f, -29.0f));
                            
                            ammo_3 = new AmmoPack(this);
                            ammo_3.setPosition(new Vec2(47.0f, -29.0f));
                            
                      // Level 2 centre secret zone      
                            potion_4 = new HealthPotion(this);
                            potion_4.setPosition(new Vec2(-2.0f, -11.0f));
                            
                            potion_5 = new HealthPotion(this);
                            potion_5.setPosition(new Vec2(3.0f, -11.0f));
                            
                            ammo_4 = new AmmoPack(this);
                            ammo_4.setPosition(new Vec2(-4.0f, -11.0f));
                            
                            ammo_5 = new AmmoPack(this);
                            ammo_5.setPosition(new Vec2(1.0f, -11.0f));
                            
                            boxSecretZone2 = new Box(this); // level 2 secret zone box
                            boxSecretZone2.setPosition(new Vec2(8,-10));
                            boxSecretZone2.setFixedRotation(true);
                            boxSecretZone2.setName("Box secret zone 2");
                          
                       // Level 2 left side middle platforms
                            potion_6 = new HealthPotion(this);
                            potion_6.setPosition(new Vec2(-65.0f, -15.0f));
                            
                            potion_7 = new HealthPotion(this);
                            potion_7.setPosition(new Vec2(-65.0f, -5.0f));
                            
                            ammo_6 = new AmmoPack(this);
                            ammo_6.setPosition(new Vec2(-63.0f, -15.0f));
                            
                            ammo_7 = new AmmoPack(this);
                            ammo_7.setPosition(new Vec2(-63.0f, -5.0f));
  
                    // make a helicopter
                        helicopter = new Helicopter(this);
                        helicopter.setPosition(new Vec2(10f, 15f));
                        helicopter.setGravityScale(0.0f);
                        helicopter.setLinearVelocity(new Vec2(-0.2f, 0f));
                        helicopter.setName("helicopter 1");
           
            // COLLISIONS  
                // Create collisions with helicopter
                    helicopter.addCollisionListener(new BulletHitHelicopter(bullet, getHero2(), helicopter));
                    
                    
                // Create getHero2() pickup life bottles + ammo packs collisions  
                    potion_1.addCollisionListener(new HeroPickHealth(getHero2()));
                    potion_2.addCollisionListener(new HeroPickHealth(getHero2()));
                    potion_3.addCollisionListener(new HeroPickHealth(getHero2()));
                    potion_4.addCollisionListener(new HeroPickHealth(getHero2()));
                    potion_5.addCollisionListener(new HeroPickHealth(getHero2()));
                    potion_6.addCollisionListener(new HeroPickHealth(getHero2()));
                    potion_7.addCollisionListener(new HeroPickHealth(getHero2()));
                    
                    ammo_1.addCollisionListener(new HeroPickAmmo(getHero2()));
                    ammo_2.addCollisionListener(new HeroPickAmmo(getHero2()));
                    ammo_3.addCollisionListener(new HeroPickAmmo(getHero2()));
                    ammo_4.addCollisionListener(new HeroPickAmmo(getHero2()));
                    ammo_5.addCollisionListener(new HeroPickAmmo(getHero2()));
                    ammo_6.addCollisionListener(new HeroPickAmmo(getHero2()));
                    ammo_7.addCollisionListener(new HeroPickAmmo(getHero2()));
                              
                // Create collision to destroy bullet when colliding with other immovable objects (immovable boxes and world ground/walls/platforms)
                    
                    // Bullet - walls and ground collisions (destroy bullet)
                        leftWall.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        leftWall.addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot1()));
                        
                        rightWall.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        ground.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                        dWall_1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        dWall_2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        dWall_3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        dWall_4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        dWall_5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        dWall_6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                    // Bullet - platforms collisions (destroy bullet)
                        p1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p7.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p8.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p9.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p10.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p11.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p12.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                        p19.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p20.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p21.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p22.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p23.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        p24.addCollisionListener(new BulletHitImmovableObjects(bullet));
                    
                    // Bullet - boxes collisions (destroy bullet)
                        boxGround.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                        boxLadder1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxLadder2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxLadder3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxLadder4.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxLadder5.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxLadder6.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                        boxLeftDelimiter.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxRightDelimiter.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                        boxLevel1Tunnel.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxSecretZoneCentreLevel1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        boxSecretZone2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        
                        level_2_connector.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        secret_3_connector_1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        secret_3_connector_2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        secret_3_connector_3.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        middlePlatform1.addCollisionListener(new BulletHitImmovableObjects(bullet));
                        middlePlatform2.addCollisionListener(new BulletHitImmovableObjects(bullet));
                                
                        
                        boxSecretZoneCentreLevel1.addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot1()));
                        boxSecretZone2.addCollisionListener(new BulletHitRobot(bullet, getHero2(), getRobot1()));  

                        tf1 = new TurretFire(this, view, getHero2(), getTurret1());
                        tf2 = new TurretFire(this, view, getHero2(),getTurret2());
                        tf3 = new TurretFire(this, view, getHero2(),getTurret3());
                        tf4 = new TurretFire(this, view, getHero2(), getTurret4());
                        tf5 = new TurretFire(this, view, getHero2(), getTurret5());
                        
         
                // Turret projectile destroy when hit other objects
                   leftWall.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   rightWall.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   level4Deck.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   getRobot12().addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   getRobot13().addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   secret_3_connector_1.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   secret_3_connector_2.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   secret_3_connector_3.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   dWall_4.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   dWall_5.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   p8.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   p9.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   boxLadder1.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   boxLadder2.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   boxLadder3.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   boxLadder4.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   boxLadder5.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));
                   boxLadder6.addCollisionListener(new ProjectileHit(projectile, getHero2(), tf1));     
                   
                   
                   Box box = new Box(this);
                   box.setPosition(new Vec2(-50.0f, - 40.0f));
                   box.addCollisionListener(new JP(getHero2()));
    }
    
          
    // HERO STARTING POSITION
    @Override
    public Vec2 startPosition() {
        return new Vec2(-60.0f, -40.0f); // origin point coordinates
   //     return new Vec2(-20.0f, -30.0f);
     //   return new Vec2(-20.0f, 5.0f);
    }
    
    // SET TURRETS POSITION FOR GAME LEVEL 1
    @Override
    public Vec2 turret1Position() {
        return new Vec2(19.48f, -30.78f);
    }
    
    @Override
    public Vec2 turret2Position() {
        return new Vec2(22.51f, -30.78f);
    }
    
    @Override
    public Vec2 turret3Position() {
        return new Vec2(-57.94f, -13.48f);
    }
    
    @Override
    public Vec2 turret4Position() {
        return new Vec2(-57.94f, -3.48f);
    }
    
    @Override
    public Vec2 turret5Position() {
        return new Vec2(5.42f, 11.51f);
    }
    
    // SET MOVING PLATFORMS POSITION FOR GAME LEVEL 1
    @Override
    public Vec2 mp1Position() {
        return new Vec2(-20.5f, -27.0f);
    }
    
    @Override
    public Vec2 mp2Position() {
        return new Vec2(-42.5f, -22.5f);
    }
    
    @Override
    public Vec2 mp3Position() {
        return new Vec2(-20.5f, -15.5f);
    }
    
    @Override
    public Vec2 mp4Position() {
        return new Vec2(-42.5f, -10.5f);
    }
    
    @Override
    public Vec2 mp5Position() {
        return new Vec2(-20.5f, -5.5f);
    }
    
    @Override
    public Vec2 mp6Position() {
        return new Vec2(-42.5f, -0.5f);
    }
    
    // SET ROBOTS POSITION FOR GAME LEVEL 1
    @Override
    public Vec2 robot1Position() {
        return new Vec2(-65.0f, -45.0f);
    }

    @Override
    public Vec2 robot2Position() {
        return new Vec2(-35.0f, -35.0f);
    }
    
    @Override
    public Vec2 robot3Position() {
        return new Vec2(-20.0f, -33.0f);
    }
    
    @Override
    public Vec2 robot4Position() {
        return new Vec2(15.0f, -33.0f);
    }
    
    @Override
    public Vec2 robot5Position() {
        return new Vec2(40.0f, -33.0f);
    }
    
    @Override
    public Vec2 robot6Position() {
        return new Vec2(50.0f, -20.0f);
    }
    
    @Override
    public Vec2 robot7Position() {
        return new Vec2(10.0f, -20.0f);
    }
    
    @Override
    public Vec2 robot8Position() {
        return new Vec2(-15.0f, -20.0f);
    }
    
    @Override
    public Vec2 robot9Position() {
        return new Vec2(-50.0f, -20.0f);
    }
    
    @Override
    public Vec2 robot10Position() {
        return new Vec2(-50.0f, -10.0f);
    }
    
    @Override
    public Vec2 robot11Position() {
        return new Vec2(-55.0f, 0.0f);
    }
    
    @Override
    public Vec2 robot12Position() {
        return new Vec2(-5.0f, -3.0f);
    }
    
    @Override
    public Vec2 robot13Position() {
        return new Vec2(12.0f, -3.0f);
    }
    
    @Override
    public Vec2 robot14Position() {
        return new Vec2(45.0f, -7.0f);
    }
    
    @Override
    public Vec2 robot15Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot16Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot17Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot18Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot19Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot20Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot21Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot22Position() {
        return new Vec2();
    }
    
    @Override
    public Vec2 robot23Position() {
        return new Vec2();
    }
 
   
}
