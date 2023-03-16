package com.hamudev.game.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetFeather {
    public final TextureAtlas.AtlasRegion feather;

    public AssetFeather(TextureAtlas atlas) {
        feather = atlas.findRegion("item_feather");
    }
}
