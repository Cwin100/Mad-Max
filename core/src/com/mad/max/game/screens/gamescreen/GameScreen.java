package com.mad.max.game.screens.gamescreen;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.mad.max.game.MadMaxGame;
import com.mad.max.game.screens.BaseScreen;

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
    }
}
