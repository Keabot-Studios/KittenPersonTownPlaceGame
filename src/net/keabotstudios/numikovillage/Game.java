package net.keabotstudios.numikovillage;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Game {

	private DisplayManager display;
	
	public Game() {
		this.init();
		this.loop();
	}

	private void init() {
		display = new DisplayManager();
		display.initalize(1280, 720, "Nu mikko vill ag", this::kCallback);
	}
	
	private void kCallback(long window, int key, int scanCode, int action, int mods) {
		if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_PRESS)
			display.close();
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	
	private void loop() {
		GL11.glClearColor(0.5f, 0.5f, 0.5f, 1f);
		while (!display.shouldClose()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			display.update();
		}
		display.destroy();
	}
}
