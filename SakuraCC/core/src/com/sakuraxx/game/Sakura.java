package com.sakuraxx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import javafx.util.converter.PercentageStringConverter;

/**
 * Created by mendezrodriguez on 11/05/17.
 * Creado por Karen Daniela Bautista Matinez
 *          y Margarita Neftalí Méndez Rodríguez
 * Esta clase sera la que modulemos a el personaje de Sakura.
 */
public class Sakura extends Persona {
    public Texture sakura;

    public Sakura(){
        super(20,20);
    }
    @Override
    public void create(){
        // imagen de Sakura
        sakura = new Texture(Gdx.files.internal("android/assets/SAKURA.jpg"));
    }
    /*public void Right(){
        super.x += 20;
    }
    public void Left(){
        x += 20;
    }*/

}
