package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by mendezrodriguez on 12/05/17.
 */
/*public abstract class Persona extends MyGdxGame {
    private int x;
    private int y;
    private int Inc = 10;
    private long time;
    private int width = Gdx.graphics.getWidth();
    public Persona(int posX, int posY){
        x = posX;
        y = posY;
    }
    public abstract void create();
    public abstract void mover();
    public int Velocidad(){
        float delta = Gdx.graphics.getDeltaTime();
        Inc *= delta;
        return Inc;
    }
    public int getX() {
        return x;
    }
    public void goRight() {
        if(x <= width-170){
            x += Inc;//Velocidad();
            System.out.println("Ancho = "+width+ " x =" + x);
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void goLeft() {
        if(x >= 0){
            x -= Inc;
            System.out.println(x);
        }
    }

    public boolean jump(){
        boolean salto = true;
        if(y < Gdx.graphics.getHeight()) {
            y += Inc;
            salto = true;
        }
        return salto;
    }
}*/