package com.hamudev.game.handlers;

import com.hamudev.game.BlockBunnyGame;
import com.hamudev.game.states.GameState;
import com.hamudev.game.states.Play;

import java.util.Stack;

public class GameStateManager {

    private BlockBunnyGame game;
    private Stack<GameState> gameStates;

    public static final int PLAY = 912837;

    public GameStateManager(BlockBunnyGame game) {
        this.game = game;
        this.gameStates = new Stack<GameState>();
        pushState(PLAY);
    }

    public BlockBunnyGame game() {
        return game;
    }

    public void update(float deltaTime) {
        gameStates.peek().update(deltaTime);
    }

    public void render() {
        gameStates.peek().render();
    }

    public GameState getState(int state) {
        if(state == PLAY) {
            return new Play(this);
        }

        return null;
    }

    public void setState(int state) {
        popState();
        pushState(state);
    }

    public void pushState(int state) {
        gameStates.push(getState(state));
    }

    public void popState() {
        GameState _gameState = gameStates.pop();
        _gameState.dispose();
    }
}