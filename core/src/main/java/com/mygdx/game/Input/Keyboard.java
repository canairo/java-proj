package core.src.main.java.com.mygdx.game.Input;

import com.badlogic.gdx.Input;

import core.src.main.java.com.mygdx.game.Managers.iInputDevice;

import com.badlogic.gdx.Gdx;

import java.util.*;

class Keyboard implements iInputDevice {
  public void updateActionStateDuringRender(Map<GameAction, Boolean> actionStates) {
    boolean moveLeft = Gdx.input.isKeyPressed(Input.Keys.A);
    boolean moveRight = Gdx.input.isKeyPressed(Input.Keys.D);
    boolean moveUp = Gdx.input.isKeyPressed(Input.Keys.W);
    boolean moveDown = Gdx.input.isKeyPressed(Input.Keys.S);

    actionStates.put(GameAction.MOVE_LEFT, moveLeft);
    actionStates.put(GameAction.MOVE_RIGHT, moveRight);
    actionStates.put(GameAction.MOVE_UP, moveUp);
    actionStates.put(GameAction.MOVE_DOWN, moveDown);
  }
}
