package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;

public class NoteStreak extends GameObject{

	Handler handler;
	
	Texture tex = Game.getInstance();
	
	public NoteStreak(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		int points = handler.getNoteStreak();
		int position = 0;
		String streak = "";
		
		streak = "" + points;
		position += streak.length()-1;
		
		for(int i = 0; i < streak.length(); i++){
			g.drawImage(tex.number[Integer.parseInt(streak.substring(i, i+1))], (int)(x+width-22-(position--*(width/10))), (int)y, (int)width/10, (int)height, null);
		}
	}

	public Rectangle getBounds() {
		return null;
	}
}
