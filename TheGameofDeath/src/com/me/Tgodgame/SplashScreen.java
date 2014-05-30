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
		Gdx.app.log(Tgodgame.LOG, "���÷��� ȭ�� show ����: " + getName());
		
		// atlas�κ��� ���÷��� �̹��� region ��������
		AtlasRegion splashRegion = getAtlas().findRegion("SplashImage");
		Drawable splashDrawable = new TextureRegionDrawable(splashRegion);
		
		// �̹��� actor �����ϱ�, �̰��� ������� resize()�� ���Ҷ����� ���õ�.
		splashImage = new Image(splashDrawable, Scaling.stretch);
		splashImage.setFillParent(true);
		

		// fade-in ȿ���� ����ϱ� ���� �̹����� �����ϰ� �����.
		splashImage.getColor().a = 0f;

		// splash image �� action �߰�
		splashImage.addAction(Actions.sequence(Actions.fadeIn(0.75f),
				Actions.delay(1.75f), Actions.fadeOut(0.75f), new Action() {

					@Override
					public boolean act(float delta) {
						// fade-in ȿ���� ���� ��, �ϰ� �� �׼�
						// �޴���ũ������ �̵�
						game.setScreen(new MenuScreen(game));
						return false;
					}
				}));

		// stage�� actor �߰�
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
