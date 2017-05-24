package com.sakuraxx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by karen on 21/05/2017.
 */
public class Menu extends Ventana {
    private Stage stage;
    private Skin skin;
    private TextButton btnJugar, btnHistoria,btnItems;
    private Texture texture;
    private TextureRegion textureRegion;
    //private Image principal;
   // private SpriteBatch batch;
    //private Sprite sprite;
   // private Table table;

    public Menu(final MyGdxGame game) {
        super(game);
        stage = new Stage(new FitViewport(600,450));
        skin = new Skin(Gdx.files.internal("core/assets/skin/uiskin.json"));

        btnJugar = new TextButton("Jugar", skin);
        btnJugar.setBounds(135,65,300,60);
        btnJugar.setColor(Color.MAGENTA);
        btnJugar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.gameScreen);
            }
        });

        btnHistoria = new TextButton("Historia", skin);
        btnHistoria.setBounds(500,230,70,30);
        btnHistoria.setColor(Color.PINK);
        btnHistoria.addCaptureListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                game.setScreen(game.history);
            }
        });
        btnItems = new TextButton("Items", skin);
        btnItems.setBounds(425,315,70,25);
        btnItems.setColor(Color.PINK);
        btnItems.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.item);
            }
        });

        //principal = new Image(game.getManager().get("core/assets/cartas.jpg",Texture.class));

        /*
        table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center|Align.top);
        table.setPosition(0,Gdx.graphics.getHeight());
        table.pad(100);
        table.add(btnJugar).padBottom(10);
        table.row();
        table.add(btnHistoria);
        table.row();
        table.add(btnItems);*/

        stage.addActor(btnJugar);
        stage.addActor(btnHistoria);
        stage.addActor(btnItems);
        // stage.addActor(table);

       /* batch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("core/assets/SAKURA.jpg")));
        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());*/
    }

    @Override
    public void show(){


        Gdx.input.setInputProcessor(stage);

        //btnJugar.setPosition(300,150);

       /* final Dialog dialog = new Dialog("Star!",skin);

        btnJugar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                dialog.show(stage); //al hacer click en el boton aparece un mensaje ("Star!")
            }
        });*/
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        /*batch.begin();
        sprite.draw(batch);
        batch.end();*/


    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
