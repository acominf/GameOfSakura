package com.sakuraxx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by karen on 21/05/2017.
 */
public class Menu extends Ventana {
    private Stage stage;
    private Skin skin;
    private Texture texture;
    private SpriteBatch batch;

    public static Music music;

    public Menu(final MyGdxGame game) {
        super(game);
        stage = new Stage(new FitViewport(600, 450));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        batch = new SpriteBatch();
        texture = new Texture("SAKURA.jpg");


        TextButton btnJugar = new TextButton("Jugar", skin);
        btnJugar.setBounds(135, 65, 300, 60);
        btnJugar.setColor(Color.MAGENTA);
        btnJugar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.gameScreen);
            }
        });

        TextButton btnHistoria = new TextButton("Historia", skin);
        btnHistoria.setBounds(500, 230, 70, 30);
        btnHistoria.setColor(Color.PINK);
        btnHistoria.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.history);
            }
        });
        TextButton btnItems = new TextButton("Items", skin);
        btnItems.setBounds(425, 315, 70, 25);
        btnItems.setColor(Color.PINK);
        btnItems.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.item);
            }
        });

        stage.addActor(btnJugar);
        stage.addActor(btnHistoria);
        stage.addActor(btnItems);


    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta){
        if(GameOver.music.isPlaying())
            GameOver.music.stop();
        music = MyGdxGame.manager.get("audio/music/SakuraCC_Op.mp3", Music.class);
        music.setLooping(true);
        music.play();
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture,0,0,MyGdxGame.V_WIDTH*MyGdxGame.PPM/65, MyGdxGame.V_HEIGHT*MyGdxGame.PPM/40);//Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }
}
