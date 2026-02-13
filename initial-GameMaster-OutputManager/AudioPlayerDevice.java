package io.github.some_example_name.lwjgl3;

public class AudioPlayerDevice extends OutputDevice implements IOutputAction {

    public AudioPlayerDevice(int id) { 
        this.deviceId = id; 
    }

    @Override
    public boolean initialize() {
        System.out.println("[AudioDevice " + deviceId + "] Initialized.");
        return true;
    }

    @Override
    public void execute(String command, int value) {
        if (command.equalsIgnoreCase("PLAY_SOUND")) {
            System.out.println("[AudioDevice " + deviceId + "] Executing: " + command + " with ID: " + value);
        }
    }
    
    @Override public void update() {}

    @Override
    public void shutdown() {
        System.out.println("[AudioDevice " + deviceId + "] Shutdown.");
    }
    
}
