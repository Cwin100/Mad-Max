package com.mad.max.game.screens.homescreen;

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
