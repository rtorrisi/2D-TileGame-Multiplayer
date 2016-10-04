package dev.tilegame.states;
import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.leveleditor.LevelEditor;
import dev.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;
	public static LevelEditor editor;
	
	public GameState(Handler handler) {
		super(handler);
		
		world = new World(handler, Game.worldSize);
		handler.setWorld(world);
		handler.loadWorld();
		editor = new LevelEditor(handler, world, Game.grid);
	}
	
	public void tick() {
		world.tick();
	}

	public void render(Graphics g) {
		world.render(g);
	}
}
