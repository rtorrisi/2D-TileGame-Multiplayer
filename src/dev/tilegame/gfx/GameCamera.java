package dev.tilegame.gfx;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	private int playerSize;
	
	public GameCamera(Handler handler, float xOffset, float yOffset, int playerSize){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.playerSize = playerSize;
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getDisplayWidth() / 2 + playerSize / 2;
		yOffset = e.getY() - handler.getDisplayHeight() / 2 + playerSize / 2;
		checkBlankSpace();
	}
	
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWorldSize() * Game.grid - handler.getDisplayWidth()){
			xOffset = handler.getWorld().getWorldSize() * Game.grid - handler.getDisplayWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getWorldSize() * Game.grid - handler.getDisplayHeight()){
			yOffset = handler.getWorld().getWorldSize() * Game.grid - handler.getDisplayHeight();
		}
	}

	public float getxOffset() {return xOffset;}
	public void setxOffset(float xOffset) {this.xOffset = xOffset;}
	public float getyOffset() {return yOffset; }
	public void setyOffset(float yOffset) {this.yOffset = yOffset;}

}