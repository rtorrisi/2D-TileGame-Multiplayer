package dev.tilegame.net.packets;

import dev.tilegame.net.GameClient_UDP;
import dev.tilegame.net.GameServer_UDP;

public class Packet10CheckName extends Packet{
	
	private String message;
	
	//COSTRUTTORI
	public Packet10CheckName(byte[] data) { super(10); message = readData(data); }
	public Packet10CheckName(String usr) { super(10); message = usr; }
	
	
	@Override
	public byte[] getData() { return ("10" + message).getBytes(); }
	
	@Override
	public void writeData(GameClient_UDP client) { client.sendData(getData()); }

	@Override
	public void writeData(GameServer_UDP server) { server.sendDataToAllClients(getData()); }

	public String getMessage() { return message; }
	public void setMessage(String ans) { message = ans; }
}
