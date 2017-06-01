package com.sakuraxx.game;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.graphics;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sakuraxx.game.Screens.*;

public class MyGdxGame extends Game {

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 200;
    public static final float PPM = 100;


	private SpriteBatch batch;
	private Ventana gameScreen;
	private Ventana menu;
	private Ventana item;
	private Ventana history;
	private Ventana GameOver;
	private Ventana winScreen;

	private static AssetManager manager;
    public static final short  LIMITE_DOWN_BIT = 64;
	public static final short DEFAULT_BIT = 1;
	public static final short Saku_bit = 2;
	public static final short BADCARD_BIT = 4;
	public static final short GOODCARD_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short META_BIT = 32;

	public static Music musica;

    public static short getDefaultBit() {
        return DEFAULT_BIT;
    }

    public static AssetManager getManager() {
        return manager;
    }

    public static void setManager(AssetManager manager) {
        MyGdxGame.manager = manager;
    }

    public static short getLimiteDownBit() {
        return LIMITE_DOWN_BIT;
    }

    public static short getSaku_bit() {
        return Saku_bit;
    }

    public static short getBadcardBit() {
        return BADCARD_BIT;
    }

    public static short getGoodcardBit() {
        return GOODCARD_BIT;
    }

    public static short getDestroyedBit() {
        return DESTROYED_BIT;
    }

    public static short getMetaBit() {
        return META_BIT;
    }

    @Override
	public void create() {
        setBatch(new SpriteBatch());
        //setScreen(new Juego(this));
		setManager(new AssetManager());
        getManager().load("audio/music/musicaJuego.mp3", Music.class);
        getManager().load("audio/music/SakuraCC_Op.mp3", Music.class);
        getManager().load("audio/music/79_Last_Battle.mp3", Music.class);
        getManager().load("audio/music/09_Small_Item_Catch.mp3", Music.class);
		getManager().load("audio/music/49_Medal_Get_Fanfare.mp3", Music.class);
        getManager().load("audio/sounds/addScore.wav", Music.class);
        getManager().load("audio/music/73_Game_Over.mp3", Music.class);
        getManager().load("audio/sounds/LessLife.wav", Music.class);
        getManager().finishLoading();

        setMenu(new Menu(this));
        setHistory(new HistoryScreen(this));
        setItem(new ItemScreen(this));
        setWinScreen(new WinScreen(this));

        setGameScreen(new Juego(this));
        setGameOver(new GameOver(this));


        setScreen(getMenu());
    }
	@Override //metodo para eliminar recursos
	public void dispose () {
		super.dispose();
		getManager().dispose();
		getBatch().dispose();

		//font.dispose();
	}

	@Override
	public void render() {
	    super.render();
	    //if(gameScreen.)

    }


    public Ventana getGameOver() {
        return GameOver;
    }

    public void setGameOver(Ventana gameOver) {
        GameOver = gameOver;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Ventana getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(Ventana gameScreen) {
        this.gameScreen = gameScreen;
    }

    public Ventana getMenu() {
        return menu;
    }

    public void setMenu(Ventana menu) {
        this.menu = menu;
    }

    public Ventana getItem() {
        return item;
    }

    public void setItem(Ventana item) {
        this.item = item;
    }

    public Ventana getHistory() {
        return history;
    }

    public void setHistory(Ventana history) {
        this.history = history;
    }

    public Ventana getWinScreen() {
        return winScreen;
    }

    public void setWinScreen(Ventana winScreen) {
        this.winScreen = winScreen;
    }
}


