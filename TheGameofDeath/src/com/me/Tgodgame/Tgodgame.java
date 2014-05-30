package com.me.Tgodgame;

import java.awt.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;

public class Tgodgame extends Game {
	
	/**
	 * �α׸� ���� �� ����ϴ� ��� ����
	 */
	public static String LOG = Tgodgame.class.getSimpleName();
	
	/**
	 * �� �ʸ��� ���� FPS�� �α��ϴ� Ŭ���� ����
	 */
	private FPSLogger fpsLogger;
	
	public com.me.Tgodgame.SplashScreen getSplashScreen(){
		return new com.me.Tgodgame.SplashScreen(this);
	}
	
	/** 
	 * ���߸�带 ���� ��� ����
	 */
	public static boolean DEV_MODE = true;
	
	//���÷��� ȭ�� ����
	private com.me.Tgodgame.SplashScreen splashScreen; 
	
	@Override
	public void create() {
		// �α� ���
		Gdx.app.log(Tgodgame.LOG, "������ �����Ǿ����ϴ�.");
		
		// fps ����
		this.fpsLogger = new FPSLogger();
		
		// ���÷��� ȭ�� ����
		this.splashScreen = new com.me.Tgodgame.SplashScreen(this);
		
		this.setScreen(this.splashScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		Gdx.app.log(Tgodgame.LOG, "���� ����");
	}

	@Override
	public void pause() {
		super.pause();
		Gdx.app.log(Tgodgame.LOG, "���� ��� ����");
	}

	@Override
	public void resume() {
		super.resume();
		Gdx.app.log(Tgodgame.LOG, "���� �ٽ� ����");
	}

	@Override
	public void render() {
		super.render();
		if(DEV_MODE){
			this.fpsLogger.log(); // ���߸��� fps �α�
		}
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		Gdx.app.log(Tgodgame.LOG, "���� ȭ�� ũ�� ���� : " + width + " x " + height);
	}
}
