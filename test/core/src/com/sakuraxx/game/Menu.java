package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by karen on 21/05/2017.
 */
public class Menu extends AbstractScreen {
    private SpriteBatch batch;
    private Texture inicio;
    private Boton play;

    public Menu(MyGdxGame main) {
        super(main);
    }

    public void show(){
        batch = main.getBatch();
        Texture texture = new Texture(Gdx.files.internal("core/assets/corazon.jpg"));
        inicio = new Texture(Gdx.files.internal("core/assets/SAKURA.jpg"));
        int centrarY = Gdx.graphics.getHeight() / 2 - texture.getHeight();
        int centrarX = Gdx.graphics.getWidth() / 2 - texture.getWidth();
        play = new BotonJugar(centrarX, centrarY);
    }

    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        play.update();

        batch.begin();
        batch.draw(inicio, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        play.draw(batch);
        batch.end();

    }
}
