package com.sakuraxx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by karen on 23/05/2017.
 */
public class HistoryScreen extends Ventana {

    private SpriteBatch batch;
    private Texture texture;
    private Stage stage;
    private TextButton back;
    private Skin skin;

    public HistoryScreen(final MyGdxGame game) {
        super(game);

        stage = new Stage(new FitViewport(600,450));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        batch = new SpriteBatch();
        texture = new Texture("historia.jpg");

        back = new TextButton("Regresar", skin);
        back.setBounds(135,65,100,60);
        back.setColor(Color.MAGENTA);
        back.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.menu);
            }
        });

        stage.addActor(back);
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void hide(){
    }
}
