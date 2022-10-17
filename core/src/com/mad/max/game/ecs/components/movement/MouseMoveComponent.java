package com.mad.max.game.ecs.components.movement;

import com.badlogic.gdx.math.Vector2;

public class MouseMoveComponent implements MoveComponent{

    public Vector2 targetPosition;
    public float speed;

    public MouseMoveComponent(float speed){
        this.speed = speed;
    }
}
