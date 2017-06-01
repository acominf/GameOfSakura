package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by mendezrodriguez on 27/05/17.
 */
public class BadCards extends Cards{
    private  Sound bCard;
    private static boolean touch;
    public BadCards(World world, TiledMap tiledMap, Rectangle rectangle){
        super(world, tiledMap, rectangle);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.BADCARD_BIT);
        touch = false;
        bCard = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/LessLife.wav"));
    }

    @Override
    public void onlinea() {
        Gdx.app.log("BadCards", "Collision");
        setTouch(true);
        setCategoryFilter(MyGdxGame.DESTROYED_BIT);
        System.out.println(touch);
        getCell().setTile(null);
        getCell1().setTile(null);
        bCard.play();
    }

    public static void setTouch(boolean touch) {
        BadCards.touch = touch;
    }
    public static boolean getTouch(){
        return touch;
    }
}
