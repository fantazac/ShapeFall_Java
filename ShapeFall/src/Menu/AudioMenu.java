package Menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;
import Objects.GameObject;
import Objects.ObjectId;

public class AudioMenu extends GameObject{

	Handler handler;
	
	float spacing;
	
	Texture tex = Game.getInstance();
	
	public AudioMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		spacing = height + 50;
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		g.fillRect((int)x, (int)(y+spacing), (int)width, (int)height);
		g.fillRect((int)x, (int)(y+(spacing*2)), (int)width, (int)height);
		g.fillRect((int)x, (int)(y+(spacing*3)), (int)width, (int)height);
		
		g.drawImage(tex.main[25], (int)x, (int)y, (int)width, (int)height, null);
		g.drawImage(tex.main[26], (int)x, (int)(y+spacing), (int)width, (int)height, null);
		//g.drawImage(tex.main[2], (int)x, (int)(y+(spacing*2)), (int)width, (int)height, null);
		g.drawImage(tex.main[13], (int)x, (int)(y+(spacing*3)), (int)width, (int)height, null);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.RED);
		g2d.draw(getBounds());
	}

	public Rectangle getBounds() {
		if(handler.getAudioOption() == 0){
			return new Rectangle((int)x, (int)y, (int)width, (int)height);
		}
		else if(handler.getAudioOption() == 1){
			return new Rectangle((int)x, (int)(y+spacing), (int)width, (int)height);
		}
		else if(handler.getAudioOption() == 2){
			return new Rectangle((int)x, (int)(y+(spacing*2)), (int)width, (int)height);
		}
		else if(handler.getAudioOption() == 3){
			return new Rectangle((int)x, (int)(y+(spacing*3)), (int)width, (int)height);
		}
		System.out.println("*Audio Option Problem.*");
		return null;
	}
}
