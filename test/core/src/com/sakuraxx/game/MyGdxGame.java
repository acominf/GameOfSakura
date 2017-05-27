package com.sakuraxx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sakuraxx.game.Screens.HistoryScreen;
import com.sakuraxx.game.Screens.ItemScreen;
import com.sakuraxx.game.Screens.Juego;
import com.sakuraxx.game.Screens.Menu;

public class MyGdxGame extends Game {

	private AssetManager manager;

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;
    public static final float PPM = 100;

	public SpriteBatch batch;
	public Ventana gameScreen;
	public Ventana menu;
	public Ventana item;
	public Ventana history;
	//private CarImage asset;

	/*
	private Texture img;
	private BitmapFont font;
	private int height, width;
	//private Sakura saku; // sakura1
	private Principal menu;*/

	@Override
	public void create() {
        batch = new SpriteBatch();
        //setScreen(new Juego(this));

        menu = new Menu(this);
        history = new HistoryScreen(this);
        item = new ItemScreen(this);
        //gameScreen = new GameScreen(this);


        gameScreen = new Juego(this);


        setScreen(menu);
    }
	@Override //metodo para eliminar recursos
	public void dispose () {
		super.dispose();
		batch.dispose();
		//font.dispose();
	}

	@Override
	public void render() {
	    super.render();

    }

}


