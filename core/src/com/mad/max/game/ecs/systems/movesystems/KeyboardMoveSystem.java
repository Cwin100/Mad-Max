package com.mad.max.game.ecs.systems.movesystems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;
import com.mad.max.game.managers.KeyboardManager;

public class KeyboardMoveSystem extends IteratingMoveSystem {

    private final ComponentMapper<KeyboardMoveComponent> keyboardMoveM = ComponentMapper.getFor(KeyboardMoveComponent.class);

    private KeyboardManager mm = KeyboardManager.get();

    public KeyboardMoveSystem() {
        super(Family.all(KeyboardMoveComponent.class, TransformComponent.class).get());
    }

    protected Vector2 calculateMoveDelta(Entity entity, float deltaTime) {
        TransformComponent transform = transformM.get(entity);
        KeyboardMoveComponent kb = keyboardMoveM.get(entity);
        Vector2 moveDelta = new Vector2(0, 0);

        if((mm.w() && kb.wasd) || (mm.up() && kb.arrows)){
            moveDelta.add(new Vector2(0, kb.speedY * deltaTime));
        }
        if((mm.s() && kb.wasd) || (mm.down() && kb.arrows)){
            moveDelta.add(new Vector2(0, -kb.speedY * deltaTime));
        }
        if((mm.a() && kb.wasd) || (mm.left() && kb.arrows)){
            moveDelta.add(new Vector2(-kb.speedX * deltaTime, 0));
        }
        if((mm.d() && kb.wasd) || (mm.right() && kb.arrows)){
            moveDelta.add(new Vector2(kb.speedX * deltaTime, 0));
        }

        return moveDelta;
    }
}
