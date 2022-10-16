package com.mad.max.game.managers;

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

    public static final FileHandle LEMON_MILK_FONT_PATH = new FileHandle("fonts/LEMONMILK-Regular.otf");
    public static com.badlogic.gdx.assets.AssetManager am;

    public static com.badlogic.gdx.assets.AssetManager load() {

        loadSplash();

        am = new com.badlogic.gdx.assets.AssetManager();
        am.load(ANI_ATLAS, TEXTURE_ATLAS);
        //am.load(SPRITE_ATLAS, TEXTURE_ATLAS);
        //am.load(FONT, BITMAP_FONT);

        return am;
    }

    public static Array<TextureAtlas.AtlasRegion> getPuffinArray() {
        return am.get(ANI_ATLAS, TEXTURE_ATLAS).findRegions("puffin/puffin");
    }

    public static Array<TextureAtlas.AtlasRegion> getPuffinRunArray() {
        return am.get(ANI_ATLAS, TEXTURE_ATLAS).findRegions("puffin/runnin");
    }

    public static BitmapFont getCourierNewBoldFont() {
        return am.get(FONT, BITMAP_FONT);
    }

    private static void loadSplash() {
        splashScreen = new TextureRegion(new Texture("badlogic.jpg"));
    }

    private static final Class<TextureAtlas> TEXTURE_ATLAS = TextureAtlas.class;
    private static final Class<Music> MUSIC = Music.class;
    private static final Class<BitmapFont> BITMAP_FONT = BitmapFont.class;
    private static final Class<Sound> SOUND = Sound.class;

    private static final String FONT = "fonts/courier-new-bold-32.fnt";
    private static final String ANI_ATLAS = "animations/animations.atlas";
    private static final String SPRITE_ATLAS = "sprites/sprites.atlas";

    public static TextureRegion splashScreen;
}
