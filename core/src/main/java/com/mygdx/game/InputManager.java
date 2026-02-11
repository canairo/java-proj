package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;


public enum GameAction {
  // keyboard
  MOVE_LEFT, MOVE_RIGHT, MOVE_UP, MOVE_DOWN
}

public class InputManager {
  public Map<GameAction, Boolean> actionStates = new HashMap<>();
  private List<iInputDevice> inputDevices = new ArrayList();

  public InputManager(List<iInputDevice> inputDevices) {
    this.inputDevices = inputDevices;
  }

  public handleInputs() {
    // reset everything
    for (GameAction action: GameAction.values()) {
      actionStates.put(action, false);
    }

    for (iInputDevice i: inputDevices) {
      i.updateActionStateDuringRender(actionStates);
    }
  }
}

interface iInputDevice {
  void updateActionStateDuringRender(Map<GameAction, Boolean>);
}

class Keyboard implements interface {
  void updateActionStateDuringRender(Map<GameAction, Boolean> actionStates) {
    boolean moveLeft = Gdx.input.isKeyPressed(Input.Keys.A);
    boolean moveRight = Gdx.input.isKeyPressed(Input.Keys.D);
    boolean moveUp = Gdx.input(isKeyPressed(Input.Keys.W));
    boolean moveDown = Gdx.input(isKeyPressed(Input.Keys.S));
    
    states.put(GameAction.MOVE_LEFT, moveLeft);
    states.put(GameAction.MOVE_RIGHT, moveRight);
    states.put(GameAction.MOVE_UP, moveUp);
    states.put(GameAction.MOVE_DOWN, moveDown);
  }
}


