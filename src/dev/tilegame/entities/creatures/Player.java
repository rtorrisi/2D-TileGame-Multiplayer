package dev.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;
import dev.tilegame.net.packets.Packet02Move;

public class Player extends Creature{
	
	private String username;
	private int id;
	private Animation animIdle, animDown, animUp, animLeft, animRight;
	//net
	private int sendTick;
	public int targetX, targetY;
	
	public Player(int id, String username, Handler handler, float x, float y) {
		super(handler, x, y);
		this.id = id;
		this.username = username;
		bounds.x=13;
		bounds.y=20;
		bounds.width=4;
		bounds.height=11;
		sendTick=0;
		
		if(id==1) {
			animDown = new Animation(Assets.pg_front);
			animUp = new Animation(Assets.pg_back);
			animLeft = new Animation(Assets.pg_left);
			animRight = new Animation(Assets.pg_right);
			animIdle = new Animation(Assets.pg_idle);
		}
		else {
			animDown = new Animation(Assets.pg2_front);
			animUp = new Animation(Assets.pg2_back);
			animLeft = new Animation(Assets.pg2_left);
			animRight = new Animation(Assets.pg2_right);
			animIdle = new Animation(Assets.pg2_idle);
			targetX = (int)x;
			targetY = (int)y;
		}
	}

	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		Animation.setSpeed(60);
	
		if(id==1) {
			if(handler.getKeyManager().w) yMove = -speed;
			if(handler.getKeyManager().s) yMove = +speed;
			if(handler.getKeyManager().a) xMove = -speed;
			if(handler.getKeyManager().d) xMove = +speed;
		}
		
		else {
			if(y>targetY) yMove = -speed;
			if(y<targetY) yMove = +speed;
			if(x>targetX) xMove = -speed;
			if(x<targetX) xMove = +speed;
		}
		
	}
	
	@Override
	public void tick() {
		
		animIdle.tick();
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();

		getInput();	
		move();
		
		if(id==1) {
			if(sendTick++==10) {
				sendTick=0;
				Packet02Move packet = new Packet02Move(username, (int)x, (int)y);
				packet.writeData(Game.getClient());
			}
			
			handler.getCamera().centerOnEntity(this);
		}
	}

	@Override
	public void render(Graphics g) {
		int posX = (int)(x - handler.getCamera().getxOffset());
		int posY = (int)(y - handler.getCamera().getyOffset());
		
		g.drawString(username, posX, posY-10);
		g.drawImage(getCurrentAnimationFrame(), posX, posY, null);
		
		/*g.setColor(Color.red);
		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),
				   (int)(y + bounds.y - handler.getCamera().getyOffset()),
				   bounds.width, bounds.height);
		*/
	}
	
	public BufferedImage getCurrentAnimationFrame() {
			if(yMove < 0) { return animUp.getCurrentFrame(); }
			else if(yMove > 0) { return animDown.getCurrentFrame(); }
			else if(xMove < 0) { return animLeft.getCurrentFrame(); }
			else if(xMove > 0) { return animRight.getCurrentFrame(); }
			else return animIdle.getCurrentFrame();
	}
	
	public String getUsername() { return username; }
}
