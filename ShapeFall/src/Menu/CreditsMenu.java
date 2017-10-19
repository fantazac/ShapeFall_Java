package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class CreditsMenu extends GameObject{

	Handler handler;
	
	float spacing;
	
	//determines if the arrow moves to the left or to the right
	boolean moveArrowRight = true;
	
	//delay to slow down the movement for the smooth animation of the arrow
	int arrowXDelay = 2;
	
	//counts the ticks until it reaches the arrowXDelay value
	int arrowXCount;
	
	//arrow position in X
	int arrowXPosition = 0;
	
	//arrow position in Y
	int arrowYPosition = 0;
	
	//arrow dimension
	int arrowDimension;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//x position for background
	int xPosBackground;
	
	//position for text
	int xPosText = 0;
	
	int yPosText = 493;
	
	//dimensions for keys and texts
	int textWidth = 400;
	
	int textHeight = 60;
	
	Texture tex = Game.getInstance();
	
	public CreditsMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		spacing = height + 30;
		arrowYPosition = 0;
		arrowXPosition = 33;
		arrowDimension = handler.getArrowDimension();
		backgroundWidth = (int) handler.getBackgroundWidth();
		backgroundHeight = (int)handler.getBackgroundHeight();
		xPosBackground = (int) ((handler.getGameWidth()/2) - (handler.getBackgroundWidth()/2));
	}

	public void tick(LinkedList<GameObject> object) {
		if(xPosText < 40){
			xPosText+=7;
			if(xPosText > 40){
				xPosText = 40;
			}
		}
		moveArrow();
	}

	public void render(Graphics g) {
		
		//draws the background
		g.drawImage(tex.credits[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.credits[1], (int)arrowXPosition, (int)505+(backgroundHeight-610), (int)arrowDimension, (int)arrowDimension, null);
		
		//draws main menu option
		g.drawImage(tex.credits[2], (int)xPosText, (int)yPosText+(backgroundHeight-610), (int)textWidth, (int)textHeight, null);
	}
	
	//moves the arrow to the wanted position
	public void moveArrow(){
		if(arrowXPosition >= 40){
			moveArrowRight = false;
		}
		else if(arrowXPosition <= 30){
			moveArrowRight = true;
		}
		
		if(moveArrowRight && arrowXCount == arrowXDelay){
			arrowXPosition++;
			arrowXCount = 0;
		}
		else if(arrowXCount == arrowXDelay){
			arrowXPosition--;
			arrowXCount = 0;
		}
		arrowXCount++;
	}

	public Rectangle getBounds() {
		return null;
	}
}