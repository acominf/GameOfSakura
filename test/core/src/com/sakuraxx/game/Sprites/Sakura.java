package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.sakuraxx.game.MyGdxGame;
import com.sakuraxx.game.Screens.Juego;

/**
 * Created by mendezrodriguez on 11/05/17.
 * Creado por Karen Daniela Bautista Matinez
 *          y Margarita Neftalí Méndez Rodríguez
 * Esta clase sera la que modulemos a el personaje de Sakura.
 */
public class Sakura extends Sprite {

    public enum State{ FALLING, JUMPING, STANDING, RUNNING};
    public State currentState;
    public State previusState;
    public World world;
    public Body b2body;

    private  TextureRegion sakuraStand;

    private Animation sakuraRun;
    private Animation sakuraJump;
    private boolean runningRight;
    private float stateTimer;


    public Sakura(World world, Juego screen){
        super(screen.getAtlas().findRegion("Camina"));
        this.world = world;
        currentState = State.STANDING;
        previusState = State.STANDING;
        stateTimer = 0;
        runningRight = true;


        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 0; i<5; i++){
            frames.add(new TextureRegion(super.getTexture(), i*100, 3, 100, 100));
        }
        sakuraJump = new Animation(0.1f, frames);
        frames.clear();
        // faltan coordenadas del salto igual a las de arriba.
        for(int i = 5; i<8; i++ )
            frames.add(new TextureRegion(getTexture(), 516+(i-5)*71, 0, 71, 96 ));

        sakuraRun = new Animation(0.1f, frames);

        defineSakura();

        sakuraStand = new TextureRegion(getTexture(), 765,0,71,96);



        setBounds(0,0,71/(MyGdxGame.PPM*3.5f), 96 / (MyGdxGame.PPM*3.5f));
        setRegion(sakuraStand);


    }

    /**
     * El metodo getFrame() es el que define las imagenes que se usaran segun el estado en el que se encuentre Sakura
     * @param deltha es el timepo de reaccion del dispositivo que este usando.
     * @return regresa un TextureRegion
     */
    public TextureRegion getFrame(float deltha){
        currentState = getState();
        TextureRegion region;
        switch (currentState){
            case JUMPING:
                region = (TextureRegion) sakuraJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = (TextureRegion) sakuraRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = sakuraStand;
                break;
        }
        if((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()){
            region.flip(true, false);
            runningRight = false;
        }
        else if((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()){
            region.flip(true, false);
            runningRight = true;
        }
        stateTimer = currentState == previusState ? stateTimer + deltha : 0;
        previusState = currentState;
        
        return region;
    }

    /**
     * El metodo getState() nos ayuda a saber si nuestro player esta corriendo, saltando, de pie o cayendo
     * @return Regresa el estado en el que se encuentra el player
     */
    public State getState() {
        if(b2body.getLinearVelocity().y > 0 || (b2body.getLinearVelocity().y < 0 && previusState == State.JUMPING))
            return State.JUMPING;
        else if(b2body.getLinearVelocity().y < 0)
            return State.FALLING;
        else if(b2body.getLinearVelocity().x != 0)
            return State.RUNNING;
        else
            return State.STANDING;
    }

    public void update(float deltha){
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2);
        setRegion(getFrame(deltha));
    }

    /**
     * Define las dimenciones de Sakura nuestra player
     */
    private void defineSakura() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(100/ MyGdxGame.PPM, 100/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(10/MyGdxGame.PPM);
        fdef.filter.categoryBits = MyGdxGame.Saku_bit;
        fdef.filter.maskBits = MyGdxGame.DEFAULT_BIT | MyGdxGame.BADCARD_BIT | MyGdxGame.GOODCARD_BIT;


        fdef.shape = shape;
        b2body.createFixture(fdef);

        fdef.shape = shape;
        b2body.createFixture(fdef);

        EdgeShape linea = new EdgeShape();
        linea.set(new Vector2(10/MyGdxGame.PPM, -10/MyGdxGame.PPM),new Vector2(10/MyGdxGame.PPM, 10/MyGdxGame.PPM));
        fdef.shape = linea;
        fdef.isSensor = true;

        b2body.createFixture(fdef).setUserData("linea");

    }

    public float getStateTimer(){
        return stateTimer;
    }

}
