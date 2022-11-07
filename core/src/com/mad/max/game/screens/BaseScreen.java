package com.mad.max.game.screens;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.managers.ViewManager;

public abstract class BaseScreen extends ScreenAdapter {

    protected final ViewManager vm = ViewManager.get();
    protected final ScreenManager sm = ScreenManager.get();
    final PooledEngine engine;
    protected final SpriteBatch batch;

    public BaseScreen(SpriteBatch batch) {
        this.batch = batch;
        this.engine = new PooledEngine();
    }

    @Override
    public void resize(int width, int height){
        vm.resize(width, height);
    }

    @Override
    public void render(float delta) {
        vm.startRender(batch);
        batch.begin();
        engine.update(delta);
        batch.end();
        vm.finishRender();
    }

    public void addEntity(Entity entity){
        this.engine.addEntity(entity);
    }

    public void removeEntity(Entity entity){
        this.engine.removeEntity(entity);
    }

    public void addSystem(EntitySystem system){
        this.engine.addSystem(system);
    }

    public abstract void init();

    public SpriteBatch getBatch() {
        return batch;
    }
}
