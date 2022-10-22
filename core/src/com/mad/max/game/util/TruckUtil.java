package com.mad.max.game.util;

import com.mad.max.game.ecs.entity.room.Room;

import java.util.ArrayList;
import java.util.List;

public class TruckUtil {


    public static class TruckConfig{
        List<Room> rooms = new ArrayList<>();
    }

    public static TruckConfig testTruck1(){
        TruckConfig config = new TruckConfig();

        return config;
    }

    public static TruckConfig testTruck2(){
        TruckConfig config = new TruckConfig();

        return config;
    }

}
