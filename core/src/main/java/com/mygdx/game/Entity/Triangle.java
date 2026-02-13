package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Triangle extends Entity {
  public Triangle(float x, float y, float speed, Color color) {
    super(x, y, speed, color);
  }

  @Override
  public void draw(ShapeRenderer shape) {
    shape.setColor(this.color);
    // Drawing counter-clockwise around center (x,y)
    float size = 50;
    shape.triangle(
        x - size, y - size, // P1: Bottom Left
        x + size, y - size, // P2: Bottom Right
        x, y + size // P3: Top Middle
    );
  }

  @Override
  public void movement() {
  }

  @Override
  public void update() {
  }

}
