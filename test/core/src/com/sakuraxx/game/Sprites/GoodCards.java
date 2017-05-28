package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by mendezrodriguez on 27/05/17.
 */
public class GoodCards extends Cards{
    public GoodCards(World world, TiledMap tiledMap, Rectangle rectangle)
    {
        super(world, tiledMap, rectangle);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.GoodCard_bit);
    }

    @Override
    public void onlinea(){
        Gdx.app.log("GoodCards", "Collision");
        setCategoryFilter(MyGdxGame.Destoyed_bit);

    }
}
