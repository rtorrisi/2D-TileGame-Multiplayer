package dev.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;

public class MenuState extends State {
	private BufferedImage menuImage;
	
	public MenuState(Handler handler){
		super(handler);
		menuImage = Assets.menuImage;
	}

	public void tick() {
		handler.getWorld().tick();
		menuImage = Assets.menuImage;
				
		if(handler.getMouseManager().getMouseY() > 65 && handler.getMouseManager().getMouseY() < 90 ) {
			menuImage = Assets.playImage;
			if(handler.getMouseManager().isLeftPressed()) State.setState(handler.getGame().gameState);
		}
		
		else if(handler.getMouseManager().getMouseY() > 160 && handler.getMouseManager().getMouseY() < 185 ) {
			menuImage = Assets.settingImage;
		}
		
		else if(handler.getMouseManager().getMouseY() > 250 && handler.getMouseManager().getMouseY() < 275 ) {
			menuImage = Assets.creditsImage;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(menuImage, 0, 0, null);
		
		int offsetX = 80;
		g.setColor(Color.white);
		g.drawString("Nickname :    "+Game.getPlayer().getUsername(), 500-offsetX, 40);
		
		if(Game.isServer()) {
			g.drawString("Server Public Ip :    "+handler.getGame().getServerPublicAddress()+" : "+handler.getGame().getServerPort(), 471-offsetX, 60);
			g.drawString("Server Local Ip :    "+handler.getGame().getServerAddress()+" : "+handler.getGame().getServerPort(), 475-offsetX, 80);
		}
	}
	
}