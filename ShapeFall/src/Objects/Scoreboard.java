package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;

public class Scoreboard extends GameObject{

	Handler handler;
	
	Texture tex = Game.getInstance();
	
	public Scoreboard(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		int points = handler.getPoints();
		int position = 1;
		String pts = "";
		
		if(points < 0){
			g.drawImage(tex.sign[1], (int)(2+(position++*(width/10))), (int)y, (int)width/10, (int)height, null);
			position-=2;
			points*=-1;
			pts = "" + points;
			position += pts.length()+1;
		}
		else{
			pts = "" + points;
			position += pts.length()-1;
		}
		
		
		for(int i = pts.length()-1; i >= 0; i--){
			g.drawImage(tex.number[Integer.parseInt(pts.substring(i, i+1))], (int)(2+(position--*(width/10))), (int)y, (int)width/10, (int)height, null);
		}
	}

	public Rectangle getBounds() {
		return null;
	}
}
