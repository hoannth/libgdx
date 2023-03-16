package com.hamudev.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hamudev.game.BlockBunnyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = BlockBunnyGame.GAME_TITLE;
		config.width = BlockBunnyGame.V_WIDTH * BlockBunnyGame.SCALE;
		config.height = BlockBunnyGame.V_HEIGHT * BlockBunnyGame.SCALE;

		new LwjglApplication(new BlockBunnyGame(), config);
	}
}
