package dev.tilegame.leveleditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.statics.Decoration;
import dev.tilegame.gfx.LevelEditorCamera;
import dev.tilegame.net.packets.Packet11Tile;
import dev.tilegame.net.packets.Packet12Item;
import dev.tilegame.tiles_and_items.Item;
import dev.tilegame.tiles_and_items.Tile;
import dev.tilegame.worlds.World;


public class PreviewPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;
	//PRIVATE:
	private int grid;
	private Handler handler;
	private World world;
	public static LevelEditorCamera editorCamera = new LevelEditorCamera(0, 0); //offset iniziale
	private int previewWidth, previewHeight;
	public Tile paintTile = null;
	public Item paintItem = null; 
	public int index=-1;
	public ArrayList<Item> multiItem;
	
	//PUBLIC:
	public PreviewPanel(Handler handler, World world, int previewWidth, int previewHeight, int grid){
		super();
		this.handler=handler;
		this.world=world;
		this.previewWidth=previewWidth;
		this.previewHeight=previewHeight;
		this.grid=grid;
		multiItem = new ArrayList<Item>();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, previewWidth, previewHeight);
		
		int xStart = (int) Math.max(0, editorCamera.getxOffset()/grid);
		int xEnd = (int) Math.min(world.getWorldSize(), (editorCamera.getxOffset() + previewWidth)/grid);
		int yStart = (int) Math.max(0, editorCamera.getyOffset()/grid);
		int yEnd = (int) Math.min(world.getWorldSize(), (editorCamera.getyOffset() + previewHeight)/grid);		
		
		
		for(int y=yStart; y<yEnd; y++){
			for(int x=xStart; x<xEnd; x++){
				World.tiles[y][x].render(g, (int)(x*grid - editorCamera.getxOffset()),
											(int)(y*grid - editorCamera.getyOffset()));
				if(World.items[y][x]!=null)World.items[y][x].render(g, (int)(x*grid - editorCamera.getxOffset()),
											(int)(y*grid - editorCamera.getyOffset()));
			 }
		}
		
		
		//STAMPA GRIGLIA
		if(LevelEditor.getGridVisibility()) {
			g.setColor(Color.black);
			for(int i = 0; i < previewWidth; i+=grid){
				g.fillRect(i-1, 0, 1, previewHeight);
				g.fillRect(i, 0, 1, previewHeight);
				g.fillRect(0, i, previewWidth, 1);
				g.fillRect(0, i-1, previewWidth, 1);
			}
		}
	}

	public void mouseDragged(MouseEvent e){if(paintItem==null)mousePressed(e);}
	public void mousePressed(MouseEvent e){
		int x = e.getX(); x = x/grid + (int) editorCamera.getxOffset()/grid;
		int y = e.getY(); y = y/grid + (int) editorCamera.getyOffset()/grid;
		
		if(	x>=0 && x < world.getWorldSize() && y>=0 && y < world.getWorldSize()) {
			if(paintItem==null && paintTile==null) {
				if(x+1 < world.getWorldSize() && y+1 < world.getWorldSize()) {
					World.items[y][x] = multiItem.get(0);
					World.items[y][x+1] = multiItem.get(1);
					World.items[y+1][x] = multiItem.get(2);
					World.items[y+1][x+1] = multiItem.get(3);
					
					//world.entityManager.addEntity(new Decoration(handler, multiItem.get(0), x*Game.getGrid(), y*Game.getGrid()));
					//world.entityManager.addEntity(new Decoration(handler, multiItem.get(1), (x+1)*Game.getGrid(), y*Game.getGrid()));
					//world.entityManager.addEntity(new Decoration(handler, multiItem.get(2), x*Game.getGrid(), (y+1)*Game.getGrid()));
					//world.entityManager.addEntity(new Decoration(handler, multiItem.get(3), (x+1)*Game.getGrid(), (y+1)*Game.getGrid()));
				}
			}
			else if(paintItem==null) {
				World.tiles[y][x] = paintTile;
				int collision = (paintTile.hasCollider()?1:0);
				Packet11Tile packet = new Packet11Tile(index, collision, x, y);
				packet.writeData(Game.getClient());
			}
			
			else if(paintTile==null) {
				World.items[y][x] = paintItem;
				world.entityManager.addEntity(new Decoration(handler, paintItem, x*Game.grid, y*Game.grid));
				int collision = (paintItem.hasCollider()?1:0);
				int interaction = (paintItem.hasInteraction()?1:0);
				Packet12Item packet = new Packet12Item(index, collision, interaction, x, y);
				packet.writeData(Game.getClient());
			}
		}
	
		repaint();
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
