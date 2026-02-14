package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {
  protected float x;
  protected float y;
  protected float width, height;
  protected Texture texture;

  public Entity() {
    this.x = 0;
    this.y = 0;
  }

  public Entity(float width, float height, float x, float y, Texture texture) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.texture = texture;
  }
}
