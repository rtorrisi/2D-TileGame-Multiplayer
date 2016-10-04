package dev.tilegame.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.PlayerMP;
import dev.tilegame.net.packets.Packet;
import dev.tilegame.net.packets.Packet.PacketTypes;
import dev.tilegame.net.packets.Packet00Login;
import dev.tilegame.net.packets.Packet01Disconnect;
import dev.tilegame.net.packets.Packet02Move;
import dev.tilegame.net.packets.Packet10CheckName;
import dev.tilegame.net.packets.Packet11Tile;
import dev.tilegame.tiles_and_items.TileMP;

public class GameServer_UDP extends Thread {
	
	private Handler handler;
	private DatagramSocket socket;
	private List<PlayerMP> connectedPlayers = new ArrayList<PlayerMP>();
	private List<TileMP> multiplayerTile = new ArrayList<TileMP>();
	
	public GameServer_UDP(Handler handler, int serverPort) {
		this.handler = handler;
		try { socket = new DatagramSocket(serverPort); } catch (SocketException e) { e.printStackTrace(); }
	}
	
	public void run() {
		while(true) {
			byte[] data = new byte[32];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			try { socket.receive(packet); } catch (IOException e) { e.printStackTrace(); }
			
			checkPacket(packet.getData(), packet.getAddress(), packet.getPort());
		}
	}
	
	private void checkPacket(byte[] data, InetAddress address, int port) {
		
		String message = new String(data).trim();
		PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
		Packet packet = null;
		String log;
		
		switch(type) {
		default:
		case INVALID:
			break;
		
		case MOVE:
			packet = new Packet02Move(data);
			handleMove((Packet02Move)packet);
			break;
			
		case LOGIN:
			packet = new Packet00Login(data);
			log = "["+address.getHostAddress()+":"+port+"] Server info: "+((Packet00Login)packet).getUsername()+" has connected to server...";
			System.out.println(log);
			
			PlayerMP player = new PlayerMP(2, ((Packet00Login)packet).getUsername(), handler, 10, 10, address, port);
			addConnection(player, (Packet00Login)packet);
			
			
			for(int i=0; i<multiplayerTile.size(); i++) {
				int collision = (multiplayerTile.get(i).hasCollider()==true?1:0);
				Packet11Tile pack = new Packet11Tile(multiplayerTile.get(i).getIndex(), collision, multiplayerTile.get(i).getX(), multiplayerTile.get(i).getY());
				sendData(pack.getData(), player.ipClient, player.portClient);
			}
			
			break;
			
		case CHECKNAME:
			packet = new Packet10CheckName(data);
			
			boolean used = usernameIsUsed(((Packet10CheckName)packet).getMessage());
			if(used) ((Packet10CheckName)packet).setMessage("used");
			else ((Packet10CheckName)packet).setMessage("notused");
			sendData(packet.getData(), address, port);
			break;
		
			
		case TILE:
			packet = new Packet11Tile(data);
			handleTile((Packet11Tile)packet);
			sendDataToAllClients(data);
			break;
			
		case DISCONNECT:
			packet = new Packet01Disconnect(data);
			log = "["+address.getHostAddress()+":"+port+"]"+" Server info: "+((Packet01Disconnect)packet).getUsername()+" has left server... ";
			System.out.println(log);
			removeConnection((Packet01Disconnect)packet);
			break;
		}
	}

	public void handleMove(Packet02Move packet) {
		if(getPlayerMP(packet.getUsername())!=null) {
			int index = getPlayerMPIndex(packet.getUsername());
			connectedPlayers.get(index).setX(packet.getX());
			connectedPlayers.get(index).setY(packet.getY());
			packet.writeData(this);
		}
	}
	
	private void handleTile(Packet11Tile packet) {
		boolean collision = (packet.getCollision()==1?true:false);
		TileMP t = new TileMP(packet.getTileIndex(), collision, packet.getX(), packet.getY());
		removeDoubleTile(t);
		multiplayerTile.add(t);
	}
	
	private void removeDoubleTile(TileMP t) {
		for(int i=0; i<multiplayerTile.size(); i++) {
			if(t.getX() == multiplayerTile.get(i).getX() && t.getY() == multiplayerTile.get(i).getY()) {
				multiplayerTile.remove(i);
				return;
			}
		}
	}
	

	public void addConnection(PlayerMP player, Packet00Login packet) {
		
        boolean alreadyConnected = false;
        
        // Cicla tramite p tutti i giocatori connessi
        for (PlayerMP p : connectedPlayers) {
        	
        	//assegna al giocatore che hosta indirizzoIp e porta
            if (player.getUsername().equalsIgnoreCase(p.getUsername())) {
                if (p.ipClient == null) p.ipClient = player.ipClient;
                if (p.portClient == -1) p.portClient = player.portClient;
                
                alreadyConnected = true;
            }
            
            else if(player.portClient != -1 ){
                // trasmetti ai vari giocatori che c'è un nuovo giocatore
                sendData(packet.getData(), p.ipClient, p.portClient);

                // trasmetti al nuovo giocatore che ci sono gia altri giocatori
                Packet packetCurrent = new Packet00Login(p.getUsername(), (int)p.getX(), (int)p.getY());
                sendData(packetCurrent.getData(), player.ipClient, player.portClient);
            }
        }
        
        if (!alreadyConnected) connectedPlayers.add(player);
    }


	public void removeConnection(Packet01Disconnect packet) {
		int index = getPlayerMPIndex(packet.getUsername());
		if(index!=-1) {
			connectedPlayers.remove(index);
			packet.writeData(this);
		}
	}
	
	public PlayerMP getPlayerMP(String username) {
		for(PlayerMP player : connectedPlayers) {
			if(player.getUsername().equalsIgnoreCase(username)) return player;
		}
		return null;
	}
	
	public int getPlayerMPIndex(String username) {
		int x=0;
		for(PlayerMP player : connectedPlayers) {
			if(player.getUsername().equalsIgnoreCase(username)) return x;
		x++;
		}
		return -1;
	}
	
	public void sendData(byte[] data, InetAddress ipAddress, int port) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
		
		try { this.socket.send(packet); }
		catch (IOException e) { e.printStackTrace();}
	}

	public void sendDataToAllClients(byte[] data) {
		for(PlayerMP p : connectedPlayers) {
			sendData(data, p.ipClient, p.portClient);
		}
	}
	
	private boolean usernameIsUsed(String usr) {
		for (PlayerMP p : connectedPlayers) {
			if(p.getUsername().equalsIgnoreCase(usr)) return true;
		}
		return false;
	}
}
