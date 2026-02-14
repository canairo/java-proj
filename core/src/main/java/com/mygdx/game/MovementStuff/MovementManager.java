package com.mygdx.game.Managers;

import com.mygdx.game.Input.iMovable;
import java.util.ArrayList;
import java.util.List;

// JH DRAFT AS OF 14TH FEB 2026!

// MovementManager handles movement coordination
// This specific class does NOT handle specific movement operations.
// Purpose: manages the objects that need updating

public class MovementManager {
	
	// 1. setting private fields
	private List <iMovable> movableObjects; 
	private float Velocity; //shift this to entity class?
	protected float maxSpeed; //shift this to entity class?
	
	public MovementManager() {
		this.movableObjects = new ArrayList<>();
	}

	// 2. register movable object with this manager
	public void addMovable(iMovable movable) {
        if (!movableObjects.contains(movable)) {
            movableObjects.add(movable);
        }
    }
    
    /**
     * Unregister a movable object from this manager
     */
    public void removeMovable(iMovable movable) {
        movableObjects.remove(movable);
    }
    
    /*
     * Update all registered movable objects
     * This delegates to each object's own movement() method
     */
    public void updateAll() {
        for (iMovable movable : movableObjects) {
            movable.movement();
        }
    }
    
    // Get all registered movable objects
    public List<iMovable> getMovableObjects() {
        return movableObjects;
    }
    
    // Clear all registered objects
    public void clear() {
        movableObjects.clear();
    }
    
     // * Get the count of managed objects
    public int getCount() {
        return movableObjects.size();
    }

	/**
	 * Implements the iMovable interface
	 * This is the main entry point that delegates to specific movement methods
	 */
	public void movement() {
		// TODO Auto-generated method stub
		
	}
}