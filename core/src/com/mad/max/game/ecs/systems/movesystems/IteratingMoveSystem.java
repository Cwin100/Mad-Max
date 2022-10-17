package com.mad.max.game.ecs.systems.movesystems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;

public abstract class IteratingMoveSystem extends IteratingSystem {

    protected final ComponentMapper<CarryMoveComponent> carryM = ComponentMapper.getFor(CarryMoveComponent.class);
    protected final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);

    public IteratingMoveSystem(Family family) {
        super(family);
    }

    @Override
    protected final void processEntity(Entity entity, float deltaTime) {
        CarryMoveComponent carrier = carryM.get(entity);
        TransformComponent transform = transformM.get(entity);

        Vector2 moveDelta = calculateMoveDelta(entity, deltaTime);
        transform.position.add(moveDelta);
        if (carrier != null){
            carrier.carriedEntities.forEach((e)->{
                TransformComponent t = transformM.get(e);
                t.position.add(moveDelta);
            });
        }
    }

    abstract Vector2 calculateMoveDelta(Entity entity, float deltaTime) ;
}
