package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by karen on 21/05/2017.
 */
public class Screen extends AbstractScreen {
    private SpriteBatch batch;
    private Texture Fondo;

    public Screen(MyGdxGame main) {
        super(main);
    }

    @Override
    public void show(){
        batch = main.getBatch();
        Fondo = new Texture(Gdx.files.internal("core/assets/nubes.jpg"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Fondo, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();
    }
}
