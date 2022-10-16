package com.mad.max.game.screens.loadingsreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mad.max.game.MadMaxGame;
import com.mad.max.game.managers.AssetLoader;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.managers.ViewManager;
import com.mad.max.game.screens.BaseScreen;

/**
 * Created by barry on 12/8/15 @ 8:24 PM.
 */
public class SplashScreen extends BaseScreen {
    private final ShapeRenderer shapeRenderer;
    private final ScreenManager sm = ScreenManager.get();
    private final ViewManager vm = ViewManager.get();

    public SplashScreen(SpriteBatch batch) {
        super(batch);
        this.shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (AssetLoader.am.update()) {
            Gdx.app.log("Splash Screen", "Assets are Loaded!");
            sm.setCurrent("homeScreen");
        } else {
            vm.startRender(batch);

            batch.enableBlending();
            batch.begin();
            batch.draw(AssetLoader.splashScreen, 0f, 0f, vm.getViewport().getWorldWidth(), vm.getViewport().getWorldHeight());
            batch.end();

            Gdx.gl20.glLineWidth(1f);
            shapeRenderer.setProjectionMatrix(vm.getCamera().combined);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.CYAN);
            shapeRenderer.rect(0, 0, vm.getViewport().getWorldWidth() * AssetLoader.am.getProgress(), vm.getViewport().getWorldHeight() / 5f);
            shapeRenderer.end();

            vm.finishRender();

        }
    }
}
