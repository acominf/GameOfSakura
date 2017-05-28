package com.sakuraxx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sakuraxx.game.MyGdxGame;
import com.sakuraxx.game.Sprites.BadCards;
import com.sakuraxx.game.Sprites.Cards;
import com.sakuraxx.game.Sprites.GoodCards;
import com.sakuraxx.game.Sprites.Sakura;
import com.sakuraxx.game.Scenes.Hud;
import com.sakuraxx.game.Tools.B2WorldCreator;
import com.sakuraxx.game.Ventana;
import com.sakuraxx.game.WorldContactListener;

/**
 * Created by mendezrodriguez on 24/05/17.
 */
public class Juego extends Ventana implements Screen{

    private TextureAtlas atlas;

    private MyGdxGame game;
    private World mundo;

    private Box2DDebugRenderer box2DD; // va de la mano con el player
    private Sakura player;

    private OrthographicCamera gamecam; // camara que centra al personaje
    private Viewport gamePort; // Sirve para que el juego no se distorcione
    private Hud hud;

    // variables para el mapa
    private TmxMapLoader mapLoader; // es para el fondo
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public Juego(MyGdxGame game) {
        super(game);



        atlas = new TextureAtlas("saku.pack");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport( MyGdxGame.V_WIDTH/MyGdxGame.PPM, MyGdxGame.V_HEIGHT/MyGdxGame.PPM, gamecam);
        hud = new Hud(super.game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("guapoFondo .tmx");

        renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);
        //renderer.setView(new Matrix4(),0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gamecam.position.set(gamePort.getWorldWidth()/2 , gamePort.getWorldHeight()/2 , 0);

        mundo = new World(new Vector2(0, -10), true); // el vector hace la par de la gravedad
        // creamos nuestro jugador que es sakura
        player = new Sakura(mundo, this);
        box2DD = new Box2DDebugRenderer();
        mundo.setContactListener(new WorldContactListener());

        // crea los rectangulos de las coliciones del juego
        new B2WorldCreator(mundo, map);

        for(MapObject object: map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            new GoodCards(mundo, map, rect);
        }
        for(MapObject object: map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            new BadCards(mundo, map, rect);
        }



    }

    public TextureAtlas getAtlas(){
        return atlas;
    }
    @Override
    public void resize(int width, int height){
        gamePort.update(width, height);
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
        map.dispose();
        renderer.dispose();
        mundo.dispose();
        box2DD.dispose();
        hud.dispose();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //super.render(delta);
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        box2DD.render(mundo, gamecam.combined);

        super.game.batch.setProjectionMatrix(gamecam.combined);
        super.game.batch.begin();
        player.draw(super.game.batch);
        super.game.batch.end();
        //super.game.batch.setProjectionMatrix(hud.escenario.getCamera().combined);
        hud.escenario.draw();


    }


    public void update(float deltha){
        handleInput(deltha);

        mundo.step(1/60f, 6, 2);

        player.update(deltha);
        gamecam.position.x = player.b2body.getPosition().x;

        gamecam.update();
        renderer.setView(gamecam);
    }

    private void handleInput(float deltha) {
        if ( Gdx.input.isKeyJustPressed(Input.Keys.W)|| Gdx.input.isKeyJustPressed(Input.Keys.UP))
            player.b2body.applyLinearImpulse(new Vector2(0,4f), player.b2body.getWorldCenter(), true );
        else if ( Gdx.input.isKeyPressed(Input.Keys.D)||Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2)
            player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
        else if ( Gdx.input.isKeyPressed(Input.Keys.A)||Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2)
            player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);

            //gamecam.position.x -= 10 * deltha;
    }

}
