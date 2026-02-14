package core.src.main.java.com.mygdx.game.Movement;

import com.mygdx.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Input.Keyboard;
import com.mygdx.game.Managers.MovementManager;

/**
 * MovementObject extends Entity and implements all the heavy movement logic.
 * All properties and get/set methods are inherited from Entity.
 */
public class MovementObject extends MovementManager {
    
    // Object dimensions
    private static final float DEFAULT_WIDTH = 64f;
    private static final float DEFAULT_HEIGHT = 64f;
	private boolean isAIControlled;
	private Texture tex;
    
    /**
     * Constructor for MovementObject with texture
     */
    public MovementObject(String texturePath, float x, float y, float speed, boolean isAIControlled, Color color) {
        super(x, y, speed, color);
        this.tex = new Texture(texturePath);
        this.isAIControlled = isAIControlled;
    }
    
    /**
     * Constructor without texture
     */
    public MovementObject(float x, float y, float speed, boolean isAIControlled, Color color) {
        super(x, y, speed, color);
        this.tex = null;
        this.isAIControlled = isAIControlled;
    }
    
    /**
     * Simplified constructor with default color
     */
    public MovementObject(String texturePath, float x, float y, float speed, boolean isAIControlled) {
        this(texturePath, x, y, speed, isAIControlled, Color.WHITE);
    }
    
    /**
     * Implements the iMovable interface
     * This is the main entry point that delegates to specific movement methods
     */
    @Override
    public void movement() {
        if (isAIControlled) {
            AIMovement();
        } 
        else {
            userMovement();
        }
    }
    
    /**
     * USER MOVEMENT - All the heavy logic for user-controlled movement
     * Handles keyboard input and boundary checking
     */
    public void userMovement() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        // Detect input keys and update position
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= speed * deltaTime;	//x and speed variables are to be parked under entity class
        }
        
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += speed * deltaTime;
        }
        
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            y += speed * deltaTime;
        }
        
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            y -= speed * deltaTime;
        }
        
        // Apply boundary constraints
        applyBoundaries();
    }
    
    /**
     * AI MOVEMENT - All the heavy logic for AI-controlled movement
     * Makes objects fall and reset when they go off screen
     */
    public void AIMovement() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        // Move downward
        y -= speed * deltaTime;
        
        // Reset position when object falls below screen
        if (y <= -getHeight()) {
            y = Gdx.graphics.getHeight();
            x = (float)(Math.random() * (Gdx.graphics.getWidth() - getWidth()));
        }
    }
    
    /**
     * Alternative AI movement - simple downward movement without reset
     */
    public void simpleAIMovement() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        y -= speed * deltaTime;
    }
    
    /**
     * BOUNDARY CHECKING - Heavy logic to keep objects within screen bounds
     */
    private void applyBoundaries() {
        // Check X boundaries
        if (x < 0) {
            x = 0;
        }
        
        float maxX = Gdx.graphics.getWidth() - getWidth();
        if (x > maxX) {
            x = maxX;
        }
        
        // Check Y boundaries
        if (y < 0) {
            y = 0;
        }
        
        float maxY = Gdx.graphics.getHeight() - getHeight();
        if (y > maxY) {
            y = maxY;
        }
    }
    
    /**
     * VELOCITY-BASED MOVEMENT - More advanced movement with acceleration
     */
    public void applyVelocity() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        float velocity;
		// Apply velocity to position
        x += velocity * deltaTime;
        
        // Clamp velocity to max speed
        if (Math.abs(velocity) > maxSpeed) {
            velocity = velocity > 0 ? maxSpeed : -maxSpeed;
        }
        
        applyBoundaries();
    }
    
    /**
     * ACCELERATED MOVEMENT - Movement with acceleration and deceleration
     */
    public void acceleratedMovement(float acceleration) {
        float deltaTime = Gdx.graphics.getDeltaTime();
        
        // Apply acceleration based on input
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            velocity -= acceleration * deltaTime;
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            velocity += acceleration * deltaTime;
        } else {
            // Apply friction/deceleration when no input
            if (Math.abs(velocity) > 0) {
                float deceleration = acceleration * 0.5f * deltaTime;
                if (velocity > 0) {
                    velocity = Math.max(0, velocity - deceleration);
                } else {
                    velocity = Math.min(0, velocity + deceleration);
                }
            }
        }
        
        applyVelocity();
    }
    
    /**
     * Update method for debugging/logging
     */
    @Override
    public void update() {
        System.out.println("MovementObject at position: " + x + ", " + y);
    }
    
    // Texture-specific methods
    public Texture getTexture() {
        return tex;
    }
    
    public void setTexture(Texture texture) {
        this.tex = texture;
    }
    
    public float getWidth() {
        return tex != null ? tex.getWidth() : DEFAULT_WIDTH;
    }
    
    public float getHeight() {
        return tex != null ? tex.getHeight() : DEFAULT_HEIGHT;
    }
    
    /**
     * Dispose of texture resources when no longer needed
     */
    public void dispose() {
        if (tex != null) {
            tex.dispose();
        }
    }
}
