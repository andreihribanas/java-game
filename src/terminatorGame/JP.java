/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package terminatorGame;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the bird to collect things.
 */
public class JP implements CollisionListener {
    private TerminatorHero hero;
    private MyView view;

    public JP(TerminatorHero hero) {
        this.hero = hero;
        this.view = view;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == hero) {
           
           float x = hero.getPosition().x;
           float y = hero.getPosition().y;
           
           hero.destroy();
           
           TerminatorHeroJetPack hero2 = new TerminatorHeroJetPack(view.getWorld());
           hero2.setPosition(new Vec2(x,y));
        }
    }
    
}
