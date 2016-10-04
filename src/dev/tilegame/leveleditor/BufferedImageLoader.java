package dev.tilegame.leveleditor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	//PUBLIC:
	public BufferedImage loadImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
