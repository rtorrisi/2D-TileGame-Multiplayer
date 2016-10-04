package dev.tilegame.gfx;

public class LevelEditorCamera {
	
	private float xOffset, yOffset;
	
	public LevelEditorCamera(float xOffset, float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void move(int xAmt, int yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() {return xOffset;}
	public void setxOffset(float xOffset) {this.xOffset = xOffset;}
	public float getyOffset() {return yOffset; }
	public void setyOffset(float yOffset) {this.yOffset = yOffset;}

}