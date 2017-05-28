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
import com.sakuraxx.game.Sprites.BadCards;


/**
 * Created by mendezrodriguez on 25/05/17.
 */
public class Hud implements Disposable{
    public Stage escenario;
    private Viewport viewport;
    private static Integer worldLife;
    private static float lifeCount;
    private static Integer score;

    private static Label countDownLabel;
    private static Label scoreLabel; //puntuacion que ah obtenido
    private Label lifeLabel; // vidas del player
    private Label levelLabel; // nivel en el que se encuentra
    private Label worldLabel; // Este Label solo dice World
    private Label sakurLabel;   // wo a terminar cambiandole el nombre a esto.. alguien recuerdeme !!!

    public Hud(SpriteBatch batch){
        worldLife = 3;
        lifeCount = 0;
        score = 0;

        viewport = new FitViewport(MyGdxGame.V_HEIGHT, MyGdxGame.V_HEIGHT, new OrthographicCamera());
        escenario = new Stage(viewport, batch);

        Table  table = new Table();
        table.top();
        table.setFillParent(true);

        countDownLabel = new Label(String.format("%01d", worldLife), new LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new LabelStyle(new BitmapFont(), Color.WHITE));
        lifeLabel = new Label("VIDAS", new LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1", new LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD", new LabelStyle(new BitmapFont(), Color.WHITE));
        sakurLabel = new Label("SAKURA", new LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(sakurLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(lifeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countDownLabel).expandX();

        escenario.addActor(table);

    }

    public void update(float deltha){
        if(BadCards.getTouch()){
            lessWorldLife();
            BadCards.setTouch(false);
        }
    }

    public static void lessWorldLife() { // esta tambien se agrega en donde imprimimos lo de colision pero aparte en donde se cae la player
        if(worldLife >= 1 ) {
            System.out.println(worldLife);
            worldLife -= 1;
            countDownLabel.setText(String.format("%01d", worldLife));
        }
    }
    public static void addScore(int value){ // se debe añadir en donde este el hit de cards (donde imprimimos collision)
        score += value;
        scoreLabel.setText(String.format("%06d", score));
    }

    @Override
    public void dispose() {
        escenario.dispose();
    }
}
