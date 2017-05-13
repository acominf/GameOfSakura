package com.sakuraxx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private BitmapFont font;
	private int height, width;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("android/assets/SAKURA.jpg"));
		font = new BitmapFont();
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.2f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Sakura Card Captor Game", 10, height - 10);
		font.draw(batch, "Holi", 10, 100, 1, 2, true);
		batch.draw(img, 0, 0, width, height);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
