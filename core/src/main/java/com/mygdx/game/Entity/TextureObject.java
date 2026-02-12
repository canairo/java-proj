package core.src.main.java.com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject extends Entity {
    private Texture tex;
    private boolean isAIControlled;

    public TextureObject(String internalPath, float x, float y, float speed, boolean isAIControlled) {
        super(x, y, speed, Color.WHITE);
        this.tex = new Texture(internalPath);
        this.isAIControlled = isAIControlled;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tex, x, y, 64, 64);
    }

    @Override
    public void movement() {
        // Example: If it's a bucket, move with Left/Right arrows
        if (isAIControlled) {
            y -= 10;
        }
        else {
            if (Gdx.input.isKeyPressed(Keys.LEFT)) x -= speed * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) x += speed * Gdx.graphics.getDeltaTime();
        }
    }

    // Specifically for raindrops to fall automatically
    public void fall() {
        y -= speed * Gdx.graphics.getDeltaTime();
        if (y < -64) y = 480;
    }

    public Texture getTexture() { return tex; }

    @Override
    public void update() {
        System.out.println("TextureObject at position: " + getX() + ", " + getY());
    }

}
