package com.mad.max.game.ecs.components.movement;

public class KeyboardMoveComponent implements MoveComponent{

    public float speedX, speedY;
    public boolean wasd = true;
    public boolean arrows = false;

    public KeyboardMoveComponent(float speedX, float speedY){
        this.speedX = speedX;
        this.speedY = speedY;
    }

}
