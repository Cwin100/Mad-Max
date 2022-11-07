package com.mad.max.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mad.max.game.managers.GridManager;
import com.mad.max.game.managers.ViewManager;

public class TextureUtil {
    private static GridManager gm = GridManager.get();


    public static TextureRegion solidTexture(Color color) {
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, 100, 100);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegion(texture);
    }

    public static TextureRegion gridTexture(Color backgroundColor, Color lineColor, int w, int h) {
        Gdx.app.log("GridTexture", "" + w + " " + h);

        Pixmap pixmap = new Pixmap(w, h, Pixmap.Format.RGBA8888);
        pixmap.setColor(backgroundColor);
        pixmap.fillRectangle(0, 0, w, h);

        pixmap.setColor(lineColor);
        for(int i = 0; i < w; i += gm.getWidth()){
            pixmap.fillRectangle(i-1, 0, 2, h);
        }
        for(int i = 0; i < h; i += gm.getHeight()){
            pixmap.fillRectangle(0, i-1, w, 2);
        }

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegion(texture);
    }

}
