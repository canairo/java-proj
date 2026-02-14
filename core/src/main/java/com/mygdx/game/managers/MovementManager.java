package com.mygdx.game.managers;

import java.util.List;

import com.mygdx.game.entity.*;

public class MovementManager {

  public void moveAll(List<Entity> entities) {
    for (Entity entity : entities) {
      if (entity instanceof iMovable) {
        ((iMovable) entity).move();
      }
    }
  }

  public void dispose() {
  }
}
