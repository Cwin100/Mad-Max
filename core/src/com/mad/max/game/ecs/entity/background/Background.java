package com.mad.max.game.ecs.entity.background;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.managers.ViewManager;

public abstract class Background extends Entity {
    protected static ViewManager vm = ViewManager.get();
    private final GraphicComponent graphic;
    private final TransformComponent transform;

    public Background(Texture texture){
        this.graphic = new GraphicComponent();
        graphic.texture = texture;
        graphic.layer = GraphicComponent.Layer.Background;
        this.add(graphic);

        this.transform = new TransformComponent();
        transform.position.x = 0;
        transform.position.y = 0;
        transform.size.x = vm.getViewport().getWorldWidth();
        transform.size.y = vm.getViewport().getWorldHeight();
        this.add(transform);
    }

}
