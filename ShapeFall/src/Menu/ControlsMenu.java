package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class ControlsMenu extends GameObject{

	Handler handler;
	
	//determines if the arrow moves to the right or to the left
	boolean moveArrowRight = true;
	
	//determines if the arrow is drawn next to "Default" after the controlsOption == 9
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
	int arrowYSpeed = 5;
	
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
	int posXImage5 = 24;
	int posXImage6 = 24;
	int posXImage7 = 24;
	int posXImage8 = 0;
	int posXImage9 = 0;
	int posXImage10 = 0;
	
	//X position for all text images at the start
	int posXKey0 = 340;
	int posXKey1 = 340;
	int posXKey2 = 340;
	int posXKey3 = 340;
	int posXKey4 = 340;
	int posXKey5 = 340;
	int posXKey6 = 340;
	int posXKey7 = 340;
	
	//space between text images in Y
	int ySpace;
	
	//space between the window's left side and all text images
	int xSpace;
	
	Texture tex = Game.getInstance();
	
	public ControlsMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		setY(135);
		ySpace = 23;
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
		setPosXKey();
	}

	public void render(Graphics g) {
		//draws the background
		g.drawImage(tex.wulf[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.wulf[1], (int)arrowXPosition, (int)arrowYPosition, (int)arrowDimension, (int)arrowDimension, null);
		
		//colors
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(1))], (int)posXImage0, (int)y+4, (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(2))], (int)posXImage1, (int)y+4+ySpace, (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(3))], (int)posXImage2, (int)y+4+(ySpace*2), (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(4))], (int)posXImage3, (int)y+4+(ySpace*3), (int)colorSquareDimension, (int)colorSquareDimension, null);
		g.drawImage(tex.wulfcolor[handler.getColorNumber(handler.getColor(5))], (int)posXImage4, (int)y+4+(ySpace*4), (int)colorSquareDimension, (int)colorSquareDimension, null);
		
		//color 1
		if(handler.getControlsOption() == 0){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey0, (int)yPos1, (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(1))], (int)posXKey0, (int)yPos1, (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[2], (int)posXImage0+xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(1))+36], (int)posXKey0, (int)yPos1, (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[3], (int)posXImage0+xSpace, (int)y, (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 2
		if(handler.getControlsOption() == 1){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey1, (int)yPos1+ySpace, (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(2))], (int)posXKey1, (int)yPos1+ySpace, (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[4], (int)posXImage1+xSpace, (int)y+ySpace, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(2))+36], (int)posXKey1, (int)yPos1+ySpace, (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[5], (int)posXImage1+xSpace, (int)y+ySpace, (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 3
		if(handler.getControlsOption() == 2){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey2, (int)yPos1+(ySpace*2), (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(3))], (int)posXKey2, (int)yPos1+(ySpace*2), (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[6], (int)posXImage2+xSpace, (int)y+(ySpace*2), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(3))+36], (int)posXKey2, (int)yPos1+(ySpace*2), (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[7], (int)posXImage2+xSpace, (int)y+(ySpace*2), (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 4
		if(handler.getControlsOption() == 3){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey3, (int)yPos1+(ySpace*3), (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(4))], (int)posXKey3, (int)yPos1+(ySpace*3), (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[8], (int)posXImage3+xSpace, (int)y+(ySpace*3), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(4))+36], (int)posXKey3, (int)yPos1+(ySpace*3), (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[9], (int)posXImage3+xSpace, (int)y+(ySpace*3), (int)textWidth1, (int)textHeight1, null);
		}
		
		//color 5
		if(handler.getControlsOption() == 4){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey4, (int)yPos1+(ySpace*4), (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(5))], (int)posXKey4, (int)yPos1+(ySpace*4), (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[10], (int)posXImage4+xSpace, (int)y+(ySpace*4), (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(5))+36], (int)posXKey4, (int)yPos1+(ySpace*4), (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[11], (int)posXImage4+xSpace, (int)y+(ySpace*4), (int)textWidth1, (int)textHeight1, null);
		}
		
		//start game
		if(handler.getControlsOption() == 5){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey5, (int)yPos2+(ySpace*6), (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(6))], (int)posXKey5, (int)yPos2+(ySpace*6), (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[20], (int)posXImage5, (int)y+(ySpace*6)+5, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(6))+36], (int)posXKey5, (int)yPos2+(ySpace*6), (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[21], (int)posXImage5, (int)y+(ySpace*6)+5, (int)textWidth1, (int)textHeight1, null);
		}
		
		//pause game
		if(handler.getControlsOption() == 6){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey6, (int)yPos2+(ySpace*7), (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(7))], (int)posXKey6, (int)yPos2+(ySpace*7), (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[14], (int)posXImage6, (int)y+(ySpace*7)+5, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(7))+36], (int)posXKey6, (int)yPos2+(ySpace*7), (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[15], (int)posXImage6, (int)y+(ySpace*7)+5, (int)textWidth1, (int)textHeight1, null);
		}
		
		//star power
		if(handler.getControlsOption() == 7){
			if(arrowIsSelecting){
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getSelectedControl())], (int)posXKey7, (int)yPos2+(ySpace*8), (int)keyDimension, (int)keyDimension, null);
			}
			else{
				g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(8))], (int)posXKey7, (int)yPos2+(ySpace*8), (int)keyDimension, (int)keyDimension, null);
			}
			g.drawImage(tex.wulf[22], (int)posXImage7, (int)y+(ySpace*8)+5, (int)textWidth1, (int)textHeight1, null);
		}
		else{
			g.drawImage(tex.wulfkeys[handler.getControlValue(handler.getControl(8))+36], (int)posXKey7, (int)yPos2+(ySpace*8), (int)keyDimension, (int)keyDimension, null);
			g.drawImage(tex.wulf[23], (int)posXImage7, (int)y+(ySpace*8)+5, (int)textWidth1, (int)textHeight1, null);
		}
		
		//save
		if(handler.getControlsOption() == 8){
			g.drawImage(tex.wulf[16], (int)posXImage8, (int)y+(ySpace*11)+10, (int)textWidth2, (int)textHeight2, null);
		}
		else{
			g.drawImage(tex.wulf[17], (int)posXImage8, (int)y+(ySpace*11)+10, (int)textWidth2, (int)textHeight2, null);
		}
		
		//default
		if(handler.getControlsOption() == 9){
			g.drawImage(tex.wulf[12], (int)posXImage9+160, (int)y+(ySpace*11)+10, (int)textWidth2, (int)textHeight2, null);
		}
		else if(!handler.controlsDefaultOption()){
			g.drawImage(tex.wulf[13], (int)posXImage9+160, (int)y+(ySpace*11)+10, (int)textWidth2, (int)textHeight2, null);
		}
		else{
			g.drawImage(tex.wulf[24], (int)posXImage9+160, (int)y+(ySpace*11)+10, (int)textWidth2, (int)textHeight2, null);
		}
		
		//cancel
		if(handler.getControlsOption() == 10){
			g.drawImage(tex.wulf[18], (int)posXImage10+10, (int)y+(ySpace*15)+17+(backgroundHeight-610), (int)textWidth2, (int)textHeight2, null);
		}
		else{
			g.drawImage(tex.wulf[19], (int)posXImage10+10, (int)y+(ySpace*15)+17+(backgroundHeight-610), (int)textWidth2, (int)textHeight2, null);
		}
	}

	//moves the arrow to the wanted position
	public void moveArrow(){
		
		//arrow smooth animation
		if(arrowXPosition <= 263 && handler.getControlSelection()){
			moveArrowRight = true;
		}
		else if(arrowXPosition >= 275 && handler.getControlSelection()){
			moveArrowRight = false;
		}
		else if(arrowXPosition >= 34 && !arrowIsOnDefault && !handler.getControlSelection()){
			moveArrowRight = false;
		}
		else if(arrowXPosition <= 22 && !arrowIsOnDefault && !handler.getControlSelection()){
			moveArrowRight = true;
		}
		else if(arrowXPosition <= 180 && arrowIsOnDefault){
			moveArrowRight = true;
		}
		else if(arrowXPosition >= 192 && arrowIsOnDefault){
			moveArrowRight = false;
		}
		
		//arrow movement in Y
		if(!arrowIsSelecting){
			
			if(arrowYPosition < (int) (y+(ySpace*(handler.getControlsOption()+1))+4) && handler.getControlsOption() == 5){
				arrowYPosition+=(arrowYSpeed*2);
				if(arrowYPosition > (int) (y+(ySpace*(handler.getControlsOption()+1))+4)){
					arrowYPosition = (int) (y+(ySpace*(handler.getControlsOption()+1))+4);
				}
			}
			
			else if(arrowYPosition > (int) (y+(ySpace*(handler.getControlsOption()+1))+4) && handler.getControlsOption() == 4){
				arrowYPosition-=(arrowYSpeed*2);
				if(arrowYPosition < (int) (y+(ySpace*(handler.getControlsOption()+1))+4)){
					arrowYPosition = (int) (y+(ySpace*(handler.getControlsOption()+1))+4);
				}
			}
			
			else if(arrowYPosition > (int) (y+(ySpace*handler.getControlsOption())) && handler.getControlsOption() < 5){
				arrowYPosition-=arrowYSpeed;
				if(arrowYPosition < (int) (y+(ySpace*handler.getControlsOption()))){
					arrowYPosition = (int) (y+(ySpace*handler.getControlsOption()));
				}
			}
			
			else if(arrowYPosition < (int) (y+(ySpace*handler.getControlsOption())) && handler.getControlsOption() < 5){
				arrowYPosition+=arrowYSpeed;
				if(arrowYPosition > (int) (y+(ySpace*handler.getControlsOption()))){
					arrowYPosition = (int) (y+(ySpace*handler.getControlsOption()));
				}
			}
			
			else if(arrowYPosition < (int)y+(ySpace*12) && handler.getControlsOption() == 8){
				arrowYPosition+=(arrowYSpeed*3);
				if(arrowYPosition > (int)y+(ySpace*12)){
					arrowYPosition = (int)y+(ySpace*12);
				}
			}
			
			else if(arrowYPosition > (int) (y+(ySpace*(handler.getControlsOption()+1))+4) && handler.getControlsOption() == 7){
				arrowYPosition-=(arrowYSpeed*3);
				if(arrowYPosition < (int) (y+(ySpace*(handler.getControlsOption()+1))+4)){
					arrowYPosition = (int) (y+(ySpace*(handler.getControlsOption()+1))+4);
				}
			}
			
			else if(arrowYPosition > (int) (y+(ySpace*(handler.getControlsOption()+1))+4) && handler.getControlsOption() > 4 && handler.getControlsOption() < 8){
				arrowYPosition-=arrowYSpeed;
				if(arrowYPosition < (int) (y+(ySpace*(handler.getControlsOption()+1))+4)){
					arrowYPosition = (int) (y+(ySpace*(handler.getControlsOption()+1))+4);
				}
			}
			
			else if(arrowYPosition < (int) (y+(ySpace*(handler.getControlsOption()+1))+4) && handler.getControlsOption() > 4 && handler.getControlsOption() < 8){
				arrowYPosition+=arrowYSpeed;
				if(arrowYPosition > (int) (y+(ySpace*(handler.getControlsOption()+1))+4)){
					arrowYPosition = (int) (y+(ySpace*(handler.getControlsOption()+1))+4);
				}
			}
			
			else if(arrowYPosition < (int) y+(ySpace*16)+7+(backgroundHeight-610) && handler.getControlsOption() == 10){
				arrowYPosition+=(arrowYSpeed*3);
				if(arrowYPosition > (int) y+(ySpace*16)+7+(backgroundHeight-610)){
					arrowYPosition = (int) y+(ySpace*16)+7+(backgroundHeight-610);
				}
			}
			
			else if(arrowYPosition > (int) y+(ySpace*12) && handler.getControlsOption() == 8){
				arrowYPosition-=(arrowYSpeed*3);
				if(arrowYPosition < (int) y+(ySpace*12)){
					arrowYPosition = (int) y+(ySpace*12);
				}
			}
		}
		
		//arrow movement in X
		if(handler.getControlsOption() == 9 && !arrowIsOnDefault){
			arrowXPosition = 185;
			arrowIsOnDefault = true;
		}
		if(handler.getControlsOption() != 9 && arrowIsOnDefault){
			arrowXPosition = 22;
			arrowIsOnDefault = false;
		}
		if(!arrowIsSelecting && handler.getControlSelection()){
			arrowXPosition = 268;
			arrowIsSelecting = true;
		}
		if(arrowIsSelecting && !handler.getControlSelection()){
			arrowXPosition = 22;
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
		posXImage5 = moveText(5, posXImage5);
		posXImage6 = moveText(6, posXImage6);
		posXImage7 = moveText(7, posXImage7);
		posXImage8 = moveText2(8, posXImage8);
		posXImage9 = moveText2(9, posXImage9);
		posXImage10 = moveText3(10, posXImage10);
	}
	
	//allows to set an X position to all key images
	public void setPosXKey(){
		posXKey0 = moveKey(0, posXKey0);
		posXKey1 = moveKey(1, posXKey1);
		posXKey2 = moveKey(2, posXKey2);
		posXKey3 = moveKey(3, posXKey3);
		posXKey4 = moveKey(4, posXKey4);
		posXKey5 = moveKey(5, posXKey5);
		posXKey6 = moveKey(6, posXKey6);
		posXKey7 = moveKey(7, posXKey7);
	}
	
	//sets the text image's X position (colors and start/pause/starpower)
	public int moveKey(int controlsOption, int posXKey){
		if(handler.getControlsOption() == controlsOption && arrowIsSelecting){
			if(posXKey > 305){
				posXKey-=7;
				if(posXKey < 305){
					posXKey = 305;
				}
			}
		}
		else{
			if(posXKey < 340){
				posXKey+=7;
				if(posXKey > 340){
					posXKey = 340;
				}
			}
		}
		return posXKey;
	}
	
	//sets the text image's X position (colors and start/pause/starpower)
	public int moveText(int controlsOption, int posXImage){
		if(handler.getControlsOption() == controlsOption && !arrowIsSelecting){
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
	
	//sets the text image's X position (save and default)
	public int moveText2(int controlsOption, int posXImage){
		if(handler.getControlsOption() == controlsOption){
			if(posXImage < 38){
				posXImage+=7;
				if(posXImage > 38){
					posXImage = 38;
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
	
	//sets the text image's X position (settings)
	public int moveText3(int controlsOption, int posXImage){
		if(handler.getControlsOption() == controlsOption){
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