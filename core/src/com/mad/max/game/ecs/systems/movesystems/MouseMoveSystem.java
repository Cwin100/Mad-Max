 package com.mad.max.game.ecs.systems.movesystems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.CarriedComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.GridComponent;
import com.mad.max.game.ecs.components.movement.MouseMoveComponent;
import com.mad.max.game.ecs.entity.actors.TargetPosition;
import com.mad.max.game.ecs.systems.LayerComparator;
import com.mad.max.game.managers.GridManager;
import com.mad.max.game.managers.MouseManager;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.managers.SelectionManager;

import java.awt.geom.Line2D;

 public class MouseMoveSystem extends SortedIteratingSystem {

    private final ComponentMapper<MouseMoveComponent> mouseMoveM = ComponentMapper.getFor(MouseMoveComponent.class);
     private final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);
     private final ComponentMapper<GridComponent> gridM = ComponentMapper.getFor(GridComponent.class);
     private final ComponentMapper<CarriedComponent> carriedM = ComponentMapper.getFor(CarriedComponent.class);
     private final ComponentMapper<CarryMoveComponent> carryM = ComponentMapper.getFor(CarryMoveComponent.class);

     private MouseManager mm = MouseManager.get();
     private SelectionManager sm = SelectionManager.get();
     private GridManager gm = GridManager.get();
     private ScreenManager screenManager = ScreenManager.get();

    public MouseMoveSystem() {
        super(Family.all(MouseMoveComponent.class, TransformComponent.class).get(), new LayerComparator());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transform = transformM.get(entity);
        MouseMoveComponent mouseMove = mouseMoveM.get(entity);

        Rectangle boundary = new Rectangle(transform.position.x, transform.position.y, transform.size.x, transform.size.y);
        Vector2 mousePos = mm.getPos();

        if(mm.leftClick() && boundary.contains(mousePos)) {
            sm.setSelected(entity);
        }
        else if(mm.rightClick() && sm.getSelected() == entity) {
            Vector2 targetPos = mousePos;

            CarriedComponent carried = carriedM.get(entity);
            GridComponent grid = gridM.get(entity);
            if(grid != null){//Align to grid if it isn't already
                Vector2 offsetPixels = new Vector2(0, 0);

                if(carried != null){// If this is carrier, we grid align based on the carrier's grid
                    TransformComponent referenceObject = transformM.get(carried.getCarrier());

                    offsetPixels.add(referenceObject.position.x % gm.getWidth(), referenceObject.position.y % gm.getHeight());
                }
                targetPos.sub(offsetPixels);

                Vector2 targetGridPosition = new Vector2((int)targetPos.x / gm.getWidth() + .5f, (int)targetPos.y / gm.getHeight() + .5f);
                if((transform.size.x -1) % (2 * gm.getWidth()) > gm.getWidth()){
                    targetGridPosition.add(.5f, 0);
                }
                if((transform.size.y - 1) % (2 * gm.getHeight()) > gm.getHeight()){
                    targetGridPosition.add(0, .5f);
                }
                targetPos = new Vector2(targetGridPosition.x * gm.getWidth(), targetGridPosition.y * gm.getHeight());
                targetPos.add(offsetPixels);
            }

            mouseMove.targetPosition = new TargetPosition(targetPos.x, targetPos.y);
            screenManager.getCurrent().addEntity(mouseMove.targetPosition);
            if(carried != null){
                //Move the target based on the carrier
                mouseMove.targetPosition.addMovement(new CarriedComponent(mouseMove.targetPosition, carried.getCarrier()));
            }
        }

        if(mouseMove.targetPosition != null){
            Vector2 targetPos = transformM.get(mouseMove.targetPosition).position;
            CarryMoveComponent carry = carryM.get(entity);
            double directionOfTravel = new Vector2(targetPos).sub(transform.getCenter()).angleRad();
            double pointDistance = distance(targetPos, transform.getCenter());
            float moveDistance = mouseMove.speed * deltaTime;

            if(pointDistance < moveDistance){
                Vector2 delta = new Vector2(targetPos);
                delta.sub(transform.getCenter());
                mouseMove.move(delta);
                if(carry != null){
                    carry.move(delta);
                }
                this.screenManager.getCurrent().removeEntity(mouseMove.targetPosition);
                mouseMove.targetPosition = null;
            }else{
                Vector2 delta = new Vector2((float) (moveDistance * Math.cos(directionOfTravel)), (float) (moveDistance * Math.sin(directionOfTravel)));
                mouseMove.move(delta);
                if(carry != null){
                    carry.move(delta);
                }
            }
        }
    }

     double distance(Vector2 object1, Vector2 object2){
         return Math.sqrt(Math.pow((object2.x - object1.x), 2) + Math.pow((object2.y - object1.y), 2));
     }
 }
