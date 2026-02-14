package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {
  protected float x;
  protected float y;
  protected Texture texture;

  public Entity() {
    this.x = 0;
    this.y = 0;
  }

  public Entity(float x, float y, Texture texture) {
    this.x = x;
    this.y = y;
    this.texture = texture;
  }
}
