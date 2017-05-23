package com.sakuraxx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by karen on 21/05/2017.
 */
public class Menu extends Ventana {
    private Stage stage;
    private Skin skin;

    public Menu(MyGdxGame g) {
        super(g);
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("core/assets/uiskin.json"));

        TextButton button = new TextButton("Jugar", skin);
        button.setPosition(100,100);
        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);

    }

    /*@Override
    public void show(){
        Skin skin = new Skin(Gdx.files.internal("core/assets/skin/uiskin.json"));


    }*/

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
