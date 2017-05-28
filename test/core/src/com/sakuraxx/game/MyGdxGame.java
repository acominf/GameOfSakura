package com.sakuraxx.game;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.graphics;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sakuraxx.game.Screens.*;

public class MyGdxGame extends Game {

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;
    public static final float PPM = 100;

	public SpriteBatch batch;
	public Ventana gameScreen;
	public Ventana menu;
	public Ventana item;
	public Ventana history;
	public Ventana GameOver;

	public static final short DEFAULT_BIT = 1;
	public static final short Saku_bit = 2;
	public static final short BADCARD_BIT = 4;
	public static final short GOODCARD_BIT = 8;
	public static final short DESTROYED_BIT = 16;

	@Override
	public void create() {
        batch = new SpriteBatch();
        //setScreen(new Juego(this));

        menu = new Menu(this);
        history = new HistoryScreen(this);
        item = new ItemScreen(this);

        gameScreen = new Juego(this);
        GameOver = new GameOver(this);


        setScreen(GameOver);
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


