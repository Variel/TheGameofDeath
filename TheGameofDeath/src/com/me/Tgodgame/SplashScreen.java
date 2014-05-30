package com.me.Tgodgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class SplashScreen extends AbstractScreen {

	private Image splashImage;
	
	private Texture splashTexture;
	private TextureRegion splashTextureRegion;
	
	public SplashScreen(Tgodgame game) {
		super(game);
	}
	
	@Override
	public void show() {
		super.show();
		Gdx.app.log(Tgodgame.LOG, "스플래쉬 화면 show 실행: " + getName());
		
		// atlas로부터 스플래쉬 이미지 region 가져오기
		AtlasRegion splashRegion = getAtlas().findRegion("SplashImage");
		Drawable splashDrawable = new TextureRegionDrawable(splashRegion);
		
		// 이미지 actor 생성하기, 이것의 사이즈는 resize()가 콜할때마다 셋팅됨.
		splashImage = new Image(splashDrawable, Scaling.stretch);
		splashImage.setFillParent(true);
		

		// fade-in 효과를 사용하기 위해 이미지를 투명하게 만든다.
		splashImage.getColor().a = 0f;

		// splash image 에 action 추가
		splashImage.addAction(Actions.sequence(Actions.fadeIn(0.75f),
				Actions.delay(1.75f), Actions.fadeOut(0.75f), new Action() {

					@Override
					public boolean act(float delta) {
						// fade-in 효과가 끝난 후, 하게 될 액션
						// 메뉴스크린으로 이동
						game.setScreen(new MenuScreen(game));
						return false;
					}
				}));

		// stage에 actor 추가
		stage.addActor(splashImage);
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		splashTexture.dispose();
	}
}
