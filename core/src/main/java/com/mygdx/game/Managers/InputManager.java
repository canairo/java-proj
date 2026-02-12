package core.src.main.java.com.mygdx.game.Managers;

import java.util.*;

public class InputManager {
  public Map<GameAction, Boolean> actionStates = new HashMap<>();
  private List<iInputDevice> inputDevices = new ArrayList<>();

  public InputManager(List<iInputDevice> inputDevices) {
    this.inputDevices = inputDevices;
  }

  public Map<GameAction, Boolean> handleInputs() {
    for (GameAction action : GameAction.values()) {
      actionStates.put(action, false);
    }

    for (iInputDevice i : inputDevices) {
      i.updateActionStateDuringRender(actionStates);
    }

    return actionStates;
  }
}

interface iInputDevice {
  void updateActionStateDuringRender(Map<GameAction, Boolean> actionStates);
}

interface iAcceptsInput {
  void dispatchInput(Map<GameAction, Boolean> actionStates);
}
