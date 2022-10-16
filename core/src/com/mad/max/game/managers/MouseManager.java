package com.mad.max.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class MouseManager {

    private static final ViewManager vm = ViewManager.get();
    private static final MouseManager manager = new MouseManager();
    public static MouseManager get(){
        return manager;
    }

    private MouseManager(){};
    public Vector2 getPos(){
        return vm.getViewport().unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
    }

    public boolean leftClick(){
        return Gdx.input.isButtonJustPressed(Input.Buttons.LEFT);
    }

    public boolean rightClick(){
        return Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT);
    }

    public boolean leftHold(){
        return Gdx.input.isButtonPressed(Input.Buttons.LEFT);
    }

    public boolean rightHold(){
        return Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
    }
}
