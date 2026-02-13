package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class GameMaster extends ApplicationAdapter {
    private OutputManager outputMgr;
//	private InputManager inputMgr;
//	private SceneManager sceneMgr;
//	private EntityManager entityMgr;
//	private MovementManager movementMgr;

    @Override
    public void create() {
    	System.out.println("Engine Core Initializing...");
        outputMgr = new OutputManager();
//        inputMgr = new InputManager();
//        sceneMgr = new SceneManager();
//        entityMgr = new EntityManager();
//        movementMgr = new MovementManager();
        
        outputMgr.addDevices(new AudioPlayerDevice(1));
        outputMgr.initializeDevices();
    }

    @Override
    public void render() {
    	if (outputMgr != null) {
            outputMgr.updateDevices();
        }
    	
    	// to add other managers' update functions here
    	
    	// testing of playing audio on click
    	if (Gdx.input.justTouched()) {
    		outputMgr.sendCommand("PLAY_SOUND", 1);
        }
    }

    @Override
    public void dispose() {
    	System.out.println("Shutting down engine...");
       
        if (outputMgr != null) {
            outputMgr.shutdownDevices();
        }
    }
    
    // Getters for communication through GameMaster
    public OutputManager getOutputMgr() {
        return outputMgr;
    }
    
//    public SceneManager getSceneMgr() {
//    	return sceneMgr; 
//    }
//    public EntityManager getEntityMgr() {
//    	return entityMgr; 
//    }
//    public MovementManager getMovementMgr() {
//    	return movementMgr; 
//    }
//    
}
