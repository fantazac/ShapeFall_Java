package Interface;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import Objects.NoteBar;
import Objects.ObjectId;
import Objects.ComboBar;
import Objects.Scoreboard;
import Save.Colors;
import Save.Controls;
import Save.Difficulty;
import Save.Score;
import Save.Shape;

public class KeyInput extends KeyAdapter{
	
	//OPTIONS
	
	//T = spawn the bar
	//A = set spawn automated
	//F = set generated fall speed for squares
	//N = set numbers in squares
	//S = summon a square
	//D = bar loses width
	//O = activate power orbs
	//1,2,3,4,5 = change the color of the bar (legit)
	//9,0 = change bar color to white/black (cheat)
	//R = reset the game
	//P = pause the game
	
	//G = CUSTOM (A, F, D, O)
	
	public boolean enterKey = false;
	
	public boolean gm = false;
	
	public LinkedList<Integer> keys = new LinkedList<Integer>();
	
	Handler handler;

	public KeyInput(Handler handler){
		this.handler = handler;
		
		try {
			new Controls(this, 8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void keyPressed(KeyEvent e){
		File file = new File("C:\\ShapeFall\\furby.txt");
		try {
				 
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(handler.getGameWidth() + " " + handler.getGameHeight() + " " + handler.backgroundWidth + " " + handler.backgroundHeight);	
			bw.close();
	
		} catch (IOException e4) {
			e4.printStackTrace();
		}
		
		
		//INGAME
		if(handler.getGameState() == 1){
			state1(e);
		}
		
		//MAIN MENU
		else if(handler.getGameState() == 0){
			state0(e);
		}
		
		//PAUSE
		else if(handler.getGameState() == 2){
			state2(e);
		}
		
		//SETTINGS
		else if(handler.getGameState() == 3){
			state3(e);
		}
		
		//CONTROLS
		else if(handler.getGameState() == 4){
			state4(e);
		}
		
		//DIFFICULTY
		else if(handler.getGameState() == 5){
			state5(e);
		}
		
		//AUDIO
		else if(handler.getGameState() == 6){
			state6(e);
		}
		
		//SOUNDS
		else if(handler.getGameState() == 7){
			state7(e);
		}
		
		//MUSIC
		else if(handler.getGameState() == 8){
			state8(e);
		}
		
		//COLORS
		else if(handler.getGameState() == 9){
			state9(e);
		}
		
		//SHAPE
		else if(handler.getGameState() == 10){
			state10(e);
		}
		
		//EXTRA
		else if(handler.getGameState() == 11){
			state11(e);
		}
		
		//HIGHSCORE
		else if(handler.getGameState() == 12){
			state12(e);
		}
		
		//PAUSE SETTINGS
		else if(handler.getGameState() == 13){
			state13(e);
		}
		
		//GAME OVER
		else if(handler.getGameState() == 14){
			state14(e);
		}
		
		//CREDITS
		else if(handler.getGameState() == 15){
			state15(e);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			enterKey = true;
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			enterKey = false;
		}
	}
	
	//MAINMENU
	public void state0(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getMenuOption() > 0){
			if(handler.getMenuOption() == 4){
				handler.setMenuOption(2);
			}
			else{
				handler.setMenuOption(handler.getMenuOption()-1);
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getMenuOption() < 3){
			handler.setMenuOption(handler.getMenuOption()+1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && handler.getMenuOption() == 3){
			handler.setMenuOption(4);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT && handler.getMenuOption() == 4){
			handler.setMenuOption(3);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//start game
			if(handler.getMenuOption() == 0){
				handler.setGame();
			}
			
			//settings
			if(handler.getMenuOption() == 1){
				handler.setSettings();
			}
			
			//exit
			if(handler.getMenuOption() == 2){
				System.out.println("Game shutting down.");
				System.exit(0);
			}
			
			//highscores
			if(handler.getMenuOption() == 3){
				handler.setHighscore();
			}
			
			//credits
			if(handler.getMenuOption() == 4){
				handler.setCredits();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DELETE){
			new Score(0, 0, 0, 0, 0);
			try {
				handler.getScore();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_INSERT){
			new Score(123456789, 4561810, 123416, 34161, 10000);
			try {
				handler.getScore();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//INGAME
	public void state1(KeyEvent e){
		//GM
		if(e.getKeyCode() == KeyEvent.VK_EQUALS){
			if(gm){
				gm = false;
				System.out.println("GM Mode: OFF");
			}
			else if(!gm){
				gm = true;
				System.out.println("GM Mode: ON");
			}
		}
		
		//CUSTOM
		if(e.getKeyCode() == keys.get(5)){
			handler.automatedSpawn = true;
			handler.generateFallSpeed = true;
			handler.reduceBar = true;
			handler.powerOrbActive = true;
			handler.gameIsStarted = true;
		}
		
		//PAUSE
		if(e.getKeyCode() == keys.get(6)){
			handler.setPause();
		}
		
		//STAR POWER
		if(e.getKeyCode() == keys.get(7) && handler.canUseStarPower){
			handler.barColorAfterStarPower = handler.barColor;
			handler.canUseStarPower = false;
			handler.starPowerActive = true;
		}
		
		//create the bar and the combo bar
		if(e.getKeyCode() == KeyEvent.VK_T && !handler.barIsAlive && gm){
			handler.addObject(new NoteBar(handler.initialX, handler.getGameHeight()*5/6, handler.getInitialWidth(), handler.barHeight, handler, ObjectId.NoteBar));
			handler.addObject(new ComboBar(handler.getGameWidth()-60, handler.getGameHeight()*3/4, handler.comboBarWidthAndHeight, handler.comboBarWidthAndHeight, handler, ObjectId.ComboBar));
			handler.addObject(new Scoreboard(handler.getInitialX()*2, 
					handler.getBarY()+handler.getBarHeight()+((handler.getGameHeight()-handler.getBarY()-handler.getBarHeight())/2)-handler.scoreboardHeight, handler.scoreboardHeight, 
					handler.scoreboardHeight*(6f+(2f/3f)), handler, ObjectId.Scoreboard));
			handler.barIsAlive = true;
		}
		
		//determines if the bar loses width
		if(e.getKeyCode() == KeyEvent.VK_D && gm){
			if(handler.reduceBar){
				handler.reduceBar = false;
				System.out.println("Bar: Cannot get reduced");
			}
			else{
				handler.reduceBar = true;
				System.out.println("Bar: Can get reduced");
			}
		}
		
		//controls power orbs
		if(e.getKeyCode() == KeyEvent.VK_O && gm){
			if(handler.powerOrbActive){
				handler.powerOrbActive = false;
				System.out.println("Power Orb: OFF");
			}
			else{
				handler.powerOrbActive = true;
				System.out.println("Power Orb: ON");
			}
		}
		
		//controls if the spawn of squares is automated
		if(e.getKeyCode() == KeyEvent.VK_A && gm){
			if(handler.automatedSpawn){
				handler.automatedSpawn = false;
				System.out.println("Spawn: Manual");
			}
			else{
				handler.automatedSpawn = true;
				System.out.println("Spawn: Automatic");
			}
		}
		
		//controls if the fall speed of squares is random or 2
		if(e.getKeyCode() == KeyEvent.VK_F && gm){
			if(handler.generateFallSpeed){
				handler.generateFallSpeed = false;
				System.out.println("Fall Speed: 2");
			}
			else{
				handler.generateFallSpeed = true;
				System.out.println("Fall Speed: Generated");
			}
			
		}
		
		//controls numbers in the squares
		if(e.getKeyCode() == KeyEvent.VK_N && gm){
			if(handler.enableNumbers){
				handler.setNumbersEnabled(false);
				System.out.println("Numbers: OFF");
			}
			else{
				handler.setNumbersEnabled(true);
				System.out.println("Numbers: ON");
			}
			
		}
		
		//summon a random square
		if(e.getKeyCode() == KeyEvent.VK_S && handler.barIsAlive && gm){
			handler.summon();
		}
		
		//summon a green
		if(e.getKeyCode() == keys.get(0) && handler.barIsAlive && !handler.pauseDelayIsActive){
			if(!handler.starPowerActive){
				handler.setBarColor(handler.getColor(1));
				System.out.println("Bar Color: Green");
			}
			else{
				handler.barColorAfterStarPower = handler.getColor(1);
				System.out.println("Bar Color After Star Power: Green");
			}
			
		}
		
		//summon a red
		if(e.getKeyCode() == keys.get(1) && handler.barIsAlive && !handler.pauseDelayIsActive){
			if(!handler.starPowerActive){
				handler.setBarColor(handler.getColor(2));
				System.out.println("Bar Color: Red");
			}
			else{
				handler.barColorAfterStarPower = handler.getColor(2);
				System.out.println("Bar Color After Star Power: Red");
			}
		}
		
		//summon a yellow
		if(e.getKeyCode() == keys.get(2) && handler.barIsAlive && !handler.pauseDelayIsActive){
			if(!handler.starPowerActive){
				handler.setBarColor(handler.getColor(3));
				System.out.println("Bar Color: Yellow");
			}
			else{
				handler.barColorAfterStarPower = handler.getColor(3);
				System.out.println("Bar Color After Star Power: Yellow");
			}
		}
		
		//summon a blue
		if(e.getKeyCode() == keys.get(3) && handler.barIsAlive && !handler.pauseDelayIsActive && handler.difficulty >= 2){
			if(!handler.starPowerActive){
				handler.setBarColor(handler.getColor(4));
				System.out.println("Bar Color: Blue");
			}
			else{
				handler.barColorAfterStarPower = handler.getColor(4);
				System.out.println("Bar Color After Star Power: Blue");
			}
		}
		
		//summon a magenta
		if(e.getKeyCode() == keys.get(4) && handler.barIsAlive && !handler.pauseDelayIsActive && handler.difficulty >= 3){
			if(!handler.starPowerActive){
				handler.setBarColor(handler.getColor(5));
				System.out.println("Bar Color: Magenta");
			}
			else{
				handler.barColorAfterStarPower = handler.getColor(5);
				System.out.println("Bar Color After Star Power: Magenta");
			}
		}
		
		//cheat mode
		if(e.getKeyCode() == KeyEvent.VK_0 && handler.barIsAlive && gm){
			handler.setBarColor(Color.BLACK);
			System.out.println("Bar Color: Black (Cheat Mode)");
		}
		if(e.getKeyCode() == KeyEvent.VK_9 && handler.barIsAlive && gm){
			handler.setBarColor(Color.WHITE);
			System.out.println("Bar Color: White (Cheat Mode)");
		}
	}
	
	//PAUSE
	public void state2(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getPauseOption() > 0 && handler.pauseCount >= handler.pauseDelay){
			handler.setPauseOption(handler.getPauseOption()-1);
			handler.pauseCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getPauseOption() < handler.pauseOptionMax && handler.pauseCount >= handler.pauseDelay){
			handler.setPauseOption(handler.getPauseOption()+1);
			handler.pauseCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//RESUME game
			if(handler.getPauseOption() == 0){
				handler.resumeGame();
				System.out.println("Game resumed.");
				handler.setPauseOption(0);
			}
			
			//restart game
			if(handler.getPauseOption() == 1){
				handler.setScore(handler.score.get(0), handler.score.get(1), handler.score.get(2), handler.score.get(3), handler.score.get(4));
				handler.setGame();
				System.out.println("Game restarting.");
				handler.setPauseOption(0);
			}
			
			//pause settings
			if(handler.getPauseOption() == 2){
				handler.setPauseSettings();
			}
		}
	}
	
	//SETTINGS
	public void state3(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getSettingsOption() > 0 && handler.settingsCount >= handler.settingsDelay){
			handler.setSettingsOption(handler.getSettingsOption()-1);
			if(handler.getSettingsOption() == 2){
				handler.setSettingsOption(handler.getSettingsOption()-1);
			}
			handler.settingsCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getSettingsOption() < handler.settingsOptionMax && handler.settingsCount >= handler.settingsDelay){
			handler.setSettingsOption(handler.getSettingsOption()+1);
			if(handler.getSettingsOption() == 2){
				handler.setSettingsOption(handler.getSettingsOption()+1);
			}
			handler.settingsCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//CONTROLS
			if(handler.getSettingsOption() == 0){
				handler.setControls();
			}
			
			//DIFFICULTY
			if(handler.getSettingsOption() == 1){
				handler.setDifficulty();
			}
			
			//AUDIO
			if(handler.getSettingsOption() == 2){
				//handler.setAudio();
				//handler.setMusic();
			}
			
			//COLORS
			if(handler.getSettingsOption() == 3){
				handler.setColors();
			}
			
			//SHAPE
			if(handler.getSettingsOption() == 4){
				handler.setShape();
			}
			
			//MAIN MENU
			if(handler.getSettingsOption() == 5){
				handler.setMenuOption(1);
				handler.setMainMenu();
				handler.setSettingsOption(0);
			}
		}
	}
	
	//CONTROLS
	public void state4(KeyEvent e){
		if(!handler.getControlSelection()){
			if(e.getKeyCode() == KeyEvent.VK_UP && handler.getControlsOption() > 0  && handler.controlsCount >= handler.controlsDelay && handler.getControlsOption() != 9){
				if(handler.getControlsOption() == 10){
					handler.setControlsOption(8);
					handler.controlsCount = 0;
				}
				else{
					handler.setControlsOption(handler.getControlsOption()-1);
					handler.controlsCount = 0;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getControlsOption() < handler.controlsOptionMax && handler.controlsCount >= handler.controlsDelay && handler.getControlsOption() != 9){
				if(handler.getControlsOption() == 8){
					handler.setControlsOption(10);
					handler.controlsCount = 0;
				}
				else{
					handler.setControlsOption(handler.getControlsOption()+1);
					handler.controlsCount = 0;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT && handler.controlsCount >= handler.controlsDelay){
				if(handler.getControlsOption() == 9){
					handler.setControlsOption(8);
					handler.controlsCount = 0;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT && !handler.controlsDefaultOption() && handler.controlsCount >= handler.controlsDelay){
				if(handler.getControlsOption() == 8){
					handler.setControlsOption(9);
					handler.controlsCount = 0;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
				
				//control1
				if(handler.getControlsOption() == 0){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.control1, handler.availableControl);
					handler.setSelectedControl(handler.control1);
					handler.setControlSelection(true);
				}
				
				//control2
				if(handler.getControlsOption() == 1){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.control2, handler.availableControl);
					handler.setSelectedControl(handler.control2);
					handler.setControlSelection(true);
				}
				
				//control3
				if(handler.getControlsOption() == 2){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.control3, handler.availableControl);
					handler.setSelectedControl(handler.control3);
					handler.setControlSelection(true);
				}
				
				//control4
				if(handler.getControlsOption() == 3){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.control4, handler.availableControl);
					handler.setSelectedControl(handler.control4);
					handler.setControlSelection(true);
				}
				
				//control5
				if(handler.getControlsOption() == 4){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.control5, handler.availableControl);
					handler.setSelectedControl(handler.control5);
					handler.setControlSelection(true);
				}
				
				//controlStart
				if(handler.getControlsOption() == 5){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.controlStart, handler.availableControl);
					handler.setSelectedControl(handler.controlStart);
					handler.setControlSelection(true);
				}
				
				//controlPause
				if(handler.getControlsOption() == 6){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.controlPause, handler.availableControl);
					handler.setSelectedControl(handler.controlPause);
					handler.setControlSelection(true);
				}
				
				//controlStarPower
				if(handler.getControlsOption() == 7){
					handler.setCurrentControlList();
					handler.setAvailableControlList();
					handler.addControl(handler.controlStarPower, handler.availableControl);
					handler.setSelectedControl(handler.controlStarPower);
					handler.setControlSelection(true);
				}
				
				//save
				if(handler.getControlsOption() == 8){
					handler.setCurrentControlList();
					try {
						keys = new LinkedList<Integer>();
						new Controls(handler.control1, handler.control2, handler.control3, handler.control4, handler.control5, 
								handler.controlStart, handler.controlPause, handler.controlStarPower);
						new Controls(this, 8);
						System.out.println("Controls saved");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					handler.setSettings();
					handler.setControlsOption(0);
				}
				
				//default
				if(handler.getControlsOption() == 9){
					handler.setControlsDefault();
					handler.setControlsOption(8);
				}
				
				//cancel
				if(handler.getControlsOption() == 10){
					handler.setControlsCancel();
					handler.setSettings();
					handler.setControlsOption(0);
				}
			}
		}
		else{			
			if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
				handler.setControl(handler.getControlsOption()+1, handler.selectedControl);
				handler.setControlSelection(false);
			}
			
			if((e.getKeyCode() >= 48 && e.getKeyCode() < 58) || (e.getKeyCode() >= 65 && e.getKeyCode() < 101)){
				if(handler.controlIsAvailable(e.getKeyCode())){
					handler.setSelectedControl(e.getKeyCode());
				}
			}
		}
	}
	
	//DIFFICULTY
	public void state5(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getDifficultyOption() > 0  && handler.difficultyCount >= handler.difficultyDelay){
			handler.setDifficultyOption(handler.getDifficultyOption()-1);
			handler.difficultyCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getDifficultyOption() < handler.difficultyOptionMax  && handler.difficultyCount >= handler.difficultyDelay){
			handler.setDifficultyOption(handler.getDifficultyOption()+1);
			handler.difficultyCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//EASY
			if(handler.getDifficultyOption() == 0){
				new Difficulty(1);
				handler.setSettings();
			}
			
			//MEDIUM
			if(handler.getDifficultyOption() == 1){
				new Difficulty(2);
				handler.setSettings();
			}
			
			//EXPERT
			if(handler.getDifficultyOption() == 2){
				new Difficulty(3);
				handler.setSettings();
			}
			
			//CANCEL
			if(handler.getDifficultyOption() == 3){
				handler.setSettings();
			}
		}
	}
	
	//AUDIO
	public void state6(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getAudioOption() > 0){
			handler.setAudioOption(handler.getAudioOption()-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getAudioOption() < handler.audioOptionMax){
			handler.setAudioOption(handler.getAudioOption()+1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//SOUNDS
			if(handler.getAudioOption() == 0){
				handler.setSounds();
				
			}
			
			//MUSIC
			if(handler.getAudioOption() == 1){
				handler.setMusic();
			}
			
			//
			if(handler.getAudioOption() == 2){
				System.out.println("Feature not created yet. Sending back to Settings Menu: Audio.");
			}
			
			//CANCEL
			if(handler.getAudioOption() == 3){
				handler.setSettings();
				handler.setAudioOption(0);
			}
		}
	}
	
	//SOUNDS
	public void state7(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getSoundsOption() > 0){
			handler.setSoundsOption(handler.getSoundsOption()-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getSoundsOption() < handler.soundsOptionMax){
			handler.setSoundsOption(handler.getSoundsOption()+1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//
			if(handler.getSoundsOption() == 0){
				System.out.println("Feature not created yet. Sending back to Settings Menu: Audio.");
			}
			
			//
			if(handler.getSoundsOption() == 1){
				System.out.println("Feature not created yet. Sending back to Settings Menu: Audio.");
			}
			
			//
			if(handler.getSoundsOption() == 2){
				System.out.println("Feature not created yet. Sending back to Settings Menu: Audio.");
			}
			
			//CANCEL
			if(handler.getSoundsOption() == 3){
				handler.setAudio();
				handler.setSoundsOption(0);
			}
		}
	}
	
	//MUSIC
	public void state8(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getMusicOption() > 0){
			handler.setMusicOption(handler.getMusicOption()-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getMusicOption() < handler.musicOptionMax){
			handler.setMusicOption(handler.getMusicOption()+1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//FIRST SONG
			if(handler.getMusicOption() == 0){
				handler.getMusicFiles();
				//handler.setAudio();
				handler.setSettings();
			}
			
			//SECOND SONG
			if(handler.getMusicOption() == 1){
				handler.getMusicFiles();
				//handler.setAudio();
				handler.setSettings();
			}
			
			//THIRD SONG
			if(handler.getMusicOption() == 2){
				handler.getMusicFiles();
				//handler.setAudio();
				handler.setSettings();
			}
			
			//CANCEL
			if(handler.getMusicOption() == 3){
				//handler.setAudio();
				handler.setSettings();
				handler.setMusicOption(0);
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			handler.music.decreaseVolume();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			handler.music.increaseVolume();
		}
		
		//No music
		if(e.getKeyCode() == KeyEvent.VK_0){
			handler.music.stop();
		}
	}
	
	//COLORS
	public void state9(KeyEvent e){
		if(!handler.getColorSelection()){
			if(e.getKeyCode() == KeyEvent.VK_UP && handler.getColorsOption() > 0 && handler.colorsCount >= handler.colorsDelay){
				if(handler.getColorsOption() >= 5){
					handler.setColorsOption(4);
					handler.colorsCount = 0;
					
				}
				else{
					handler.setColorsOption(handler.getColorsOption()-1);
					handler.colorsCount = 0;
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getColorsOption() < 5 && handler.colorsCount >= handler.colorsDelay){
				handler.setColorsOption(handler.getColorsOption()+1);
				handler.colorsCount = 0;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
				
				//color1
				if(handler.getColorsOption() == 0){
					handler.setCurrentColorList();
					handler.setAvailableColorList();
					handler.addColor(handler.color1, handler.availableColor);
					handler.setColorSelection(true);
				}
				
				//color2
				if(handler.getColorsOption() == 1){
					handler.setCurrentColorList();
					handler.setAvailableColorList();
					handler.addColor(handler.color2, handler.availableColor);
					handler.setColorSelection(true);
				}
				
				//color3
				if(handler.getColorsOption() == 2){
					handler.setCurrentColorList();
					handler.setAvailableColorList();
					handler.addColor(handler.color3, handler.availableColor);
					handler.setColorSelection(true);
				}
				
				//color4
				if(handler.getColorsOption() == 3){
					handler.setCurrentColorList();
					handler.setAvailableColorList();
					handler.addColor(handler.color4, handler.availableColor);
					handler.setColorSelection(true);
				}
				
				//color5
				if(handler.getColorsOption() == 4){
					handler.setCurrentColorList();
					handler.setAvailableColorList();
					handler.addColor(handler.color5, handler.availableColor);
					handler.setColorSelection(true);
				}
				
				//CANCEL
				if(handler.getColorsOption() == 5){
					handler.setSettings();
					new Colors(handler.getColorNumber(handler.color1)+1, handler.getColorNumber(handler.color2)+1, handler.getColorNumber(handler.color3)+1, 
							handler.getColorNumber(handler.color4)+1, handler.getColorNumber(handler.color5)+1);
					System.out.println("Current Colors: " + handler.getColorName(handler.color1) + ", " + handler.getColorName(handler.color2) + ", " 
							+ handler.getColorName(handler.color3) + ", " + handler.getColorName(handler.color4) + ", " + handler.getColorName(handler.color5));
					handler.setColorsOption(0);
				}
			}	
		}
		else if(handler.getColorSelection()){
			if(e.getKeyCode() == KeyEvent.VK_UP && handler.getColorSelectionOption() > 0 && handler.colorsCount >= handler.colorsDelay){
				handler.setColorSelectionOption(handler.getColorSelectionOption()-1);
				handler.colorsCount = 0;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getColorSelectionOption() < handler.colorSelectionOptionMax && handler.colorsCount >= handler.colorsDelay){
				handler.setColorSelectionOption(handler.getColorSelectionOption()+1);
				handler.colorsCount = 0;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
				
				//color1
				if(handler.getColorSelectionOption() == 0){
					handler.setColor(handler.getColorsOption(), handler.availableColor.get(handler.getColorSelectionOption()));
					handler.setColorSelection(false);
					handler.setColorSelectionOption(0);
				}
				
				//color2
				if(handler.getColorSelectionOption() == 1){
					handler.setColor(handler.getColorsOption(), handler.availableColor.get(handler.getColorSelectionOption()));
					handler.setColorSelection(false);
					handler.setColorSelectionOption(0);
				}
				
				//color3
				if(handler.getColorSelectionOption() == 2){
					handler.setColor(handler.getColorsOption(), handler.availableColor.get(handler.getColorSelectionOption()));
					handler.setColorSelection(false);
					handler.setColorSelectionOption(0);
				}
				
				//color4
				if(handler.getColorSelectionOption() == 3){
					handler.setColor(handler.getColorsOption(), handler.availableColor.get(handler.getColorSelectionOption()));
					handler.setColorSelection(false);
					handler.setColorSelectionOption(0);
				}
				
				/*
				
				//color5
				if(handler.getColorSelectionOption() == 4){
					handler.setColor(handler.getColorsOption(), handler.availableColor.get(handler.getColorSelectionOption()));
					handler.setColorSelection(false);
					handler.setColorSelectionOption(0);
				}
				
				//color6
				if(handler.getColorSelectionOption() == 5){
					handler.setColor(handler.getColorsOption(), handler.availableColor.get(handler.getColorSelectionOption()));
					handler.setColorSelection(false);
					handler.setColorSelectionOption(0);
				}
				
				*/
			}	
		}
	}
	
	//SHAPE
	public void state10(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getShapeOption() > 0 && handler.shapeCount >= handler.shapeDelay){
			handler.setShapeOption(handler.getShapeOption()-1);
			handler.shapeCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getShapeOption() < handler.shapeOptionMax && handler.shapeCount >= handler.shapeDelay){
			handler.setShapeOption(handler.getShapeOption()+1);
			handler.shapeCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//SQUARE
			if(handler.getShapeOption() == 0){
				new Shape(1);
				handler.setSettings();
			}
			
			//CIRCLE
			if(handler.getShapeOption() == 1){
				new Shape(2);
				handler.setSettings();
			}
			
			//CANCEL
			if(handler.getShapeOption() == 2){
				handler.setSettings();
			}
		}
	}
	
	//EXTRA
	public void state11(KeyEvent e){
		//TO DO
	}
	
	//HIGHSCORE
	public void state12(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			handler.setMainMenu();
		}
	}
	
	//PAUSE SETTINGS
	public void state13(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getPauseSettingsOption() > 0 && handler.pauseSettingsCount >= handler.pauseSettingsDelay){
			handler.setPauseSettingsOption(handler.getPauseSettingsOption()-1);
			handler.pauseSettingsCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getPauseSettingsOption() < handler.pauseSettingsOptionMax && handler.pauseSettingsCount >= handler.pauseSettingsDelay){
			handler.setPauseSettingsOption(handler.getPauseSettingsOption()+1);
			handler.pauseSettingsCount = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//RETURN TO PAUSE MENU
			if(handler.getPauseSettingsOption() == 0){
				handler.setPause();
			}
			
			//EXIT TO MAIN MENU
			if(handler.getPauseSettingsOption() == 1){
				handler.setScore(handler.score.get(0), handler.score.get(1), handler.score.get(2), handler.score.get(3), handler.score.get(4));
				handler.setMainMenu();
				handler.setPauseSettingsOption(0);
				handler.setPauseOption(0);
			}
		}
	}
	
	//GAME OVER
	public void state14(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && handler.getGameOverOption() > 0){
			handler.setGameOverOption(handler.getGameOverOption()-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && handler.getGameOverOption() < handler.gameOverOptionMax){
			handler.setGameOverOption(handler.getGameOverOption()+1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			
			//NEW GAME
			if(handler.getGameOverOption() == 0){
				handler.setGame();
				handler.setGameOverOption(0);
			}
			
			//RETURN TO MAIN MENU
			if(handler.getGameOverOption() == 1){
				handler.setMainMenu();
				handler.setGameOverOption(0);
			}
		}
	}
	
	//CREDITS
	public void state15(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER && !enterKey){
			handler.setMainMenu();
		}
	}
	
	//add key (STRING)
	public void addKey(String num){
		addKey(Integer.parseInt(num));
	}
	
	//add key (INT)
	public void addKey(int k){
		this.keys.add(k);
	}
	
	//remove key
	public void removeKey(int k){
		this.keys.remove(k);
	}
	
}
