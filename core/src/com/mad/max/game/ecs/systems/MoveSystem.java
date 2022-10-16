package com.mad.max.game.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveSystem extends IteratingSystem {

    private final ComponentMapper<CarryMoveComponent> carryM = ComponentMapper.getFor(CarryMoveComponent.class);
    List<Entity> entities = new ArrayList<>();

    public MoveSystem(Family family) {
        super(family);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        CarryMoveComponent carrier = carryM.get(entity);
        entities.clear();
        entities.add(entity);
        if (carrier != null){
            entities.addAll(carrier.carriedEntities);
        }
        processEntities(entity, entities, deltaTime);
    }

    abstract void processEntities(Entity originalEntity, List<Entity> entity, float deltaTime) ;
}
