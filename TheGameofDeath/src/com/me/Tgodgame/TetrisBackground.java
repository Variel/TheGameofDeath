package com.me.Tgodgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TetrisBackground extends Actor {
	
	public TetrisBackground(float width, float height){
		setWidth(width);
		setHeight(height);
		setPosition(width, 0);
		/*addAction(Actions.forever(Actions.sequence(Actions.moveTo(0, 0, 1f),
				Actions.moveTo(width, 0)))); */
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		TextureAtlas atlas = AbstractScreen.atlas;
		TextureRegion tetrisBg = atlas.findRegion("TetrisBackground");
		batch.draw(tetrisBg, getX() - getWidth(), getY(), getWidth() * 2,
				getHeight());
	}

}
