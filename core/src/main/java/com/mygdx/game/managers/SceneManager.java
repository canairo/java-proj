package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.List;

import com.mygdx.game.entity.*;

public class SceneManager {
  private Batch batch;

  public SceneManager() {
    this.batch = new SpriteBatch();
  }

  public void drawAll(List<Entity> entities) {
    batch.begin();
    for (Entity entity : entities) {
      if (entity instanceof iDrawable) {
        System.out.println(entity);
        ((iDrawable) entity).draw(batch);
      }
    }
    batch.end();
  }

  public void dispose() {
    batch.dispose(); // Always clean up memory!
  }
}
