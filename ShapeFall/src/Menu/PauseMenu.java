package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class PauseMenu extends GameObject{

	Handler handler;
	
	//determines if the arrow moves to the left or to the right
	boolean moveArrowRight = true;
	
	//delay to slow down the movement for the smooth animation of the arrow
	int arrowXDelay = 2;
	
	//counts the ticks until it reaches the arrowXDelay value
	int arrowXCount;
	
	//arrow position in X
	int arrowXPosition = 0;
	
	//arrow position in Y
	int arrowYPosition;
	
	//arrow dimension
	int arrowDimension;
	
	//arrow movement speed in Y when changing of option
	int arrowYSpeed = 17;
	
	//dimensions for keys and texts
	int textWidth1 = 240;
	
	int textHeight1 = 59;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//x position for background
	int xPosBackground;
	
	//space between text images in Y and X
	float ySpace;
	
	float xSpace = 85;
	
	Texture tex = Game.getInstance();
	
	public PauseMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		setY(150);
		ySpace = 110;
		arrowYPosition = (int) (y+(ySpace*handler.getPauseOption())+59);
		arrowXPosition = 33;
		arrowDimension = handler.getArrowDimension();
		backgroundWidth = (int) handler.getBackgroundWidth();
		backgroundHeight = (int)handler.getBackgroundHeight();
		xPosBackground = (int) ((handler.getGameWidth()/2) - (handler.getBackgroundWidth()/2));
	}

	public void tick(LinkedList<GameObject> object) {
		moveArrow();
	}

	public void render(Graphics g) {
		
		//draws the background
		g.drawImage(tex.pause[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.pause[7], (int)arrowXPosition, (int)arrowYPosition, (int)arrowDimension, (int)arrowDimension, null);
		
		//continue
		if(handler.getPauseOption() == 0){
			g.drawImage(tex.pause[1], (int)xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.pause[2], (int)xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
		}
		
		//retry
		if(handler.getPauseOption() == 1){
			g.drawImage(tex.pause[3], (int)xSpace, (int)(y+ySpace), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.pause[4], (int)xSpace, (int)(y+ySpace), (int)textWidth1, (int)textHeight1, null);
		}
		
		//exit
		if(handler.getPauseOption() == 2){
			g.drawImage(tex.pause[5], (int)xSpace-6, (int)(y+(ySpace*2)), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.pause[6], (int)xSpace-6, (int)(y+(ySpace*2)), (int)textWidth1, (int)textHeight1, null);
		}
	}

	//moves the arrow to the wanted position
	public void moveArrow(){
		
		if(arrowXPosition >= 43){
			moveArrowRight = false;
		}
		else if(arrowXPosition <= 33){
			moveArrowRight = true;
		}
		if(arrowYPosition > (int) (y+(ySpace*handler.getPauseOption())+10) && handler.getPauseOption() < 2){
			arrowYPosition-=arrowYSpeed;
			if(arrowYPosition < (int) (y+(ySpace*handler.getPauseOption())+10)){
				arrowYPosition = (int) (y+(ySpace*handler.getPauseOption())+10);
			}
		}
		
		else if(arrowYPosition < (int) (y+(ySpace*handler.getPauseOption())+10) && handler.getPauseOption() < 3){
			arrowYPosition+=arrowYSpeed;
			if(arrowYPosition > (int) (y+(ySpace*handler.getPauseOption())+10)){
				arrowYPosition = (int) (y+(ySpace*handler.getPauseOption())+10);
			}
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