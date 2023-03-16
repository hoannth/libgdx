package com.hamudev.game.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetFonts {
    public final BitmapFont defaultNormal;

    public AssetFonts() {
        defaultNormal = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);
    }

    public void init(AssetManager assetManager) {

    }
}
