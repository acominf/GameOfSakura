package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by karen on 24/05/2017.
 */
public class CarImage {

    public Texture t1,t2,t3;
    public TextureRegion tr1,tr2,tr3;

    public void cargarAssets(){
        t1 = new Texture(Gdx.files.internal("core/assets/SAKURA.jpg"));
        tr1 = new TextureRegion(t1,0,0,400,400);

        t2 = new Texture(Gdx.files.internal("core/assets/cartas.jpg"));
        tr2 = new TextureRegion(t2,0,0,100,180);

        t3 = new Texture(Gdx.files.internal("core/assets/Historia.jpg"));
        tr3 = new TextureRegion(t3,0,0,100,180);
    }

    public void disposeAssets(){
        t1.dispose();
        t2.dispose();
        t3.dispose();
    }

}
