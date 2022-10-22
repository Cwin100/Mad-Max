package com.mad.max.game.ecs.components.movement;

import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.entity.actors.Actor;

public class GridComponent extends MoveComponent{

    public GridComponent(Actor owner) {
        super(owner.transform);
    }

}
