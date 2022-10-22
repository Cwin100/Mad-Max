package com.mad.max.game.ecs.components.movement;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.entity.actors.Actor;

public class CarriedComponent extends MoveComponent{

    Actor carrierEntity = null;
    Actor carriedEntity;

    public CarriedComponent(Actor owner){
        super(owner.transform);
        this.carriedEntity = owner;
    }
    public CarriedComponent(Actor owner, Actor carrier){
        this(owner);
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

    @Override
    public void move(Vector2 delta) {
        super.move(delta);
        if(this.carriedEntity.getMovement(CarryMoveComponent.class) != null){//move carrier components
            this.carriedEntity.getMovement(CarryMoveComponent.class).move(delta);
        }
    }
}
