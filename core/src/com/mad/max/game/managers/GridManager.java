package com.mad.max.game.managers;

public class GridManager {

    public static final int GRID_WIDTH_PIXELS = 90;
    public static final int GRID_HEIGHT_PIXELS = 90;

    private static final GridManager manager = new GridManager();
    public static GridManager get(){
        return manager;
    }

    public int getWidth(){
        return GRID_WIDTH_PIXELS;
    }

    public int getHeight(){
        return GRID_HEIGHT_PIXELS;
    }
}
