package com.mad.max.game.ecs.entity.room;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarriedComponent;
import com.mad.max.game.ecs.entity.truck.Truck;
import com.mad.max.game.util.TextureUtil;



public class EmptyRoom extends Room{

    private static final Color GRID_COLOR = Color.BLACK;

    public EmptyRoom(int gx, int gy, int gw, int gh, Color roomColor, GraphicComponent.Layer layer) {
        super(gx, gy, gw, gh, TextureUtil.gridTexture(roomColor, GRID_COLOR, gw * gm.getWidth(), gh * gm.getHeight()), layer);
    }

    public EmptyRoom(int gx, int gy, int gw, int gh, Color roomColor, GraphicComponent.Layer layer, boolean walled) {
        super(gx, gy, gw, gh, TextureUtil.gridTexture(roomColor, GRID_COLOR, gw * gm.getWidth(), gh * gm.getHeight()), layer, walled);
    }

    @Override
    public void addToTruck(Truck truck) {
        this.transform.position.add(truck.transform.position);
        this.addMovement(new CarriedComponent(this, truck));
    }
}
