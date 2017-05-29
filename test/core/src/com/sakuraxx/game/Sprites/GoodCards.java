package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import com.sakuraxx.game.MyGdxGame;

import com.sakuraxx.game.Scenes.Hud;


/**
 * Created by mendezrodriguez on 27/05/17.
 */
public class GoodCards extends Cards{
    private Sound sonido;
    private Music musica;
    public GoodCards(World world, TiledMap tiledMap, Rectangle rectangle)
    {
        super(world, tiledMap, rectangle);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.GOODCARD_BIT);
        sonido = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/addScore.wav"));

        //sonido = MyGdxGame.manager.get("audio/sounds/addScore.wav", Sound.class);
    }

    @Override
    public void onlinea(){
        Gdx.app.log("GoodCards", "Collision");

        setCategoryFilter(MyGdxGame.DESTROYED_BIT);
        getCell().setTile(null);
        getCell1().setTile(null);
        /*musica = MyGdxGame.manager.get("audio/music/09_Small_Item_Catch.mp3", Music.class);
        musica.setLooping(true);
        musica.play();*/
        //Gdx.audio.newSound(FileHandle.tempFile("audio/sounds/addScore.wav"));
        sonido.play();



        Hud.addScore(100);

    }
}
