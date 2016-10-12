package dev.tilegame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dev.tilegame.entities.statics.Decoration;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.tiles_and_items.Item;
import dev.tilegame.tiles_and_items.Tile;
import dev.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {this.game=game;}
	
	public KeyManager getKeyManager(){ return game.getKeyManager();}
	public MouseManager getMouseManager() { return game.getMouseManager(); }
	public GameCamera getCamera() { return game.getCamera(); }
	
	public int getDisplayWidth(){ return game.getDisplayWidth();}
	public int getDisplayHeight(){ return game.getDisplayHeight();}
	public static int getGrid(){ return Game.grid; }
	
	public Game getGame() {return game;}
	public void setGame(Game game) {this.game = game;}
	
	public World getWorld() {return world;}
	public void setWorld(World world) {this.world = world;}
	
	public void saveWorld() {

		for(int i=0; i<world.getWorldSize(); i++) {
			for(int j=0; j<world.getWorldSize(); j++) {
				try {
					if( !World.tiles[i][j].getTileImage().equals(Assets.a6) && !World.tiles[i][j].getTileImage().equals(Assets.a12) && !World.tiles[i][j].getTileImage().equals(Assets.a24) ) {
						ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Data/World/worldTiles_"+i+"_"+j+"_.dat"));
						os.writeObject(World.tiles[i][j]);
						os.close();
					}
				
				} catch (FileNotFoundException e1) {
				} catch (IOException e1) {
				}
				
				//Item
				
				try {
					if(world.getItem(j, i)!=null) {
						ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Data/World/worldItems_"+i+"_"+j+"_.dat"));
						os.writeObject(World.items[i][j]);
						os.close();
					}
				} catch (FileNotFoundException e1) {
				} catch (IOException e1) {
				}
			}
		}
		
	}
	
	public void loadWorld() {
		world.entityManager.getEntities().clear();		
		
		for(int i=0; i<world.getWorldSize(); i++) {
			for(int j=0; j<world.getWorldSize(); j++) {
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data/World/worldTiles_"+i+"_"+j+"_.dat"));
					Tile t = (Tile) in.readObject();
					if(t!=null)World.tiles[i][j] = t;
					in.close();
				}
				catch (FileNotFoundException e) {} 
				catch (IOException e) {}
				catch (ClassNotFoundException e) {}
				
				//Item
				
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data/World/worldItems_"+i+"_"+j+"_.dat"));
					World.items[i][j] = (Item) in.readObject();
						if(World.items[i][j]!=null) {
							world.entityManager.addEntity(new Decoration(this, World.items[i][j], j*Game.grid, i*Game.grid));
						}
					in.close();
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				} catch (ClassNotFoundException e) {
				}
			}
		}
	}
}
