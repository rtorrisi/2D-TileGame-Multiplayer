package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	private static int speed=60;
	private int index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	public Animation(BufferedImage[] frames) {
		this.frames=frames;
		index=0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) index=0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
	public static void setSpeed(int x) { speed=x; }
}
