package com.mad.max.game.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class TextureUtil {

    public static Texture solidTexture(Color color) {
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, 100, 100);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

}
