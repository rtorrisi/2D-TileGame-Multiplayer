package dev.tilegame.tiles_and_items;

import dev.tilegame.gfx.Assets;

public class ItemMP extends Item{
	
	private static final long serialVersionUID = 1L;
	public int index;
	private int x, y;
	
	public ItemMP(int index, boolean collision, boolean interaction, int x, int y) {
		super(Assets.itemList.get(index-1), collision, interaction);
		this.index=index;
		this.x=x;
		this.y=y;
	}
	
	public ItemMP(int index,int x, int y) {
		super(Assets.itemList.get(index-1), false, false);
		this.index=index;
		this.x=x;
		this.y=y;
	}
	
	public int getIndex() { return index; }
	public int getX() { return x; }
	public int getY() { return y; }
}
