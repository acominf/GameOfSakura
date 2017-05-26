package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by karen on 23/05/2017.
 */
public class ItemScreen extends Ventana {

    private Stage stage;
    private TextButton back;
    private Skin skin;

    private SpriteBatch batch;
    private Texture texture;

    public ItemScreen(final MyGdxGame game) {
        super(game);
        stage = new Stage(new FitViewport(600,450));
        skin = new Skin(Gdx.files.internal("core/assets/skin/uiskin.json"));

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("core/assets/Items.jpg"));

        back = new TextButton("Regresar", skin);
        back.setBounds(480,20,100,40);
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
        batch.draw(texture,0,0,600,450);
        batch.end();

        stage.act();
        stage.draw();

    }
}
