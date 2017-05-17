package com.sakuraxx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by mendezrodriguez on 11/05/17.
 * Creado por Karen Daniela Bautista Matinez
 *          y Margarita Neftalí Méndez Rodríguez
 * Esta clase sera la que modulemos a el personaje de Sakura.
 */
public class Sakura extends Persona {
    private Texture sakura;
    private Sprite img;
    private SpriteBatch batch;

    public Sakura(){
        super(100,20);
    }
    @Override
    public void create(){
        // imagen de Sakura
        sakura = new Texture(Gdx.files.internal("android/assets/sakura-1.png"));
        img = new Sprite(sakura, 130, 0, 165, 300);
        img.setPosition(super.getX(),super.getY());
    }
    public void render(){
        batch.begin();
        img.draw(batch);
        super.pause();
        batch.end();
    }
    public void dibujar(SpriteBatch batch){
        img.draw(batch);
        //batch.draw(sakura, 100, 100);
    }
    @Override
    public void mover(){
        if(input.isKeyPressed(Input.Keys.A)){
            super.goLeft();
        }
        else if(input.isKeyPressed(Input.Keys.D)){
            super.goRight();
        }
        else if (input.isKeyPressed(Input.Keys.SPACE)){
            super.jump();

        }

        img.setPosition(super.getX(), super.getY());
    }

    @Override
    public void dispose() {
        super.dispose();
        sakura.dispose();
    }
}
