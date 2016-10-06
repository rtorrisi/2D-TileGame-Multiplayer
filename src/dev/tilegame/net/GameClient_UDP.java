package dev.tilegame.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.PlayerMP;
import dev.tilegame.entities.statics.Decoration;
import dev.tilegame.gfx.Assets;
import dev.tilegame.net.packets.Packet;
import dev.tilegame.net.packets.Packet.PacketTypes;
import dev.tilegame.net.packets.Packet00Login;
import dev.tilegame.net.packets.Packet01Disconnect;
import dev.tilegame.net.packets.Packet02Move;
import dev.tilegame.net.packets.Packet10CheckName;
import dev.tilegame.net.packets.Packet11Tile;
import dev.tilegame.net.packets.Packet12Item;
import dev.tilegame.tiles_and_items.Item;
import dev.tilegame.tiles_and_items.Tile;
import dev.tilegame.worlds.World;

public class GameClient_UDP extends Thread {
	
	private Handler handler;
	private DatagramSocket socket;
	private InetAddress serverIp;
	private int serverPort;
	
	public GameClient_UDP(Handler handler, String address, int serverPort) {
		this.handler = handler;
		this.serverPort = serverPort;
		
		try {
			this.serverIp = InetAddress.getByName(address);
			this.socket = new DatagramSocket();
		}
		catch (SocketException e) {e.printStackTrace();} catch (UnknownHostException e) {e.printStackTrace();}
	}

	public void run() {
		while(true) {
			byte[] data = new byte[32];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			try {socket.receive(packet);} catch (IOException e) {e.printStackTrace();}
			
			checkPacket(packet.getData(), packet.getAddress(), packet.getPort());
		}
	}
	
	public void sendData(byte[] data) {
		DatagramPacket myPacket = new DatagramPacket(data, data.length, serverIp, serverPort);
		try { socket.send(myPacket); } catch (IOException e) { e.printStackTrace(); }
	}
	
	private void checkPacket(byte[] data, InetAddress address, int port) {
		
		String message = new String(data).trim();
		PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
		Packet packet = null;
		
		switch(type) {
		default:
		case INVALID:
			break;
			
		case MOVE:
			packet = new Packet02Move(data);
			
			handleMove((Packet02Move)packet);
			break;
			
		case LOGIN: //Quando si collega un nuovo giocatore al server ai client arriva:
			packet = new Packet00Login(data);
			handleLogin((Packet00Login) packet, address, port);
			break;
			
		case CHECKNAME:
			packet = new Packet10CheckName(data);
			String mess = ((Packet10CheckName)packet).getMessage();
			handler.getGame().setValidUsername(mess);
			if(mess.equalsIgnoreCase("used")) JOptionPane.showMessageDialog(null, "Username already used from another player");
			break;
		
		case TILE:
			packet = new Packet11Tile(data);
			handleTile((Packet11Tile)packet);
			break;
		
		case ITEM:
			packet = new Packet12Item(data);
			handleItem((Packet12Item)packet);
			break;
			
		case DISCONNECT:
			packet = new Packet01Disconnect(data);
			handleLogout((Packet01Disconnect)packet);
			break;
		}
	}
	
	private void handleMove(Packet02Move packet) {
		handler.getWorld().entityManager.movePlayer(packet.getUsername(), packet.getX(), packet.getY());
	}

	private void handleLogin(Packet00Login packet, InetAddress address, int port) {
        PlayerMP player = new PlayerMP(2, packet.getUsername(), handler, packet.getX(), packet.getY(), address, port);
        handler.getWorld().entityManager.addEntity(player);
    }
	private void handleLogout(Packet01Disconnect packet) { handler.getWorld().entityManager.removePlayerMP(packet.getUsername()); }
	
	private void handleTile(Packet11Tile packet) {
		int tileIndex = packet.getTileIndex();
		boolean collision=(packet.hasCollision()==1?true:false);
		
		World.tiles[packet.getY()][packet.getX()] = new Tile( Assets.tileList.get(tileIndex-1), collision);
	}
	
	private void handleItem(Packet12Item packet) {
		int tileIndex = packet.getTileIndex();
		boolean collision=(packet.hasCollision()==1?true:false);
		boolean interaction =(packet.hasInteraction()==1?true:false);
		World.items[packet.getY()][packet.getX()] = new Item(Assets.itemList.get(tileIndex-1), collision, interaction);
		handler.getWorld().entityManager.addEntity(new Decoration(handler, World.items[packet.getY()][packet.getX()], packet.getX()*Game.grid, packet.getY()*Game.grid));
	}
	
}
