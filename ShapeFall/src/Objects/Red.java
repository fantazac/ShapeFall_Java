package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.LinkedList;

import Interface.Game;
import Interface.Handler;
import Interface.Texture;

public class Red extends GameObject{

	Handler handler;
	
	//speed at which the shape falls
	float fallSpeed;
	
	//which shape is drawn (square, circle)
	int shape;
	
	//color of the shape
	Color color;
	
	Texture tex = Game.getInstance();
	
	public Red(float x, float y, float width, float height, float fallSpeed, Color color, Handler handler, ObjectId id) {
		super(x, y, width, height, id);
		this.handler = handler;
		this.fallSpeed = fallSpeed;
		this.color = color;
		try {
			shape = handler.getShape();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick(LinkedList<GameObject> object) {
		if((handler.getGameState() == 1 || handler.getGameState() == 14) && !handler.getPauseDelayIsActive()){
			y+=fallSpeed;
		}
	}

	public void render(Graphics g) {
		
		g.setColor(color);
		if(shape == 1){
			g.fillRect((int)x, (int)y, (int)width, (int)height);
		}
		else if(shape == 2){
			g.fillOval((int)x, (int)y, (int)width, (int)height);
		}
		else{
			g.fillRect((int)x, (int)y, (int)width, (int)height);
			System.out.println("RED ERROR 1");
		}
		
		if(handler.numbersEnabled()){
			g.drawImage(tex.mini[1], (int)x+2, (int)y+2, (int)width-4, (int)height-4, null);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		
		if(shape == 1){
			g2d.draw(getBounds());
		}
		else if(shape == 2){
			g2d.drawOval((int)x, (int)y, (int)width, (int)height);
		}
		else{
			g2d.draw(getBounds());
			System.out.println("RED ERROR 2");
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
}