package com.hamudev.game.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.hamudev.game.handlers.GameStateManager;

public class Play extends GameState {

    private BitmapFont font = new BitmapFont();

    public Play(GameStateManager gsm) {
        super(gsm);
    }

    public void handleInput() {

    }

    public void update(float deltaTime) {

    }

    public void render() {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        font.draw(spriteBatch, "Play State", 100, 100);

        spriteBatch.end();
    }

    public void dispose() {

    }
}

