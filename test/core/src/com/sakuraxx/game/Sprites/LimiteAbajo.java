package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by mendezrodriguez on 29/05/17.
 */
public class LimiteAbajo extends InteractiveTileObject{
    private Sound pierde;
    private static boolean touch;
    public LimiteAbajo(World w, TiledMap map, Rectangle b) {
        super(w, map, b);
        fixture.setUserData(this);
        touch = false;
        //setCategoryFilter(MyGdxGame.LIMITE_DOWN_BIT);
        pierde = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/LessLife.wav"));
    }

    @Override
    public void onlinea() {
        Gdx.app.log("LimiteAbajo", "Collision");
        touch = true;
        //setCategoryFilter(MyGdxGame.DESTROYED_BIT);
        pierde.play();
    }
    public static boolean getTouch(){
        return touch;
    }
    public static void setTouch(boolean touch) {
        LimiteAbajo.touch = touch;
    }
}
