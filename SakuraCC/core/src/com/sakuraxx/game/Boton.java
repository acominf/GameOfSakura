package com.sakuraxx.game;

import com.badlogic.gdx.graphics.Texture;
import com.sakuraxx.game.MyGdxGame;

/**
 * Created by mendezrodriguez on 11/05/17.
 */
public class Boton extends MyGdxGame{
    private int x;
    private int y;
    private Texture img;
    private int tipo;
    private int color;
    private String enlace;

    public Boton(int posx, int posy, int t){
        x = posx;
        y = posy;
        tipo = t;
    }

    void presionar(boolean push){
        if(push){
            // abre otra pantalla para realizar lo deseado.
            // o se puede limpiar pantalla y poner lo que se realizara
            // una de las opciones seria Jugar, Ayuda, Historia, Items, Menu... etc.
        }
    }



}
