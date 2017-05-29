package com.sakuraxx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sakuraxx.game.MyGdxGame;
import com.sakuraxx.game.Sprites.BadCards;
import com.sakuraxx.game.Sprites.GoodCards;
import com.sakuraxx.game.Sprites.Sakura;
import com.sakuraxx.game.Scenes.Hud;
import com.sakuraxx.game.Tools.B2WorldCreator;
import com.sakuraxx.game.WorldContactListener;

/**
 * Created by mendezrodriguez on 24/05/17.
 */
public class Juego extends Ventana implements Screen{

    private TextureAtlas atlas;

    private MyGdxGame game;
    private World mundo;

    private Box2DDebugRenderer box2DD; // va de la mano con el player

    private OrthographicCamera gamecam; // camara que centra al personaje
    private Viewport gamePort; // Sirve para que el juego no se distorcione
    private Hud hud;

    // variables para el mapa
    private TmxMapLoader mapLoader; // es para el fondo
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private Sakura player;
    private static Music music;

    /**
     * En el constructor de Juego se inicializan todas las variables de la clase
     * y se determina dod ese encuentra el piso, plataformas y cartas buenas o malas.
     *
     * @param game
     */
    public Juego(MyGdxGame game) {
        super(game);


        atlas = new TextureAtlas("saku.pack");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport( MyGdxGame.V_WIDTH/MyGdxGame.PPM, MyGdxGame.V_HEIGHT/MyGdxGame.PPM, gamecam);
        hud = new Hud(super.game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("guapoFondo .tmx");

        renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM);
        gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2 , 0);

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
        for(MapObject object: map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            new BadCards(mundo, map, rect);
        }

        music = MyGdxGame.manager.get("audio/music/musicaJuego.mp3", Music.class);
        music.setLooping(true);
        music.stop();
        //music.play();

    }

    public static Music getMusic() {
        return music;
    }

    public static void setMusic(boolean a) {
        if(a)
            Juego.music.play();
        else
            Juego.music.stop();
    }

    public boolean gameOver(){
        if(player.currentState == Sakura.State.DEAD && player.getStateTimer() > 3){
            return true;
        }
        return false;
    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    /**
     * Redimenciona la viewPort que es lo que se puede ver del juego
     * @param width El ancho de la pantalla
     * @param height El alto de la pantalla
     */

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

    /**
     * Este metodo sirve para eliminar los recursos usados
     * Aunque java tiene un recogedor de basura, no funciona en automatico para los recursos almacendos en la tarjeta grafica
     * asi que es necesario eliminarlos manualmente.
     */

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
        Menu.music.pause();
        Juego.music.play();
        music.setVolume(.8f);
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

        if(gameOver()){
            game.setScreen(game.menu);
            dispose();
        }


    }

    /**
     * En este metodo carga lo que queremos cambiar del hud, que es el
     * @param deltha
     */
    public void update(float deltha){
        handleInput(deltha);

        mundo.step(1/60f, 6, 2);

        player.update(deltha);
        hud.update(deltha);
        gamecam.position.x = player.b2body.getPosition().x;

        gamecam.update();
        renderer.setView(gamecam);
    }

    /**
     * En este metodo se utiliza para mover al player
     * @param deltha el tiempo por frame
     */
    private void handleInput(float deltha) {
        if ( Gdx.input.isKeyJustPressed(Input.Keys.W)|| Gdx.input.isKeyJustPressed(Input.Keys.UP))
            player.b2body.applyLinearImpulse(new Vector2(0,4f), player.b2body.getWorldCenter(), true );
        else if ( Gdx.input.isKeyPressed(Input.Keys.D)||Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2)
            player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
        else if ( Gdx.input.isKeyPressed(Input.Keys.A)||Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2)
            player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
    }

}
