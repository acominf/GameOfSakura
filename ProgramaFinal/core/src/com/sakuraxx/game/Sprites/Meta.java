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
public class Meta extends InteractiveTileObject{

    private Sound meta;
    private static boolean touch;
    public Meta(World w, TiledMap map, Rectangle b) {
        super(w, map, b);
        fixture.setUserData(this);
        touch = false;
        //setCategoryFilter(MyGdxGame.META_BIT);
        meta = Gdx.audio.newSound(Gdx.files.internal("audio/music/09_Small_Item_Catch.mp3"));
    }

    @Override
    public void onlinea() {
        Gdx.app.log("Meta", "Collision");
        touch = true;
        //setCategoryFilter(MyGdxGame.DESTROYED_BIT);

        meta.play();
    }
    public static boolean getTouch(){
        return touch;
    }
    public static void setTouch(boolean touch) {
        Meta.touch = touch;
    }
}
