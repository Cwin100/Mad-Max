package com.mad.max.game.ecs.entity.room;

import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.entity.actors.GridActor;

public abstract class Room extends GridActor {
    public Room(int gx, int gy, float gw, float gh, Texture texture, GraphicComponent.Layer layer) {
        super(gm.getWidth() * gx, gm.getHeight() * gy, gw, gh, texture, layer);
    }
}
