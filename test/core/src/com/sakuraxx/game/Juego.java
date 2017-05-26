package com.sakuraxx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by mendezrodriguez on 24/05/17.
 */
public class Juego extends Ventana {

    private World mundo;
    private Stage escenario;
    private Sakura saku;
    private Box2DDebugRenderer box2DD; // va de la mano con el player

    private OrthographicCamera gamecam; // camara que centra al personaje
    private Viewport gamePort; // Sirve para que el juego no se distorcione
    private Hud hud;

    private World world;
    private Box2DDebugRenderer b2dr;


    private TmxMapLoader mapLoader; // es para el fondo
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public Juego(MyGdxGame game) {
        super(game);
        mundo = new World(new Vector2(0, -10), true);
        escenario = new Stage();
        saku = new Sakura();
        escenario.addActor(saku);
        saku.setScale(.5f, .5f);

        gamecam = new OrthographicCamera();
        gamePort = new FitViewport( MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        hud = new Hud(super.game.batch);

        mapLoader = new TmxMapLoader();
        //map = mapLoader.load("guapoFondo.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        gamecam.position.set(gamePort.getScreenWidth() /2, gamePort.getScreenHeight() /2 , 0);
        world = new World(new Vector2(0,0), true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef =new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;


    }
    @Override
    public void resize(int width, int height){
        gamePort.update(width, height);
    }
    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(0.2f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //super.game.batch.setProjectionMatrix(gamecam.combined);
        super.game.batch.setProjectionMatrix(hud.escenario.getCamera().combined);
        hud.escenario.draw();
        //renderer.render();
        //escenario.draw();
        //escenario.act();
        //saku.addAction(Actions.moveBy(.1f, .5f));
        //saku.scaleBy(.5f);ç
        SequenceAction seq = new SequenceAction();
        ParallelAction par = new ParallelAction();

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            saku.addAction(Actions.moveBy(10, saku.getY(), .1f));

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){

            seq.addAction(Actions.moveBy(0, 10, .8f));
            seq.addAction(Actions.moveBy(0, -10, 1));

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            seq.addAction(Actions.moveBy(-10, 0, .7f));
        }
        saku.addAction(seq);

        /*batch = new SpriteBatch();
        batch.begin();
        saku.draw(batch, 1);

        batch.end();*/

    }


    public void update(float deltha){
        handleInput(deltha);
        gamecam.update();
        renderer.setView(gamecam);
    }

    private void handleInput(float deltha) {
        if ( Gdx.input.isKeyPressed(Input.Keys.A))
            gamecam.position.x += 100 * deltha;
    }

}
