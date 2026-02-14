package com.mygdx.game.managers;

import java.util.*;

import com.mygdx.game.input.*;
import com.mygdx.game.entity.*;

public class InputManager {
  public Map<InputAction, Boolean> actionStates = new HashMap<>();
  private List<iInputDevice> inputDevices;

  public InputManager() {
    this.inputDevices = new ArrayList<>();
    inputDevices.add(new Keyboard());
  }

  public Map<InputAction, Boolean> handleInputs() {
    for (InputAction action : InputAction.values()) {
      actionStates.put(action, false);
    }

    for (iInputDevice i : inputDevices) {
      i.updateActionStateDuringRender(actionStates);
    }

    return actionStates;
  }

  public void dispatchAll(List<Entity> entities) {
    for (Entity entity : entities) {
      if (entity instanceof iAcceptsInput) {
        ((iAcceptsInput) entity).dispatchInput(actionStates);
      }
    }
  }
}
