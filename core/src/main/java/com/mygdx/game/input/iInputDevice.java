package com.mygdx.game.input;

import java.util.*;

public interface iInputDevice {
  void updateActionStateDuringRender(Map<InputAction, Boolean> actionStates);
}
