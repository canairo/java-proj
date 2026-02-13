package io.github.some_example_name.lwjgl3;

public interface IOutputAction {
	// command identifies the type of output, value is the ID for that output
	void execute(String command, int value);
}
