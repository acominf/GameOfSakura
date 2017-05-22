package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by karen on 22/05/2017.
 */
public class BotonJugar extends Boton {

    public BotonJugar(int x, int y) {
        super(x, y);
        texture = new Texture(Gdx.files.internal("core/assets/corazon.jpg"));
    }

    @Override
    public void funcionamiento() {
        Ventanas.juego.setScreen(Ventanas.GameScreen);
    }
}
