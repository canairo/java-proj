package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameMaster extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shape;

    private TextureObject bucket;
    private TextureObject[] raindrops;
    private Circle circle;
    private Triangle triangle;
    private EntityManager entities;
    private InputManager inputs;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        entities = new EntityManager();

        // Instantiate Subclasses
        bucket = new TextureObject("bucket.png", 300, 20, 200, false);
        circle = new Circle(600, 300, 150, Color.RED, 50);
        triangle = new Triangle(100, 100, 150, Color.GREEN);

        entities.add(bucket);
        entities.add(circle);
        entities.add(triangle);

        for (int i = 0; i < 5; i++) {
            entities.add(new TextureObject("droplet.png", 100 + (i * 100), 400, 100, true));
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // 1. Handle Movements
        entities.movement();
        entities.update();

        inputs.handleInputs();

        // 2. Draw Textures (SpriteBatch)
        batch.begin(); shape.begin(ShapeRenderer.ShapeType.Filled);
        entities.draw(batch, shape);
        batch.end(); shape.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
    }
}
