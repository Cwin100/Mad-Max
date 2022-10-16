package com.mad.max.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class KeyboardManager {

    private static final ViewManager vm = ViewManager.get();
    private static final KeyboardManager manager = new KeyboardManager();
    public static KeyboardManager get(){
        return manager;
    }

    private KeyboardManager(){};

    public boolean up(){
        return Gdx.input.isKeyPressed(Input.Keys.UP);
    }
    public boolean down(){
        return Gdx.input.isKeyPressed(Input.Keys.DOWN);
    }
    public boolean left(){
        return Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }
    public boolean right(){
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }

    public boolean w(){
        return Gdx.input.isKeyPressed(Input.Keys.W);
    }
    public boolean a(){
        return Gdx.input.isKeyPressed(Input.Keys.A);
    }
    public boolean s(){
        return Gdx.input.isKeyPressed(Input.Keys.S);
    }
    public boolean d(){
        return Gdx.input.isKeyPressed(Input.Keys.D);
    }




}
