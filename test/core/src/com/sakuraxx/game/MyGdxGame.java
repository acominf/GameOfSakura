package com.sakuraxx.game;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.graphics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sakuraxx.game.Screens.*;
import com.sakuraxx.game.Sprites.Sakura;

public class MyGdxGame extends Game {

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 200;
    public static final float PPM = 100;


	public SpriteBatch batch;
	public Ventana gameScreen;
	public Ventana menu;
	public Ventana item;
	public Ventana history;
	public Ventana GameOver;
	public Ventana winScreen;

	public static AssetManager manager;
    public static final short  LIMITE_DOWN_BIT = 64;
	public static final short DEFAULT_BIT = 1;
	public static final short Saku_bit = 2;
	public static final short BADCARD_BIT = 4;
	public static final short GOODCARD_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short META_BIT = 32;

	public static Music musica;

	@Override
	public void create() {
        batch = new SpriteBatch();
        //setScreen(new Juego(this));
		manager = new AssetManager();
        manager.load("audio/music/musicaJuego.mp3", Music.class);
        manager.load("audio/music/SakuraCC_Op.mp3", Music.class);
        manager.load("audio/music/79_Last_Battle.mp3", Music.class);
        manager.load("audio/music/09_Small_Item_Catch.mp3", Music.class);
		manager.load("audio/music/49_Medal_Get_Fanfare.mp3", Music.class);
        manager.load("audio/sounds/addScore.wav", Music.class);
        manager.load("audio/music/73_Game_Over.mp3", Music.class);
        manager.load("audio/sounds/LessLife.wav", Music.class);
        manager.finishLoading();

        menu = new Menu(this);
        history = new HistoryScreen(this);
        item = new ItemScreen(this);
        winScreen = new WinScreen(this);

        gameScreen = new Juego(this);
        GameOver = new GameOver(this);


        setScreen(menu);
    }
	@Override //metodo para eliminar recursos
	public void dispose () {
		super.dispose();
		manager.dispose();
		batch.dispose();

		//font.dispose();
	}

	@Override
	public void render() {
	    super.render();
	    //if(gameScreen.)

    }


}


