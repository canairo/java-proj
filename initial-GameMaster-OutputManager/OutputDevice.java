package io.github.some_example_name.lwjgl3;

public abstract class OutputDevice {
    protected int deviceId;

    public abstract boolean initialize();
    public abstract void shutdown();
    public abstract void update();
}
