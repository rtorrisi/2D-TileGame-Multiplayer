package dev.tilegame;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("Game Title!", 640, 360);
		game.start();
	}
}
