package com.mad.max.game.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.managers.MouseManager;

public class ClickSystem extends IteratingSystem {

    private final ComponentMapper<ClickComponent> clickM = ComponentMapper.getFor(ClickComponent.class);
    private final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);

    private MouseManager mm = MouseManager.get();

    public ClickSystem() {
        super(Family.all(ClickComponent.class, TransformComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = transformM.get(entity);
        ClickComponent click = clickM.get(entity);

        if(click.leftAction != null && mm.leftClick()) {
            Rectangle boundary = new Rectangle(transform.position.x, transform.position.y, transform.size.x, transform.size.y);
            Vector2 mousePos = mm.getPos();
            System.out.println("" + mousePos + "|" + boundary);
            System.out.println(boundary.contains(mousePos));
            if (boundary.contains(mousePos)) {
                click.leftAction.run();
            }
        }
        if(click.rightAction != null &&mm.rightClick()) {
            Rectangle boundary = new Rectangle(transform.position.x, transform.position.y, transform.size.x, transform.size.y);
            Vector2 mousePos = mm.getPos();
            if (boundary.contains(mousePos)) {
                click.rightAction.run();
            }
        }
        //TODO add dragging
    }
}
