package com.mad.max.game.ecs.entity.actors;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.MoveComponent;
import com.mad.max.game.ecs.components.TransformComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actor extends Entity {

    TransformComponent transform;
    GraphicComponent graphic;
    Map<Class<? extends MoveComponent>, MoveComponent> movement;

    public Actor(float x, float y, float w, float h, Texture texture, GraphicComponent.Layer layer){
        this.graphic = new GraphicComponent();
        graphic.texture = texture;
        graphic.layer = layer;
        this.add(graphic);

        this.transform = new TransformComponent();
        transform.position.x = x;
        transform.position.y = y;
        transform.size.x = w;
        transform.size.y = h;
        this.add(transform);

        this.movement = new HashMap<>();
    }

    public void addMovement(MoveComponent move){
        MoveComponent old = movement.put(move.getClass(), move);
        if(old != null){
            this.remove(move.getClass());
        }
        this.add(move);
    }

    public void removeMovement(MoveComponent move){
        movement.remove(move);
        this.remove(move.getClass());
    }

    public MoveComponent getMovement(Class<? extends MoveComponent> moveClass){
        return movement.get(moveClass);
    }

}
