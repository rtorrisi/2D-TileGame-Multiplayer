package dev.tilegame.tiles_and_items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//CLASS
	private transient BufferedImage texture;
	private boolean collision, interaction;
	
	public Item(BufferedImage texture, boolean collision, boolean interaction) {
		this.texture = texture;
		this.collision=collision;
		this.interaction=interaction;
	}
	
	public Item(BufferedImage texture) {
		this.texture = texture;
		this.collision=false;
		this.interaction=false;
	}
	
	public Item(BufferedImage texture, boolean collision) {
		this.texture = texture;
		this.collision=collision;
		this.interaction=false;
	}
	
	public BufferedImage getTileImage() { return texture; }
	public boolean hasInteraction() {return interaction;}
	public boolean hasCollider() {return collision;}
	
	public void tick() {}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, null);
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(texture, "png", out);
    }
	
	 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	        in.defaultReadObject();
	        texture = ImageIO.read(in);
	    }
}
