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

public class GameOverMenu extends GameObject{

	Handler handler;
	
	float spacing;
	
	Texture tex = Game.getInstance();
	
	public GameOverMenu(float x, float y, float width, float height, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		spacing = height + 50;
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		g.drawImage(tex.back[1], 0, 0, (int)(handler.getGameWidth()+10), (int)(handler.getGameHeight()+10), null);
		
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)(y+(spacing*2)), (int)width, (int)height);
		g.fillRect((int)x, (int)(y+(spacing*3)), (int)width, (int)height);
		
		g.drawImage(tex.main[7], (int)x, (int)(y+(spacing*2)), (int)width, (int)height, null);
		g.drawImage(tex.main[8], (int)x, (int)(y+(spacing*3)), (int)width, (int)height, null);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.RED);
		g2d.draw(getBounds());
	}

	public Rectangle getBounds() {
		if(handler.getGameOverOption() == 0){
			return new Rectangle((int)x, (int)(y+(spacing*2)), (int)width, (int)height);
		}
		else if(handler.getGameOverOption() == 1){
			return new Rectangle((int)x, (int)(y+(spacing*3)), (int)width, (int)height);
		}
		System.out.println("*Game Over Option Problem.*");
		return null;
	}
}