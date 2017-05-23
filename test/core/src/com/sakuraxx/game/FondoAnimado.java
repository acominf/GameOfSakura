package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by karen on 22/05/2017.
 */
public class FondoAnimado extends Ventana {

    private Texture dude;
    private TextureRegion dudeRegion;
    private TextureRegion [] dudeFrame;
    private Animation dudeAnimation;
    private float duracion = 0;

    private static final int Anchura = 600;
    private static final int Altura = 450;

    public FondoAnimado(MyGdxGame g) {
        super(g);
    }
    @Override
    public void show(){
        dude = new Texture("core/assets/Fnubes.jpg");
        dudeRegion = new TextureRegion(dude,Anchura,Altura);
        TextureRegion[][] temp = dudeRegion.split(Anchura/4, Altura);
        dudeFrame = new TextureRegion[temp.length * temp[0].length];
        int indice = 0;
        for(int i  = 0; i <temp.length; i++ ){
            for(int j = 0; j<temp[i].length; j++){
                dudeFrame[indice++] = temp[i][j];
            }
        }
        dudeAnimation = new Animation(0.2f,dudeFrame);

    }
    @Override
    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);

        duracion += delta;
        TextureRegion frame = (TextureRegion) dudeAnimation.getKeyFrame(duracion, true);
        game.batch.begin();
            game.batch.draw( frame,100,100);
        game.batch.end();
    }
}
