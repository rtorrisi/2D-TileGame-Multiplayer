package dev.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class SpriteSheet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet=sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y+3, width, height);
	}
}
