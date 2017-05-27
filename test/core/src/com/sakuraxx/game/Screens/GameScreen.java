package com.sakuraxx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sakuraxx.game.MyGdxGame;
import com.sakuraxx.game.Ventana;

/**
 * Created by karen on 22/05/2017.
 */
public class GameScreen extends Ventana {

    private SpriteBatch batch;
    private Texture texture;

    public GameScreen(MyGdxGame game) {
        super(game);
        batch = new SpriteBatch();
        texture = new Texture("nubes.jpg");
    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture,0,0,600,450);
        batch.end();
    }
    @Override
    public void hide()
    {

    }
}
