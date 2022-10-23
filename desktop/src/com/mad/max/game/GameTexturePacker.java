package com.mad.max.game;

import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class GameTexturePacker {
    //private static final String INPUT_DIR = Gdx.files.internal("assets/data/animations").toString();
    private static final String ANIMATION_INPUT_DIR = "animations/";
    private static final String ANIMATION_OUTPUT_DIR = "../assets/animations/";
    private static final String ANIMATION_PACK_FILE = "animations";

    private static final String TEXTURE_INPUT_DIR = "textures/";
    private static final String TEXTURE_OUTPUT_DIR = "../assets/textures/";
    private static final String TEXTURE_PACK_FILE = "textures";


    private static final float[] HUNDRED_PERCENT = new float[] {1f};
    private static final float[] FIFTY_PERCENT = new float[] {0.5f};

    public static void packAtlas(){
        // create the packing's settings
        Settings settings = new Settings();

        // adjust the padding settings
        settings.scale = HUNDRED_PERCENT;//FIFTY_PERCENT;
        settings.paddingX = 2;
        settings.paddingY = 2;
        settings.edgePadding = false;
        settings.maxWidth = 2048;//4096;
        settings.maxHeight = 2048;//4096;

        // pack the images
        settings.combineSubdirectories = true;
        TexturePacker.process(settings, ANIMATION_INPUT_DIR, ANIMATION_OUTPUT_DIR, ANIMATION_PACK_FILE);
        TexturePacker.process(settings, TEXTURE_INPUT_DIR, TEXTURE_OUTPUT_DIR, TEXTURE_PACK_FILE);
    }
}


