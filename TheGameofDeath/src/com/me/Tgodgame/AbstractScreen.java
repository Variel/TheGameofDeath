package com.me.Tgodgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class AbstractScreen implements Screen{
	protected final Tgodgame game;
	protected final Stage stage;
	
	private Table table;
	private Skin skin;
	static TextureAtlas atlas;
	
	public AbstractScreen(Tgodgame game){
		this.game = game;
		this.stage = new Stage();
	}
	
	
	/**
	 * atlas 가져오기
	 */
	TextureAtlas getAtlas() {
		if (atlas == null) {
			atlas = new TextureAtlas(
					Gdx.files.internal("textures/textures.atlas"));
		}
		return atlas;
	}

	/**
	 *  해당 클래스 이름을 스트링으로 반환
	 */
	protected String getName(){
		return getClass().getSimpleName();
	}
	
	protected Table getTable(){
		if(table == null){
			table = new Table(getSkin());
			table.setFillParent(true);
			stage.addActor(table);
		}
		return table;
	}
	
	protected Skin getSkin(){
		if(skin == null){
			FileHandle skinFile = Gdx.files.internal("skin/uiskin.json");
			skin = new Skin(skinFile);
		}
		return skin;
	}
	
	@Override
	public void render(float delta) {
		// RGB 흰색으로 화면을 클리어함
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// actor 업데이트
		stage.act(delta);
		
		// actor들 그리기
		stage.draw();
	}
	

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(Tgodgame.LOG, "화면 크기 변경: " + getName() + " 이 " + width
				+ " x " + height);
	}

	@Override
	public void show() {
		// InputProcessor 선언
		Gdx.input.setInputProcessor(this.stage);
		Gdx.app.log(Tgodgame.LOG, "화면을 보여줌: " + getName());
	}

	@Override
	public void hide() {
		Gdx.app.log(Tgodgame.LOG, "화면을 숨김: " + getName());
	}

	@Override
	public void pause() {
		Gdx.app.log(Tgodgame.LOG, "화면을 멈춤: " + getName());
	}

	@Override
	public void resume() {
		Gdx.app.log(Tgodgame.LOG, "화면을 재개: " + getName());
	}

	@Override
	public void dispose() {
		Gdx.app.log(Tgodgame.LOG, "화면을 반환: " + getName());
		if (skin != null) {
			skin.dispose();
		}
		if (stage != null) {
			stage.dispose();
		}
		if (atlas != null) {
			atlas.dispose();
		}
	}
	
	
}
