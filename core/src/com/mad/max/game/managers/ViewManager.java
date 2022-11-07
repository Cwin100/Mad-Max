package com.mad.max.game.managers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ViewManager {


    private static final ViewManager manager = new ViewManager();
    private final OrthographicCamera camera;
    private final FitViewport viewport;

    public static final int WORLD_WIDTH = 3840;
    public static final int WORLD_HEIGHT = 2160;


    public static ViewManager get(){
        return manager;
    }

    private ViewManager(){
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH,  WORLD_HEIGHT, camera);
        viewport.apply();
    }

    public void resize(int width, int height) {
        viewport.update(width,height);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
    }

    public void startRender(Batch batch){
        ScreenUtils.clear(0, 0, 0, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    public void finishRender(){}

    public Viewport getViewport(){
        return viewport;
    }

    public Camera getCamera(){
        return camera;
    }

}
