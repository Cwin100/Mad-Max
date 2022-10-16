package com.mad.max.game.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;
import com.mad.max.game.managers.KeyboardManager;
import com.mad.max.game.managers.MouseManager;

import java.util.List;

public class KeyboardMoveSystem extends MoveSystem {

    private final ComponentMapper<KeyboardMoveComponent> keyboardMoveM = ComponentMapper.getFor(KeyboardMoveComponent.class);
    private final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);

    private KeyboardManager mm = KeyboardManager.get();

    public KeyboardMoveSystem() {
        super(Family.all(KeyboardMoveComponent.class, TransformComponent.class).get());
    }

    protected void processEntities(Entity originalEntity, List<Entity> entities, float deltaTime) {
        TransformComponent transform = transformM.get(originalEntity);
        KeyboardMoveComponent kb = keyboardMoveM.get(originalEntity);

        if((mm.w() && kb.wasd) || (mm.up() && kb.arrows)){
            entities.forEach((e)->{
                TransformComponent t = transformM.get(e);
                t.position.y += kb.speedX;
            });
        }
        if((mm.s() && kb.wasd) || (mm.down() && kb.arrows)){
            entities.forEach((e)->{
                TransformComponent t = transformM.get(e);
                t.position.y -= kb.speedX;
            });
        }
        if((mm.a() && kb.wasd) || (mm.left() && kb.arrows)){
            entities.forEach((e)->{
                TransformComponent t = transformM.get(e);
                t.position.x -= kb.speedY;
            });
        }
        if((mm.d() && kb.wasd) || (mm.right() && kb.arrows)){
            entities.forEach((e)->{
                TransformComponent t = transformM.get(e);
                t.position.x += kb.speedY;
            });
        }
    }
}
