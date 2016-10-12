 package dev.tilegame;
 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.io.Serializable;

import dev.tilegame.db.Database;
import dev.tilegame.db.signup_login.SignUpLogInFrame;
import dev.tilegame.display.Display;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.creatures.PlayerMP;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.net.GameClient_UDP;
import dev.tilegame.net.packets.Packet00Login;
import dev.tilegame.states.GameState;
import dev.tilegame.states.LoadingState;
import dev.tilegame.states.MenuState;
import dev.tilegame.states.State;

public class Game implements Runnable, Serializable {
	private static final long serialVersionUID = 1L;
	
	public static Database database = new Database();
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
	//private static GameServer_UDP socketServer=null;
	private static boolean server=false; 
	private String nickname;
	public static String serverPublicAddress="";
	public static String serverAddress="";
	public static int serverPort;
	
	
	//COSTRUCTOR
	public Game(String title, int displayWidth, int displayHeight){
		this.title = title;
		this.displayWidth = displayWidth;
		this.displayHeight = displayHeight;
		
		running = false;
		keyManager = new KeyManager(this);
		mouseManager = new MouseManager();
		
		new SignUpLogInFrame(this);
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
		
		//Creazione Socket Client
		Game.socketClient = new GameClient_UDP(handler, serverAddress, serverPort);
		
		//Creazione e aggiunta del proprio Player
		player = new PlayerMP(1, nickname, handler, 400, 400, null, -1);		
		handler.getWorld().entityManager.addEntity(player);
		
		//Creazione pacchetto login
		Packet00Login loginPacket = new Packet00Login(player.getUsername(), (int)player.getX(), (int)player.getY());
		
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
	public Rectangle getFrameRectangle() { return display.getFrame().getBounds(); }
	public int getDisplayWidth() { return displayWidth; }
	public int getDisplayHeight() { return displayHeight; }
	public KeyManager getKeyManager() { return keyManager; }
	public MouseManager getMouseManager() { return mouseManager; }
	public GameCamera getCamera() { return camera; }
	public static Player getPlayer() { return Game.player; }
	public static GameClient_UDP getClient() { return Game.socketClient; }
	public String getServerPublicAddress() { return serverPublicAddress; }
	public String getServerAddress() { return serverAddress; }
	public int getServerPort() { return serverPort; }
	public static boolean isServer() { return Game.server; }
	public void setNickname(String nickname) { this.nickname=nickname; }
	
}