package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;

public class PowerOrb extends GameObject{

	Handler handler;
	
	//x2 and y2 are the end of the function
	float x2, y2, x3, y3;
	
	float vX;
	
	double accY = 0.2;
	
	double voY;

	int count;
	
	int timer;
	
	boolean swap = false;
	
	boolean newMov;
	
	float maxY = (float)(Math.random()*15)+575;
	
	float distanceX, distanceY;
	
	int image = 0;
	
	Texture tex = Game.getInstance();
	
	public PowerOrb(float x, float y, float width, float height, float x2, float y2, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		this.x2 = x2;
		this.y2 = y2;
		distanceX = (x2 - x)/2;
		vX = distanceX/31;
		x3 = handler.getBarX() + handler.getBarWidth() - 10;
		y3 = handler.getBarY() + (handler.getBarHeight()/2) - 12;
	}

	public void tick(LinkedList<GameObject> object) {
		if((handler.getGameState() == 1 || handler.getGameState() == 14) && !handler.getPauseDelayIsActive()){
			count++;
			if(count >= 15){
				count = 0;
				if(image == 0){
					image = 1;
				}
				else{
					image = 0;
				}
			}
			movement();
		}
	}
	
	public void movement(){
		if(!swap){
			distanceY = maxY - y;
			voY = Math.sqrt(2*accY*distanceY);
			y+=voY;
		}
		else{
			timer++;
			voY = accY*timer;
			y-=voY;
		}
		
		if(y >= maxY && !swap){
			swap = true;
		}
		x+=vX;
	}

	public void render(Graphics g) {
		g.drawImage(tex.exp[image], (int)x, (int)y, (int)width, (int)height, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x+2, (int)y+2, (int)width-5, (int)height-5);
	}

}
