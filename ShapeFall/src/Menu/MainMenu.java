package Menu;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class MainMenu extends GameObject{

	Handler handler;
	
	int spacing;
	
	//values to draw the right image for the 3 main options of the menu (when highlighted or not)
	int startOption = 6;
	
	int settingsOption = 9;
	
	int exitOption = 3;
	
	//delay for the small animation when selecting/unselecting an option
	int startOptionTick = 0;
	
	int settingsOptionTick = 0;
	
	int exitOptionTick = 0;
	
	//maximum delay for animations
	int optionDelay = 3;
	
	//dimensions for options
	int optionWidth = 400;
	
	int optionHeight1 = 159;
	
	int optionHeight2 = 64;
	
	//dimensions for background
	int backgroundWidth;
	
	int backgroundHeight;
	
	//x position for background
	int xPosBackground;
	
	//position for options
	int xPos;
	
	int yPos;
	
	int yPos2 = 518;
	
	Texture tex = Game.getInstance();
	
	public MainMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		spacing = 30;
		xPos = (int)(handler.getGameWidth()/2)-200;
		yPos = 130;
		backgroundWidth = (int) handler.getBackgroundWidth();
		backgroundHeight = (int)handler.getBackgroundHeight();
		xPosBackground = (int) ((handler.getGameWidth()/2) - (handler.getBackgroundWidth()/2));
	}

	public void tick(LinkedList<GameObject> object) {
		if(startOption < 6 && handler.getMenuOption() != 0 && startOptionTick >= optionDelay){
			startOption++;
			startOptionTick = 0;
		}
		else if(startOption > 4 && handler.getMenuOption() == 0 && startOptionTick >= optionDelay){
			startOption--;
			startOptionTick = 0;
		}
		
		if(settingsOption < 9 && handler.getMenuOption() != 1 && settingsOptionTick >= optionDelay){
			settingsOption++;
			settingsOptionTick = 0;
		}
		else if(settingsOption > 7 && handler.getMenuOption() == 1 && settingsOptionTick >= optionDelay){
			settingsOption--;
			settingsOptionTick = 0;
		}
		
		if(exitOption < 3 && handler.getMenuOption() != 2 && exitOptionTick >= optionDelay){
			exitOption++;
			exitOptionTick = 0;
		}
		else if(exitOption > 1 && handler.getMenuOption() == 2 && exitOptionTick >= optionDelay){
			exitOption--;
			exitOptionTick = 0;
		}
		
		if(startOptionTick < optionDelay){
			startOptionTick++;
		}
		if(settingsOptionTick < optionDelay){
			settingsOptionTick++;
		}
		if(exitOptionTick < optionDelay){
			exitOptionTick++;
		}
		
	}

	public void render(Graphics g) {
		
		g.drawImage(tex.furby[0], (int) xPosBackground, 0, (int)backgroundWidth, (int)backgroundHeight, null);
		
		g.drawImage(tex.furby[startOption], (int)xPos, (int)y+spacing, (int)optionWidth, (int)optionHeight1, null);
		g.drawImage(tex.furby[settingsOption], (int)xPos, (int)y+spacing+yPos, (int)optionWidth, (int)optionHeight1, null);
		g.drawImage(tex.furby[exitOption], (int)xPos, (int)y+spacing+(yPos*2), (int)optionWidth, (int)optionHeight1, null);
		
		if(handler.getMenuOption() == 3){
			g.drawImage(tex.furby[10], (int)xPos-110, (int)yPos2, (int)optionWidth, (int)optionHeight2, null);
		}
		else{
			g.drawImage(tex.furby[11], (int)xPos-110, (int)yPos2, (int)optionWidth, (int)optionHeight2, null);
		}
		
		if(handler.getMenuOption() == 4){
			g.drawImage(tex.furby[12], (int)xPos+110, (int)yPos2, (int)optionWidth, (int)optionHeight2, null);
		}
		else{
			g.drawImage(tex.furby[13], (int)xPos+110, (int)yPos2, (int)optionWidth, (int)optionHeight2, null);
		}
		
	}

	public Rectangle getBounds() {
		return null;
	}
}
