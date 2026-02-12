package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import core.src.main.java.com.mygdx.game.Entity.Player;
import core.src.main.java.com.mygdx.game.Input.Keyboard;
import core.src.main.java.com.mygdx.game.Managers.EntityManager;
import core.src.main.java.com.mygdx.game.Managers.InputManager;
import core.src.main.java.com.mygdx.game.Managers.iAcceptsInput;
import core.src.main.java.com.mygdx.game.Managers.iInputDevice;

import java.util.*;

public class GameMaster extends ApplicationAdapter {
  private SpriteBatch batch;
  private ShapeRenderer shape;

  private Player player;
  private EntityManager entities;
  private InputManager inputManager;
  private List<iInputDevice> inputDevices;
  private List<iAcceptsInput> inputReceivers;

  @Override
  public void create() {
    batch = new SpriteBatch();
    shape = new ShapeRenderer();
    entities = new EntityManager();

    inputDevices = new ArrayList<>(
        List.of(
            new Keyboard()));

    inputManager = new InputManager(inputDevices);
    inputReceivers = new ArrayList<>();

    player = new Player(100, 100, 150, Color.GREEN);

    entities.add(player);
    inputReceivers.add(player);
  }

  @Override
  public void render() {
    ScreenUtils.clear(0, 0, 0.2f, 1);

    entities.movement();
    entities.update();

    // dispatch inputManager
    inputManager.handleInputs();
    for (iAcceptsInput i : inputReceivers) {
      i.dispatchInput(inputManager.actionStates);
    }

    batch.begin();
    shape.begin(ShapeRenderer.ShapeType.Filled);
    entities.draw(batch, shape);
    batch.end();
    shape.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    shape.dispose();
  }
}
