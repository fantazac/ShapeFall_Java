package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Handler;

public class NoteBar extends GameObject{
	
	Handler handler;
	
	//points given when catching a square successfully
	int sameColorPoints = 5;
	
	//points given when not catching a square successfully
	int notSameColorPoints = -1;
	
	//minimum bar width for the game to keep going
	int minimumBarWidth = 10;
	
	//initial width of the note bar
	float barInitialWidth;
	
	//amount of width taken away when not catching a square successfully
	int barReduction;
	
	//amount of width gained when having a 20 note streak
	int barIncrease;
	
	//animation booleans to increase of reduce the bar
	boolean barHasToBeReduced = false;
	
	boolean barHasToBeIncreased = false;
	
	//amount the bar has to be increased or reduced
	int barReductionValue = 0;
	
	int barIncreaseValue = 0;
	
	//x position for power orbs
	float xPosPowerOrb;
	
	//dimensions for power orbs
	float powerOrbDimension = 25;
	
	//maximum note streak
	int maxNoteStreak;
	
	public NoteBar(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		barInitialWidth = handler.getInitialWidth();
		xPosPowerOrb = handler.getGameWidth()-25;
		maxNoteStreak = handler.getMaxStreak();
		barReduction = (int)(barInitialWidth/25);
		barIncrease = (int)(barInitialWidth/13);
	}

	public void tick(LinkedList<GameObject> object) {
		collision();
		
		if(barHasToBeReduced){
			setWidth(getWidth()-2);
			setX(getX()+1);
			barReductionValue-=2;
			if(barReductionValue <= 0){
				barHasToBeReduced = false;
			}
		}
		
		if(barHasToBeIncreased){
			if(getWidth() >= barInitialWidth){
				barHasToBeIncreased = false;
				barIncreaseValue = 0;
			}
			else{
				setWidth(getWidth()+2);
				setX(getX()-1);
				barIncreaseValue-=2;
				if(barIncreaseValue <= 0){
					barHasToBeIncreased = false;
				}
			}
		}
		
		if(getWidth() <= minimumBarWidth){
			handler.losingSound();
			handler.setGameOver();
			System.out.println("You lost, GG.");
		}
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Green){
				if(getBounds().intersects(tempObject.getBounds())){
					amountOfPoints(1, tempObject.getX(), tempObject.getY(), tempObject);
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ObjectId.Red){
				if(getBounds().intersects(tempObject.getBounds())){
					amountOfPoints(2, tempObject.getX(), tempObject.getY(), tempObject);
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ObjectId.Yellow){
				if(getBounds().intersects(tempObject.getBounds())){
					amountOfPoints(3, tempObject.getX(), tempObject.getY(), tempObject);
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ObjectId.Blue){
				if(getBounds().intersects(tempObject.getBounds())){
					amountOfPoints(4, tempObject.getX(), tempObject.getY(), tempObject);
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ObjectId.Magenta){
				if(getBounds().intersects(tempObject.getBounds())){
					amountOfPoints(5, tempObject.getX(), tempObject.getY(), tempObject);
					handler.removeObject(tempObject);
				}
			}
		}		
	}

	public void amountOfPoints(int c, float x1, float y1, GameObject obj){
		if((handler.getBarColor() == handler.getColor(1) && c == 1) ||
				(handler.getBarColor() == handler.getColor(2) && c == 2) ||
				(handler.getBarColor() == handler.getColor(3) && c == 3) ||
				(handler.getBarColor() == handler.getColor(4) && c == 4) ||
				(handler.getBarColor() == handler.getColor(5) && c == 5 ||
				(handler.getBarColor() == Color.BLACK))){
			handler.setPoints(sameColorPoints);
			
			handler.squareSound();
			
			if(handler.powerOrbActive()){
				handler.addObject(new PowerOrb(x1, y1, powerOrbDimension, powerOrbDimension, xPosPowerOrb, y1-10, handler, ObjectId.PowerOrb));
			}
			
			handler.setNoteStreak(1);
			
			if(handler.getNoteStreak() >= maxNoteStreak && getWidth() < barInitialWidth && handler.canReduceBar() && handler.getNoteStreak()%20 == 0){
				barHasToBeIncreased = true;
				barIncreaseValue += barIncrease;
			}
		}
		else{
			handler.setPoints(notSameColorPoints);
			
			handler.failSound();
			
			if(handler.getNoteStreakForComboBar() > 0){
				handler.setNoteStreakForComboBar(-handler.getNoteStreakForComboBar());
			}
			
			if(handler.getNoteStreak() > 0){
				handler.setNoteStreak(-handler.getNoteStreak());
			}
			else if(handler.canReduceBar()){	
				if(getWidth() >= minimumBarWidth){
					barHasToBeReduced = true;
					barReductionValue += barReduction;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(handler.getBarColor());
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}

}
