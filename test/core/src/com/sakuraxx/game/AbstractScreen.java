package com.sakuraxx.game;

import com.badlogic.gdx.Screen;

/**
 * Created by karen on 21/05/2017.
 */
public class AbstractScreen implements Screen {
    protected MyGdxGame main;

    public AbstractScreen(MyGdxGame main){
        this.main = main;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
