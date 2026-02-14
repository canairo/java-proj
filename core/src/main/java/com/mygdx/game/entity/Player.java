package com.mygdx.game.entity;

import java.util.*;

import com.mygdx.game.input.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity implements iAcceptsInput, iDrawable {

  public Player(double x, double y, Texture texture) {
    super((float) x, (float) y, texture);
  }

  public void dispatchInput(Map<InputAction, Boolean> states) {
    for (InputAction action : InputAction.values()) {

      if (!states.getOrDefault(action, false))
        continue;

      switch (action) {
        case MOVE_UP:
          this.y += 5;
          break;
        case MOVE_DOWN:
          this.y -= 5;
          break;
        case MOVE_LEFT:
          this.x -= 5;
          break;
        case MOVE_RIGHT:
          this.x += 5;
          break;
      }
    }
  }

  public void draw(Batch batch) {
    batch.draw(texture, x, y);
  }
}
