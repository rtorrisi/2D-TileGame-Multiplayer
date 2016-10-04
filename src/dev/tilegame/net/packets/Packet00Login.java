package dev.tilegame.net.packets;

import dev.tilegame.net.GameClient_UDP;
import dev.tilegame.net.GameServer_UDP;

public class Packet00Login extends Packet{
	
	private String username;
	private int x, y;
	
	//COSTRUTTORI
	public Packet00Login(byte[] data) {
		super(00);
		String[] dataArray = readData(data).split(",");
		username = dataArray[0];
		x = Integer.parseInt(dataArray[1]);
		y = Integer.parseInt(dataArray[2]);
	}
	public Packet00Login(String usr, int x, int y) {
		super(00);
		username = usr;
		this.x=x;
		this.y=y;
	}
	
	
	@Override
	public byte[] getData() { return ("00" + username + "," + x + "," + y).getBytes(); }
	
	@Override
	public void writeData(GameClient_UDP client) { client.sendData(getData()); }

	@Override
	public void writeData(GameServer_UDP server) { server.sendDataToAllClients(getData()); }

	public String getUsername() { return username; }
	public int getX() { return x; }
	public int getY() { return y; }
}
