package com.mad.max.game.ecs.entity.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarriedComponent;
import com.mad.max.game.ecs.entity.truck.Truck;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.util.TextureUtil;


public class SystemRoom extends Room{

    private static final Color GRID_COLOR = Color.BLACK;

    private RoomIcon icon;

    public ScreenManager sm = ScreenManager.get();

    public SystemRoom(int gx, int gy, int gw, int gh, Color roomColor, String textureId, GraphicComponent.Layer layer) {
        super(gx, gy, gw, gh, TextureUtil.gridTexture(roomColor, GRID_COLOR, gw * gm.getWidth(), gh * gm.getHeight()), layer);
        icon = new RoomIcon((float)gx + (float)gw/2, (float)gy + (float)gh/2, textureId);
    }

    public SystemRoom(int gx, int gy, int gw, int gh, Color roomColor, String textureId, GraphicComponent.Layer layer, boolean walled) {
        super(gx, gy, gw, gh, TextureUtil.gridTexture(roomColor, GRID_COLOR, gw * gm.getWidth(), gh * gm.getHeight()), layer, walled);
        icon = new RoomIcon((float)gx + (float)gw/2, (float)gy + (float)gh/2, textureId);
    }

    @Override
    public void addToTruck(Truck truck) {
        this.transform.position.add(truck.transform.position);
        this.addMovement(new CarriedComponent(this, truck));

        Gdx.app.log("SystemRoom", "" + sm.getCurrent());
        sm.getScreen("gameScreen").addEntity(icon);
        icon.transform.position.add(truck.transform.position);
        icon.addMovement(new CarriedComponent(icon, truck));
    }
}
