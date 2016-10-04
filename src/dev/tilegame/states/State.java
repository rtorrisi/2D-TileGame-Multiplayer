package dev.tilegame.states;
import java.awt.Graphics;
import dev.tilegame.Handler;

public abstract class State {
	
	//PRIVATE:
	private static State currentState = null;
	protected Handler handler;
	
	//PUBLIC:
	public State(Handler handler) {
		this.handler=handler;
	}
	
	public static void setState(State state){ currentState = state; }
	public static State getState(){return currentState; }
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}