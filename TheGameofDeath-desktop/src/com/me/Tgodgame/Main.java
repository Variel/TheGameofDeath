package com.me.Tgodgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "TheGameofDeath";
		cfg.useGL20 = true;
		cfg.width = 768;
		cfg.height = 1024;
		
		new LwjglApplication(new Tgodgame(), cfg);
	}
}
