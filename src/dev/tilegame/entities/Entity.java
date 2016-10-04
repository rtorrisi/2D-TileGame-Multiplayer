package dev.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.tilegame.Game;
import dev.tilegame.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		
		bounds = new Rectangle(0,0,Game.grid,Game.grid);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public float getX() {return x;}
	public void setY(float y) {this.y = y;}
	public void setX(float x) {this.x = x;}
	public float getY() {return y;}

}
