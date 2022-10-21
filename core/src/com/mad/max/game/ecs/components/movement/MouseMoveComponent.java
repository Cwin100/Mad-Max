package com.mad.max.game.ecs.components.movement;

import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.entity.actors.TargetPosition;

public class MouseMoveComponent implements MoveComponent{

    public TargetPosition targetPosition;
    public float speed;

    public MouseMoveComponent(float speed){
        this.speed = speed;
    }
}
