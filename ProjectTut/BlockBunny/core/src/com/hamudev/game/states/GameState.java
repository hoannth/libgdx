package com.hamudev.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hamudev.game.BlockBunnyGame;
import com.hamudev.game.handlers.GameStateManager;

public abstract class GameState {

    protected GameStateManager gameStateManager;
    protected BlockBunnyGame game;

    protected SpriteBatch spriteBatch;
    protected OrthographicCamera camera;
    protected OrthographicCamera hudCamera;

    protected GameState(GameStateManager _gameStateManager) {
        this.gameStateManager = _gameStateManager;
        this.game = _gameStateManager.game();
        this.spriteBatch = game.getSpriteBatch();
        this.camera = game.getCamera();
        this.hudCamera = game.getHudCamera();
    }

    public abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render();
    public abstract void dispose();
}
