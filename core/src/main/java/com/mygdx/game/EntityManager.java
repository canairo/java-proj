package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class EntityManager {
  private List<Entity> entityList;

  public EntityManager() {
    this.entityList = new ArrayList<>();
  }

  public void add(Entity entity) {
    entityList.add(entity);
  }

  public void movement() {
    for (Entity entity : entityList) {
      entity.movement();
    }
  }

  public void update() {
    for (Entity entity : entityList) {
      entity.update();
    }
  }

  public void draw(SpriteBatch batch, ShapeRenderer shape) {
    for (Entity entity : entityList) {
      entity.draw(batch);
      entity.draw(shape);
    }
  }
}
