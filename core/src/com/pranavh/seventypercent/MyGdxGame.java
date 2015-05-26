/**
 * The MyGdxGame clas controls the animation and movement of the game and responds to user input
 * @author Ashley Handoko, Pranav Harathi, Brandon Perry
 * Period: 3
 * Date: 5-26-15
 */

package com.pranavh.seventypercent;

//import statements
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import java.awt.Rectangle;


public class MyGdxGame extends ApplicationAdapter implements InputProcessor {

	//instantiate and declare variables
    private SpriteBatch batch;
    private TextureAtlas flyAtlas;
    private Animation animation;
    private float timePassed = 0;
    private int curX = 300;
    private int curY = 500;
    private int rectBLX = 0;
    private int rectBLY = 0;
    private int rectTRX = 0;
    private int rectTRY = 0;
    private ShapeRenderer shapeRenderer;

/*	Creates a new SpriteBatch and sets the animation of the fly*/
	@Override
	public void create () {
        batch = new SpriteBatch();

        flyAtlas = new TextureAtlas(Gdx.files.internal("flu.atlas"));
        // fraction is length of one frame in seconds
        animation = new Animation(1/30f, flyAtlas.getRegions());
        /* font.scale()?? */


        // User input
        Gdx.input.setInputProcessor(this);
        shapeRenderer = new ShapeRenderer();

	}

/*	Overrides the dispose method and disposes of the SpriteBatch, TextureAtlas, and shapeRenderer*/
    @Override
    public void dispose() {
        batch.dispose();
        flyAtlas.dispose();
        shapeRenderer.dispose();
    }

/*	Clears the screen and creates the rectangle according to coordinates of user*/
    @Override
	public void render () {
        // Clears screen with white color
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //speeds up drawing
        batch.begin();
        // 0,0 is bottom left in libgdx
        timePassed += Gdx.graphics.getDeltaTime();
        // true is looping, others are coords
        batch.draw(animation.getKeyFrame(timePassed, true), curX++ , curY++);
        if(rectBLX != rectTRX) {
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.rect(rectBLX, rectBLY, Math.abs(rectTRX-rectBLX),Math.abs(rectTRY-rectTRX));
            shapeRenderer.end();
        }

        batch.end();
	}

/*
 * Returns true when touched
 * @param x x coordinate of user touch
 * @param y y coordinate of uer touch
 * @param pointer counts how many touches to screen
 * @param button button on screen
 */	
    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        rectBLX = x;
        rectBLY = y;
        return true;
    }
    
/*
 * Returns true when screen is dragged
 * @param x x coordinate of user touch
 * @param y y coordinate of uer touch
 * @param pointer counts how many touches to screen
 */
    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        rectTRX = x;
        rectTRY = y;
        return true;
    }

/*
 * Returns true when touch is released
 * @param x x coordinate of user touch
 * @param y y coordinate of uer touch
 * @param pointer counts how many touches to screen
 * @param button button on screen
 */	
    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        return false;
    }
    
 /*
 * Returns false when key pressed
 * @param keycode key pressed
 */   
    @Override
    public boolean keyDown (int keycode) {
        return false;
    }

 /*
 * Returns false when key released
 * @param keycode key released
 */   
    @Override
    public boolean keyUp (int keycode) {
        return false;
    }

/*
 * Returns false when key typed
 * @param character characters typed by user
 */   
    @Override
    public boolean keyTyped (char character) {
        return false;
    }
    
    /*
     * Returns false when mouse is moved
     * @param x x cordinate of mouse
     * @param y y coordinate of mouse
     */   
    @Override
    public boolean mouseMoved (int x, int y) {
        return false;
    }

 /*
     * Returns false when scrolled
     * @param amount amount scrolled
     */   
    @Override
    public boolean scrolled (int amount) {
        return false;
    }
}
