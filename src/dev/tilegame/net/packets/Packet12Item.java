package dev.tilegame.net.packets;
import dev.tilegame.net.GameClient_UDP;

public class Packet12Item extends Packet{
	
	private int tileIndex;
	private int collision;
	private int interaction;
	private int x, y;
	
	//COSTRUTTORI
	public Packet12Item(byte[] data) {
		super(12); 
		String[] dataArray = readData(data).split(",");
		tileIndex = Integer.parseInt(dataArray[0]);
		collision = Integer.parseInt(dataArray[1]);
		interaction = Integer.parseInt(dataArray[2]);
		x = Integer.parseInt(dataArray[3]);
		y = Integer.parseInt(dataArray[4]);
	}
	
	public Packet12Item(int tileIndex, int collision, int interaction, int x, int y) {
		super(12);
		this.tileIndex = tileIndex;
		this.collision = collision;
		this.interaction = interaction;
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public byte[] getData() {
		return ("12"+tileIndex+","+collision+","+interaction+","+x+","+y).getBytes();
	}
	
	@Override
	public void writeData(GameClient_UDP client) { client.sendData(getData()); }

	public int getTileIndex() { return tileIndex; }
	public int hasCollision() { return collision; }
	public int hasInteraction() { return interaction; }
	public int getX() { return x; }
	public int getY() { return y; }
}
