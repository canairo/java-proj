package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Triangle extends Entity {
    public Triangle(float x, float y, float speed, Color color) {
        super(x, y, speed, color);
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(this.color);
        // Drawing counter-clockwise around center (x,y)
        float size = 50;
        shape.triangle(
            x - size, y - size, // P1: Bottom Left
            x + size, y - size, // P2: Bottom Right
            x, y + size         // P3: Top Middle
        );
    }

    @Override
    public void movement() {
        // Control: A and D keys
        if (Gdx.input.isKeyPressed(Keys.A)) x -= speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.D)) x += speed * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void update() {
        String updatestr = String.format("in triangle at posn %f %f", this.x, this.y);
        System.out.println(updatestr);
    }
}
