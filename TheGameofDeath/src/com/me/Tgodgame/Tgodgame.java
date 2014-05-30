package com.me.Tgodgame;

import java.awt.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;

public class Tgodgame extends Game {
	
	/**
	 * 로그를 남길 때 사용하는 상수 정의
	 */
	public static String LOG = Tgodgame.class.getSimpleName();
	
	/**
	 * 매 초마다 현재 FPS를 로깅하는 클래스 선언
	 */
	private FPSLogger fpsLogger;
	
	public com.me.Tgodgame.SplashScreen getSplashScreen(){
		return new com.me.Tgodgame.SplashScreen(this);
	}
	
	/** 
	 * 개발모드를 위한 상수 정의
	 */
	public static boolean DEV_MODE = true;
	
	//스플래쉬 화면 선언
	private com.me.Tgodgame.SplashScreen splashScreen; 
	
	@Override
	public void create() {
		// 로그 출력
		Gdx.app.log(Tgodgame.LOG, "게임이 생성되었습니다.");
		
		// fps 생성
		this.fpsLogger = new FPSLogger();
		
		// 스플래쉬 화면 생성
		this.splashScreen = new com.me.Tgodgame.SplashScreen(this);
		
		this.setScreen(this.splashScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		Gdx.app.log(Tgodgame.LOG, "게임 종료");
	}

	@Override
	public void pause() {
		super.pause();
		Gdx.app.log(Tgodgame.LOG, "게임 잠시 멈춤");
	}

	@Override
	public void resume() {
		super.resume();
		Gdx.app.log(Tgodgame.LOG, "게임 다시 시작");
	}

	@Override
	public void render() {
		super.render();
		if(DEV_MODE){
			this.fpsLogger.log(); // 개발모드면 fps 로깅
		}
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		Gdx.app.log(Tgodgame.LOG, "게임 화면 크기 변경 : " + width + " x " + height);
	}
}
