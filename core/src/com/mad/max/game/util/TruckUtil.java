package com.mad.max.game.util;

import com.badlogic.gdx.graphics.Color;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.entity.room.EmptyRoom;
import com.mad.max.game.ecs.entity.room.Room;
import com.mad.max.game.ecs.entity.room.SystemRoom;
import com.mad.max.game.managers.AssetLoader;

import java.util.ArrayList;
import java.util.List;

public class TruckUtil {

    public static class TruckConfig{
        public int truckGridWidth = 20;
        public int truckGridHeight = 6;
        public Color truckColor = Color.LIGHT_GRAY;
        public List<Room> rooms = new ArrayList<>();
    }

    public static TruckConfig testTruck1(){
        TruckConfig config = new TruckConfig();

        config.rooms.add(new EmptyRoom(0, 0, 3, 3, Color.GRAY, GraphicComponent.Layer.Room));
        config.rooms.add(new SystemRoom(0, 3, 3, 3, Color.GRAY, AssetLoader.ARTILLERY_PATH, GraphicComponent.Layer.Room));
        config.rooms.add(new SystemRoom(3, 3, 2, 2, Color.GRAY, AssetLoader.BATTERY_PATH, GraphicComponent.Layer.Room));
        config.rooms.add(new SystemRoom(3, 1, 2, 2, Color.GRAY, AssetLoader.DOOR_PATH, GraphicComponent.Layer.Room));
        config.rooms.add(new EmptyRoom(5, 0, 3, 3, Color.GRAY, GraphicComponent.Layer.Room));
        config.rooms.add(new EmptyRoom(5, 3, 3, 3, Color.GRAY, GraphicComponent.Layer.Room));

        return config;
    }

    public static TruckConfig testTruck2(){
        TruckConfig config = new TruckConfig();

        return config;
    }

}
