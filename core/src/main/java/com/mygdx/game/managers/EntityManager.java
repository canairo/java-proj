package com.mygdx.game.managers;

import java.util.*;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.entity.*;

public class EntityManager {
  private List<Entity> entityList;

  public EntityManager() {
    this.entityList = new ArrayList<>(); // composition
  }

  public void add(Entity entity) {
    entityList.add(entity);
  }

  public List<Entity> get() {
    return entityList;
  }

  public void moveAll() {
    for (Entity entity : entityList) {
      if (entity instanceof iMovable) {
        ((iMovable) entity).move();
      }
    }
  }

  public void drawAll(SpriteBatch batch) {
    for (Entity entity : entityList) {
      if (entity instanceof iDrawable) {
        ((iDrawable) entity).draw(batch);
      }
    }
  }
}
