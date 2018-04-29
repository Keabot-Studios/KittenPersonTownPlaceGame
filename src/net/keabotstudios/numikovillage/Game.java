package net.keabotstudios.numikovillage;

import org.lwjgl.glfw.GLFW;

public class Game {

	private DisplayManager display;
	
	public Game() {
		this.init();
		this.loop();
	}

	private void init() {
		display = new DisplayManager();
		display.initalize(1280, 720, "Fuck.", this::kCallback);
	}
	
	private void kCallback(long window, int key, int scanCode, int action, int mods) {
		if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_PRESS)
			display.close();
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
	private void loop() {
		while (!display.shouldClose()) {
			display.update();
		}
		display.destroy();
	}
}
