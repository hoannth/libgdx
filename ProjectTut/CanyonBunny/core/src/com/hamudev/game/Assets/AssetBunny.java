package com.hamudev.game.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetBunny {
    public final TextureAtlas.AtlasRegion head;

    public AssetBunny(TextureAtlas atlas) {
        head = atlas.findRegion("bunny_head");
    }
}
