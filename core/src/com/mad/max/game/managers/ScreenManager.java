package com.mad.max.game.managers;

import com.badlogic.gdx.Screen;

import java.util.HashMap;

/**
 * Created by barry on 12/8/15 @ 8:14 PM.
 */
public class ScreenManager {

    private static final ScreenManager manager = new ScreenManager();
    public static ScreenManager get(){
        return manager;
    }

    public HashMap<String, Screen> screens;
    private final boolean isCurrenScreenEnded = false;
    private Screen current = null;
    private String currentName = null;

    ScreenManager() {
        screens = new HashMap<>();
    }

    public void addScreen(String screenName, Screen screen) {
        screens.put(screenName, screen);
        if(current == null){
            current = screen;
            currentName = screenName;
        }
    }

    public void setCurrent(String screenName) {
        Screen newScreen = screens.get(screenName);
        if(newScreen != null){
            current = newScreen;
            currentName = screenName;
        }
    }

    public String getCurrentName(){
        return currentName;
    }

    public Screen getCurrent() {
        return current;
    }
}
