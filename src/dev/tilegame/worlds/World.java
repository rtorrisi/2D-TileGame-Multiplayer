package dev.tilegame.worlds;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.EntityManager;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles_and_items.*;

public class World implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Handler handler;
	private int worldSize;
	public transient static Tile[][] tiles;
	public transient static Item[][] items;
	//Entities
	public EntityManager entityManager;
	
	public World(Handler handler, int worldSize){
		this.handler = handler;
		entityManager = new EntityManager(handler);
		this.worldSize = worldSize;
		initWorld();
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Game.grid);
		int xEnd = (int) Math.min(worldSize, (handler.getCamera().getxOffset() + handler.getDisplayWidth())/Game.grid+1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Game.grid);
		int yEnd = (int) Math.min(worldSize, (handler.getCamera().getyOffset() + handler.getDisplayHeight())/Game.grid+1);		
		
		for(int y=yStart; y < yEnd; y++){
			for(int x=xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int)(x*Game.grid - handler.getCamera().getxOffset()),
										(int)(y*Game.grid - handler.getCamera().getyOffset()));
			}
		}
		
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x<0 || y<0 || x>=worldSize || y>=worldSize) return tiles[0][0];
		return tiles[y][x];
	}
	public Item getItem(int x, int y) {
		if(x<0 || y<0 || x>=worldSize || y>=worldSize) return items[0][0];
		return items[y][x];
	}
	
	private void initWorld(){
		tiles = new Tile[worldSize][worldSize];
		items = new Item[worldSize][worldSize];

		Random rand;
		rand = new Random();
		
		for(int i=0; i<worldSize; i++) {
			for(int j=0; j<worldSize; j++) {
				int r = rand.nextInt()%100;
				if(r<33)tiles[i][j] = new Tile(Assets.a6);
				else if(r<66)tiles[i][j] = new Tile(Assets.a12);
				else tiles[i][j] = new Tile(Assets.a24);
			}
		}
	}
	
	public int getWorldSize() { return worldSize; }

}