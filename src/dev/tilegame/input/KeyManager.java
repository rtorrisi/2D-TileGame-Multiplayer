package dev.tilegame.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.tilegame.Game;
import dev.tilegame.states.GameState;
import dev.tilegame.states.State;

public class KeyManager implements KeyListener{
	
	private Game game;
	private boolean[] keys;
	public boolean w, s, a, d;
	
	public KeyManager(Game game) {
		keys = new boolean[256];
		this.game=game;
	}
	
	public void tick() {
		w = keys[KeyEvent.VK_W];
		a = keys[KeyEvent.VK_A];
		s = keys[KeyEvent.VK_S];
		d = keys[KeyEvent.VK_D];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		if(game.isServer()==1 && State.getState().equals(game.gameState) && e.getKeyCode() == KeyEvent.VK_Q)
			GameState.editor.setVisible(!GameState.editor.isVisible());
	}
	public void keyReleased(KeyEvent e) { keys[e.getKeyCode()]=false; }
	public void keyTyped(KeyEvent e) {}
}
