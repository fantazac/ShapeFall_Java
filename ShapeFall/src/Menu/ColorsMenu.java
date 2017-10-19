package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class ColorsMenu extends GameObject{

Handler handler;
	
	//determines if the arrow moves to the right or to the left
	boolean moveArrowRight = true;
	
	//determines if the arrow is drawn next to "Default" after the colorsOption == 9
	boolean arrowIsOnDefault = false;
	
	//determines if the arrow is drawn next to the selection key
	boolean arrowIsSelecting = false;
	
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
	
	//color squares dimension
	int colorSquareDimension = 30;
	
	//dimensions for keys and texts
	int textWidth1 = 265;
	
	int textHeight1 = 35;
	
	int textWidth2 = 224;
	
	int textHeight2 = 64;
	
	int keyDimension = 33;
	
	//y position for texts
	int yPos1 = 138;
	
	int yPos2 = 143;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//x position for background
	int xPosBackground;
	
	//X position for all text images at the start
	int posXImage0 = 24;
	int posXImage1 = 24;
	int posXImage2 = 24;
	int posXImage3 = 24;
	int posXImage4 = 24;
	int posXImage5 = 0;
	
	//space between text images in Y
	int ySpace;
	
	//space between the window's left side and all text images
	int xSpace;
	
	//space between colors squares on the right=
	int ySpaceSquare = 36;
	
	int xPosColors = 337;
	
	Texture tex = Game.getInstance();
	
	public ColorsMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		setY(160);
		ySpace = 46;
		xSpace = 30;
		arrowYPosition = (int)getY();
		arrowXPosition = 22;
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
		g.drawImage(tex.colors[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.colors[11], (int)arrowXPosition, (int)arrowYPosition, (int)arrowDimension, (int)arrowDimension, null);
		
		//colors next to text
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(1))], (int)posXImage0, (int)y+4, (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(2))], (int)posXImage1, (int)y+4+ySpace, (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(3))], (int)posXImage2, (int)y+4+(ySpace*2), (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(4))], (int)posXImage3, (int)y+4+(ySpace*3), (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(5))], (int)posXImage4, (int)y+4+(ySpace*4), (int)colorSquareDimension, (int)colorSquareDimension, null);
		
		if(handler.getColorSelection()){
			//colors to select from (on the right)
			g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.availableColor.get(0))], (int)xPosColors, (int)y+4, (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.availableColor.get(1))], (int)xPosColors, (int)y+4+ySpaceSquare, (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.availableColor.get(2))], (int)xPosColors, (int)y+4+(ySpaceSquare*2), (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.availableColor.get(3))], (int)xPosColors, (int)y+4+(ySpaceSquare*3), (int)colorSquareDimension, (int)colorSquareDimension, null);
			//g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.availableColor.get(4))], (int)xPosColors, (int)y+4+(ySpaceSquare*4), (int)colorSquareDimension, (int)colorSquareDimension, null);
			//g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.availableColor.get(5))], (int)xPosColors, (int)y+4+(ySpaceSquare*5), (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)(int)y+4+(ySpaceSquare*4), (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)(int)y+4+(ySpaceSquare*5), (int)colorSquareDimension, (int)colorSquareDimension, null);
		}
		else{
			//colors to select from (on the right)
			g.drawImage(tex.colors[14], (int)xPosColors, (int)y+4, (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)y+4+ySpaceSquare, (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)y+4+(ySpaceSquare*2), (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)y+4+(ySpaceSquare*3), (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)(int)y+4+(ySpaceSquare*4), (int)colorSquareDimension, (int)colorSquareDimension, null);
			g.drawImage(tex.colors[14], (int)xPosColors, (int)(int)y+4+(ySpaceSquare*5), (int)colorSquareDimension, (int)colorSquareDimension, null);
		}
		
		
		//color 1
		if(handler.getColorsOption() == 0){
			g.drawImage(tex.colors[1], (int)posXImage0+xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.colors[2], (int)posXImage0+xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 2
		if(handler.getColorsOption() == 1){
			g.drawImage(tex.colors[3], (int)posXImage1+xSpace, (int)y+ySpace, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.colors[4], (int)posXImage1+xSpace, (int)y+ySpace, (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 3
		if(handler.getColorsOption() == 2){
			g.drawImage(tex.colors[5], (int)posXImage2+xSpace, (int)y+(ySpace*2), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.colors[6], (int)posXImage2+xSpace, (int)y+(ySpace*2), (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 4
		if(handler.getColorsOption() == 3){
			g.drawImage(tex.colors[7], (int)posXImage3+xSpace, (int)y+(ySpace*3), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.colors[8], (int)posXImage3+xSpace, (int)y+(ySpace*3), (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 5
		if(handler.getColorsOption() == 4){
			g.drawImage(tex.colors[9], (int)posXImage4+xSpace, (int)y+(ySpace*4), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.colors[10], (int)posXImage4+xSpace, (int)y+(ySpace*4), (int)textWidth1, (int)textHeight1, null);
		}
		
		//cancel
		if(handler.getColorsOption() == 5){
			g.drawImage(tex.colors[12], (int)posXImage5+10, (int)y+(ySpace*7)+11+(backgroundHeight-610), (int)textWidth2, (int)textHeight2, null);
		}
		else{
			g.drawImage(tex.colors[13], (int)posXImage5+10, (int)y+(ySpace*7)+11+(backgroundHeight-610), (int)textWidth2, (int)textHeight2, null);
		}
	}

	//moves the arrow to the wanted position
	public void moveArrow(){
		
		//arrow smooth animation
		if(arrowXPosition <= 256 && handler.getColorSelection()){
			moveArrowRight = true;
		}
		else if(arrowXPosition >= 268 && handler.getColorSelection()){
			moveArrowRight = false;
		}
		else if(arrowXPosition >= 34 && !handler.getColorSelection()){
			moveArrowRight = false;
		}
		else if(arrowXPosition <= 22 && !handler.getColorSelection()){
			moveArrowRight = true;
		}
		
		//arrow movement in Y
		if(!arrowIsSelecting){
			
			if(arrowYPosition < (int) (y+(ySpace*(handler.getColorsOption()+2))+24+(backgroundHeight-610)) && handler.getColorsOption() == 5){
				arrowYPosition+=(arrowYSpeed*2);
				if(arrowYPosition > (int) (y+(ySpace*(handler.getColorsOption()+2))+24+(backgroundHeight-610))){
					arrowYPosition = (int) (y+(ySpace*(handler.getColorsOption()+2))+24+(backgroundHeight-610));
				}
			}
			
			else if(arrowYPosition > (int) (y+(ySpace*(handler.getColorsOption()+1))+4) && handler.getColorsOption() == 4){
				arrowYPosition-=(arrowYSpeed*3);
				if(arrowYPosition < (int) (y+(ySpace*(handler.getColorsOption()+1))+4)){
					arrowYPosition = (int) (y+(ySpace*(handler.getColorsOption()+1))+4);
				}
			}
			
			else if(arrowYPosition > (int) (y+(ySpace*handler.getColorsOption())) && handler.getColorsOption() < 5){
				arrowYPosition-=arrowYSpeed;
				if(arrowYPosition < (int) (y+(ySpace*handler.getColorsOption()))){
					arrowYPosition = (int) (y+(ySpace*handler.getColorsOption()));
				}
			}
			
			else if(arrowYPosition < (int) (y+(ySpace*handler.getColorsOption())) && handler.getColorsOption() < 5){
				arrowYPosition+=arrowYSpeed;
				if(arrowYPosition > (int) (y+(ySpace*handler.getColorsOption()))){
					arrowYPosition = (int) (y+(ySpace*handler.getColorsOption()));
				}
			}
		}
		else{
			
			if(arrowYPosition > (int) (y+(ySpaceSquare*handler.getColorSelectionOption())) && handler.getColorsOption() < 6){
				arrowYPosition-=arrowYSpeed;
				if(arrowYPosition < (int) (y+(ySpaceSquare*handler.getColorSelectionOption()))){
					arrowYPosition = (int) (y+(ySpaceSquare*handler.getColorSelectionOption()));
				}
			}
			
			else if(arrowYPosition < (int) (y+(ySpaceSquare*handler.getColorSelectionOption())) && handler.getColorsOption() < 6){
				arrowYPosition+=arrowYSpeed;
				if(arrowYPosition > (int) (y+(ySpaceSquare*handler.getColorSelectionOption()))){
					arrowYPosition = (int) (y+(ySpaceSquare*handler.getColorSelectionOption()));
				}
			}
		}
		
		//arrow movement in X
		if(!arrowIsSelecting && handler.getColorSelection()){
			arrowXPosition = 260;
			arrowYPosition = (int)y;
			arrowIsSelecting = true;
		}
		if(arrowIsSelecting && !handler.getColorSelection()){
			arrowXPosition = 22;
			arrowYPosition = (int) (y+(ySpace*handler.getColorsOption()));
			arrowIsSelecting = false;
		}
		
		//allows the arrow smooth animation
		if(moveArrowRight && arrowXCount >= arrowXDelay){
			arrowXPosition++;
			arrowXCount = 0;
		}
		else if(arrowXCount >= arrowXDelay){
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
		posXImage5 = moveText3(5, posXImage5);
		xPosColors = moveSquare(xPosColors);
	}
	
	//sets the text image's X position (colors and start/pause/starpower)
	public int moveSquare(int posXSquare){
		if(arrowIsSelecting){
			if(posXSquare > 299){
				posXSquare-=7;
				if(posXSquare < 299){
					posXSquare = 299;
				}
			}
		}
		else{
			if(posXSquare < 337){
				posXSquare+=7;
				if(posXSquare > 337){
					posXSquare = 337;
				}
			}
		}
		return posXSquare;
	}
	
	//sets the text image's X position (colors and start/pause/starpower)
	public int moveText(int colorsOption, int posXImage){
		if(handler.getColorsOption() == colorsOption && !arrowIsSelecting){
			if(posXImage < 64){
				posXImage+=7;
				if(posXImage > 64){
					posXImage = 64;
				}
			}
		}
		else{
			if(posXImage > 24){
				posXImage-=7;
				if(posXImage < 24){
					posXImage = 24;
				}
			}
		}
		return posXImage;
	}
	
	//sets the text image's X position (settings)
	public int moveText3(int colorsOption, int posXImage){
		if(handler.getColorsOption() == colorsOption){
			if(posXImage < 30){
				posXImage+=7;
				if(posXImage > 30){
					posXImage = 30;
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