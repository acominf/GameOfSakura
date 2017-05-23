package com.sakuraxx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public Ventana c;
	public Ventana animacion;
	public Ventana m;

	/*
	private Texture img;
	private BitmapFont font;
	private int height, width;
	//private Sakura saku; // sakura1
	private Principal menu;*/

	@Override
	public void create() {
	batch = new SpriteBatch();
	c = new GameScreen(this);
	animacion = new FondoAnimado(this);
	m = new Menu(this);
	setScreen(m);
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

	@Override
	public void render() {

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
	}
	/*@Override //metodo para eliminar recursos
	public void dispose () {

		//img.dispose();
		//font.dispose();
	}*/

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
