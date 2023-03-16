package com.hamudev.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.hamudev.game.Assets.Assets;

public class Game extends ApplicationAdapter {

	private static final String TAG = Game.class.getName();

	private WorldController worldController;
	private WorldRenderer worldRenderer;

	private boolean paused;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		Assets.instance.init(new AssetManager());

		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);

		paused = false;
	}

	@Override
	public void render () {
		if(!paused) {
			worldController.update(Gdx.graphics.getDeltaTime());

			Gdx.gl.glClearColor(1, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			worldRenderer.render();
		}
	}

	private void init() {

	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width, height);
	}

	@Override
	public void pause() {
		paused = true;
	}

	@Override
	public void resume() {
		Assets.instance.init(new AssetManager());
		paused = false;
	}

	@Override
	public void dispose() {
		Assets.instance.dispose();
		worldRenderer.dispose();
	}
}
