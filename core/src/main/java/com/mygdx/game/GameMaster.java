package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.entity.*;
import com.mygdx.game.managers.*;
import java.util.*;

public class GameMaster extends ApplicationAdapter {
  private SpriteBatch batch;
  private ShapeRenderer shape;

  private Player player;
  private EntityManager entities;
  private InputManager inputs;
  private ResourceManager resources;
  private SceneManager scene;

  private List<iAcceptsInput> inputReceivers;

  @Override
  public void create() {
    batch = new SpriteBatch();
    shape = new ShapeRenderer();
    entities = new EntityManager();

    inputs = new InputManager();
    inputReceivers = new ArrayList<>();

    resources = new ResourceManager();
    resources.initialize();

    scene = new SceneManager();

    player = new Player(100.0, 100.0, resources.getRawTexture("player"));
    entities.add(player);
    inputReceivers.add(player);
  }

  @Override
  public void render() {
    ScreenUtils.clear(0, 0, 0.2f, 1);

    // dispatch inputs
    inputs.handleInputs();
    inputs.dispatchAll(entities.get());

    entities.moveAll();

    // draw
    scene.drawAll(entities.get());
  }

  @Override
  public void dispose() {
    scene.dispose();
    resources.dispose();
  }
}
