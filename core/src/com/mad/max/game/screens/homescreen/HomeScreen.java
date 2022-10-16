package com.mad.max.game.screens.homescreen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mad.max.game.MadMaxGame;
import com.mad.max.game.ecs.entity.SolidBackgroundEntity;
import com.mad.max.game.ecs.systems.ClickSystem;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.ecs.systems.RenderSystem;
import com.mad.max.game.screens.BaseScreen;

/**
 * Created by barry on 12/8/15 @ 8:24 PM.
 */
public class HomeScreen extends BaseScreen {
    public HomeScreen(SpriteBatch batch) {
        super(batch);

        init();
    }

    private void init() {
        Gdx.app.log("HomeScreen", "Initializing");

        RenderSystem renderSystem = new RenderSystem(super.batch);
        ClickSystem clickSystem = new ClickSystem();
        engine.addSystem(renderSystem);
        engine.addSystem(clickSystem);

        Entity startButton = new StartButton(vm.WORLD_WIDTH/2,  vm.WORLD_HEIGHT/2);
        engine.addEntity(startButton);

        Entity background = new SolidBackgroundEntity(Color.BLUE);
        engine.addEntity(background);

        //Entity testButton = new TestButton(20,  40, 1);
        //engine.addEntity(testButton);

        //Entity testButton2 = new TestButton(250,  100, 3f);
        //engine.addEntity(testButton2);

        Gdx.app.log("HomeScreen", "Initialized");
    }


}
