package com.mad.max.game.ecs.components.movement;

import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.entity.actors.Actor;

public class KeyboardMoveComponent extends MoveComponent{

    public float speedX, speedY;
    public boolean wasd = true;
    public boolean arrows = false;

    public KeyboardMoveComponent(Actor owner, float speedX, float speedY){
        super(owner.transform);
        this.speedX = speedX;
        this.speedY = speedY;
    }

}
