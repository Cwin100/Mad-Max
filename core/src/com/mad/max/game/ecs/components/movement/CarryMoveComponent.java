package com.mad.max.game.ecs.components.movement;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.entity.actors.Actor;

import java.util.ArrayList;
import java.util.List;

public class CarryMoveComponent extends MoveComponent{

    public List<Actor> carriedEntities = new ArrayList<>();

    public CarryMoveComponent(Actor owner) {
        super(owner.transform);
    }

    @Override
    public void move(Vector2 delta) {
        carriedEntities.forEach((e)->{
            e.getMovement(CarriedComponent.class).move(delta);
        });
    }
}
