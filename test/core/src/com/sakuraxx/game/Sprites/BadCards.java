package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by mendezrodriguez on 27/05/17.
 */
public class BadCards extends Cards{
    private static boolean touch;
    public BadCards(World world, TiledMap tiledMap, Rectangle rectangle){
        super(world, tiledMap, rectangle);
        fixture.setUserData(this);
<<<<<<< Updated upstream
        setCategoryFilter(MyGdxGame.BadCard_bit);
=======
        touch = false;
>>>>>>> Stashed changes
    }

    @Override
    public void onlinea() {
        Gdx.app.log("BadCards", "Collision");
<<<<<<< Updated upstream
=======
        setTouch(true);
        System.out.println(touch);
    }

    public static void setTouch(boolean touch) {
        BadCards.touch = touch;
    }
    public static boolean getTouch(){
        return touch;
>>>>>>> Stashed changes
    }
}
