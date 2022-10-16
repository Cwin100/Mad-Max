package com.mad.max.game.screens.homescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mad.max.game.ecs.entity.ButtonEntity;
import com.mad.max.game.managers.AssetLoader;
import com.mad.max.game.managers.ScreenManager;

public class HomeScreenButton extends ButtonEntity {

    public HomeScreenButton(String text, float x, float y, Runnable action) {
        super(text, x, y, 1500, 200, action, createOptions());
    }

    private static ButtonOptions createOptions(){
        ButtonOptions options = new ButtonOptions();
        options.backgroundColor = Color.WHITE;
        options.centerOnPoint = true;
        return options;
    }
}
