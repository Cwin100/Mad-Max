package com.mad.max.game.screens.homescreen;

import com.badlogic.gdx.Gdx;
import com.mad.max.game.managers.ScreenManager;

public class TestButton extends HomeScreenButton {

    private static final ScreenManager sm = ScreenManager.get();
    private static final String text = "Test Button\nSecond Line";

    public TestButton(float x, float y) {
        super(text, x, y, () -> {
            Gdx.app.log("Test Button", "Clicked");
        });
    }
}
