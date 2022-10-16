package com.mad.max.game.ecs.entity.background;

import com.badlogic.gdx.graphics.Color;
import com.mad.max.game.util.TextureUtil;

public class SolidBackground extends Background {
    public SolidBackground(Color color) {
        super(TextureUtil.solidTexture(color));
    }
}
