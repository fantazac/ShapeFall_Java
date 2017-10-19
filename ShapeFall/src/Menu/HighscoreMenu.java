package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class HighscoreMenu extends GameObject{

	Handler handler;
	
	float spacing;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//numbers dimension
	int numberHeight = 53;
	
	int numberWidth = 40;
	
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
	
	//x position for background
	int xPosBackground;
	
	//x position ranks
	int xPosRank = 20;
	
	//temp
	int tempY = 220;
	
	int tempX = 70;
	
	int tempWidth = 190;
	
	//dimensions for keys and texts
	int textWidth = 400;
	
	int textHeight = 60;
	
	//position for text
	int xPosText = 0;
	
	int yPosText = 493;
	
	LinkedList<Integer> score = new LinkedList<Integer>();
	
	Texture tex = Game.getInstance();
	
	public HighscoreMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		spacing = numberHeight;
		score = handler.getScoreList();
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
	
	public void drawNumber(int number, int position, Graphics g, int yPos){
		g.drawImage(tex.hsnumber[number], (int)(tempX+(width-(position*(tempWidth/10)))), (int)(tempY+(yPos*spacing)), (int)numberWidth, (int)numberHeight, null);
	}

	public void render(Graphics g) {
		//draws the background
		g.drawImage(tex.highscore[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		//draws the arrow
		g.drawImage(tex.highscore[1], (int)arrowXPosition, (int)505+(backgroundHeight-610), (int)arrowDimension, (int)arrowDimension, null);
		
		//draws main menu option
		g.drawImage(tex.expert[10], (int)xPosText, (int)(yPosText+(backgroundHeight-610)), (int)textWidth, (int)textHeight, null);
		
		//number ranks
		g.drawImage(tex.hsnumber[1], (int) xPosRank, (int) tempY, (int)numberWidth, (int)numberHeight, null);
		g.drawImage(tex.hsnumber[2], (int) xPosRank, (int) (tempY+spacing), (int)numberWidth, (int)numberHeight, null);
		g.drawImage(tex.hsnumber[3], (int) xPosRank, (int) (tempY+(2*spacing)), (int)numberWidth, (int)numberHeight, null);
		g.drawImage(tex.hsnumber[4], (int) xPosRank, (int) (tempY+(3*spacing)), (int)numberWidth, (int)numberHeight, null);
		g.drawImage(tex.hsnumber[5], (int) xPosRank, (int) (tempY+(4*spacing)), (int)numberWidth, (int)numberHeight, null);
		
		//expert[10] pour main menu
		
		for(int i = 0; i < score.size(); i++){
			int points = score.get(i);
			int value = 1000000000;
			int position = 10;
			int temp = 0;
			boolean numberStarted = false;

			while(value > 0){
				if(points == 0 && !numberStarted){
					break;
				}
				if(points/value == 0){
					if(!numberStarted){
						temp = 10;
					}
					else{
						temp = 0;
					}
				}
				else{
					if(!numberStarted){
						numberStarted = true;
					}
					temp = points/value;
					points-=temp*value;
					
				}
				if(position == 1 && temp == 10){
					temp = 0;
				}
				if(temp != 10){
					drawNumber(temp, position, g, i);
				}
				value/=10;
				position--;
			}
		}
	}

	public Rectangle getBounds() {
		return null;
	}
}