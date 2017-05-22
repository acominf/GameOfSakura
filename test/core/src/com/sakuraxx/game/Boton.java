package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

/**
 * Created by mendezrodriguez on 11/05/17.
 */
public abstract class Boton {
    protected Texture texture;
    protected Rectangle bordes;
    protected float xMin;
    protected float yMin;
    protected float xMax;
    protected float yMax;

    public Boton(int x, int y){
        Texture t = new Texture(Gdx.files.internal("core/assets/corazon.jpg"));
        bordes = new Rectangle(x, y, t.getWidth(), t.getHeight());

        xMin = x;
        yMax = Gdx.graphics.getHeight() - y;
        xMax = x + bordes.width;
        yMin = Gdx.graphics.getHeight() - (y + bordes.height);
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture,bordes.x, bordes.y, bordes.width, bordes.height);
    }

    public void update(){
        if(Click()){
            funcionamiento();
        }
    }

    private boolean Click(){
        return Gdx.input.isTouched() && Gdx.input.getX() >= xMin && Gdx.input.getX() <= xMax &&
                Gdx.input.getY() >= yMin && Gdx.input.getY() <= yMax;
    }

    public abstract void funcionamiento();

    public Rectangle getBordes(){
        return bordes;
    }
/*    private int x;
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
        Gdx.input.isCursorCatched();
        if(push){
            // abre otra pantalla para realizar lo deseado.
            // o se puede limpiar pantalla y poner lo que se realizara
            // una de las opciones seria Jugar, Ayuda, Historia, Items, Menu... etc.
        }
    }


*/
}
