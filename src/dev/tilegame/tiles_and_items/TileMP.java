package dev.tilegame.tiles_and_items;

import dev.tilegame.gfx.Assets;

public class TileMP extends Tile{
	private static final long serialVersionUID = 1L;
	public int index;
	private int x, y;
	
	public TileMP(int index, boolean collision, int x, int y) {
		super(Assets.tileList.get(index-1), collision);
		this.index=index;
		this.x=x;
		this.y=y;
	}
	public int getIndex() { return index; }
	public int getX() { return x; }
	public int getY() { return y; }
}
