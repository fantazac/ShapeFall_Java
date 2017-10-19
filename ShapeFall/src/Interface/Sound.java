package Interface;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

	private Clip sound;
	
	private FloatControl gainControl;
	
	Handler handler;
	
	//used for sounds
	public Sound(String file, Handler handler){
		
		this.handler = handler;
		
		try {
			AudioInputStream input; 
			input = AudioSystem.getAudioInputStream(new File("C:\\ShapeFall\\sound\\" + file));
			sound = AudioSystem.getClip(); 
			sound.open(input);
			sound.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	//used for music
	public Sound(String file, Handler handler, boolean b){
		
		this.handler = handler;
		
		try {
			AudioInputStream input;
			input = AudioSystem.getAudioInputStream(new File("C:\\ShapeFall\\music\\" + file));
			sound = AudioSystem.getClip(); 
			sound.open(input);
			sound.start();
			gainControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0);
			sound.loop(2000000000);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	
	public void stop(){
		sound.stop();
	}
	
	public void increaseVolume(){
		if(gainControl.getValue() < 0){
			gainControl.setValue(gainControl.getValue()+4);
		}
	}
	
	public void decreaseVolume(){
		if(gainControl.getValue() > -20){
			gainControl.setValue(gainControl.getValue()-4);
		}
	}
}
