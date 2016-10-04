package dev.tilegame.entities.creatures;

import java.awt.Graphics;
import java.net.InetAddress;

import dev.tilegame.Handler;

public class PlayerMP extends Player{
	
	public InetAddress ipClient;
	public int portClient;
	
	public PlayerMP(int id, String username, Handler handler, float x, float y, InetAddress ipClient, int port) {
		super(id, username, handler, x, y);
		this.ipClient = ipClient;
		this.portClient = port;
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
	}
}
