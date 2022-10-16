package com.mad.max.game.ecs.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.TextComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.managers.ViewManager;

public class SolidBackgroundEntity extends Entity {
    private static ViewManager vm = ViewManager.get();
    private final GraphicComponent graphic;
    private final TransformComponent transform;

    public SolidBackgroundEntity(Color color){
        this.graphic = new GraphicComponent();
        graphic.texture = createSolidBackground(vm.getViewport().getWorldWidth(), vm.getViewport().getWorldHeight(), color);
        graphic.layer = GraphicComponent.Layer.Background;
        this.add(graphic);

        this.transform = new TransformComponent();
        transform.position.x = 0;
        transform.position.y = 0;
        transform.size.x = vm.getViewport().getWorldWidth();
        transform.size.y = vm.getViewport().getWorldHeight();
        this.add(transform);
    }

    private static Texture createSolidBackground(float w, float h, Color color) {
        Pixmap pixmap = new Pixmap((int) w, (int) h, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, (int) w, (int) h);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

}
