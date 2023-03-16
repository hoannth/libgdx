package com.hamudev.game.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetRock {
    public final TextureAtlas.AtlasRegion edge;
    public final TextureAtlas.AtlasRegion middle;

    public AssetRock(TextureAtlas atlas) {
        edge = atlas.findRegion("rock_edge");
        middle = atlas.findRegion("rock_middle");
    }
}
