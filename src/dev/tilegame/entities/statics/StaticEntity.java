package dev.tilegame.entities.statics;

import dev.tilegame.Handler;
import dev.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y){
		super(handler, x, y);
	}

}