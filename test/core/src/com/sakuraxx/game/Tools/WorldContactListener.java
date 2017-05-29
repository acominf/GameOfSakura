package com.sakuraxx.game.Tools;

import com.badlogic.gdx.physics.box2d.*;
import com.sakuraxx.game.MyGdxGame;
import com.sakuraxx.game.Sprites.*;

/**
 * Created by USER-PC on 27/05/2017.
 * esta clase detecta cuando sakura toca una carta buena o una carta mala
 */
public class WorldContactListener implements ContactListener {


    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int Collision = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        if(fixA.getUserData() == "linea"|| fixB.getUserData() == "linea"){
            Fixture linea = fixA.getUserData() == "linea" ? fixA : fixB;
            Fixture object = linea == fixA ? fixB : fixA;

            if(object.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject) object.getUserData()).onlinea();
            }
        }

        switch (Collision){
            case MyGdxGame.BADCARD_BIT | MyGdxGame.Saku_bit:
                if (fixA.getFilterData().categoryBits == MyGdxGame.BADCARD_BIT)
                    ((BadCards)fixA.getUserData()).onlinea();
                else
                    ((BadCards)fixB.getUserData()).onlinea();
                break;
            case MyGdxGame.GOODCARD_BIT | MyGdxGame.Saku_bit:
                if (fixA.getFilterData().categoryBits == MyGdxGame.GOODCARD_BIT)
                    ((GoodCards)fixA.getUserData()).onlinea();
                else
                    ((GoodCards)fixB.getUserData()).onlinea();
                break;
            case MyGdxGame.META_BIT | MyGdxGame.Saku_bit:
                if (fixA.getFilterData().categoryBits == MyGdxGame.META_BIT)
                    ((Meta)fixA.getUserData()).onlinea();
                else
                    ((Meta)fixB.getUserData()).onlinea();
                break;
            case MyGdxGame.LIMITE_DOWN_BIT | MyGdxGame.Saku_bit:
                if (fixA.getFilterData().categoryBits == MyGdxGame.LIMITE_DOWN_BIT)
                    ((Meta)fixA.getUserData()).onlinea();
                else
                    ((Meta)fixB.getUserData()).onlinea();
                break;
        }
    }

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
