package com.mad.max.game.ecs.components.movement;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;

public abstract class MoveComponent implements Component {

    protected TransformComponent pos = null;

    public MoveComponent(TransformComponent pos){
        this.pos = pos;
    }

    public void move(Vector2 delta){
        pos.position.add(delta);
    }

}
