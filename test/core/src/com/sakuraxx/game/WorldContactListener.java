package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.sakuraxx.game.Sprites.BadCards;
import com.sakuraxx.game.Sprites.Cards;
import com.sakuraxx.game.Sprites.GoodCards;
import com.sakuraxx.game.Sprites.InteractiveTileObject;

/**
 * Created by USER-PC on 27/05/2017.
 */
public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if(fixA.getUserData() == "linea"|| fixB.getUserData() == "linea"){
            Fixture linea = fixA.getUserData() == "linea" ? fixA : fixB;
            Fixture object = linea == fixA ? fixB : fixA;

            if(object.getUserData() != null && GoodCards.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject) object.getUserData()).onlinea();
            }
            if(object.getUserData() != null && BadCards.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject) object.getUserData()).onlinea();
            }
        }
    }
    //InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
