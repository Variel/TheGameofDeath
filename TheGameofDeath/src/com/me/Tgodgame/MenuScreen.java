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
		// 테이블 가져오기
		Table table = super.getTable();
		table.add("Wecome to The Game of Death!").spaceBottom(50);
		
		// start game 버튼 추가
				table.row();
				TextButton startGameButton = new TextButton("Start Game", getSkin());
				startGameButton.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						// 실제 게임화면으로 이동 구현
						Gdx.app.log(Tgodgame.LOG, "실제 게임화면으로 이동 구현!");
						game.setScreen(new GameScreen(game));
					}
				});
				table.add(startGameButton).size(300, 60).uniform().spaceBottom(10);
				
				// options 버튼 추가
				table.row();
				TextButton optionsButton = new TextButton("Options", getSkin());
				optionsButton.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						// 옵션 화면으로 이동 구현
						Gdx.app.log(Tgodgame.LOG, "옵션 화면으로 이동 구현!");
					}
				});
				table.add(optionsButton).uniform().fill().spaceBottom(10);

				// exit 버튼 추가
				table.row();
				TextButton exitButton = new TextButton("Exit", getSkin());
				exitButton.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						// 게임 나가기를 구현
						Gdx.app.log(Tgodgame.LOG, "게임 나가기 구현!");
					}
				});
				table.add(exitButton).uniform().fill().spaceBottom(10);
	}
}
