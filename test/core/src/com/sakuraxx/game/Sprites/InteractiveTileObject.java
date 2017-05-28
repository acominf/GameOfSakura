package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.sakuraxx.game.MyGdxGame;

import java.io.PrintStream;

/**
 * Created by mendezrodriguez on 26/05/17.
 */
public abstract class InteractiveTileObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile title;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;

    public InteractiveTileObject(World w, TiledMap map, Rectangle b){
        this.world = w;
        this.map = map;
        this.bounds = b;
        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();


        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth()/2)/ MyGdxGame.PPM, (bounds.getY() + bounds.getHeight()/2)/MyGdxGame.PPM);

        body= world.createBody(bdef);

        shape.setAsBox(bounds.getWidth()/2/MyGdxGame.PPM, bounds.getHeight()/2/MyGdxGame.PPM);
        fdef.shape  =shape;
        fixture = body.createFixture(fdef);
    }

    public abstract void onlinea();
    public void setCategoryFilter(short filterBit){
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }
    public TiledMapTileLayer.Cell getCell(){
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
        return layer.getCell((int) (body.getPosition().x * MyGdxGame.PPM / 16), (int) (body.getPosition().y * MyGdxGame.PPM / 17));
    }
    public TiledMapTileLayer.Cell getCell1(){
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
        return layer.getCell((int) (body.getPosition().x * MyGdxGame.PPM / 16),( (int) (body.getPosition().y * MyGdxGame.PPM / 15)));
         //System.out.printf(body.getPosition().toString().);
    }

}
