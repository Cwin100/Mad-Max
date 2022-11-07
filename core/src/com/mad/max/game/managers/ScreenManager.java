package com.mad.max.game.managers;

import com.badlogic.gdx.Screen;
import com.mad.max.game.screens.BaseScreen;

import java.util.HashMap;

/**
 * Created by barry on 12/8/15 @ 8:14 PM.
 */
public class ScreenManager {

    private static final ScreenManager manager = new ScreenManager();
    public static ScreenManager get(){
        return manager;
    }

    public HashMap<String, BaseScreen> screens;
    private BaseScreen current = null;
    private String currentName = null;

    ScreenManager() {
        screens = new HashMap<>();
    }

    public void addScreen(String screenName, BaseScreen screen) {
        screens.put(screenName, screen);
        if(current == null){
            current = screen;
            currentName = screenName;
        }
        screen.init();
    }

    public void setCurrent(String screenName) {
        BaseScreen newScreen = screens.get(screenName);
        if(newScreen != null){
            current = newScreen;
            currentName = screenName;
        }
    }

    public String getCurrentName(){
        return currentName;
    }

    public BaseScreen getCurrent() {
        return current;
    }

    public BaseScreen getScreen(String screenName) {
        return screens.get(screenName);
    }
}
