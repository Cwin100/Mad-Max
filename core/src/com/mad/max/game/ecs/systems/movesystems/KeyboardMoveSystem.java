package com.mad.max.game.ecs.systems.movesystems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;
import com.mad.max.game.managers.KeyboardManager;

public class KeyboardMoveSystem extends IteratingSystem {

    private final ComponentMapper<KeyboardMoveComponent> keyboardMoveM = ComponentMapper.getFor(KeyboardMoveComponent.class);
    private final ComponentMapper<CarryMoveComponent> carryM = ComponentMapper.getFor(CarryMoveComponent.class);

    private KeyboardManager mm = KeyboardManager.get();

    public KeyboardMoveSystem() {
        super(Family.all(KeyboardMoveComponent.class).get());
    }

    protected void processEntity(Entity entity, float deltaTime) {
        KeyboardMoveComponent kb = keyboardMoveM.get(entity);
        CarryMoveComponent carry = carryM.get(entity);
        Vector2 delta = new Vector2();

        if((mm.w() && kb.wasd) || (mm.up() && kb.arrows)){
            delta.add(0, kb.speedY * deltaTime);
        }
        if((mm.s() && kb.wasd) || (mm.down() && kb.arrows)){
            delta.add(0, -kb.speedY * deltaTime);
        }
        if((mm.a() && kb.wasd) || (mm.left() && kb.arrows)){
            delta.add(-kb.speedX * deltaTime, 0);
        }
        if((mm.d() && kb.wasd) || (mm.right() && kb.arrows)){
            delta.add(kb.speedX * deltaTime, 0);
        }

        kb.move(delta);
        if(carry != null){
            carry.move(delta);
        }

    }
}
