package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

/**
 * Created by mendezrodriguez on 24/05/17.
 */
public class Juego extends Ventana {

    private Stage escenario;
    private Sakura saku;

    public Juego(MyGdxGame game) {
        super(game);
        escenario = new Stage();
        saku = new Sakura();
        escenario.addActor(saku);
        saku.setScale(.5f, .5f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        escenario.draw();
        escenario.act();

        //saku.addAction(Actions.moveBy(.1f, .5f));
        //saku.scaleBy(.5f);ç
        SequenceAction seq = new SequenceAction();
        ParallelAction par = new ParallelAction();

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            saku.addAction(Actions.moveBy(10, saku.getY(), .1f));

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){

            seq.addAction(Actions.moveBy(0, 10, .8f));
            seq.addAction(Actions.moveBy(0, -10, 1));
            //seq.addAction();
            //par.addAction(seq);
            /*if(Gdx.input.isKeyPressed(Input.Keys.D)){
                par.addAction(Actions.moveBy(5, -10, 1));
            }
            else if(Gdx.input.isKeyPressed(Input.Keys.A)){
                par.addAction(Actions.moveBy(-5, -10, 1));
            }
            else {
                par.addAction(Actions.moveBy(0, -10, 1));
            }*/

        }
        saku.addAction(seq);

        /*batch = new SpriteBatch();
        batch.begin();
        saku.draw(batch, 1);

        batch.end();*/

    }

}
