package com.sakuraxx.game;

import com.badlogic.gdx.Screen;

/**
 * Created by karen on 22/05/2017.
 */
public abstract class Ventana implements Screen {

    protected MyGdxGame game;

    public Ventana(MyGdxGame g){
        this.game = g;
    }

    @Override
    public void render(float delta){

    }

    @Override
    public void resize(int width, int height){

    }

    @Override
    public void show(){

    }

    @Override
    public void hide(){

    }

    @Override
    public void pause(){

    }
    @Override
    public void  resume(){

    }
    @Override
    public void dispose(){

    }
}