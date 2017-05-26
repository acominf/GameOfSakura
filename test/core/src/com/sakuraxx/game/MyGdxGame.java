package com.sakuraxx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyGdxGame extends Game {

	private AssetManager manager;

	public static final int V_WIDTH = 600;
	public static final int V_HEIGHT = 400;
	public SpriteBatch batch;
	public Ventana gameScreen;
	public Ventana menu;
	public Ventana item;
	public Ventana history;

	private Juego juego;
	//private CarImage asset;


	/*private Texture img;
	private BitmapFont font;
	private int height, width;
	//private Sakura saku; // sakura1
	private Principal menu;*/
    private Sakura saku;

    @Override
	public void create() {
        batch = new SpriteBatch();
        //setScreen(new Juego(this));
		menu = new Menu(this);
		history = new HistoryScreen(this);
		item = new ItemScreen(this);
        juego =new Juego(this);
		//setScreen(menu);



	//animacion = new FondoAnimado(this);
	setScreen(menu);

	/*img = new Texture(Gdx.files.internal("core/assets/SAKURA.jpg"));
	font = new BitmapFont();
	height = Gdx.graphics.getHeight();
	width = Gdx.graphics.getWidth();
	System.out.println(width);*/
	    saku = new Sakura();
	//personaje = new Sakura();
	   // saku.create();
	}

	/*public AssetManager getManager(){
		return manager;*/

	@Override //metodo para eliminar recursos
	public void dispose () {
		super.dispose();
		batch.dispose();
		//font.dispose();
	}

	@Override
	public void render() {
	    float delta = Gdx.graphics.getDeltaTime();
        juego.render(delta);


	}
	    /*//m.render(new Gdx.graphics.ge);
        float delta = Gdx.graphics.getDeltaTime();
        history.render(delta);
		/*Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(img, 0, 0, width, height);
        // System.out.println(width);
        saku.dibujar(batch);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //personaje.mover();
        saku.mover();
		//font.draw(batch, "Sakura Card Captor Game", 10, height - 10);
        //font.draw(batch, "Holi", 60, 100, 2, 1, false);
        //super.pause();
        //font.dispose();

        img.dispose();

	//batch.end();
	}
	*/

   /* public int getHeight() {
        return height;
    }

    /*
            public void mover(){
                if(input.isKeyPressed(Input.Keys.A)){
                    saku.goLeft();
                }
                else if(input.isKeyPressed(Input.Keys.D)){
                    saku.goRight();
                }
                else if (input.isKeyPressed(Input.Keys.SPACE)){
                    saku.jump();
                }
            }

	*/
}
