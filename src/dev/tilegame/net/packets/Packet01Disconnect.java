package dev.tilegame.net.packets;

import dev.tilegame.net.GameClient_UDP;

public class Packet01Disconnect extends Packet{
	
	private String username;
	
	//COSTRUTTORI
	public Packet01Disconnect(byte[] data) { super(01); username = readData(data); }
	public Packet01Disconnect(String usr) { super(01); username = usr; }
	
	
	@Override
	public byte[] getData() { return ("01" + username).getBytes(); }
	
	@Override
	public void writeData(GameClient_UDP client) { client.sendData(getData()); }

	public String getUsername() { return username; }
}
