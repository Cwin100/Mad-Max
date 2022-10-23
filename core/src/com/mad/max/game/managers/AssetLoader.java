package com.mad.max.game.managers;

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

    public static AssetManager am;

    public static AssetManager load() {

        splashScreen = new TextureRegion(new Texture("badlogic.jpg"));

        am = new AssetManager();
        am.load(ANI_ATLAS, TextureAtlas.class);
        am.load(TEXTURE_ATLAS, TextureAtlas.class);
        //am.load(FONT, BITMAP_FONT);

        return am;
    }

    //public static Array<TextureAtlas.AtlasRegion> getPuffinArray() {
    //    return am.get(ANI_ATLAS, TEXTURE_ATLAS).findRegions("puffin/puffin");
    //}

    //public static Array<TextureAtlas.AtlasRegion> getPuffinRunArray() {
    //    return am.get(ANI_ATLAS, TEXTURE_ATLAS).findRegions("puffin/runnin");
    //}

    public static Texture getTexture(String textureID){
        return am.get(TEXTURE_ATLAS, TextureAtlas.class).findRegions(textureID).first().getTexture();
    }

    //Icons
    public static final String ARTILLERY_ICON = "room_icons/ArtilleryBeamSymbol";
    public static final String BATTERY_ICON = "room_icons/BackupBatterySymbol";
    public static final String CLOAK_ICON = "room_icons/CloakingSymbol";
    public static final String CLONE_BAY_ICON = "room_icons/CloneBaySymbol";
    public static final String TELEPORT_ICON = "room_icons/CrewTeleporterSymbol";
    public static final String DOOR_ICON = "room_icons/DoorSystemSymbol";
    public static final String DRONE_ICON = "room_icons/DroneControlSymbol";
    public static final String ENGINES_ICON = "room_icons/EnginesSymbol";
    public static final String HACKING_ICON = "room_icons/HackingSymbol";
    public static final String MEDBAY_ICON = "room_icons/MedbaySymbol";
    public static final String MIND_CONTROL_ICON = "room_icons/MindControlSymbol";
    public static final String OXYGEN_ICON = "room_icons/OxygenSymbol";
    public static final String PILOT_ICON = "room_icons/PilotSymbol";
    public static final String SENSORS_ICON = "room_icons/SensorsSymbol";
    public static final String SHIELDS_ICON = "room_icons/ShieldsSymbol";
    public static final String WEAPONS_ICON = "room_icons/WeaponControlSymbol";

    public static final FileHandle LEMON_MILK_FONT_PATH = new FileHandle("fonts/LEMONMILK-Regular.otf");

    private static final String FONT = "fonts/courier-new-bold-32.fnt";
    private static final String ANI_ATLAS = "animations/animations.atlas";
    private static final String TEXTURE_ATLAS = "textures/textures.atlas";
    public static TextureRegion splashScreen;
}
