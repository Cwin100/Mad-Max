package com.mad.max.game.ecs.components.movement;

import com.badlogic.ashley.core.Entity;

import java.util.ArrayList;
import java.util.List;

public class CarryMoveComponent implements MoveComponent{

    public List<Entity> carriedEntities = new ArrayList<>();

}
