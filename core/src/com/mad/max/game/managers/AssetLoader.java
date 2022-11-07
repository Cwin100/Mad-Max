package com.mad.max.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by barry on 12/9/15 @ 11:17 PM.
 */
public class AssetLoader {

    public static void load() {

        splashScreen = new TextureRegion(new Texture("badlogic.jpg"));


        atlas = new TextureAtlas(Gdx.files.internal(TEXTURE_ATLAS));
        //am.load(ANI_ATLAS, TextureAtlas.class);
        //am.load(TEXTURE_ATLAS, TextureAtlas.class);
        //am.load(FONT, BITMAP_FONT);
    }

    //public static Array<TextureAtlas.AtlasRegion> getPuffinArray() {
    //    return am.get(ANI_ATLAS, TEXTURE_ATLAS).findRegions("puffin/puffin");
    //}

    //public static Array<TextureAtlas.AtlasRegion> getPuffinRunArray() {
    //    return am.get(ANI_ATLAS, TEXTURE_ATLAS).findRegions("puffin/runnin");
    //}

    public static TextureRegion getTexture(String textureID){
        Gdx.app.log("Here", textureID);
        return atlas.findRegion(textureID);
    }

    //Atlas
    static TextureAtlas atlas;

    //Icons
    public static final String ARTILLERY_PATH = "roomIcons/ArtilleryBeamSymbol";
    public static final String BATTERY_PATH = "roomIcons/BackupBatterySymbol";
    public static final String CLOAK_PATH = "roomIcons/CloakingSymbol";
    public static final String CLONE_BAY_PATH = "roomIcons/CloneBaySymbol";
    public static final String TELEPORT_PATH = "roomIcons/CrewTeleporterSymbol";
    public static final String DOOR_PATH = "roomIcons/DoorSystemSymbol";
    public static final String DRONE_PATH = "roomIcons/DroneControlSymbol";
    public static final String ENGINES_PATH = "roomIcons/EnginesSymbol";
    public static final String HACKING_PATH = "roomIcons/HackingSymbol";
    public static final String MEDBAY_PATH = "roomIcons/MedbaySymbol";
    public static final String MIND_CONTROL_PATH = "roomIcons/MindControlSymbol";
    public static final String OXYGEN_PATH = "roomIcons/OxygenSymbol";
    public static final String PILOT_PATH = "roomIcons/PilotSymbol";
    public static final String SENSORS_PATH = "roomIcons/SensorsSymbol";
    public static final String SHIELDS_PATH = "roomIcons/ShieldsSymbol";
    public static final String WEAPONS_PATH = "roomIcons/WeaponControlSymbol";

    public static final FileHandle LEMON_MILK_FONT_PATH = new FileHandle("fonts/LEMONMILK-Regular.otf");

    private static final String FONT = "fonts/courier-new-bold-32.fnt";
    private static final String ANI_ATLAS = "animations/animations.atlas";
    private static final String TEXTURE_ATLAS = "textures/textures.atlas";
    public static TextureRegion splashScreen;
}
