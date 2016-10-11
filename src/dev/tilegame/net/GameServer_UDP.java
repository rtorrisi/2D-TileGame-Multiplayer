package dev.tilegame.net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.PlayerMP;
import dev.tilegame.net.bot.TelegramBot;
import dev.tilegame.net.packets.Packet;
import dev.tilegame.net.packets.Packet.PacketTypes;
import dev.tilegame.net.packets.Packet00Login;
import dev.tilegame.net.packets.Packet01Disconnect;
import dev.tilegame.net.packets.Packet02Move;
import dev.tilegame.net.packets.Packet11Tile;
import dev.tilegame.net.packets.Packet12Item;
import dev.tilegame.tiles_and_items.ItemMP;
import dev.tilegame.tiles_and_items.TileMP;

public class GameServer_UDP extends Thread {
	
	private Game game;
	private Handler handler;
	private DatagramSocket socket;
	
	private List<PlayerMP> connectedPlayers = new ArrayList<PlayerMP>();
	private List<TileMP> multiplayerTile = new ArrayList<TileMP>();
	private List<ItemMP> multiplayerItem = new ArrayList<ItemMP>();
	
	//Telegram
	private TelegramBot myBot;
	private static String BOT_TOKEN = "Here your Bot Token";
	private static String BOT_NAME = "Here your Bot Name"; 
	private static String BOT_CHATID = "Here your default chatId";
	
	public GameServer_UDP(Handler handler, int serverPort) {
		this.handler = handler;
		this.game = handler.getGame();
		
		try { socket = new DatagramSocket(serverPort);
		} catch (SocketException e) { e.printStackTrace(); }
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("telegram_bot.conf"));
			String[] dataArray = ((String)in.readObject()).split(",");
			BOT_TOKEN = dataArray[0];
			BOT_NAME = dataArray[1];
			BOT_CHATID = dataArray[2];
			in.close();

			myBot = new TelegramBot(handler, BOT_NAME, BOT_TOKEN, BOT_CHATID);
			myBot.sendMess("> Server ON\nAddress: "+game.getServerPublicAddress()+"\nPort: "+game.getServerPort(), BOT_CHATID);
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
		} catch (ClassNotFoundException e) {}
		
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
			log = "> "+((Packet00Login)packet).getUsername()+" has joined the game.";
			myBot.sendMess(log, BOT_CHATID);
			
			PlayerMP player = new PlayerMP(2, ((Packet00Login)packet).getUsername(), handler, 10, 10, address, port);
			addConnection(player, (Packet00Login)packet);
			
			
			for(int i=0; i<multiplayerTile.size(); i++) {
				int collision = (multiplayerTile.get(i).hasCollider()==true?1:0);
				Packet11Tile pack = new Packet11Tile(multiplayerTile.get(i).getIndex(), collision, multiplayerTile.get(i).getX(), multiplayerTile.get(i).getY());
				sendData(pack.getData(), player.ipClient, player.portClient);
			}
			
			for(int i=0; i<multiplayerItem.size(); i++) {
				int collision = (multiplayerItem.get(i).hasCollider()==true?1:0);
				int interaction = (multiplayerItem.get(i).hasInteraction()==true?1:0);
				Packet12Item pack = new Packet12Item(multiplayerItem.get(i).getIndex(), collision, interaction, multiplayerItem.get(i).getX(), multiplayerItem.get(i).getY());
				sendData(pack.getData(), player.ipClient, player.portClient);
			}
			
			break;
			
		case TILE:
			packet = new Packet11Tile(data);
			handleTile((Packet11Tile)packet);
			sendDataToAllClients(data);
			break;
			
		case ITEM:
			packet = new Packet12Item(data);
			handleItem((Packet12Item)packet);
			sendDataToAllClients(data);
			break;
			
		case DISCONNECT:
			packet = new Packet01Disconnect(data);
			log = "> "+((Packet01Disconnect)packet).getUsername()+" has left the game.";
			myBot.sendMess(log, BOT_CHATID);
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
		boolean collision = (packet.hasCollision()==1?true:false);
		TileMP t = new TileMP(packet.getTileIndex(), collision, packet.getX(), packet.getY());
		removeDoubleTile(t);
		multiplayerTile.add(t);
	}
	
	private void handleItem(Packet12Item packet) {
		boolean collision = (packet.hasCollision()==1?true:false);
		boolean interaction = (packet.hasInteraction()==1?true:false);
		ItemMP t = new ItemMP(packet.getTileIndex(), collision, interaction, packet.getX(), packet.getY());
		removeDoubleItem(t);
		multiplayerItem.add(t);
	}
	
	private void removeDoubleTile(TileMP t) {
		for(int i=0; i<multiplayerTile.size(); i++) {
			if(t.getX() == multiplayerTile.get(i).getX() && t.getY() == multiplayerTile.get(i).getY()) {
				multiplayerTile.remove(i);
				return;
			}
		}
	}
	private void removeDoubleItem(ItemMP t) {
		for(int i=0; i<multiplayerItem.size(); i++) {
			if(t.getX() == multiplayerItem.get(i).getX() && t.getY() == multiplayerItem.get(i).getY()) {
				multiplayerItem.remove(i);
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
                // trasmetti ai vari giocatori che c'� un nuovo giocatore
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
	
	public TelegramBot getTelegramBot() { return myBot; }
	public static String getBOT_CHATID() { return GameServer_UDP.BOT_CHATID; }
	public List<PlayerMP> getConnectedPlayers() { return connectedPlayers; }
}
