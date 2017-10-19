package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;

public class ComboBar extends GameObject{

	Handler handler;
	
	//
	int barIncrease;
	
	int barIncreaseValue;
	
	int barYValue;
	
	int increaseAmount;
	
	int decreaseAmount;
	
	int streak = 0;
	
	int barStateStreakTemp;
	
	boolean barHasToBeReduced = false;
	
	boolean barHasToBeIncreased = false;
	
	int maxStreak;
	
	int starState = 0;
	
	boolean starPowerActivated = false;
	
	int starPowerTick = 0;
	
	int starPowerTime;
	
	int countStarState;
	
	Texture tex = Game.getInstance();
	
	public ComboBar(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		maxStreak = handler.getMaxStreak();
		starPowerTime = handler.getStarPowerTime();
		increaseAmount = (int)height/4;
	}

	public void tick(LinkedList<GameObject> object) {
		collision();
		
		if(handler.starPowerActive() && !starPowerActivated){
			starPowerActivated = true;
		}
		
		if(starPowerActivated && handler.getGameState() == 1 && !handler.getPauseDelayIsActive()){
			starPowerTick++;
			if(starPowerTick % starPowerTime == 0){
				starState--;
				if(starState == 0){
					starPowerActivated = false;
					handler.setStarPowerActive(false);
				}
			}
		}
		
		if(barHasToBeIncreased){
			barYValue+=4;
			barIncreaseValue-=4;
			if(barIncreaseValue <= 0 || barYValue >= height*5){
				barIncreaseValue = 0;
				barHasToBeIncreased = false;
			}
		}
		
		if(barHasToBeReduced){
			if(barHasToBeIncreased){
				barIncreaseValue = 0;
				barHasToBeIncreased = false;
			}
			barYValue-=12;
			if(barYValue <= 0){
				barYValue = 0;
				barHasToBeReduced = false;
				if(barIncreaseValue > 0){
					barHasToBeIncreased = true;
				}
			}
		}
		
		barStateStreakTemp = streak;
		streak = handler.getNoteStreakForComboBar();
		
		if(streak == 0 && !barHasToBeReduced && barStateStreakTemp != streak){
			barHasToBeReduced = true;
		}
		
		int tempStreak = streak;
		
		if(tempStreak >= maxStreak && starState < 4){
			handler.setNoteStreakForComboBar(-handler.getNoteStreakForComboBar());
			tempStreak = 0;
			streak = 0;
			starState++;
			barHasToBeReduced = true;
		}
		
		if(starState > 0 && !handler.canUseStarPower() && !handler.starPowerActive()){
			handler.setCanUseStarPower(true);
		}
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.PowerOrb){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					if(handler.powerOrbActive()){
						if(streak < maxStreak){
							handler.setNoteStreakForComboBar(1);
							barIncreaseValue += increaseAmount;
							if(!barHasToBeReduced){
								barHasToBeIncreased = true;
							}
						}
					}
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect((int)x-2, (int)(y-(height*4)-2), (int)width+4, (int)height*5+4);
		
		g.drawImage(tex.star[starState], (int)x, (int)(y-(height*5)-5), (int)width, (int)width, null);
		
		g.drawImage(tex.combo[0], (int)x, (int)(y-(height*4)), (int)width, (int)height*5, null);
		g.drawImage(tex.combo[4], (int)x, (int)((y+height-barYValue)), (int)width, (int)barYValue, null);
		
		if(starState == 4 && handler.getNoteStreakForComboBar() >= 20 && !barHasToBeIncreased){
			g.drawImage(tex.combo[4], (int)x, (int)(y-(height*4)), (int)width, (int)height*5, null);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x-2, (int)y-202, (int)width+4, (int)height*5+4);
	}

}
