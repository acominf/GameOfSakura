package com.sakuraxx.game.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sakuraxx.game.Menu;
import com.sakuraxx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 600;
		config.height = 450;
		config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
        //new LwjglApplication((ApplicationListener) new Menu(new MyGdxGame()), config);

	}
}
