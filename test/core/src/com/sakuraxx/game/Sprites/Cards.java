package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.sakuraxx.game.MyGdxGame;

import static com.badlogic.gdx.utils.JsonValue.ValueType.object;

/**
 * Created by mendezrodriguez on 26/05/17.
 */
public class Cards extends InteractiveTileObject{
    public Cards (World mundo, TiledMap map, Rectangle bounds){

        super(mundo, map, bounds);
        fixture.setUserData(this);
    }

    @Override
    public void onlinea() {
        Gdx.app.log("cards", "collision");
    }
}
