package com.mad.max.game.screens.homescreen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mad.max.game.ecs.entity.background.SolidBackground;
import com.mad.max.game.ecs.entity.room.RoomIcon;
import com.mad.max.game.ecs.systems.ClickSystem;
import com.mad.max.game.ecs.systems.RenderSystem;
import com.mad.max.game.managers.AssetLoader;
import com.mad.max.game.screens.BaseScreen;

/**
 * Created by barry on 12/8/15 @ 8:24 PM.
 */
public class HomeScreen extends BaseScreen {
    public HomeScreen(SpriteBatch batch) {
        super(batch);
    }

    public void init() {
        Gdx.app.log("HomeScreen", "Initializing");

        RenderSystem renderSystem = new RenderSystem(super.batch);
        ClickSystem clickSystem = new ClickSystem();
        this.addSystem(renderSystem);
        this.addSystem(clickSystem);

        Entity startButton = new StartButton(vm.WORLD_WIDTH/2,  vm.WORLD_HEIGHT/2);
        this.addEntity(startButton);

        Entity background = new SolidBackground(Color.BLUE);
        this.addEntity(background);

        Gdx.app.log("HomeScreen", "Initialized");
    }


}
