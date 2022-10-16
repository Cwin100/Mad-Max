package com.mad.max.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mad.max.game.managers.AssetLoader;
import com.mad.max.game.managers.ScreenManager;
import com.mad.max.game.screens.gamescreen.GameScreen;
import com.mad.max.game.screens.loadingsreen.SplashScreen;
import com.mad.max.game.screens.homescreen.HomeScreen;

public class MadMaxGame extends Game {

	//TODO at some point fix memory leaks by disposing all things that implement Disposable

	Texture img;
	private final ScreenManager sm = ScreenManager.get();
	public com.badlogic.gdx.assets.AssetManager am;
	public SpriteBatch batch;

	@Override
	public void create() {


		am = AssetLoader.load();
		this.batch = new SpriteBatch();

		Screen loadingScreen = new SplashScreen(batch);
		Screen homeScreen = new HomeScreen(batch);
		Screen gameScreen = new GameScreen(batch);
		sm.addScreen("loadingScreen", loadingScreen);
		sm.addScreen("homeScreen", homeScreen);
		sm.addScreen("gameScreen", gameScreen);

		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render() {
		Screen nextScreen = sm.getCurrent();
		if (nextScreen != getScreen()) {
			setScreen(nextScreen);
		}

		super.render();
	}

}
