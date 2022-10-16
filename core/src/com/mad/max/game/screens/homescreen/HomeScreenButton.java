package com.mad.max.game.screens.homescreen;

import com.badlogic.gdx.graphics.Color;
import com.mad.max.game.ecs.entity.ui.ButtonEntity;

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
