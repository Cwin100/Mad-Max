package com.mad.max.game.ecs.entity.actors;

import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.GridComponent;
import com.mad.max.game.managers.GridManager;

public class GridActor extends Actor {

    protected static GridManager gm = GridManager.get();

    public GridActor(float x, float y, float gw, float gh, Texture texture, GraphicComponent.Layer layer){
        super(x, y, gw * gm.getWidth(), gh * gm.getHeight(), texture, layer);
        this.addMovement(new GridComponent(this));
    }

}
