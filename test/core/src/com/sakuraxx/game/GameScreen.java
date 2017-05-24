package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by karen on 22/05/2017.
 */
public class GameScreen extends Ventana {

    private SpriteBatch batch;
    private Sprite sprite;

    public GameScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show(){
        batch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("core/assets/nubes.jpg")));
        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }


    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
        batch.end();
    }
    @Override
    public void hide(){
        batch.dispose();
    }
}
