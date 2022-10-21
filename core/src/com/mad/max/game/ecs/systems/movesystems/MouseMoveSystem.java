 package com.mad.max.game.ecs.systems.movesystems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.CarriedComponent;
import com.mad.max.game.ecs.components.movement.GridComponent;
import com.mad.max.game.ecs.components.movement.MouseMoveComponent;
import com.mad.max.game.ecs.entity.actors.TargetPosition;
import com.mad.max.game.ecs.systems.LayerComparator;
import com.mad.max.game.managers.GridManager;
import com.mad.max.game.managers.MouseManager;
import com.mad.max.game.managers.SelectionManager;

import java.awt.geom.Line2D;

 public class MouseMoveSystem extends SortedIteratingMoveSystem {

    private final ComponentMapper<MouseMoveComponent> mouseMoveM = ComponentMapper.getFor(MouseMoveComponent.class);
     private final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);
     private final ComponentMapper<GridComponent> gridM = ComponentMapper.getFor(GridComponent.class);
     private final ComponentMapper<CarriedComponent> carriedM = ComponentMapper.getFor(CarriedComponent.class);

    private MouseManager mm = MouseManager.get();
     private SelectionManager sm = SelectionManager.get();
     private GridManager gm = GridManager.get();

    public MouseMoveSystem() {
        super(Family.all(MouseMoveComponent.class, TransformComponent.class).get(), new LayerComparator());
    }

    @Override
    protected Vector2 calculateMoveDelta(Entity entity, float deltaTime) {
        TransformComponent transform = transformM.get(entity);
        MouseMoveComponent mouseMove = mouseMoveM.get(entity);

        Vector2 moveDelta = new Vector2(0, 0);

        Rectangle boundary = new Rectangle(transform.position.x, transform.position.y, transform.size.x, transform.size.y);
        Vector2 mousePos = mm.getPos();

        if(mm.leftClick() && boundary.contains(mousePos)) {
            Gdx.app.log("MouseMoveSystem", "Entity selected");
            sm.setSelected(entity);
        }
        else if(mm.rightClick() && sm.getSelected() == entity) {
            Gdx.app.log("MouseMoveSystem", "Entity directed");
            Vector2 targetPos = mousePos;

            CarriedComponent carried = carriedM.get(entity);
            GridComponent grid = gridM.get(entity);
            if(grid != null){//Align to grid if it isn't already
                Vector2 offsetPixels = new Vector2(0, 0);

                if(carried != null){// If this is carrier, we grid align based on the carrier's grid
                    TransformComponent referenceObject = transformM.get(carried.getCarrier());

                    offsetPixels.add(referenceObject.position.x % gm.getWidth(), referenceObject.position.y % gm.getHeight());
                }
                Gdx.app.log("Grid Align", "" + offsetPixels);
                targetPos.sub(offsetPixels);

                Vector2 targetGridPosition = new Vector2((int)targetPos.x / gm.getWidth() + .5f, (int)targetPos.y / gm.getHeight() + .5f);
                Gdx.app.log("Grid Alignment", "GridPos " + targetGridPosition);
                if((transform.size.x -1) % (2 * gm.getWidth()) > gm.getWidth()){
                    targetGridPosition.add(.5f, 0);
                }
                if((transform.size.y - 1) % (2 * gm.getHeight()) > gm.getHeight()){
                    targetGridPosition.add(0, .5f);
                }
                targetPos = new Vector2(targetGridPosition.x * gm.getWidth(), targetGridPosition.y * gm.getHeight());
                targetPos.add(offsetPixels);
                Gdx.app.log("Grid Alignment", "" + targetPos + "|" + mousePos + "|" + targetGridPosition);

            }

            mouseMove.targetPosition = new TargetPosition(targetPos.x, targetPos.y);
            if(carried != null){
                //Move the target based on the carrier
                mouseMove.targetPosition.addMovement(new CarriedComponent(mouseMove.targetPosition, carried.getCarrier()));
            }
        }

        if(mouseMove.targetPosition != null){
            Vector2 targetPos = transformM.get(mouseMove.targetPosition).position;
            double directionOfTravel = new Vector2(targetPos).sub(transform.getCenter()).angleRad();
            double pointDistance = distance(targetPos, transform.getCenter());
            float moveDistance = mouseMove.speed * deltaTime;

            if(pointDistance < moveDistance){
                moveDelta.add(targetPos);
                moveDelta.sub(transform.getCenter());
                mouseMove.targetPosition = null;
            }else{
                moveDelta.add(new Vector2((float) (moveDistance * Math.cos(directionOfTravel)), (float) (moveDistance * Math.sin(directionOfTravel))));
            }
        }

        return moveDelta;
    }

     double distance(Vector2 object1, Vector2 object2){
         return Math.sqrt(Math.pow((object2.x - object1.x), 2) + Math.pow((object2.y - object1.y), 2));
     }
}
