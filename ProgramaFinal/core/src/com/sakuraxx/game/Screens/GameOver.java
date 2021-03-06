package com.sakuraxx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by USER-PC on 28/05/2017.
 */
public class GameOver extends Ventana {
    private Viewport viewport;
    private Stage stage;
    private static Music music;
    public GameOver(final MyGdxGame game) {
        super(game);
        viewport = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((MyGdxGame) game).getBatch());

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.MAGENTA);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label GameOverLabel = new Label("GAME OVER", font);
        Label playAgainLabel = new Label("Click to play again", font);

        table.add(GameOverLabel).expandX();
        table.row();
        table.add(playAgainLabel).expandX().padTop(10f);
        setMusic(MyGdxGame.getManager().get("audio/music/73_Game_Over.mp3", Music.class));
        getMusic().setLooping(true);
        getMusic().stop();



        stage.addActor(table);
    }

    public static Music getMusic() {
        return music;
    }

    public static void setMusic(Music music) {
        GameOver.music = music;
    }

    @Override
    public void render(float delta){
        getMusic().play();
        if(Gdx.input.justTouched()){
            game.setScreen(new Juego(game));
            dispose();
        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose(){
        stage.dispose();
    }
}
