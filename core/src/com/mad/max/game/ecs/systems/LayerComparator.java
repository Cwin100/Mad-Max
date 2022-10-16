package com.mad.max.game.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.mad.max.game.ecs.components.GraphicComponent;

import java.util.Comparator;

public class LayerComparator implements Comparator<Entity> {
    private final ComponentMapper<GraphicComponent> graphicM;

    public LayerComparator() {
        graphicM = ComponentMapper.getFor(GraphicComponent.class);
    }

    @Override
    public int compare(Entity entityA, Entity entityB) {
        return graphicM.get(entityA).layer.compareTo(graphicM.get(entityB).layer);
    }
}
