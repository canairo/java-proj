package core.src.main.java.com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Color;

import core.src.main.java.com.mygdx.game.Managers.iAcceptsInput;

import java.util.*;

public class Player extends Triangle implements iAcceptsInput {

  public Player(float x, float y, float speed, Color color) {
    super(x, y, speed, color);
  }

  public void dispatchInput(Map<GameAction, Boolean> states) {
    for (GameAction action : GameAction.values()) {

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
}
