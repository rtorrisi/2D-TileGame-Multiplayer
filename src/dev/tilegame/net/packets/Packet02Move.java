package dev.tilegame.net.packets;

import dev.tilegame.net.GameClient_UDP;

public class Packet02Move extends Packet{
	
	private String username;
	private int x, y;
	
	//COSTRUTTORI
	public Packet02Move(byte[] data) {
		super(02); 
		String[] dataArray = readData(data).split(",");
		username = dataArray[0];
		x = Integer.parseInt(dataArray[1]);
		y = Integer.parseInt(dataArray[2]);
	}
	public Packet02Move(String usr, int x, int y) {
		super(02); username = usr;
		this.x=x;
		this.y=y;
	}
	
	
	@Override
	public byte[] getData() {
		return ("02" + username + "," + x + "," + y).getBytes();
	}
	
	@Override
	public void writeData(GameClient_UDP client) { client.sendData(getData()); }

	public String getUsername() { return username; }
	public int getX() { return x; }
	public int getY() { return y; }
}
