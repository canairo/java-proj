package com.mygdx.game.Managers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.MovingEntity;
import com.mygdx.game.Entity.StaticEntity;

public class EntityManager {
  private List<Entity> entityList;
  private List<StaticEntity> staticList;
  private List<MovingEntity> movingList;

  public EntityManager() {
    this.entityList = new ArrayList<>();
    this.staticList = new ArrayList<>();
    this.movingList = new ArrayList<>();
  }

  public void add(Entity entity) {
    entityList.add(entity);
  }
  
  public void add(MovingEntity entity) {
	  movingList.add(entity);
  }
  
  public void add(StaticEntity entity) {
	  staticList.add(entity);
  }

  public void movement() {
    for (MovingEntity entity : movingList) {
      entity.movement();
    }
  }
  
  public void remove(Entity entity) {
	  if (entity instanceof MovingEntity) {
		  movingList.remove(entity);
	  }
	  else {
		  staticList.remove(entity);
	  }
  }

  public void update() {
    for (Entity entity : entityList) {
      entity.update();
    }
  }

  public void draw(SpriteBatch batch, ShapeRenderer shape) {
    for (Entity entity : entityList) {
    	if (entity.IsShape()) {
    		entity.draw(shape);
    	}
    	else {
    		entity.draw(batch);
    	}
    }
  }
}
