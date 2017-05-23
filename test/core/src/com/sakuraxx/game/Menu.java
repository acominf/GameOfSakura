package com.sakuraxx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

/**
 * Created by karen on 21/05/2017.
 */
public class Menu extends Ventana {
    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private Sprite sprite;
   // private Table table;

    public Menu(MyGdxGame g) {
        super(g);
    }

    @Override
    public void show(){
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("core/assets/skin/uiskin.json"));

        TextButton btnJugar = new TextButton("Jugar", skin);
        btnJugar.setPosition(150,100);
        TextButton btnHistoria = new TextButton("Historia", skin);
        btnHistoria.setPosition(500,230);
        TextButton btnItems = new TextButton("Items", skin);
        btnItems.setPosition(435,315);

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

        batch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("core/assets/SAKURA.jpg")));
        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

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

        batch.begin();
        sprite.draw(batch);
        batch.end();

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
