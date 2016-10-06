 package dev.tilegame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import dev.tilegame.display.Display;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.creatures.PlayerMP;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.net.GameClient_UDP;
import dev.tilegame.net.GameServer_UDP;
import dev.tilegame.net.packets.Packet00Login;
import dev.tilegame.net.packets.Packet10CheckName;
import dev.tilegame.states.GameState;
import dev.tilegame.states.LoadingState;
import dev.tilegame.states.MenuState;
import dev.tilegame.states.State;

public class Game implements Runnable, Serializable {
	private static final long serialVersionUID = 1L;
	public static final int grid=32;
	public static final int worldSize=50;
	
	//Window info
	private Display display;
	private int displayWidth, displayHeight;
	private String title;
	private static Player player;
	
	//Thread
	private boolean running;
	private Thread thread;
	
	//Graphics
	private transient BufferStrategy bs;
	private Graphics g;
	
	//State
	public State loadingState;
	public State menuState;
	public State gameState;
	
	//Camera, KeyManager & Handler
	private GameCamera camera;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private Handler handler;
	
	//NET
	private static GameClient_UDP socketClient=null;
	private static GameServer_UDP socketServer=null;
	private static boolean server=false; 
	private String serverPublicAddress="";
	private String serverAddress="";
	private int serverPort=1331;
	private String validUsername="false";
	
	//COSTRUCTOR
	public Game(String title, int displayWidth, int displayHeight){
		this.title = title;
		this.displayWidth = displayWidth;
		this.displayHeight = displayHeight;
		
		running = false;
		keyManager = new KeyManager(this);
		mouseManager = new MouseManager();
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				display.setTitle(title + "     FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		stop();
	}
		
	public synchronized void stop(){
		if(!running) return;
		running = false;
		try { thread.join(); }
		catch (InterruptedException e) {e.printStackTrace();}
	}
	
	private void init(){
		display = new Display(title, displayWidth, displayHeight);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);		
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		loadingState = new LoadingState(null);
		State.setState(loadingState); render(); render(); render();
		
		Assets.init();
		
		handler = new Handler(this);
		camera = new GameCamera(handler, 0, 0, grid);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
		
		//### NETWORK ############################################
		
		server = (JOptionPane.showConfirmDialog(null, "Do you want to host other players?")==0?true:false);
		if(Game.server) {
			try {
				URL url_name = new URL("http://bot.whatismyipaddress.com");
				BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
				serverPublicAddress = sc.readLine().trim();
				serverAddress = InetAddress.getLocalHost().getHostAddress().toString();
			} catch (UnknownHostException e) {} catch (MalformedURLException e) {} catch (IOException e) {}
			
			serverPort = Integer.parseInt(JOptionPane.showInputDialog("Select port (es. 1331)"));			
			Game.socketServer = new GameServer_UDP(handler, serverPort);
			Game.socketServer.start();
		}
		else {
			serverAddress = JOptionPane.showInputDialog("Please enter server ip address (es. 192.168.1.1)");
			serverPort = Integer.parseInt(JOptionPane.showInputDialog("Please enter server port (es. 1331)"));
		}
		
		//Creazione Socket Client
		Game.socketClient = new GameClient_UDP(handler, serverAddress, serverPort);
		Game.socketClient.start();
		
		//Creazione e aggiunta del proprio Player
		Packet10CheckName checkNamePacket;
		String username = "";
		do {
			username = JOptionPane.showInputDialog("Please enter a username (max 8 letters)");
			checkNamePacket = new Packet10CheckName(username);
			checkNamePacket.writeData(Game.socketClient);
			try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		}while(username.length()>8 || validUsername.equalsIgnoreCase("used"));
		
		player = new PlayerMP(1, username, handler, 400, 400, null, -1);		
		handler.getWorld().entityManager.addEntity(player);
		
		//Creazione pacchetto login
		Packet00Login loginPacket = new Packet00Login(player.getUsername(), (int)player.getX(), (int)player.getY());

		//(IF SERVER) Aggiunge il giocatore che fa anche da server alla lista giocatori
		if(socketServer!=null) socketServer.addConnection((PlayerMP)player, loginPacket);
		
		//Invia al server il pacchetto login contenente il proprio username
		loginPacket.writeData(Game.socketClient);
	}
	
	private void tick(){
		keyManager.tick(); //controlla quali tasti sono stati premuti
		if(State.getState() != null) State.getState().tick(); //aggiorna lo stato
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//Clear Screen
		g.clearRect(0, 0, displayWidth, displayHeight);
		
		//Draw Here!
		if(State.getState() != null) State.getState().render(g);
		
		//End Drawing and print!
		bs.show();
		g.dispose();
	}
	
	public Display getDisplay() { return display; }
	public int getDisplayWidth() { return displayWidth; }
	public int getDisplayHeight() { return displayHeight; }
	public void setValidUsername(String str) { validUsername = str; }
	public KeyManager getKeyManager() { return keyManager; }
	public MouseManager getMouseManager() { return mouseManager; }
	public GameCamera getCamera() { return camera; }
	public static Player getPlayer() { return Game.player; }
	public static GameClient_UDP getClient() { return Game.socketClient; }
	public static GameServer_UDP getServer() { return Game.socketServer; }
	public String getServerPublicAddress() { return serverPublicAddress; }
	public String getServerAddress() { return serverAddress; }
	public int getServerPort() { return serverPort; }
	public static boolean isServer() { return Game.server; }
	
}