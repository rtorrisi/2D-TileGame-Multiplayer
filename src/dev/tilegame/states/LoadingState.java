package dev.tilegame.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.tilegame.Handler;
import dev.tilegame.gfx.ImageLoader;

public class LoadingState extends State {
	public static BufferedImage loadingImage;
	
	public LoadingState(Handler handler){
		super(handler);
		loadingImage = ImageLoader.loadImage("/textures/loading.png");
	}

	public void tick() {}
	public void render(Graphics g) { g.drawImage(loadingImage, 0, 0, null); }
	
}