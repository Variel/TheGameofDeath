package com.me.Tgodgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

public class MenuScreen extends AbstractScreen {

	public MenuScreen(Tgodgame game) {
		super(game);
	}
	
	@Override
	public void show() {
		super.show();
		// ���̺� ��������
		Table table = super.getTable();
		table.add("Wecome to The Game of Death!").spaceBottom(50);
		
		// start game ��ư �߰�
				table.row();
				TextButton startGameButton = new TextButton("Start Game", getSkin());
				startGameButton.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						// ���� ����ȭ������ �̵� ����
						Gdx.app.log(Tgodgame.LOG, "���� ����ȭ������ �̵� ����!");
						game.setScreen(new GameScreen(game));
					}
				});
				table.add(startGameButton).size(300, 60).uniform().spaceBottom(10);
				
				// options ��ư �߰�
				table.row();
				TextButton optionsButton = new TextButton("Options", getSkin());
				optionsButton.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						// �ɼ� ȭ������ �̵� ����
						Gdx.app.log(Tgodgame.LOG, "�ɼ� ȭ������ �̵� ����!");
					}
				});
				table.add(optionsButton).uniform().fill().spaceBottom(10);

				// exit ��ư �߰�
				table.row();
				TextButton exitButton = new TextButton("Exit", getSkin());
				exitButton.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						// ���� �����⸦ ����
						Gdx.app.log(Tgodgame.LOG, "���� ������ ����!");
					}
				});
				table.add(exitButton).uniform().fill().spaceBottom(10);
	}
}
