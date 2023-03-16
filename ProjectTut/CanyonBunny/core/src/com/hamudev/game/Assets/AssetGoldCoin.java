package com.hamudev.game.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetGoldCoin {
    public final TextureAtlas.AtlasRegion goldCoin;

    public AssetGoldCoin(TextureAtlas atlas) {
        goldCoin = atlas.findRegion("item_gold_coin");
    }
}
