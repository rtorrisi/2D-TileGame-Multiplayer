package dev.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.PlayerMP;
import dev.tilegame.entities.statics.Decoration;

public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		public int compare(Entity a, Entity b) {
			if(a.getY() < b.getY() ) return -1;
			return 1;
		}
		
	};
	
	public EntityManager(Handler handler){
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick(){
		for(int i = 0; i<entities.size(); i++){
			entities.get(i).tick();
		}
		try { entities.sort(renderSorter); } catch(RuntimeException e) {}
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Game.grid);
		int xEnd = (int) Math.min(handler.getWorld().getWorldSize(), (handler.getCamera().getxOffset() + handler.getDisplayWidth())/Game.grid+1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Game.grid);
		int yEnd = (int) Math.min(handler.getWorld().getWorldSize(), (handler.getCamera().getyOffset() + handler.getDisplayHeight())/Game.grid+1);
		
		for(int i = 0; i < entities.size();i++){
			int x = (int) entities.get(i).getX() / Game.grid;
			int y = (int) entities.get(i).getY() / Game.grid;
			if(x>=xStart && x<xEnd && y>=yStart && y<yEnd)
				entities.get(i).render(g);
		}
	}
	
	private int getPlayerMPIndex(String username) {
			for(int index=0; index<entities.size(); index++) {
				if(entities.get(index) instanceof PlayerMP && ((PlayerMP)entities.get(index)).getUsername().equalsIgnoreCase(username) )
					return index;
			}
		return -1;
	}
	
	public void addEntity(Entity e){
		if(e instanceof Decoration) removeDuplicate(e);
		entities.add(e);
	}
	
	public void removePlayerMP(String username) {
		int index=0;
		for(Entity e : entities) {
			if(e instanceof PlayerMP && ((PlayerMP)e).getUsername().equalsIgnoreCase(username)) break;
			index++;
		}
		
		if(index<entities.size()) entities.remove(index);
	}
	
	public void movePlayer(String username, int x, int y) {
		int index = getPlayerMPIndex(username);
		if (index==-1 || index>=entities.size() || ((PlayerMP)entities.get(index)).getUsername().equalsIgnoreCase(Game.getPlayer().getUsername())) return;
		((PlayerMP)entities.get(index)).targetX = x;
		((PlayerMP)entities.get(index)).targetY = y;
	}
	
	private void removeDuplicate(Entity e){
		for(int i = 0; i < entities.size();i++){
			Entity tmp = entities.get(i);
			if (tmp.getX()==e.getX() && tmp.getY()==e.getY()){
				entities.remove(i);
				return;
			}
		}
	}
	
	//GETTERS SETTERS

	public Handler getHandler() { return handler; }
	public void setHandler(Handler handler) { this.handler = handler; }
	public ArrayList<Entity> getEntities() { return entities; }
	public void setEntities(ArrayList<Entity> entities) { this.entities = entities; }
}