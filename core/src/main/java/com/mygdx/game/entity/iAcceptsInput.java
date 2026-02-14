package com.mygdx.game.entity;

import com.mygdx.game.input.*;
import java.util.*;

public interface iAcceptsInput {
  void dispatchInput(Map<InputAction, Boolean> actionStates);
}
