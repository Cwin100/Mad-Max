package com.mad.max.game.ecs.entity.room;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.entity.actors.GridActor;
import com.mad.max.game.ecs.entity.truck.Truck;

public abstract class Room extends GridActor {

    boolean walled;
    public Room(int gx, int gy, int gw, int gh, TextureRegion texture, GraphicComponent.Layer layer) {
        super(gm.getWidth() * gx, gm.getHeight() * gy, gw, gh, texture, layer);
        this.addMovement(new CarryMoveComponent(this));
        walled = true;
    }

    public Room(int gx, int gy, int gw, int gh, TextureRegion texture, GraphicComponent.Layer layer, boolean walled) {
        super(gm.getWidth() * gx, gm.getHeight() * gy, gw, gh, texture, layer);
        this.addMovement(new CarryMoveComponent(this));
        this.walled = walled;
    }

    public abstract void addToTruck(Truck truck);
}
