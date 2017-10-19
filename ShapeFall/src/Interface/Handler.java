package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;

import Menu.AudioMenu;
import Menu.ColorsMenu;
import Menu.ControlsMenu;
import Menu.CreditsMenu;
import Menu.DifficultyMenu;
import Menu.GameOverMenu;
import Menu.HighscoreMenu;
import Menu.MusicMenu;
import Menu.MainMenu;
import Menu.PauseMenu;
import Menu.PauseSettingsMenu;
import Menu.SettingsMenu;
import Menu.ShapeMenu;
import Menu.SoundsMenu;
import Objects.Blue;
import Objects.ComboBar;
import Objects.GameObject;
import Objects.Green;
import Objects.NoteBar;
import Objects.NoteStreak;
import Objects.ObjectId;
import Objects.Magenta;
import Objects.Red;
import Objects.Scoreboard;
import Objects.Yellow;
import Save.Score;

public class Handler {

	/**
	 * Currently active Game class.
	 */
	Game game;
	
	//A FAIRE
	//CHEATS
	//SOUNDS
	//INTERFACE
	//LOGO + NAME
	
	//AUTOMATISE POWER ORBS MECHANICS
	
	//Game States
	//0 = Main Menu
	//1 = Game
	//2 = Pause
	//3 = Settings
	//4 = Controls
	//5 = Difficulty
	//6 = Audio
	//7 = Sounds
	//8 = Music
	//9 = Colors
	//10 = Shape (Image?)
	//11 = Extra (GM and stuff)
	//12 = Highscore
	//13 = Pause: Settings
	//14 = Game Over
	//15 = Credits
	/** Determines the current game state interface. Values in Handler. */
	int gameState = 0;
	
	//interface options in menus
	/** Determines the selected option in the Main Menu interface. */
	int menuOption = 0;
	
	/** Determines the selected option in the Pause Menu interface. */
	int pauseOption = 0;
	
	/** Determines the selected option in the Settings Menu interface. */
	int settingsOption = 0;
	
	/** Determines the selected option in the Controls Menu interface. */
	int controlsOption = 0;
	
	/** Determines the selected option in the Difficulty Menu interface. */
	int difficultyOption = 0;
	
	/** Determines the selected option in the Audio Menu interface. */
	int audioOption = 0;
	
	/** Determines the selected option in the Sounds Menu interface. */
	int soundsOption = 0;
	
	/** Determines the selected option in the Music Menu interface. */
	int musicOption = 0;
	
	/** Determines the selected option in the Colors Menu interface. */
	int colorsOption = 0;
	
	/** Determines the selected option in the Color Selection from the Colors Menu interface. */
	int colorSelectionOption = 0;
	
	/** Determines the selected option in the Shape Menu interface. */
	int shapeOption = 0;
	
	/** Determines the selected option in the Pause Settings Menu interface. */
	int pauseSettingsOption = 0;
	
	/** Determines the selected option in the Game Over Menu interface. */
	int gameOverOption = 0;
	
	
	//maximum values of the different menu options
	/** Determines the maximum value for options in the Main Menu interface. */
	final int menuOptionMax = 4;

	/** Determines the maximum value for options in the Pause Menu interface. */
	final int pauseOptionMax = 2;

	/** Determines the maximum value for options in the Settings Menu interface. */
	final int settingsOptionMax = 5;

	/** Determines the maximum value for options in the Controls Menu interface. */
	final int controlsOptionMax = 10;

	/** Determines the maximum value for options in the Difficulty Menu interface. */
	final int difficultyOptionMax = 3;

	/** Determines the maximum value for options in the Audio Menu interface. */
	final int audioOptionMax = 3;

	/** Determines the maximum value for options in the Sounds Menu interface. */
	final int soundsOptionMax = 3;

	/** Determines the maximum value for options in the Music Menu interface. */
	final int musicOptionMax = 3;

	/** Determines the maximum value for options in the Pause Settings Menu interface. */
	final int pauseSettingsOptionMax = 1;

	/** Determines the maximum value for options in the Colors Menu interface. */
	final int colorsOptionMax = 7;

	/** Determines the maximum value for options in the Color Selection from the Colors Menu interface. */
	final int colorSelectionOptionMax = 5;

	/** Determines the maximum value for options in the Shape Menu interface. */
	final int shapeOptionMax = 2;

	/** Determines the maximum value for options in the Game Over Menu interface. */
	int gameOverOptionMax = 1;
	
	
	//delays for KeyInput so the animation is not too fast
	/** Determines the delay in ticks to change options from the Settings Menu interface. */
	int settingsDelay = 5;
	
	/** Counts the ticks after changing options from the Settings Menu interface. */
	int settingsCount = 0;
	
	/** Determines the delay in ticks to change options from the Controls Menu interface. */
	int controlsDelay = 6;
	
	/** Counts the ticks after changing options from the Controls Menu interface. */
	int controlsCount = 0;
	
	/** Determines the delay in ticks to change options from the Colors Menu interface. */
	int colorsDelay = 5;
	
	/** Counts the ticks after changing options from the Colors Menu interface. */
	int colorsCount = 0;
	
	/** Determines the delay in ticks to change options from the Difficulty Menu interface. */
	int difficultyDelay = 5;
	
	/** Counts the ticks after changing options from the Difficulty Menu interface. */
	int difficultyCount = 0;
	
	/** Determines the delay in ticks to change options from the Shape Menu interface. */
	int shapeDelay = 5;
	
	/** Counts the ticks after changing options from the Shape Menu interface. */
	int shapeCount = 0;
	
	/** Determines the delay in ticks to change options from the Pause Menu interface. */
	int pauseDelay = 5;
	
	/** Counts the ticks after changing options from the Pause Menu interface. */
	int pauseCount = 0;
	
	/** Determines the delay in ticks to change options from the Pause Menu interface. */
	int pauseSettingsDelay = 5;
	
	/** Counts the ticks after changing options from the Pause Menu interface. */
	int pauseSettingsCount = 0;
	
	
	/** Counts the ticks between each shape spawn during the game. */
	int clock = 0;
	
	/** Determines the delay in ticks between each shape spawn during the game. */
	int spawnTime = 60;
	
	/** Determines if the NoteBar exists. True: Bar exists. */
	boolean barIsAlive = false;
	
	/** Determines if the game was started. True: Game has started. */
	boolean gameIsStarted = false;
	
	/** Determines if the spawn for the shapes is automated. True: Spawn is automated. */
	boolean automatedSpawn = false;
	
	/** Determines if the falling speed for shapes are randomly generated. True: Falling speed is randomly generated. */
	boolean generateFallSpeed = false;
	
	/** Determines if numbers appear in the shapes. True: Numbers appear in the shapes. */
	boolean enableNumbers = false;
	
	/** Determines if the NoteBar's width can be altered. True: NoteBar's width can be altered. */
	boolean reduceBar = false;
	
	/** Determines if catching a shape successfully spawns an orb for the Combo Bar. True: Catching a shape successfully spawns an orb. */
	boolean powerOrbActive = false;
	
	/** Determines if the Star Power is available for use. True: Star Power is available. */
	boolean canUseStarPower = false;
	
	/** Determines if the Star Power is currently active. True: Star Power is active. */
	boolean starPowerActive = false;
	
	/** Determines how many ticks lasts a Star Power charge. */
	final int starPowerTime = 60;
	
	
	/** Determines the basic value of the falling speed for shapes. */
	final float ySpeed = 1;
	
	/** Determines the multiplying value of the falling speed for shapes on the Easy difficulty. */
	final float ySpeedMultiplierEasy = 1;
	
	/** Determines the multiplying value of the falling speed for shapes on the Normal difficulty. */
	final float ySpeedMultiplierNormal = 1.25f;
	
	/** Determines the multiplying value of the falling speed for shapes on the Expert difficulty. */
	final float ySpeedMultiplierExpert = 2.5f;
	
	
	/** Determines the width for Buttons in the Menu interfaces. */
	final int menuButtonsWidth = 300;
	
	/** Determines the height for Buttons in the Menu interfaces. */
	final int menuButtonsHeight = 60;
	
	/** Determines the height for the Scoreboard in the Game interface. */
	final int scoreboardHeight = 20;
	
	/** Determines the height for the NoteStreak in the Game interface. */
	final int noteStreakHeight = 35;
	
	/** Determines the width and height for Shapes in the Game interface. */
	final int shapeDimension = 20;
	
	/** Determines the height for the NoteBar in the Game interface. */
	final int barHeight = 45;
	
	//total distance on the left and the right from the bar
	/** Determines the X space on the left and the right of the NoteBar. */
	final int initialDistanceOfBarFromSides = 80;
	
	/** Determines the X space on the right of the NoteBar. */
	final int initialDistanceOfBarFromRightSide = 65;
	
	/** Determines the width and height for the Arrows in the Menu interfaces. */
	final int arrowDimension = 40;
	
	/** Determines the width for backgrounds in the Game and Menu interfaces. */
	float backgroundWidth;
	
	/** Determines the height for backgrounds in the Game and Menu interfaces. */
	float backgroundHeight;
	
	/** Determines the amount of points the player has. */
	int points = 0;
	
	/** Determines the maximum amount of points the player can get. */
	final int maxPoints = 2000000000;
	
	/** Determines the minimum amount of points the player can get. */
	final int minPoints = -999999999;
	
	/** Determines the color of the last shape that was spawned. */
	int previousType;
	
	/** Determines the current note streak value. */
	int noteStreak;
	
	/** Determines the current note streak value for the Combo Bar. */
	int noteStreakForComboBar;
	
	/** Determines the maximum note streak value. */
	final int maxNoteStreak = 20;
	
	/** Determines the difficulty selected by the player. */
	int difficulty;
	
	/** Determines the lowest difficulty (1 = Easy). */
	final int minDifficulty = 1;
	
	/** Determines the highest difficulty (3 = Expert). */
	final int maxDifficulty = 3;
	
	/** Determines the value relative to squares (1). */
	final int squareValue = 1;
	
	/** Determines the String "square". */
	final String squareString = "square";
	
	/** Determines the value relative to circles (2). */
	final int circleValue = 2;
	
	/** Determines the String "circle". */
	final String circleString = "circle";
	
	/** Determines the initial width of the NoteBar. */
	float initialWidth;
	
	/** Determines the width and height of the ComboBar. */
	final int comboBarWidthAndHeight = 48;

	/** Determines the initial X position of the NoteBar. */
	float initialX;
	
	/** Determines if the Pause Menu is drawn on top of all the other objects. True: Pause Menu is drawn on top. */
	boolean pauseOnTop = true;
	
	/** Determines if the Game Over Menu is drawn on top of all the other objects. True: Game Over Menu is drawn on top. */
	boolean gameOverOnTop = true;
	
	/** Determines if the player is currently changing a color in the Colors Menu. True: The player is currently changing a color. */
	boolean colorSelection = false;
	
	/** Determines if the player is currently changing a control in the Controls Menu. True: The player is currently changing a control. */
	boolean controlSelection = false;
	
	/** Determines if the delay after resuming a game is active. True: Delay after resuming the game is active. */
	boolean pauseDelayIsActive = false;
	
	/** Counts the ticks after resuming a game. */
	int pauseDelayTick = 0;
	
	/** Determines the delay in ticks to fully resume the currently started game. */
	final int pauseGameDelay = 140;
	
	/** Counts the ticks before drawing the Pause Menu on top of all the other objects. */
	int pauseOnTopTick = 0;
	
	/** Determines the delay in ticks before drawing the Pause Menu on top of all the other objects. */
	final int pauseOnTopTickMax = 1;
	
	/** Counts the ticks before drawing the Game Over Menu on top of all the other objects. */
	int gameOverOnTopTick = 0;
	
	/** Determines the delay in ticks before drawing the Game Over Menu on top of all the other objects. */
	final int gameOverOnTopTickMax = 1;
	
	//colors of squares
	/** Determines the color used for the first shape (Green). */
	Color color1;
	
	/** Determines the color used for the second shape (Red). */
	Color color2;

	/** Determines the color used for the third shape (Yellow). */
	Color color3;
	
	/** Determines the color used for the fourth shape (Blue). */
	Color color4;
	
	/** Determines the color used for the fifth shape (Magenta). */
	Color color5;
	
	//controls
	/** Determines the control used for the first shape (Green). */
	int control1;
	
	/** Determines the control used for the second shape (Red). */
	int control2;
	
	/** Determines the control used for the third shape (Yellow). */
	int control3;
	
	/** Determines the control used for the fourth shape (Blue). */
	int control4;
	
	/** Determines the control used for the fifth shape (Magenta). */
	int control5;
	
	/** Determines the control used to start a game. */
	int controlStart;
	
	/** Determines the control used to pause a game. */
	int controlPause;
	
	/** Determines the control used to use the Star Power. */
	int controlStarPower;
	
	/** Determines the control chosen by the player for any option in the Controls Menu. */
	int selectedControl;
	
	/** Contains all the .wav files to play. */
	File[] files;
	
	/** Determines how many music files can be played. */
	int filesLength;
	
	/** Determines the sound name used when successfully catching a shape. */
	final String squareSound = "squaresound.wav";
	
	/** Determines the sound name used when not successfully catching a shape. */
	final String failSound = "failsound.wav";
	
	/** Determines the sound name used when losing a game. */
	final String losingSound = "losingsound.wav";
	
	
	//.txt file names
	/** Determines the file location for the Music save .txt file. */
	final String musicTxt = "C:\\ShapeFall\\save\\Music.txt";
	
	/** Determines the file location for the Colors save .txt file. */
	final String colorsTxt = "C:\\ShapeFall\\save\\Colors.txt";

	/** Determines the file location for the Shape save .txt file. */
	final String shapeTxt = "C:\\ShapeFall\\save\\Shape.txt";
	
	/** Determines the file location for the Controls save .txt file. */
	final String controlsTxt = "C:\\ShapeFall\\save\\Controls.txt";
	
	/** Determines the file location for the Difficulty save .txt file. */
	final String difficultyTxt = "C:\\ShapeFall\\save\\Difficulty.txt";
	
	/** Determines the file location for the Score save .txt file. */
	final String scoreTxt = "C:\\ShapeFall\\save\\Score.txt";
	
	/** Determines the file location for the music .wav file(s). */
	final String musicFileDir = "C:\\ShapeFall\\music";

	/** Determines the currently playing music Sound file. */
	Sound music;
	
	/** Determines the currently playing sound when a shape hits the NoteBar. */
	Sound hitSound;
	
	/** Determines the color for the NoteBar */
	Color barColor = Color.GRAY;
	
	/** Determines the color for the NoteBar when the Star Power is active. */
	final Color starPowerBarColor = Color.BLACK;
	
	/** Determines the color for the NoteBar when the Star Power is not active anymore. */
	Color barColorAfterStarPower;
	
	/** Determines the number of High Scores in the Highscore Menu. */
	final int numberOfHighscores = 5;
	
	
	/** Determines the list of all the alive GameObjects */
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	/** Determines the list of all possible colors (8). */
	public LinkedList<Color> color = new LinkedList<Color>(); 
	
	/** Determines the list of the currently 5 selected colors. */
	public LinkedList<Color> currentColor = new LinkedList<Color>();
	
	/** Determines the list of all the available colors, which excludes colors from the currentColor list. */
	public LinkedList<Color> availableColor = new LinkedList<Color>();
	
	/** Determines the list of the default colors. */
	public LinkedList<Color> defaultColor = new LinkedList<Color>();
	
	/** Determines the list of all the possible controls (letters and numbers only). */
	public LinkedList<Integer> control = new LinkedList<Integer>();
	
	/** Determines the list of the currently 8 selected controls. */
	public LinkedList<Integer> currentControl = new LinkedList<Integer>();
	
	/** Determines the list of all the available controls, which excludes controls from the currentControl list. */
	public LinkedList<Integer> availableControl = new LinkedList<Integer>();	
	
	/** Determines the list of the default 8 selected controls. */
	public LinkedList<Integer> defaultControl = new LinkedList<Integer>();
	
	/** Determines the list of the 5 highest scores ever reached by the player. */
	public LinkedList<Integer> score = new LinkedList<Integer>();
	
	
	
	public Handler(Game game){
		
		this.game = game;
		initialWidth = getGameWidth() - initialDistanceOfBarFromSides;
		initialX = getGameWidth() - initialWidth - initialDistanceOfBarFromRightSide;
		backgroundWidth = ((getGameHeight())*(Game.getInstance().back[0].getWidth())/(Game.getInstance().back[0].getHeight()))+4;
		backgroundHeight = getGameHeight();
		setMainMenu();
		try {
			difficulty = getDifficulty();
			System.out.println("Difficulty: " + difficulty);
			
			getMusicFiles();
			
			System.out.println("Current Shape: " + getShape(true));
			
			color1 = getColorValue(getColors(0));
			color2 = getColorValue(getColors(1));
			color3 = getColorValue(getColors(2));
			color4 = getColorValue(getColors(3));
			color5 = getColorValue(getColors(4));
			setDefaultColorList(defaultColor);
			System.out.println("Current Colors: " + getColorName(color1) + ", " + getColorName(color2) + ", " + getColorName(color3) + ", "
					 + getColorName(color4) + ", " + getColorName(color5));
			
			control1 = getControls(0);
			control2 = getControls(1);
			control3 = getControls(2);
			control4 = getControls(3);
			control5 = getControls(4);
			controlStart = getControls(5);
			controlPause = getControls(6);
			controlStarPower = getControls(7);
			setDefaultControlList(defaultControl);
			getScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setColorList(color);
		setControlList(control);
		
		
	}
	
	public void tick(){
		clock++;
		
		//calls the method tick() for all GameObjects
		for(int i = 0; i < object.size(); i++){
			object.get(i).tick(object);
		}
		
		//allows to summon a shape every spawnTime
		if(clock >= spawnTime && barIsAlive && automatedSpawn){
			summon();
			clock = 0;
		}
		
		//allows to draw the Pause Menu on top
		if(!pauseOnTop){
			pauseOnTopTick++;
			if(pauseOnTopTick >= pauseOnTopTickMax){
				pauseOnTop = true;
				pauseOnTopTick = 0;
				setPauseMenuOnTop();
			}
		}
		
		//allows to draw the Game Over Menu on top
		if(!gameOverOnTop){
			gameOverOnTopTick++;
			if(gameOverOnTopTick >= gameOverOnTopTickMax){
				gameOverOnTop = true;
				gameOverOnTopTick = 0;
				setGameOverMenuOnTop();
			}
		}
		
		//delay after resuming the game
		if(pauseDelayIsActive){
			pauseDelayTick++;
			if(pauseDelayTick == pauseGameDelay){
				pauseDelayIsActive = false;
				pauseDelayTick = 0;
			}
		}
		
		//keeps the bar at a certain color while the star power is active
		if(starPowerActive){
			if(barColor != starPowerBarColor){
				barColor = starPowerBarColor;
			}
		}
		
		//delay after changing of option in the settings menu
		if(settingsCount < settingsDelay){
			settingsCount++;
		}
		
		//delay after changing of option in the controls menu
		if(controlsCount < controlsDelay){
			controlsCount++;
		}
		
		//delay after changing of option in the colors menu
		if(colorsCount < colorsDelay){
			colorsCount++;
		}
		
		//delay after changing of option in the difficulty menu
		if(difficultyCount < difficultyDelay){
			difficultyCount++;
		}
		
		//delay after changing of option in the shape menu
		if(shapeCount < shapeDelay){
			shapeCount++;
		}
		
		//delay after changing of option in the pause menu
		if(pauseCount < pauseDelay){
			pauseCount++;
		}
		
		//delay after changing of option in the pause settings menu
		if(pauseSettingsCount < pauseSettingsDelay){
			pauseSettingsCount++;
		}
	}
	
	public void render(Graphics g){
		//draws the background if its an older menu
		if(gameState == 1 || gameState == 2 || gameState == 13 || gameState == 14){
			g.drawImage(Game.getInstance().back[0], (int) ((getGameWidth()/2) - (backgroundWidth/2)), 0, (int)backgroundWidth, (int)backgroundHeight, null);
		}
		
		//renders all GameObjects
		for(int i = 0; i < object.size(); i++){
			object.get(i).render(g);
		}
		
		//to change
		//draws the numbers on screen for the pause delay
		if(pauseDelayIsActive){
			if(pauseDelayTick < (pauseGameDelay-100)){
				g.drawImage(Game.getInstance().number[3], (int)getGameWidth()/2 - 50, (int)getGameHeight()/2 - 75, 100, 150, null);
			}
			else if(pauseDelayTick < (pauseGameDelay-60)){
				g.drawImage(Game.getInstance().number[2], (int)getGameWidth()/2 - 50, (int)getGameHeight()/2 - 75, 100, 150, null);
			}
			else if(pauseDelayTick < pauseGameDelay){
				g.drawImage(Game.getInstance().number[1], (int)getGameWidth()/2 - 50, (int)getGameHeight()/2 - 75, 100, 150, null);
			}
		}
	}
	
	public void getMusicFiles(){
		File dir = new File(musicFileDir);
		files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".wav"); 
		    }
		});
		if(files.length > 0){
			filesLength = files.length;
			if(music != null){
				music.stop();
			}
			music = new Sound(files[0].getName(), this, true);
		}
	}
	
	public float getGameHeight(){
		return game.getHeight();
	}
	
	public float getGameWidth(){
		return game.getWidth();
	}
	
	//determines which game state is active
	public void setGameState(int gs){
		if(gs == 0){
			System.out.println("Main Menu");
		}
		if(gs == 1){
			System.out.println("Game Start");
		}
		if(gs == 2){
			System.out.println("Game Paused");
		}
		if(gs == 3){
			System.out.println("Settings Menu");
		}
		if(gs == 4){
			System.out.println("Controls Menu");
		}
		if(gs == 5){
			System.out.println("Difficulty Menu");
		}
		if(gs == 6){
			System.out.println("Audio Menu");
		}
		if(gs == 7){
			System.out.println("Sounds Menu");
		}
		if(gs == 8){
			System.out.println("Music Menu");
		}
		if(gs == 9){
			System.out.println("Colors Menu");
		}
		if(gs == 10){
			System.out.println("Shape Menu");
		}
		if(gs == 11){
			System.out.println("Game State 11: Not Created Yet");
		}
		if(gs == 12){
			System.out.println("Highscore Menu");
		}
		if(gs == 13){
			System.out.println("Pause Settings");
		}
		if(gs == 14){
			System.out.println("Game Over");
		}
		if(gs == 15){
			System.out.println("Credits Menu");
		}
		if(gs < 0 || gs > 15){
			gs = 0;
			setMainMenu();
			System.out.println("Invalid Game State: Returning to Main Menu.");
		}
		gameState = gs;
	}
	
	//returns the active game state
	public int getGameState(){
		return gameState;
	}
	
	//changes active game state to "Main Menu"
	public void setMainMenu(){
		reset();
		setGameState(0);
		addObject(new MainMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/7, menuButtonsWidth, menuButtonsHeight, this, ObjectId.MainMenu));
	}
	
	//changes active game state to "Game"
	public void setGame(){
		reset();
		setGameState(1);
		spawnBar();
	}
	
	//changes back active game state to "Game"
	public void resumeGame(){
		removeMenu(ObjectId.PauseMenu);
		if(gameIsStarted){
			pauseDelayTick = 0;
			pauseDelayIsActive = true;
		}
		setGameState(1);
	}
	
	//changes active game state to "Pause Menu"
	public void setPause(){
		removeMenu(ObjectId.PauseSettingsMenu);
		setGameState(2);
		addObject(new PauseMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.PauseMenu));
		pauseOnTop = false;
	}
	
	//changes active game state to "Settings Menu"
	public void setSettings(){
		setMenu(3);
		addObject(new SettingsMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.SettingsMenu));
	}
	
	//changes active game state to "Controls Menu"
	public void setControls(){
		setMenu(4);
		addObject(new ControlsMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.ControlsMenu));
	}
	
	//changes active game state to "Settings Menu: Change Difficulty"
	public void setDifficulty(){
		setMenu(5);
		try {
			setDifficultyOption(getDifficulty()-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		addObject(new DifficultyMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.DifficultyMenu));
	}
	
	//changes active game state to "Settings Menu: Audio"
	public void setAudio(){
		setMenu(6);
		addObject(new AudioMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.AudioMenu));
	}
	
	//changes active game state to "Settings Menu: Change Game Sounds"
	public void setSounds(){
		setMenu(7);
		addObject(new SoundsMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.SoundsMenu));
	}
	
	//changes active game state to "Settings Menu: Change Game Music"
	public void setMusic(){
		setMenu(8);
		addObject(new MusicMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.MusicMenu));
	}
	
	//changes active game state to "Settings Menu: Change Colors"
	public void setColors(){
		setMenu(9);
		addObject(new ColorsMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.ColorsMenu));
	}
	
	//changes active game state to "Settings Menu: Change Shape"
	public void setShape(){
		setMenu(10);
		try {
			setShapeOption(getShape()-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		addObject(new ShapeMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.ShapeMenu));
	}
	
	//changes the active game state to "Highscore Menu"
	public void setHighscore(){
		setMenu(12);
		addObject(new HighscoreMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.HighscoreMenu));
	}
	
	//changes active game state to "Pause Menu: Settings Menu"
	public void setPauseSettings(){
		removeMenu(ObjectId.PauseMenu);
		setGameState(13);
		addObject(new PauseSettingsMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.PauseSettingsMenu));
	}
	
	//changes active game state to "Game Over"
	public void setGameOver(){
		removeMenu(ObjectId.PauseMenu);
		barIsAlive = false;
		removeBar();
		setGameState(14);
		addObject(new GameOverMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.GameOverMenu));
		gameOverOnTop = false;
		setScore(score.get(0), score.get(1), score.get(2), score.get(3), score.get(4));
	}
	
	//changes the active game state to "Credits Menu"
	public void setCredits(){
		setMenu(15);
		addObject(new CreditsMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.CreditsMenu));
	}
	
	//removes an active menu
	public void removeMenu(ObjectId id){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == id){
				removeObject(object.get(i));
			}
		}
	}
	
	//moves the active Pause Menu to be drawn on top
	public void setPauseMenuOnTop(){
		for(int i = object.size()-1; i < object.size(); i++){
			if(findEntity(ObjectId.PauseMenu) && object.get(i).getId() != ObjectId.PauseMenu){
				removeMenu(ObjectId.PauseMenu);
				addObject(new PauseMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.PauseMenu));
				System.out.println("Pause Menu placed on top.");
			}
		}
	}
	
	//moves the active Game Over Menu to be drawn on top
	public void setGameOverMenuOnTop(){
		for(int i = object.size()-1; i < object.size(); i++){
			if(findEntity(ObjectId.GameOverMenu) && object.get(i).getId() != ObjectId.GameOverMenu){
				removeMenu(ObjectId.GameOverMenu);
				addObject(new GameOverMenu((getGameWidth()/2) - (menuButtonsWidth/2), getGameHeight()/6, menuButtonsWidth, menuButtonsHeight, this, ObjectId.GameOverMenu));
				System.out.println("Game Over Menu placed on top.");
			}
		}
	}
	
	//determines which menu option is highlighted for "Main Menu"
	public void setMenuOption(int mo){
		if(mo > menuOptionMax){
			mo = menuOptionMax;
		}
		if(mo < 0){
			mo = 0;
		}
		menuOption = mo;
	}
	
	//determines which menu option is highlighted for "Pause Menu"
	public void setPauseOption(int po){
		if(po > pauseOptionMax){
			po = pauseOptionMax;
		}
		if(po < 0){
			po = 0;
		}
		pauseOption = po;
	}
	
	//determines which menu option is highlighted for "Settings Menu"
	public void setSettingsOption(int so){
		if(so > settingsOptionMax){
			so = settingsOptionMax;
		}
		if(so < 0){
			so = 0;
		}
		settingsOption = so;
	}
	
	//determines which menu option is highlighted for "Controls Menu"
	public void setControlsOption(int co){
		if(co > controlsOptionMax){
			co = controlsOptionMax;
		}
		if(co < 0){
			co = 0;
		}
		controlsOption = co;
	}
	
	//determines which menu option is highlighted for "Settings Menu: Change Difficulty"
	public void setDifficultyOption(int dop){
		if(dop > difficultyOptionMax){
			dop = difficultyOptionMax;
		}
		if(dop < 0){
			dop = 0;
		}
		difficultyOption = dop;
	}
	
	//determines which menu option is highlighted for "Settings Menu: Audio"
	public void setAudioOption(int ao){
		if(ao > audioOptionMax){
			ao = audioOptionMax;
		}
		if(ao < 0){
			ao = 0;
		}
		audioOption = ao;
	}
	
	//determines which menu option is highlighted for "Settings Menu: Sounds"
	public void setSoundsOption(int so){
		if(so > soundsOptionMax){
			so = soundsOptionMax;
		}
		if(so < 0){
			so = 0;
		}
		soundsOption = so;
	}
	
	//determines which menu option is highlighted for "Settings Menu: Change Music"
	public void setMusicOption(int gso){
		if(gso > musicOptionMax){
			gso = musicOptionMax;
		}
		if(gso < 0){
			gso = 0;
		}
		musicOption = gso;
	}
	
	//determines which menu option is highlighted for "Pause Settings Menu"
	public void setPauseSettingsOption(int pso){
		if(pso > pauseSettingsOptionMax){
			pso = pauseSettingsOptionMax;
		}
		if(pso < 0){
			pso = 0;
		}
		pauseSettingsOption = pso;
	}
	
	//determines which menu option is highlighted for "Colors Menu"
	public void setColorsOption(int co){
		if(co > colorsOptionMax){
			co = colorsOptionMax;
		}
		if(co < 0){
			co = 0;
		}
		colorsOption = co;
	}
	
	//determines which menu option is highlighted for "Colors Menu: Selection"
	public void setColorSelectionOption(int cso){
		if(cso > colorSelectionOptionMax){
			cso = colorSelectionOptionMax;
		}
		if(cso < 0){
			cso = 0;
		}
		colorSelectionOption = cso;
	}
	
	//determines which menu option is highlighted for "Shape Menu"
	public void setShapeOption(int so){
		if(so > shapeOptionMax){
			so = shapeOptionMax;
		}
		if(so < 0){
			so = 0;
		}
		shapeOption = so;
	}
	
	//determines which menu option is highlighted for "Game Over"
	public void setGameOverOption(int goo){
		if(goo > gameOverOptionMax){
			goo = gameOverOptionMax;
		}
		if(goo < 0){
			goo = 0;
		}
		gameOverOption = goo;
	}
	
	//returns the highlighted menuOption
	public int getMenuOption(){
		return menuOption;
	}
	
	//returns the highlighted pauseOption
	public int getPauseOption(){
		return pauseOption;
	}
	
	//returns the highlighted controlsOption
	public int getControlsOption(){
		return controlsOption;
	}
	
	//returns the highlighted settingsOption
	public int getSettingsOption(){
		return settingsOption;
	}
	
	//returns the highlighted difficultyOption
	public int getDifficultyOption(){
		return difficultyOption;
	}
	
	//returns the highlighted audioOption
	public int getAudioOption(){
		return audioOption;
	}
	
	//returns the highlighted soundsOption
	public int getSoundsOption(){
		return soundsOption;
	}
		
	//returns the highlighted musicOption
	public int getMusicOption(){
		return musicOption;
	}
	
	//returns the highlighted pauseSettingsOption
	public int getPauseSettingsOption(){
		return pauseSettingsOption;
	}
	
	//returns the highlighted colorsOption
	public int getColorsOption(){
		return colorsOption;
	}
	
	//returns the highlighted colorSelectionOption
	public int getColorSelectionOption(){
		return colorSelectionOption;
	}
	
	//returns the highlighted shapeOption
	public int getShapeOption(){
		return shapeOption;
	}
	
	//returns the highlighted gameOverOption
	public int getGameOverOption(){
		return gameOverOption;
	}
	
	//gets the Score from the Score.txt file
	public void getScore() throws IOException{
		String word = "";
		score = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(scoreTxt));
		for (int i = 0; i < numberOfHighscores; i++) 
		{
			word = br.readLine();
			if(word == null){
				word = "0";
			}
			addScore(Integer.parseInt(word));
		}
		br.close();
	}
	
	//sets and saves the score (considering numberOfHighscores = 5)
	public void setScore(int s1, int s2, int s3, int s4, int s5){
		
		if(points > s1){
			new Score(points, s1, s2, s3, s4);
		}
		else if(points > s2){
			new Score(s1, points, s2, s3, s4);
		}
		else if(points > s3){
			new Score(s1, s2, points, s3, s4);
		}
		else if(points > s4){
			new Score(s1, s2, s3, points, s4);
		}
		else if(points > s5){
			new Score(s1, s2, s3, s4, points);
		}
		
		try {
			getScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//returns the score list
	public LinkedList<Integer> getScoreList(){
		return score;
	}
	
	//gets the difficulty from the Difficulty.txt file
	public int getDifficulty() throws IOException{
		int diff;
		String word = "";
		
		BufferedReader br = new BufferedReader(new FileReader(difficultyTxt));
		word = br.readLine();
		diff = Integer.parseInt(word);
		br.close();
		
		if(diff < minDifficulty){
			diff = minDifficulty;
		}
		
		if(diff > maxDifficulty){
			diff = maxDifficulty;
		}
		
		return diff;
	}
	
	//gets the shape from the Shape.txt file
	public int getShape() throws IOException{
		int value = 0;
		String word = "";
		
		BufferedReader br = new BufferedReader(new FileReader(shapeTxt));
		word = br.readLine();
		br.close();
		
		if(word.equals(squareString)){
			value = squareValue;
		}
		else if(word.equals(circleString)){
			value = circleValue;
		}
		else{
			value = squareValue;
			System.out.println("ERROR getShape(): Invalid string (" + word + ").");
		}
		
		return value;
	}
	
	//gets the shape from the Shape.txt file (used in Handler controller to print the current shape)
	public String getShape(boolean b) throws IOException{
		String word = "";
		
		BufferedReader br = new BufferedReader(new FileReader(shapeTxt));
		word = br.readLine();
		br.close();
		
		return word;
	}
	
	//plays the Sound when a square is the right color
	public void squareSound(){
		hitSound = new Sound(squareSound, this);
	}
	
	//plays the Sound when a square is not the right color
	public void failSound(){
		hitSound = new Sound(failSound, this);
	}
	
	//plays the Sound when losing
	public void losingSound(){
		hitSound = new Sound(losingSound, this);
	}
	
	//gets the Controls from the Controls.txt file
	public int getControls(int n) throws IOException{
		String word = "";
		BufferedReader br = new BufferedReader(new FileReader(controlsTxt));
		for (int i = 0; i < n; i++) 
		{
			word = br.readLine();
		}
		for (int j = n; j < n+1; j++) 
		{
			word = br.readLine();
		}
		br.close();
		
		return Integer.parseInt(word);
	}
	
	//returns the control for the needed option
	public int getControl(int c){
		if(c == 1){
			return control1;
		}
		else if(c == 2){
			return control2;
		}
		else if(c == 3){
			return control3;
		}
		else if(c == 4){
			return control4;
		}
		else if(c == 5){
			return control5;
		}
		else if(c == 6){
			return controlStart;
		}
		else if(c == 7){
			return controlPause;
		}
		else if(c == 8){
			return controlStarPower;
		}
		else{
			System.out.println("ERROR getContorl(int): Control number INVALID (" + c + ").");
		}
		return control1;
	}
	
	//gives the control the new control
	public void setControl(int c, int o){
		if(c == 1){
			control1 = o;
		}
		else if(c == 2){
			control2 = o;
		}
		else if(c == 3){
			control3 = o;
		}
		else if(c == 4){
			control4 = o;
		}
		else if(c == 5){
			control5 = o;
		}
		else if(c == 6){
			controlStart = o;
		}
		else if(c == 7){
			controlPause = o;
		}
		else if(c == 8){
			controlStarPower = o;
		}
		else{
			System.out.println("ERROR setContorl(int,int): Invalid int (" + c + ", " + o + ").");
		}
	}
	
	//returns the control value for Texture
	public int getControlValue(int k){
		int n = 0;
		if(k >= '0' && k <= '9'){
			n = k - 48;
		}
		else if(k >= 'A' && k <= 'Z'){
			n = k - 55;
		}
		else{
			System.out.println("ERROR getControlValue(): Invalid int (" + k + ").");
		}
		return n;
	}
	
	//returns the color number for Texture
	public int getControlNumber(int c){
		int n = 1;
		if(c == control1){
			n = 1;
		}
		else if(c == control2){
			n = 2;
		}
		else if(c == control3){
			n = 3;
		}
		else if(c == control4){
			n = 4;
		}
		else if(c == control5){
			n = 5;
		}
		else if(c == controlStart){
			n = 6;
		}
		else if(c == controlPause){
			n = 7;
		}
		else if(c == controlStarPower){
			n = 8;
		}
		else{
			System.out.println(" ERROR getControlNumber(): Invalid int (" + c + ").");
		}
		return n;
	}
	
	//sets the default control list
	public void setDefaultControlList(LinkedList<Integer> l){
		addControl('1', l);
		addControl('2', l);
		addControl('3', l);
		addControl('4', l);
		addControl('5', l);
		addControl('G', l);
		addControl('P', l);
		addControl('U', l);
	}
	
	//sets back the controls to what it was before changing them
	public void setControlsCancel(){
		try {
			control1 = getControls(0);
			control2 = getControls(1);
			control3 = getControls(2);
			control4 = getControls(3);
			control5 = getControls(4);
			controlStart = getControls(5);
			controlPause = getControls(6);
			controlStarPower = getControls(7);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//sets back controls to default
	public void setControlsDefault(){
		control1 = defaultControl.get(0);
		control2 = defaultControl.get(1);
		control3 = defaultControl.get(2);
		control4 = defaultControl.get(3);
		control5 = defaultControl.get(4);
		controlStart = defaultControl.get(5);
		controlPause = defaultControl.get(6);
		controlStarPower = defaultControl.get(7);
	}
	
	//sets the control list
	public void setControlList(LinkedList<Integer> l){
		for(int o = '0'; o < '9'+1; o++){
			addControl(o, l);
		}
		for(int p = 'A'; p < 'Z'+1; p++){
			addControl(p, l);
		}
	} 
	
	//sets currentControl list
	public void setCurrentControlList(){
		currentControl = new LinkedList<Integer>();
		addControl(control1, currentControl);
		addControl(control2, currentControl);
		addControl(control3, currentControl);
		addControl(control4, currentControl);
		addControl(control5, currentControl);
		addControl(controlStart, currentControl);
		addControl(controlPause, currentControl);
		addControl(controlStarPower, currentControl);
	}
	
	//sets available controls
	public void setAvailableControlList(){
		availableControl = new LinkedList<Integer>();
		setControlList(availableControl);
		//go through all the possible controls (letters and numbers)
		for(int i = 0; i < control.size(); i++){
			//go through the current 7 controls (5 colors + start + pause)
			for(int j = 0; j < currentControl.size(); j++){
				//if those 2 match, ...
				if(control.get(i) == currentControl.get(j)){
					//go through all the available controls (excludes the controls of the 6 other options)
					for(int k = 0; k < availableControl.size(); k++){
						//if those 2 match, ...
						if(availableControl.get(k) == control.get(i)){
							removeControl(k, availableControl);
						}
					}
				}
			}
		}
	}
	
	//returns if control is available
	public boolean controlIsAvailable(int c){
		for(int i = 0; i < availableControl.size(); i++){
			if(availableControl.get(i) == c){
				return true;
			}
		}
		return false;
	}
	
	//get the selectedControl
	public int getSelectedControl(){
		return selectedControl;
	}
	
	//set the selectedControl
	public void setSelectedControl(int j){
		selectedControl = j;
	}
	
	//returns true if defaultControl equals the current controls
	public boolean controlsDefaultOption(){
		if(defaultControl.get(0) == control1 && defaultControl.get(1) == control2 && defaultControl.get(2) == control3 && defaultControl.get(3) == control4 
				&& defaultControl.get(4) == control5 && defaultControl.get(5) == controlStart && defaultControl.get(6) == controlPause && defaultControl.get(7) == controlStarPower){
			return true;
		}
		return false;
	}	
	
	//gets the Colors from the Colors.txt file
	public int getColors(int n) throws IOException{
		String word = "";
		BufferedReader br = new BufferedReader(new FileReader(colorsTxt));
		for (int i = 0; i < n; i++) 
		{
			word = br.readLine();
		}
		for (int i = n; i < n + 1; i++) 
		{
			word = br.readLine();
			
		}
		br.close();
		
		return Integer.parseInt(word);
	}
	
	//returns the color of the needed square
	public Color getControlsColor(int c){
		if(c == 1){
			return color1;
		}
		else if(c == 2){
			return color2;
		}
		else if(c == 3){
			return color3;
		}
		else if(c == 4){
			return color4;
		}
		else if(c == 5){
			return color5;
		}
		else if(c == 6 || c == 7 || c == 8){
			return Color.CYAN;
		}
		else{
			System.out.println("ERROR getControlsColor(int): Control number INVALID (" + c + ").");
		}
		return color1;
	}
	
	//gives a color for a int value
	public Color getColorValue(int i){
		if(i == 1){
			return Color.GREEN;
		}
		else if(i == 2){
			return Color.RED;
		}
		else if(i == 3){
			return Color.YELLOW;
		}
		else if(i == 4){
			return Color.BLUE;
		}
		else if(i == 5){
			return Color.MAGENTA;
		}
		else if(i == 6){
			return Color.ORANGE;
		}
		else if(i == 7){
			return Color.CYAN;
		}
		else if(i == 8){
			return Color.PINK;
		}
		System.out.println("ERROR getColorValue(int): i is out of range (" + i + ").");
		return null;
	}
	
	//returns the color list
	public LinkedList<Color> getColorList(){
		return color;
	}
	
	//returns the color of the needed square
	public Color getColor(int c){
		if(c == 1){
			return color1;
		}
		else if(c == 2){
			return color2;
		}
		else if(c == 3){
			return color3;
		}
		else if(c == 4){
			return color4;
		}
		else if(c == 5){
			return color5;
		}
		System.out.println("ERROR getColor(int): Color number INVALID (" + c + ").");
		return color1;
	}
	
	//returns the color number for Texture
	public int getColorNumber(Color c){
		int n = 0;
		if(c == Color.GREEN){
			n = 0;
		}
		else if(c == Color.RED){
			n = 1;
		}
		else if(c == Color.YELLOW){
			n = 2;
		}
		else if(c == Color.BLUE){
			n = 3;
		}
		else if(c == Color.MAGENTA){
			n = 4;
		}
		else if(c == Color.ORANGE){
			n = 5;
		}
		else if(c == Color.CYAN){
			n = 6;
		}
		else if(c == Color.PINK){
			n = 7;
		}
		else{
			System.out.println("ERROR getColorNumber(): Invalid color (" + c.toString() + ").");
		}
		return n;
	}
	
	//returns the color number for Texture
	public String getColorName(Color c){
		String n = "";
		if(c == Color.GREEN){
			n = "Green";
		}
		else if(c == Color.RED){
			n = "Red";
		}
		else if(c == Color.YELLOW){
			n = "Yellow";
		}
		else if(c == Color.BLUE){
			n = "Blue";
		}
		else if(c == Color.MAGENTA){
			n = "Magenta";
		}
		else if(c == Color.ORANGE){
			n = "Orange";
		}
		else if(c == Color.CYAN){
			n = "Cyan";
		}
		else if(c == Color.PINK){
			n = "Pink";
		}
		else{
			System.out.println("ERROR getColorName(). Invalid color (" + c.toString() + ").");
		}
		return n;
	}
	
	//sets a color to one of the 5
	public void setColor(int c, Color col){
		if(c == 0){
			color1 = col;
		}
		if(c == 1){
			color2 = col;
		}
		if(c == 2){
			color3 = col;
		}
		if(c == 3){
			color4 = col;
		}
		if(c == 4){
			color5 = col;
		}
	}
	
	//sets back the colors to what it was before changing them
	public void setColorsCancel(){
		try {
			color1 = getColorValue(getColors(0));
			color2 = getColorValue(getColors(1));
			color3 = getColorValue(getColors(2));
			color4 = getColorValue(getColors(3));
			color5 = getColorValue(getColors(4));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//sets back colors to default
	public void setColorsDefault(){
		color1 = defaultColor.get(0);
		color2 = defaultColor.get(1);
		color3 = defaultColor.get(2);
		color4 = defaultColor.get(3);
		color5 = defaultColor.get(4);
	}
	
	//returns true if defaultColor equals the current colors
	public boolean colorsDefaultOption(){
		if(defaultColor.get(0) == color1 && defaultColor.get(1) == color2 && defaultColor.get(2) == color3 && defaultColor.get(3) == color4 && defaultColor.get(4) == color5){
			return true;
		}
		return false;
	}
	
	//sets the color list
	public void setColorList(LinkedList<Color> l){
		addColor(Color.GREEN, l);
		addColor(Color.RED, l);
		addColor(Color.YELLOW, l);
		addColor(Color.BLUE, l);
		addColor(Color.MAGENTA, l);
		addColor(Color.ORANGE, l);
		addColor(Color.CYAN, l);
		addColor(Color.PINK, l);
	} 
	
	//sets the default color list
	public void setDefaultColorList(LinkedList<Color> l){
		addColor(Color.GREEN, l);
		addColor(Color.RED, l);
		addColor(Color.YELLOW, l);
		addColor(Color.BLUE, l);
		addColor(Color.MAGENTA, l);
	}
	
	//sets currentColor list
	public void setCurrentColorList(){
		currentColor = new LinkedList<Color>();
		addColor(color1, currentColor);
		addColor(color2, currentColor);
		addColor(color3, currentColor);
		addColor(color4, currentColor);
		addColor(color5, currentColor);
	}
	
	//sets available colors
	public void setAvailableColorList(){
		availableColor = new LinkedList<Color>();
		setColorList(availableColor);
		//go through all the possible 8 colors
		for(int i = 0; i < color.size(); i++){
			//go through the 5 currently selected colors
			for(int j = 0; j < currentColor.size(); j++){
				//if those 2 match, ...
				if(color.get(i) == currentColor.get(j)){
					//go through the 4 available colors (excludes the other 4 selected ones)
					for(int k = 0; k < availableColor.size(); k++){
						//if those 2 match, ...
						if(availableColor.get(k) == color.get(i)){
							removeColor(color.get(i), availableColor);
						}
					}
				}
			}
		}
	}
	
	//get if controlSelection is active
	public boolean getControlSelection(){
		return controlSelection;
	}
	
	//get if controlSelection is active
	public void setControlSelection(boolean b){
		controlSelection = b;
	}
	
	//get if colorSelection is active
	public boolean getColorSelection(){
		return colorSelection;
	}
	
	//get if colorSelection is active
	public void setColorSelection(boolean b){
		colorSelection = b;
	}
	
	//spawns the bar and the combo bar
	public void spawnBar(){
		addObject(new NoteBar(initialX, getGameHeight()*5/6, getInitialWidth(), barHeight, this, ObjectId.NoteBar));
		addObject(new ComboBar(getGameWidth()-60, getGameHeight()*3/4, comboBarWidthAndHeight, comboBarWidthAndHeight, this, ObjectId.ComboBar));
		addObject(new Scoreboard(getInitialX()*2, getBarY()+getBarHeight()+((getGameHeight()-getBarY()-getBarHeight())/2)-scoreboardHeight, scoreboardHeight*(6f+(2f/3f)), 
				scoreboardHeight, this, ObjectId.Scoreboard));
		addObject(new NoteStreak(getGameWidth()-240, 7, noteStreakHeight*(6f+(2f/3f)), noteStreakHeight, this, ObjectId.NoteStreak));
		barIsAlive = true;
	}
	
	//allows to find out if a precise entity exists (ID)
	public boolean findEntity(ObjectId id){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == id){
				System.out.println("Entity is alive.");
				return true;
			}
		}
		System.out.println("findEntity(id): Entity does not exist.");
		return false;
	}
	
	//removes the NoteBar
	public void removeBar(){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				removeObject(object.get(i));
			}
		}
	}
	
	//determines the bar's width
	public float getBarWidth(){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				return object.get(i).getWidth();
			}
		}
		System.out.println("getBarWidth(): Bar does not exist.");
		return 0;
	}
	
	//determines the bar's height
	public float getBarHeight(){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				return object.get(i).getHeight();
			}
		}
		System.out.println("getBarHeight(): Bar does not exist.");
		return 0;
	}
	
	//sets bar width
	public void setBarWidth(float w){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				object.get(i).setWidth(object.get(i).getWidth()+w);
				if(object.get(i).getWidth() >= getInitialWidth()){
					object.get(i).setWidth(getInitialWidth());
				}
			}
		}
	}
	
	//sets bar x
	public void setBarX(float x){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				object.get(i).setX(object.get(i).getX()+x);
				if(object.get(i).getX() <= initialX){
					object.get(i).setX(initialX);
				}
			}
		}
	}
	
	//determines the bar's x
	public float getBarX(){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				return object.get(i).getX();
			}
		}
		System.out.println("getBarX(): Bar does not exist.");
		return 0;
	}
	
	//determines the bar's y
	public float getBarY(){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).getId() == ObjectId.NoteBar){
				return object.get(i).getY();
			}
		}
		System.out.println("getBarY(): Bar does not exist.");
		return 0;
	}
	
	//get the bar initial width
	public float getInitialWidth(){
		return initialWidth;
	}
	
	//set the bar initial x
	public void setInitialX(float x3){
		initialX = x3;
	}
	
	//get arrow dimension
	public int getArrowDimension(){
		return arrowDimension;
	}
	
	//gets the backgroundWidth
	public float getBackgroundWidth(){
		return backgroundWidth;
	}
	
	//gets the backgroundHeight
	public float getBackgroundHeight(){
		return backgroundHeight;
	}
	
	//get the bar initial x
	public float getInitialX(){
		return initialX;
	}
	
	//can reduce the width of the bar
	public boolean canReduceBar(){
		return reduceBar;
	}
	
	//can do the power orbs
	public boolean powerOrbActive(){
		return powerOrbActive;
	}
	
	//starPowerIsActive or not
	public boolean starPowerActive(){
		return starPowerActive;
	}
	
	//set starPowerIsActive or not
	public void setStarPowerActive(boolean b){
		starPowerActive = b;
		if(!starPowerActive && barColor == Color.BLACK){
			setCurrentColorList();
			barColor = barColorAfterStarPower;
		}
	}
	
	//can use starPower
	public boolean canUseStarPower(){
		return canUseStarPower;
	}
	
	//sets can use starPower
	public void setCanUseStarPower(boolean b){
		canUseStarPower = b;
	}
	
	//get starPowerTime
	public int getStarPowerTime(){
		return starPowerTime;
	}
	
	//gives the color of the bar
	public Color getBarColor(){
		return barColor;
	}
	
	//sets the color of the bar
	public void setBarColor(Color color){
		barColor = color;
	}
	
	//gets noteStreak
	public int getNoteStreak(){
		return noteStreak;
	}
	
	//gets noteStreakForComboBar
	public int getNoteStreakForComboBar(){
		return noteStreakForComboBar;
	}
	
	//gets maxNoteStreak
	public int getMaxStreak(){
		return maxNoteStreak;
	}
	
	//gets if the pauseDelayIsActive
	public boolean getPauseDelayIsActive(){
		return pauseDelayIsActive;
	}
	
	//noteStreak iteration
	public void setNoteStreak(int i){
		noteStreak += i;
	}
	
	//noteStreakForComboBar iteration
	public void setNoteStreakForComboBar(int i){
		noteStreakForComboBar += i;
	}
	
	//summons a square
	public void summon(int type){
		if(gameState == 1 && !pauseDelayIsActive){
			int r = (int)((Math.random()*(getBarWidth()-40))+getBarX()+10);
			float fallSpeed = ySpeed;
			if(generateFallSpeed){
				if(difficulty == 1){
					fallSpeed = (float)(Math.random()*ySpeedMultiplierEasy)+(ySpeed);
				}
				else if(difficulty == 2){
					fallSpeed = (float)(Math.random()*ySpeedMultiplierNormal)+(ySpeed);
				}
				else if(difficulty == 3){
					fallSpeed = (float)(Math.random()*ySpeedMultiplierExpert)+(ySpeed);
				}
				else{
					System.out.println("ERROR: Difficulty for summon(int) is incorrect (" + difficulty + ").");
				}
			}
			
			if(type == 0){
				addObject(new Green(r, -shapeDimension, shapeDimension, shapeDimension, fallSpeed, color1, this, ObjectId.Green));
			}
			else if(type == 1){
				addObject(new Red(r, -shapeDimension, shapeDimension, shapeDimension, fallSpeed, color2, this, ObjectId.Red));
			}
			else if(type == 2){
				addObject(new Yellow(r, -shapeDimension, shapeDimension, shapeDimension, fallSpeed, color3, this, ObjectId.Yellow));
			}
			else if(type == 3){
				addObject(new Blue(r, -shapeDimension, shapeDimension, shapeDimension, fallSpeed, color4, this, ObjectId.Blue));
			}
			else if(type == 4){
				addObject(new Magenta(r, -shapeDimension, shapeDimension, shapeDimension, fallSpeed, color5, this, ObjectId.Magenta));
			}
			previousType = type;
		}
	}
	
	//summons a random square
	public void summon(){
		int type;
		
		do{
			type = (int)(Math.random()*(2+difficulty));
		}
		while(previousType == type);
		
		summon(type);
	}
	
	//set the number of points
	public void setPoints(int amount){
		points+=amount;
		if(points > maxPoints){
			points = maxPoints;
		}
		if(points < minPoints){
			points = minPoints;
		}
	}
	
	//gives the number of points
	public int getPoints(){
		if(points > maxPoints){
			return maxPoints;
		}
		if(points < minPoints){
			return minPoints;
		}
		return points;
	}
	
	//determines if enableNumbers is true or false
	public boolean numbersEnabled(){
		return enableNumbers;
	}
	
	//gives a value to enableNumbers
	public void setNumbersEnabled(boolean num){
		enableNumbers = num;
	}
	
	//resets the game
	public void reset(){
		object = new LinkedList<GameObject>();
		barIsAlive = false;
		automatedSpawn = false;
		generateFallSpeed = false;
		previousType = -1;
		points = 0;
		barColor = Color.GRAY;
		enableNumbers = false;
		starPowerActive = false;
		canUseStarPower = false;
		gameIsStarted = false;
		noteStreak = 0;
		noteStreakForComboBar = 0;
		reduceBar = false;
		powerOrbActive = false;
		try {
			difficulty = getDifficulty();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Game has been reseted.");
	}
	
	//reset menus
	public void setMenu(int state){
		object = new LinkedList<GameObject>();
		setGameState(state);
	}
	
	//adds an object
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	//removes an object
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	//adds a color
	public void addColor(Color c, LinkedList<Color> list){
		list.add(c);
	}
	
	//removes a color
	public void removeColor(Color c, LinkedList<Color> list){
		list.remove(c);
	}
	
	//adds a control
	public void addControl(int i, LinkedList<Integer> list){
		list.add(i);
	}
	
	//removes a control
	public void removeControl(int i, LinkedList<Integer> list){
		list.remove(i);
	}
	
	//adds a score
	public void addScore(int i){
		score.add(i);
	}
}
