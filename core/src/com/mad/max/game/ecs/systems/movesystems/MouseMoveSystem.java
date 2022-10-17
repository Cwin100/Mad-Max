 package com.mad.max.game.ecs.systems.movesystems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mad.max.game.ecs.components.ClickComponent;
import com.mad.max.game.ecs.components.TransformComponent;
import com.mad.max.game.ecs.components.movement.MouseMoveComponent;
import com.mad.max.game.ecs.systems.LayerComparator;
import com.mad.max.game.managers.MouseManager;
import com.mad.max.game.managers.SelectionManager;

import java.awt.geom.Line2D;

 public class MouseMoveSystem extends SortedIteratingMoveSystem {

    private final ComponentMapper<MouseMoveComponent> mouseMoveM = ComponentMapper.getFor(MouseMoveComponent.class);
    private final ComponentMapper<TransformComponent> transformM = ComponentMapper.getFor(TransformComponent.class);

    private MouseManager mm = MouseManager.get();
    private SelectionManager sm = SelectionManager.get();

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
        //Gdx.app.log("MouseMoveSystem","" + mousePos + "|" + boundary);
        //Gdx.app.log("MouseMoveSystem", "" + boundary.contains(mousePos));

        if(mm.leftClick() && boundary.contains(mousePos)) {
            Gdx.app.log("MouseMoveSystem", "Entity selected");
            sm.setSelected(entity);
        }
        else if(mm.rightClick() && sm.getSelected() == entity) {
            Gdx.app.log("MouseMoveSystem", "Entity directed");
            mouseMove.targetPosition = mousePos;
        }

        if(mouseMove.targetPosition != null){
            double directionOfTravel = new Vector2(mouseMove.targetPosition).sub(transform.getCenter()).angleRad();
            Gdx.app.log("MouseMoveSystem", "Movement angle: " + Math.toDegrees(directionOfTravel));

            double pointDistance = distance(mouseMove.targetPosition, transform.getCenter());
            float moveDistance = mouseMove.speed * deltaTime;

            if(pointDistance < moveDistance){
                moveDelta.add(mouseMove.targetPosition);
                moveDelta.sub(transform.getCenter());
                mouseMove.targetPosition = null;
            }else{
                moveDelta.add(new Vector2((float) (moveDistance * Math.cos(directionOfTravel)), (float) (moveDistance * Math.sin(directionOfTravel))));
            }

            Gdx.app.log("MouseMoveSystem", "Movement: " + moveDelta);

        }

        return moveDelta;
    }

     double distance(Vector2 object1, Vector2 object2){
         return Math.sqrt(Math.pow((object2.x - object1.x), 2) + Math.pow((object2.y - object1.y), 2));
     }
}
