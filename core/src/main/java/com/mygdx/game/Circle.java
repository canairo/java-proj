package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Circle extends Entity {
  private float radius;

  public Circle(float x, float y, float speed, Color color, float radius) {
    super(x, y, speed, color);
    this.radius = radius;
  }

  @Override
  public void draw(ShapeRenderer shape) {
    shape.setColor(this.color);
    shape.circle(x, y, radius);
  }

  @Override
  public void movement() {
    // Control: Up and Down arrow keys
    if (Gdx.input.isKeyPressed(Keys.UP))
      y += speed * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.DOWN))
      y -= speed * Gdx.graphics.getDeltaTime();
  }

  @Override
  public void update() {
  }
}
