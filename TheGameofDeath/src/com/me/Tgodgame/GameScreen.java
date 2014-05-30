package com.me.Tgodgame;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class GameScreen extends AbstractScreen {

	public GameScreen(Tgodgame game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		Table table = super.getTable();
		table.setBounds(0, 0, 385, 1024);
		table.setClip(true);
		TetrisBackground loadBackground = new TetrisBackground(table.getWidth(),
				table.getHeight());
		table.addActor(loadBackground);
	}
}
