package com.sakuraxx.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sakuraxx.game.MyGdxGame;


/**
 * Created by mendezrodriguez on 25/05/17.
 */
public class Hud implements Disposable{
    public Stage escenario;
    private Viewport viewport;
    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countDownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label marioLabel;   // wo a terminar cambiandole el nombre a esto.. alguien recuerdeme !!!

    public Hud(SpriteBatch batch){
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(MyGdxGame.V_HEIGHT, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        escenario = new Stage(viewport, batch);

        Table  table = new Table();
        table.top();
        table.setFillParent(true);

        countDownLabel = new Label(String.format("%03d", worldTimer), new LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1", new LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD", new LabelStyle(new BitmapFont(), Color.WHITE));
        marioLabel = new Label("SAKU", new LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countDownLabel).expandX();

        escenario.addActor(table);

    }

    @Override
    public void dispose() {
        escenario.dispose();
    }
}
