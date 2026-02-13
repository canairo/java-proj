package io.github.some_example_name.lwjgl3;
import java.util.ArrayList;

public class OutputManager {
    
    private ArrayList<OutputDevice> outputList = new ArrayList<>(); 

    public void addDevices(OutputDevice device) {
        outputList.add(device);
    }

    public void initializeDevices() {
        for (OutputDevice device : outputList) {
            device.initialize();
        }
    }

    public void updateDevices() {
        for (OutputDevice device : outputList) {
            device.update();
        }
    }

    public void sendCommand(String command, int value) {
        for (OutputDevice device : outputList) {
            if (device instanceof IOutputAction) {
                ((IOutputAction) device).execute(command, value);
            }
        }
    }

    public void shutdownDevices() {
        for (OutputDevice device : outputList) {
            device.shutdown();
        }
    }
}