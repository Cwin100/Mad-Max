package com.mad.max.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.managers.GridManager;
import com.mad.max.game.managers.ViewManager;

public class TextureUtil {
    private static GridManager gm = GridManager.get();


    public static Texture solidTexture(Color color) {
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, 100, 100);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

    public static Texture gridTexture(Color backgroundColor, Color lineColor, int w, int h) {
        Gdx.app.log("GridTexture", "" + w + " " + h);

        Pixmap pixmap = new Pixmap(w, h, Pixmap.Format.RGBA8888);
        pixmap.setColor(backgroundColor);
        pixmap.fillRectangle(0, 0, w, h);

        pixmap.setColor(lineColor);
        for(int i = 0; i < w; i += gm.getWidth()){
            pixmap.drawLine(i, 0, i, h);
            pixmap.drawLine(i-1, 0, i-1, h);
        }
        for(int i = 0; i < h; i += gm.getHeight()){
            pixmap.drawLine(0, h- i, w, h- i);
            pixmap.drawLine(0, h- i-1, w, h- i-1);
        }

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

}
