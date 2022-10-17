package com.mad.max.game.managers;

import com.badlogic.ashley.core.Entity;

public class SelectionManager {

    private static final SelectionManager manager = new SelectionManager();
    public static SelectionManager get(){
        return manager;
    }

    private SelectionManager(){};

    Entity entity = null;

    public Entity getSelected(){
        return entity;
    }

    public void setSelected(Entity e){
        entity = e;
    }

}
