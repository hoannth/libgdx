package com.hamudev.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.hamudev.game.objects.Level;
import com.hamudev.game.util.CameraHelper;
import com.hamudev.game.util.Constants;

public class WorldController extends InputAdapter {
    private static final String TAG = WorldController.class.getName();

    public CameraHelper cameraHelper;

    public Level level;
    public int lives;
    public int scores;

    public WorldController() {
        init();
    }

    private void init() {
        Gdx.input.setInputProcessor(this);
        cameraHelper = new CameraHelper();
        lives = Constants.LIVES_START;
        initLevel();
    }

    private void initLevel() {
        scores = 0;
        level = new Level(Constants.LEVEL_01);
    }

    public void update(float deltaTime) {
        handleInputObjects(deltaTime);
        level.update(deltaTime);
        cameraHelper.update(deltaTime);
    }

    @Override
    public boolean keyUp(int keycode) {
        // Reset game world
        if (keycode == Input.Keys.R) {
            init();
            Gdx.app.debug(TAG, "Game world resetted");
        }
        return false;
    }

    private void handleInputObjects(float dealtaTime) {
        if(Gdx.app.getType() != Application.ApplicationType.Desktop)
            return;

        float camMoveSpeed = 5 * dealtaTime;
        float camMoveSpeedAccelerationFactor = 5;
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
            camMoveSpeed *= camMoveSpeedAccelerationFactor;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            moveCamera(-camMoveSpeed, 0);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            moveCamera(camMoveSpeed, 0);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            moveCamera(0, camMoveSpeed);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            moveCamera(0, -camMoveSpeed);
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            cameraHelper.setPosition(0, 0);

        float camZoomSpeed = 1 * dealtaTime;
        float camZoomSpeedAccelerationFactor = 5;
        if (Gdx.input.isKeyPressed(Input.Keys.V)) {
            camZoomSpeed *= camZoomSpeedAccelerationFactor;
            Gdx.app.debug(TAG, "camZoomSpeed = " + camZoomSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            Gdx.app.debug(TAG, "set Zoom = " + camMoveSpeed);
            cameraHelper.addZoom(camZoomSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            Gdx.app.debug(TAG, "set Zoom = -" + camMoveSpeed);
            cameraHelper.addZoom(-camZoomSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.C)) {
            Gdx.app.debug(TAG, "set Zoom = 1");
            cameraHelper.setZoom(1);
        }
    }

    private void moveCamera(float x, float y) {
        x += cameraHelper.getPosition().x;
        y += cameraHelper.getPosition().y;
        cameraHelper.setPosition(x, y);
    }

    private Pixmap createPixmap(int with, int height) {
        Pixmap pixmap = new Pixmap(with, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();

        pixmap.setColor(1, 1, 0, 1);
        pixmap.drawLine(0, 0, with, height);
        pixmap.drawLine(with, 0, 0, height);

        pixmap.setColor(0, 1, 1, 1);
        pixmap.drawRectangle(0, 0, with, height);

        return pixmap;
    }
}