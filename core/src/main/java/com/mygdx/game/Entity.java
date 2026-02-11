package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Entity implements iMovable {
    protected float x;
    protected float y;
    protected float speed;
    protected Color color;

    public Entity() {
        this.x = 0;
        this.y = 0;
        this.speed = 0;
        this.color = Color.WHITE;
    }

    public Entity(float x, float y, float speed, Color color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public float getSpeed() { return speed; }
    public void setSpeed(float speed) { this.speed = speed; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public void draw(SpriteBatch batch) {}
    public void draw(ShapeRenderer shape) {}
    public void movement() {}

    public abstract void update();
}
