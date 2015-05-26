package com.pranavh.seventypercent;

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

    @Override
    public void dispose() {
        batch.dispose();
        flyAtlas.dispose();
        shapeRenderer.dispose();
    }

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

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        rectBLX = x;
        rectBLY = y;
        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        rectTRX = x;
        rectTRY = y;
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        return false;
    }
    @Override
    public boolean keyDown (int keycode) {
        return false;
    }

    @Override
    public boolean keyUp (int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped (char character) {
        return false;
    }
    @Override
    public boolean mouseMoved (int x, int y) {
        return false;
    }

    @Override
    public boolean scrolled (int amount) {
        return false;
    }
}
