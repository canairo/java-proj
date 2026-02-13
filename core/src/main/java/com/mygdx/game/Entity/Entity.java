package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import core.src.main.java.com.mygdx.game.Input.iMovable;

public abstract class Entity {
	protected boolean isShape;
    protected int x;
    protected int y;
    //protected float speed;
    protected Color color;

    public Entity() {
        this.x = 0;
        this.y = 0;
        //this.speed = 0;
        this.color = Color.WHITE;
    }

    public Entity(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        //this.speed = speed;
        this.color = color;
    }
    
    public Entity(int x, int y, boolean isShape) {
    	this.x = x;
    	this.y = y;
    	this.isShape = isShape;
    }
    
    public boolean IsShape() {return isShape;}
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    //public float getSpeed() { return speed; }
    //public void setSpeed(float speed) { this.speed = speed; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public void draw(SpriteBatch batch) {}
    public void draw(ShapeRenderer shape) {}

    public abstract void update();
}
