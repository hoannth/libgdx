package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	float posX, posY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setScale(0.5f);

		posX = Gdx.graphics.getWidth()/2 - sprite.getWidth()/2;
		posY = Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
		sprite.setPosition(posX, posY);

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
        sprite.setPosition(posX, posY);
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public boolean keyDown(int keycode) {
		float moveAmount = 1.0f;

		if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
			moveAmount = 10.0f;
		if(keycode == Input.Keys.LEFT)
			posX -= moveAmount;
		if(keycode == Input.Keys.RIGHT)
			posX += moveAmount;

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		if(button == Input.Buttons.LEFT) {
			posX = screenX - sprite.getWidth()/2;
			posY = Gdx.graphics.getHeight() - screenY - sprite.getHeight()/2;
		}
		if(button == Input.Buttons.RIGHT) {
			posX = Gdx.graphics.getWidth()/2 - sprite.getWidth()/2;
			posY = Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
		}

		return false;
	}

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
