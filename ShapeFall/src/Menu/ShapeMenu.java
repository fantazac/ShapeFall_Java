package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class ShapeMenu extends GameObject{

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
	int textWidth1 = 216;
	
	int textHeight1 = 58;
	
	int textWidth2 = 224;
	
	int textHeight2 = 64;
	
	int shapeWidth = 87;
	
	int shapeHeight = 86;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//x position for background
	int xPosBackground;
	
	//X position for all text images at the start
	int posXImage3 = 12;
	
	//space between text images in Y and X
	float ySpace;
	
	float xSpace = 104;
	
	//y position for the current selected shape bar
	float yCurrent;
	
	Texture tex = Game.getInstance();
	
	public ShapeMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		setY(150);
		ySpace = 110;
		yCurrent = (int) (y+(ySpace*handler.getShapeOption())+67);
		arrowYPosition = (int) (y+(ySpace*handler.getShapeOption())+59);
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
		g.drawImage(tex.shape[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.shape[12], (int)arrowXPosition, (int)arrowYPosition, (int)arrowDimension, (int)arrowDimension, null);
		
		//draws the current selected shape bar
		g.drawImage(tex.shape[11], (int)xSpace, (int)yCurrent, (int)textWidth1, (int)textHeight1, null);
		
		//square
		if(handler.getShapeOption() == 0){
			g.drawImage(tex.shape[1], (int)xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
			g.drawImage(tex.shape[7], (int)xSpace+64, (int)y+37, (int)shapeWidth, (int)shapeHeight, null);
		}
		else{
			g.drawImage(tex.shape[2], (int)xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
			g.drawImage(tex.shape[8], (int)xSpace+64, (int)y+37, (int)shapeWidth, (int)shapeHeight, null);
		}
		
		//circle
		if(handler.getShapeOption() == 1){
			g.drawImage(tex.shape[3], (int)xSpace, (int)(y+ySpace), (int)textWidth1, (int)textHeight1, null);
			g.drawImage(tex.shape[9], (int)xSpace+64, (int)(y+ySpace+39), (int)shapeWidth, (int)shapeHeight, null);
		}
		else{
			g.drawImage(tex.shape[4], (int)xSpace, (int)(y+ySpace), (int)textWidth1, (int)textHeight1, null);
			g.drawImage(tex.shape[10], (int)xSpace+64, (int)(y+ySpace+39), (int)shapeWidth, (int)shapeHeight, null);
		}
		
		//main menu
		if(handler.getShapeOption() == 2){
			g.drawImage(tex.shape[5], (int)posXImage3, (int)(y+(ySpace*3)+12+(backgroundHeight-610)), (int)textWidth2, (int)textHeight2, null);
		}
		else{
			g.drawImage(tex.shape[6], (int)posXImage3, (int)(y+(ySpace*3)+12+(backgroundHeight-610)), (int)textWidth2, (int)textHeight2, null);
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
		if(arrowYPosition > (int) (y+(ySpace*handler.getShapeOption())+10) && handler.getShapeOption() < 1){
			arrowYPosition-=arrowYSpeed;
			if(arrowYPosition < (int) (y+(ySpace*handler.getShapeOption())+10)){
				arrowYPosition = (int) (y+(ySpace*handler.getShapeOption())+10);
			}
		}
		
		else if(arrowYPosition > (int) (y+(ySpace*handler.getShapeOption())+10) && handler.getShapeOption() == 1){
			arrowYPosition-=(arrowYSpeed*1.4);
			if(arrowYPosition < (int) (y+(ySpace*handler.getShapeOption())+10)){
				arrowYPosition = (int) (y+(ySpace*handler.getShapeOption())+10);
			}
		}
		
		else if(arrowYPosition < (int) (y+(ySpace*handler.getShapeOption())+10) && handler.getShapeOption() < 2){
			arrowYPosition+=arrowYSpeed;
			if(arrowYPosition > (int) (y+(ySpace*handler.getShapeOption())+10)){
				arrowYPosition = (int) (y+(ySpace*handler.getShapeOption())+10);
			}
		}
		
		else if(arrowYPosition < (int) (y+(ySpace*3)+25+(backgroundHeight-610)) && handler.getShapeOption() == 2){
			arrowYPosition+=(arrowYSpeed*1.4);
			if(arrowYPosition > (int) (y+(ySpace*3)+25)+(backgroundHeight-610)){
				arrowYPosition = (int) (y+(ySpace*3)+25)+(backgroundHeight-610);
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
		posXImage3 = moveText(2, posXImage3);
	}
	
	//sets the text image's X position
	public int moveText(int shapeOption, int posXImage){
		if(handler.getShapeOption() == shapeOption){
			if(posXImage < 52){
				posXImage+=7;
				if(posXImage > 52){
					posXImage = 52;
				}
			}
		}
		else{
			if(posXImage > 12){
				posXImage-=7;
				if(posXImage < 12){
					posXImage = 12;
				}
			}
		}
		return posXImage;
	}
	
	public Rectangle getBounds() {
		return null;
	}
}