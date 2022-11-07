package com.mad.max.game.screens.gamescreen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.*;
import com.mad.max.game.ecs.entity.actors.Actor;
import com.mad.max.game.ecs.entity.background.GridBackground;
import com.mad.max.game.ecs.entity.room.RoomIcon;
import com.mad.max.game.ecs.entity.truck.Truck;
import com.mad.max.game.ecs.systems.movesystems.KeyboardMoveSystem;
import com.mad.max.game.ecs.systems.RenderSystem;
import com.mad.max.game.ecs.systems.movesystems.MouseMoveSystem;
import com.mad.max.game.managers.AssetLoader;
import com.mad.max.game.screens.BaseScreen;
import com.mad.max.game.util.TextureUtil;
import com.mad.max.game.util.TruckUtil;

/**
 * Created by barry on 12/9/15 @ 11:12 PM.
 */
public class GameScreen extends BaseScreen {

    private boolean isInitialized = false;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    public void init() {
        Gdx.app.log("GameScreen", "Initializing");

        RenderSystem renderSystem = new RenderSystem(super.batch);
        KeyboardMoveSystem keyboardMoveSystem = new KeyboardMoveSystem();
        MouseMoveSystem mouseMoveSystem = new MouseMoveSystem();
        this.addSystem(renderSystem);
        this.addSystem(keyboardMoveSystem);
        this.addSystem(mouseMoveSystem);

        Actor character3 = new Actor(500, 100, 75, 150, TextureUtil.solidTexture(Color.ORANGE), GraphicComponent.Layer.Character);
        character3.addMovement(new MouseMoveComponent(character3, 300));
        character3.addMovement(new GridComponent(character3));
        this.addEntity(character3);

        Actor truck = new Truck(11, 1, TruckUtil.testTruck1());
        truck.addMovement(new KeyboardMoveComponent(truck, 300, 300));
        this.addEntity(truck);

        character3.addMovement(new CarriedComponent(character3, truck));

        Actor enemyTruck = new Truck(11, 17, TruckUtil.testTruck2());
        this.addEntity(enemyTruck);

        Entity background = new GridBackground(Color.GREEN, Color.GRAY);
        this.addEntity(background);

        Entity icon = new RoomIcon(3, 3, AssetLoader.CLOAK_PATH);
        this.addEntity(icon);

        Gdx.app.log("GameScreen", "Initialized");
    }
}
