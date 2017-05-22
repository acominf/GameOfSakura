package com.sakuraxx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {//ApplicationAdapter {
    private SpriteBatch batch;

	/*
	private Texture img;
	private BitmapFont font;
	private int height, width;
	//private Sakura saku; // sakura1
	private Principal menu;*/

	@Override
	public void create() {
        batch = new SpriteBatch();
        Ventanas.juego = this;
		Ventanas.GameScreen = new Screen(this);
		Ventanas.Menu = new Menu(this);
		setScreen(Ventanas.Menu);
	/*
	img = new Texture(Gdx.files.internal("core/assets/SAKURA.jpg"));
	font = new BitmapFont();
	height = Gdx.graphics.getHeight();
	width = Gdx.graphics.getWidth();
	System.out.println(width);
	saku = new Sakura();
	//personaje = new Sakura();
	saku.create();*/
	}

	@Override //metodo para eliminar recursos
	public void dispose () {
		batch.dispose();
		Ventanas.GameScreen.dispose();
		//img.dispose();
		//font.dispose();
	}

	public SpriteBatch getBatch(){
	    return batch;
    }

	//@Override
	//public void render() {
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

        img.dispose();*/

		//batch.end();
	//}

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
