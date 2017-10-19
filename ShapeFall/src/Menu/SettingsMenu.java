package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class SettingsMenu extends GameObject{

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
	int arrowYPosition = 0;
	
	//arrow dimension
	int arrowDimension;
	
	//arrow movement speed in Y when changing of option
	int arrowYSpeed = 10;
	
	//dimensions for keys and texts
	int textWidth = 400;
	
	int textHeight = 60;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//x position for background
	int xPosBackground;
	
	//X position for all text images at the start
	int posXImage0 = 0;
	int posXImage1 = 0;
	int posXImage2 = 0;
	int posXImage3 = 0;
	int posXImage4 = 0;
	int posXImage5 = 0;
	
	//space between text images in Y
	float ySpace;
	
	Texture tex = Game.getInstance();
	
	public SettingsMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		ySpace = 25;
		arrowYPosition = (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11);
		arrowXPosition = 33;
		arrowDimension = handler.getArrowDimension();
		backgroundWidth = (int) handler.getBackgroundWidth();
		backgroundHeight = (int)handler.getBackgroundHeight();
		xPosBackground = (int) ((handler.getGameWidth()/2) - (handler.getBackgroundWidth()/2));
	}

	public void tick(LinkedList<GameObject> object) {
		moveArrow();
		setPosXImage();
	}

	public void render(Graphics g) {
		
		//draws the background
		g.drawImage(tex.expert[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.expert[1], (int)arrowXPosition, (int)arrowYPosition, (int)arrowDimension, (int)arrowDimension, null);
		
		//controls
		if(handler.getSettingsOption() == 0){
			g.drawImage(tex.expert[6], (int)posXImage0, (int)(y+ySpace), (int)textWidth, (int)textHeight, null);
		}
		else{
			g.drawImage(tex.expert[7], (int)posXImage0, (int)(y+ySpace), (int)textWidth, (int)textHeight, null);
		}
		
		//difficulty
		if(handler.getSettingsOption() == 1){
			g.drawImage(tex.expert[8], (int)posXImage1, (int)(y+(ySpace*3)), (int)textWidth, (int)textHeight, null);
		}
		else{
			g.drawImage(tex.expert[9], (int)posXImage1, (int)(y+(ySpace*3)), (int)textWidth, (int)textHeight, null);
		}
		
		//audio
		if(handler.getSettingsOption() == 2){
			g.drawImage(tex.expert[2], (int)posXImage2, (int)(y+(ySpace*5)), (int)textWidth, (int)textHeight, null);
		}
		else{
			//g.drawImage(tex.expert[3], (int)posXImage2, (int)(y+(ySpace*5)), (int)textWidth, (int)textHeight, null);
			g.drawImage(tex.expert[14], (int)posXImage2, (int)(y+(ySpace*5)), (int)textWidth, (int)textHeight, null);
		}
		
		//colors
		if(handler.getSettingsOption() == 3){
			g.drawImage(tex.expert[4], (int)posXImage3, (int)(y+(ySpace*7)), (int)textWidth, (int)textHeight, null);
		}
		else{
			g.drawImage(tex.expert[5], (int)posXImage3, (int)(y+(ySpace*7)), (int)textWidth, (int)textHeight, null);
		}
		
		//shape
		if(handler.getSettingsOption() == 4){
			g.drawImage(tex.expert[12], (int)posXImage4, (int)(y+(ySpace*9)), (int)textWidth, (int)textHeight, null);
		}
		else{
			g.drawImage(tex.expert[13], (int)posXImage4, (int)(y+(ySpace*9)), (int)textWidth, (int)textHeight, null);
		}
		
		//main menu
		if(handler.getSettingsOption() == 5){
			g.drawImage(tex.expert[10], (int)posXImage5, (int)(y+(ySpace*15)-8+(backgroundHeight-610)), (int)textWidth, (int)textHeight, null);
		}
		else{
			g.drawImage(tex.expert[11], (int)posXImage5, (int)(y+(ySpace*15)-8+(backgroundHeight-610)), (int)textWidth, (int)textHeight, null);
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
		if(arrowYPosition > (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11) && handler.getSettingsOption() < 4){
			arrowYPosition-=arrowYSpeed;
			if(arrowYPosition < (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11)){
				arrowYPosition = (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11);
			}
		}
		
		else if(arrowYPosition > (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11) && handler.getSettingsOption() == 4){
			arrowYPosition-=(arrowYSpeed*2);
			if(arrowYPosition < (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11)){
				arrowYPosition = (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11);
			}
		}
		
		else if(arrowYPosition < (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11) && handler.getSettingsOption() < 5){
			arrowYPosition+=arrowYSpeed;
			if(arrowYPosition > (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11)){
				arrowYPosition = (int) (y+(ySpace*(1+(2*handler.getSettingsOption())))+11);
			}
		}
		
		else if(arrowYPosition < (int) (y+(ySpace*15)+4+(backgroundHeight-610)) && handler.getSettingsOption() == 5){
			arrowYPosition+=(arrowYSpeed*2);
			if(arrowYPosition > (int) (y+(ySpace*15)+4)+(backgroundHeight-610)){
				arrowYPosition = (int) (y+(ySpace*15)+4)+(backgroundHeight-610);
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
	
	//allows to set an X position to all text images
	public void setPosXImage(){
		posXImage0 = moveText(0, posXImage0);
		posXImage1 = moveText(1, posXImage1);
		posXImage2 = moveText(2, posXImage2);
		posXImage3 = moveText(3, posXImage3);
		posXImage4 = moveText(4, posXImage4);
		posXImage5 = moveText(5, posXImage5);
	}
	
	//sets the text image's X position
	public int moveText(int settingsOption, int posXImage){
		if(handler.getSettingsOption() == settingsOption){
			if(posXImage < 40){
				posXImage+=7;
				if(posXImage > 40){
					posXImage = 40;
				}
			}
		}
		else{
			if(posXImage > 0){
				posXImage-=7;
				if(posXImage < 0){
					posXImage = 0;
				}
			}
		}
		return posXImage;
	}
	
	public Rectangle getBounds() {
		return null;
	}
}