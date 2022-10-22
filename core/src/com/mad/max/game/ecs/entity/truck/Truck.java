package com.mad.max.game.ecs.entity.truck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;
import com.mad.max.game.ecs.entity.actors.GridActor;
import com.mad.max.game.managers.GridManager;
import com.mad.max.game.util.TextureUtil;
import com.mad.max.game.util.TruckUtil;

public class Truck extends GridActor {
    protected static final GridManager gm = GridManager.get();

    private static final int GRID_HEIGHT = 6;
    private static final int HEIGHT = GRID_HEIGHT * gm.getHeight() ;
    private static final int GRID_WIDTH = 20;
    private static final int WIDTH = GRID_WIDTH * gm.getWidth();

    private static final Color TRUCK_COLOR = Color.LIGHT_GRAY;
    private static final Color GRID_COLOR = Color.BLACK;


    public Truck(float gx, float gy, TruckUtil.TruckConfig config) {
        super(gm.getWidth() * gx, gm.getHeight() * gy, GRID_WIDTH, GRID_HEIGHT, TextureUtil.gridTexture(TRUCK_COLOR, GRID_COLOR, WIDTH, HEIGHT), GraphicComponent.Layer.Truck);
        this.addMovement(new CarryMoveComponent());
        this.init_truck(config);
    }

    private void init_truck(TruckUtil.TruckConfig config) {
        //TODO
    }


}
