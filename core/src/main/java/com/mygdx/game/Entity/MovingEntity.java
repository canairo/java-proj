package com.mygdx.game.Entity;

import com.mygdx.game.Input.iMovable;

public class MovingEntity extends Entity implements iMovable, {
	protected float speed;
	protected boolean isAI;
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public MovingEntity(int x, int y, boolean isShape, float speed) {
		super(x,y, isShape);
		this.speed = speed;
		isAI = false;
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean IsAI() {
		return isAI;
	}
	
	public boolean toggleAI() {
		isAI = !isAI;
		return isAI;
	}

}
