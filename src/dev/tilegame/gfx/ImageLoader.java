package dev.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class ImageLoader implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static BufferedImage loadImage(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	
		return img;
	}
}
