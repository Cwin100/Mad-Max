package com.mad.max.game.screens.gamescreen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mad.max.game.ecs.components.GraphicComponent;
import com.mad.max.game.ecs.components.movement.CarryMoveComponent;
import com.mad.max.game.ecs.components.movement.KeyboardMoveComponent;
import com.mad.max.game.ecs.entity.actors.Actor;
import com.mad.max.game.ecs.entity.background.SolidBackground;
import com.mad.max.game.ecs.systems.KeyboardMoveSystem;
import com.mad.max.game.ecs.systems.RenderSystem;
import com.mad.max.game.screens.BaseScreen;
import com.mad.max.game.util.TextureUtil;

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
        engine.addSystem(renderSystem);
        engine.addSystem(keyboardMoveSystem);

        Actor character = new Actor(100, 100, 100, 200, TextureUtil.solidTexture(Color.RED), GraphicComponent.Layer.Character);
        character.addMovement(new KeyboardMoveComponent(10, 10));
        engine.addEntity(character);

        Actor character2 = new Actor(150, 150, 100, 200, TextureUtil.solidTexture(Color.BLUE), GraphicComponent.Layer.Character);
        KeyboardMoveComponent kmc = new KeyboardMoveComponent(10, 10);
        kmc.wasd = false;
        kmc.arrows = true;
        character2.addMovement(kmc);
        character2.addMovement(new CarryMoveComponent());
        engine.addEntity(character2);

        character.setCarrier(character2);

        Entity background = new SolidBackground(Color.GREEN);
        engine.addEntity(background);

        Gdx.app.log("GameScreen", "Initialized");
    }
}
