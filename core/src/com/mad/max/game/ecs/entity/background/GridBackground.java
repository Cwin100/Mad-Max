package com.mad.max.game.ecs.entity.background;

import com.badlogic.gdx.graphics.Color;
import com.mad.max.game.util.TextureUtil;

public class GridBackground extends Background {
    public GridBackground(Color backgroundColor, Color lineColor) {
        super(TextureUtil.gridTexture(backgroundColor, lineColor, (int) vm.getViewport().getWorldWidth(), (int) vm.getViewport().getWorldHeight()));
    }
}
