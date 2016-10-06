package dev.tilegame.display;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import dev.tilegame.Game;
import dev.tilegame.net.GameServer_UDP;
import dev.tilegame.net.packets.Packet01Disconnect;

public class Display implements WindowListener{
	// PRIVATE:
	private JFrame frame;
	private Canvas canvas;
	//Window info
	private String title;
	private int displayWidth, displayHeight;
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(displayWidth, displayHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.setUndecorated(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(this);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(displayWidth, displayHeight));
		canvas.setMaximumSize(new Dimension(displayWidth, displayHeight));
		canvas.setMinimumSize(new Dimension(displayWidth, displayHeight));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
// PUBLIC:
	public Display(String title, int width, int height){
		this.title = title;
		this.displayWidth = width;
		this.displayHeight = height;
		
		createDisplay();
	}
	
	public void setTitle(String title) { frame.setTitle(title); }
	public Canvas getCanvas(){ return canvas; }
	public JFrame getFrame() { return frame; }
	public Container getContentPane() { return frame.getContentPane(); }
	public void pack() { frame.pack(); }

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		if(Game.getPlayer()!=null) {
			Packet01Disconnect packet = new Packet01Disconnect(Game.getPlayer().getUsername());
			packet.writeData(Game.getClient());
			
			if(Game.isServer()) Game.getServer().getTelegramBot().sendMess("> Server OFF", GameServer_UDP.getBOT_CHATID());
		}
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
}
