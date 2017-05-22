package com.sakuraxx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sakuraxx.game.MyGdxGame;
import com.sakuraxx.game.Principal;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 500;
		config.width = 700;
		new LwjglApplication(new MyGdxGame(), config);


	}
}
