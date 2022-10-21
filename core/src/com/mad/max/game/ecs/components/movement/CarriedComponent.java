package com.mad.max.game.ecs.components.movement;

import com.badlogic.ashley.core.Entity;
import com.mad.max.game.ecs.entity.actors.Actor;

public class CarriedComponent implements MoveComponent{

    Actor carrierEntity = null;
    Actor carriedEntity;

    public CarriedComponent(Actor carried){
        this.carriedEntity = carried;
    }
    public CarriedComponent(Actor carried, Actor carrier){
        this.carriedEntity = carried;
        setCarrier(carrier);
    }

    public void setCarrier(Actor carrier){
        //Remove old carrier
        if(this.carrierEntity != null){
            CarryMoveComponent carryMove = (CarryMoveComponent) this.carrierEntity.getMovement(CarryMoveComponent.class);
            if (carryMove != null) {
                carryMove.carriedEntities.remove(carriedEntity);
            }
        }

        //Add new carrier
        this.carrierEntity = carrier;
        if(this.carrierEntity != null){
            CarryMoveComponent carryMove = (CarryMoveComponent) this.carrierEntity.getMovement(CarryMoveComponent.class);
            if (carryMove != null) {
                carryMove.carriedEntities.add(carriedEntity);
            }
        }
    }

    public Actor getCarrier(){
        return carrierEntity;
    }

    public Actor getCarried(){
        return carriedEntity;
    }

}
