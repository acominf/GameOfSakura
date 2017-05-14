package com.sakuraxx.game;

import com.sakuraxx.game.MyGdxGame;

/**
 * Created by mendezrodriguez on 12/05/17.
 */
public class Persona extends MyGdxGame{
    private int x;
    private int y;
    public Persona(int posX, int posY){
        x = posX;
        y = posY;
    }
    void mover(char tecla){
        switch(tecla){
            case 'a':
                x++;
            case 'd':


        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
