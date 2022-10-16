package com.mad.max.game.ecs.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.TextComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.managers.AssetLoader;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.managers.ViewManager;

public abstract class ButtonEntity extends Entity {

    private final GraphicComponent graphic;
    private final TransformComponent transform;
    private final TextComponent text;
    private final ClickComponent click;
    ViewManager vm = ViewManager.get();

    public ButtonEntity(String text, float x, float y, float w, float h, Runnable action, ButtonOptions options){
        if(options.centerOnPoint){
            x -= w/2;
            y -= h/2;
        }

        this.graphic = new GraphicComponent();
        graphic.texture = createSolidBackground(w, h, options.backgroundColor);
        graphic.layer = options.layer;
        this.add(graphic);

        this.transform = new TransformComponent();
        transform.position.x = x;
        transform.position.y = y;
        transform.size.x = w;
        transform.size.y = h;
        this.add(transform);

        this.text = new TextComponent();
        this.text.font = createBitmapFont(h / 1.1f / numLines(text), options.textColor);
        this.text.text = text;
        this.add(this.text);

        this.click = new ClickComponent();
        this.click.leftAction = action;
        this.add(this.click);
    }

    private static BitmapFont createBitmapFont(float h, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(AssetLoader.LEMON_MILK_FONT_PATH);

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) h;
        parameter.color = color;
        BitmapFont font12 = generator.generateFont(parameter);
        return font12;
    }

    private static Texture createSolidBackground(float w, float h, Color color) {
        Pixmap pixmap = new Pixmap((int) w, (int) h, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, (int) w, (int) h);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

    private static int numLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

    public static class ButtonOptions{
        public Color backgroundColor = Color.CLEAR;
        public GraphicComponent.Layer layer = GraphicComponent.Layer.MenuButton;
        public Color textColor = Color.BLACK;

        public boolean centerOnPoint = false;

    }

}
