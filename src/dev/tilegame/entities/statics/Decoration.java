package dev.tilegame.entities.statics;

import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.tiles_and_items.Item;

public class Decoration extends StaticEntity {
	
	private Item item;
	
	public Decoration(Handler handler, Item item, float x, float y) {
		super(handler, x, y);
		this.item = item;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.drawImage(item.getTileImage(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), null);
	}
}
