package com.sakuraxx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by mendezrodriguez on 11/05/17.
 * Creado por Karen Daniela Bautista Matinez
 *          y Margarita Neftalí Méndez Rodríguez
 * Esta clase sera la que modulemos a el personaje de Sakura.
 */
public class Sakura extends Actor {

    private Texture sakura;
    private TextureRegion img;
    private Sprite sprite;

    Sakura(){
        sakura = new Texture(Gdx.files.internal("core/assets/sakura-1.png"));
        img = new TextureRegion(sakura, 130,0,165, 300);
        //setPosition(50, 50);
        setSize(165, 300);
        sprite = new Sprite(sakura, 130, 0, 165, 300);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(img, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        /*batch.draw(img, getX(), getY(),getWidth(), getHeight());
        batch.draw(img, 100,100, getWidth(), getHeight());*/
        Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a * parentAlpha);
        //batch.draw(img, getWidth(), getHeight());

        /*sprite.draw(batch, parentAlpha);
        //sprite.flip(true, false);
        sprite.setScale(.5f, .5f);
        //sprite.translate(.2f, 0);
        //sprite.split(img);
        sprite.isFlipX();
        //sprite.
*/


    }

    @Override
    public void act(float delta) {
        super.act(delta);
   
    }
    /*private Texture sakura;
    private Sprite img;
    private SpriteBatch batch;

    public Sakura(){
        super(100,20);
        sakura = new Texture(Gdx.files.internal("core/assets/sakura-1.png"));
        img = new Sprite(sakura, 130, 0, 165, 300);
        img.setPosition(super.getX(),super.getY());
    }
    @Override
    public void create(){
        // imagen de Sakura

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
        boolean bandera = false;
        if(input.isKeyPressed(Input.Keys.A)){
            super.goLeft();
        }
        else if(input.isKeyPressed(Input.Keys.D)){
            super.goRight();
        }
        else if (input.isKeyPressed(Input.Keys.SPACE)){
            bandera = super.jump();
        }
        if(bandera){
            super.setY(super.getY()-1);
        }

        img.setPosition(super.getX(), super.getY());
    }

    @Override
    public void dispose() {
        super.dispose();
        sakura.dispose();
    }*/
}
