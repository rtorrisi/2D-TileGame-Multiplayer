package dev.tilegame.net.packets;
import dev.tilegame.net.GameClient_UDP;
import dev.tilegame.net.GameServer_UDP;

public class Packet11Tile extends Packet{
	
	private int tileIndex;
	private int collision;
	private int x, y;
	
	//COSTRUTTORI
	public Packet11Tile(byte[] data) {
		super(11); 
		String[] dataArray = readData(data).split(",");
		tileIndex = Integer.parseInt(dataArray[0]);
		collision = Integer.parseInt(dataArray[1]);
		x = Integer.parseInt(dataArray[2]);
		y = Integer.parseInt(dataArray[3]);
	}
	
	public Packet11Tile(int tileIndex, int collision, int x, int y) {
		super(11);
		this.tileIndex = tileIndex;
		this.collision = collision;
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public byte[] getData() {
		return ("11" + tileIndex + "," + collision + "," + x + "," + y).getBytes();
	}
	
	@Override
	public void writeData(GameClient_UDP client) { client.sendData(getData()); }

	@Override
	public void writeData(GameServer_UDP server) { server.sendDataToAllClients(getData()); }

	public int getTileIndex() { return tileIndex; }
	public int getCollision() { return collision; }
	public int getX() { return x; }
	public int getY() { return y; }
}
