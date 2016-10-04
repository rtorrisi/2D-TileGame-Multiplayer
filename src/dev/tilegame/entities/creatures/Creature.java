package dev.tilegame.entities.creatures;
import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALT = 10;
	public static final float DEFAULT_SPEED = 1.0f;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	protected boolean isMoving;
	
	public Creature(Handler handler, float x, float y) {
		super(handler, x, y);
		health = DEFAULT_HEALT;
		speed = DEFAULT_SPEED;
		xMove=0;
		yMove=0;
		isMoving=false;
	}
	
	public void move(){
		isMoving=false;
		moveX();
		moveY();
	}
	
	public void moveX(){
		
		if(xMove > 0){//Moving right
			isMoving=true;
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Game.grid;
			
			if(!collisionTile(tx, (int) (y + bounds.y) / Game.grid) &&
			   !collisionTile(tx, (int) (y + bounds.y + bounds.height) / Game.grid)){
				x += xMove;
			}else{
				x = tx * Game.grid - bounds.x - bounds.width - 1;
			}
		}else if(xMove < 0){//Moving left
			isMoving=true;
			int tx = (int) (x + xMove + bounds.x) / Game.grid;
			
			if(!collisionTile(tx, (int) (y + bounds.y) / Game.grid) &&
					!collisionTile(tx, (int) (y + bounds.y + bounds.height) / Game.grid)){
				x += xMove;
			}else{
				x = tx * Game.grid + Game.grid - bounds.x;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			isMoving=true;
			int ty = (int) (y + yMove + bounds.y) / Game.grid;
			
			if(!collisionTile((int) (x + bounds.x) / Game.grid, ty) &&
					!collisionTile((int) (x + bounds.x + bounds.width) / Game.grid, ty)){
				y += yMove;
			}
			else{
				y = ty * Game.grid + Game.grid - bounds.y;
			}
		}
		else if(yMove > 0){//Down
			isMoving=true;
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Game.grid;
			
			if(!collisionTile((int) (x + bounds.x) / Game.grid, ty) &&
					!collisionTile((int) (x + bounds.x + bounds.width) / Game.grid, ty)){
				y += yMove;
			}else{
				y = ty * Game.grid - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionTile(int x, int y) {
		if(handler.getWorld().getTile(x, y).hasCollider()) return true;
		if(handler.getWorld().getItem(x, y)!=null) return handler.getWorld().getItem(x, y).hasCollider();
		return false;
	}
	
	//Getter & Setter
	public float getxMove() {return xMove;}
	public float getyMove() {return yMove;}
	public int getHealth() {return health;}
	public float getSpeed() {return speed;}
	public void setxMove(float xMove) {this.xMove = xMove;}
	public void setyMove(float yMove) {this.yMove = yMove;}
	public void setHealth(int health) {this.health = health;}
	public void setSpeed(float speed) {this.speed = speed;}
	
}
