package com.sakuraxx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.*;
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
        super(screen.getAtlas().findRegion("camina1"));
        this.world = world;
        currentState = State.STANDING;
        previusState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 1; i<4; i++){
            frames.add(new TextureRegion(getTexture(), i*70, 0, 70, 94));
        }
        sakuraRun = new Animation(0.1f, frames);
        // faltan coordenadas del salto igual a las de arriba.

        sakuraJump = new Animation(0.1f, frames);

        sakuraStand = new TextureRegion(getTexture(), 0,0,71,96);

        defineSakura();

        setBounds(0,0,71/(MyGdxGame.PPM*3.5f), 96 / (MyGdxGame.PPM*3.5f));
        setRegion(sakuraStand);


    }
    public TextureRegion getFrame(float deltha){
        currentState = getState();
        TextureRegion region;
        switch (currentState){
            case JUMPING:
                region = (TextureRegion) sakuraJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = (TextureRegion) sakuraJump.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = sakuraStand;
                break;
        }
        if((b2body.getLinearVelocity().x < 0 || !runningRight) && region.isFlipX()){
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

    private State getState() {
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
    }

    private void defineSakura() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(100/ MyGdxGame.PPM, 100/MyGdxGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();

        shape.setRadius(10/MyGdxGame.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }


    /*private Texture sakura;
    private TextureRegion img;
    private Sprite sprite;

    Sakura(){
        sakura = new Texture(Gdx.files.internal("core/assets/sakura-1.png"));
        img = new TextureRegion(sakura, 130,0,165, 300);
        //setPosition(50, 50);
        setSize(165, 300);
        sprite = new Sprite(sakura, 130, 0, 165, 300);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(img, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        /*batch.draw(img, getX(), getY(),getWidth(), getHeight());
        batch.draw(img, 100,100, getWidth(), getHeight());*/
       /* Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a * parentAlpha);
        //batch.draw(img, getWidth(), getHeight());

        /*sprite.draw(batch, parentAlpha);
        //sprite.flip(true, false);
        sprite.setScale(.5f, .5f);
        //sprite.translate(.2f, 0);
        //sprite.split(img);
        sprite.isFlipX();
        //sprite.



    }

    @Override
    public void act(float delta) {
        super.act(delta);
   
    }
    /*private Texture sakura;
    private Sprite img;
    private SpriteBatch batch;

    public Sakura(){
        super(100,20);
        sakura = new Texture(Gdx.files.internal("core/assets/sakura-1.png"));
        img = new Sprite(sakura, 130, 0, 165, 300);
        img.setPosition(super.getX(),super.getY());
    }
    @Override
    public void create(){
        // imagen de Sakura

    }
    public void render(){
        batch.begin();
        img.draw(batch);
        super.pause();
        batch.end();
    }
    public void dibujar(SpriteBatch batch){
        img.draw(batch);
        //batch.draw(sakura, 100, 100);
    }
    @Override
    public void mover(){
        boolean bandera = false;
        if(input.isKeyPressed(Input.Keys.A)){
            super.goLeft();
        }
        else if(input.isKeyPressed(Input.Keys.D)){
            super.goRight();
        }
        else if (input.isKeyPressed(Input.Keys.SPACE)){
            bandera = super.jump();
        }
        if(bandera){
            super.setY(super.getY()-1);
        }

        img.setPosition(super.getX(), super.getY());
    }

    @Override
    public void dispose() {
        super.dispose();
        sakura.dispose();
    }*/
}
