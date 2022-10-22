package com.mad.max.game.screens.gamescreen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.*;
import com.mad.max.game.ecs.entity.actors.Actor;
import com.mad.max.game.ecs.entity.background.GridBackground;
import com.mad.max.game.ecs.entity.truck.Truck;
import com.mad.max.game.ecs.systems.movesystems.KeyboardMoveSystem;
import com.mad.max.game.ecs.systems.RenderSystem;
import com.mad.max.game.ecs.systems.movesystems.MouseMoveSystem;
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
        init();
    }

    private void init() {
        Gdx.app.log("GameScreen", "Initializing");

        RenderSystem renderSystem = new RenderSystem(super.batch);
        KeyboardMoveSystem keyboardMoveSystem = new KeyboardMoveSystem();
        MouseMoveSystem mouseMoveSystem = new MouseMoveSystem();
        engine.addSystem(renderSystem);
        engine.addSystem(keyboardMoveSystem);
        engine.addSystem(mouseMoveSystem);

        Actor character3 = new Actor(500, 100, 75, 150, TextureUtil.solidTexture(Color.ORANGE), GraphicComponent.Layer.Character);
        character3.addMovement(new MouseMoveComponent(300));
        character3.addMovement(new GridComponent());
        engine.addEntity(character3);

        Actor truck = new Truck(11, 1, TruckUtil.testTruck1());
        engine.addEntity(truck);

        character3.addMovement(new CarriedComponent(character3, truck));

        Actor enemyTruck = new Truck(11, 17, TruckUtil.testTruck2());
        engine.addEntity(enemyTruck);

        Entity background = new GridBackground(Color.GREEN, Color.GRAY);
        engine.addEntity(background);

        Gdx.app.log("GameScreen", "Initialized");
    }
}
