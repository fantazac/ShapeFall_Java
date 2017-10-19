package Interface;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	public static final String gameName = "ShapeFall";
	
	public static final String version = "Alpha: 1.0.000";
	
	public boolean running = false;
	
	public Thread thread;
	
	Handler handler;
	
	static Texture tex;
	
	private void init(){
		
		tex = new Texture();
		
		new Window(400, 600, gameName+" "+version, this);
		
		//slows the program down the initialise the handler variables correctly
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		handler = new Handler(this);
		
		this.addKeyListener(new KeyInput(handler));
	}
	
	public synchronized void start(){
		
		//Used to prevent another thread to start
		if(running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run() {
		
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer >= 1000){
				
				timer += 1000;
				
				
				File file = new File("C:\\ShapeFall\\info\\Frames.txt");
				try {
						 
					if (!file.exists()) {
						file.createNewFile();
					}
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("FPS: " + frames + " TICKS: " + updates);	
					bw.close();
			
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				//System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
			
		}
		
	}
	
	private void tick(){
		handler.tick();
	}
	
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//Choses à dessiner
		
		//FOND NOIR 
		//g.setColor(Color.GRAY);
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}

	public static Texture getInstance(){
		return tex;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	
}
