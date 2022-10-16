package com.mad.max.game.screens.homescreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mad.max.game.ecs.entity.ButtonEntity;
import com.mad.max.game.managers.ScreenManager;

public class StartButton extends HomeScreenButton {

    private static final ScreenManager sm = ScreenManager.get();
    private static final String text = "Start Game";

    public StartButton(float x, float y) {
        super(text, x, y, () -> {
            sm.setCurrent("gameScreen");
        });
    }
}
