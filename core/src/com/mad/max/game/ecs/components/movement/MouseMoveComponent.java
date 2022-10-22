package com.mad.max.game.ecs.components.movement;

import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.entity.actors.Actor;
import com.mad.max.game.ecs.entity.actors.TargetPosition;

public class MouseMoveComponent extends MoveComponent{

    public TargetPosition targetPosition;
    public float speed;

    public MouseMoveComponent(Actor owner, float speed){
        super(owner.transform);
        this.speed = speed;
    }

}
