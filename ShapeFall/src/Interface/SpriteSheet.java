package Interface;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height){
		
		BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		
		return img;
	}
	
	public BufferedImage grabImage(){
		
		BufferedImage img = image.getSubimage(0, 0, image.getWidth(), image.getHeight());
		
		return img;
	}
	
}
