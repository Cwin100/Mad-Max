package com.mad.max.game.ecs.entity.truck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarriedComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;
import com.mad.max.game.ecs.entity.actors.GridActor;
import com.mad.max.game.ecs.entity.room.Room;
import com.mad.max.game.managers.GridManager;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.util.TextureUtil;
import com.mad.max.game.util.TruckUtil;

public class Truck extends GridActor {
    protected static final GridManager gm = GridManager.get();
    private static final Color GRID_COLOR = Color.BLACK;

    public ScreenManager sm = ScreenManager.get();


    public Truck(float gx, float gy, TruckUtil.TruckConfig config) {
        super(gm.getWidth() * gx, gm.getHeight() * gy, config.truckGridWidth, config.truckGridHeight, TextureUtil.gridTexture(config.truckColor, GRID_COLOR, config.truckGridWidth * gm.getWidth(), config.truckGridHeight * gm.getHeight()), GraphicComponent.Layer.Truck);
        this.addMovement(new CarryMoveComponent(this));
        this.init_truck(config);
    }

    private void init_truck(TruckUtil.TruckConfig config) {
        for(Room room: config.rooms){
            room.addToTruck(this);
            sm.getScreen("gameScreen").addEntity(room);
        }
    }

}
