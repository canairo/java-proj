package com.mygdx.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;

import java.util.*;

public class Keyboard implements iInputDevice {
  public void updateActionStateDuringRender(Map<InputAction, Boolean> actionStates) {
    boolean moveLeft = Gdx.input.isKeyPressed(Input.Keys.A);
    boolean moveRight = Gdx.input.isKeyPressed(Input.Keys.D);
    boolean moveUp = Gdx.input.isKeyPressed(Input.Keys.W);
    boolean moveDown = Gdx.input.isKeyPressed(Input.Keys.S);

    actionStates.put(InputAction.MOVE_LEFT, moveLeft);
    actionStates.put(InputAction.MOVE_RIGHT, moveRight);
    actionStates.put(InputAction.MOVE_UP, moveUp);
    actionStates.put(InputAction.MOVE_DOWN, moveDown);
  }
}
