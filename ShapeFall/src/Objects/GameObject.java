package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;


public abstract class GameObject {

	protected float x, y;
	
	protected float width, height;
	
	protected ObjectId id;
	
	
	public GameObject(float x, float y, float width, float height, ObjectId id){
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick(LinkedList<GameObject> object);
	
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public ObjectId getId() {
		return id;
	}
}
