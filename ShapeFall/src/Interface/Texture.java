package Interface;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {

	SpriteSheet backs, zeros, ones, twos, threes, fours, fives, sixs, sevens, eights, nines, 
				emptys, pluss, minuss, star0s, star1s, star2s, star3s, star4s, heart0s, heart1s,
				combo0s, combo1s, combo2s, combo3s, combo4s, exp0s, exp1s, back2s, back3s, mini1s, mini2s,
				mini3s, mini4s, mini5s, main1s, main2s, main3s, main4s, main5s, main6s, main7s, main8s,
				main9s, main10s, main11s, main12s, main13s, main14s, main15s, main16s, main17s, main18s, 
				main19s, main20s, main21s, main22s, main23s, main24s, main25s, main26s, main27s, main28s, main29s,
				miniminuss, minipluss, colorAs, colorBs, color3s, color4s, color5s, color6s, color7s, color8s,
				control1s, control2s, control3s, control4s, control5s, control6s, control7s, control8s, control9s, 
				control10s, control11s, control12s, control13s, control14s, control15s, control16s, control17s, control18s, 
				control19s, control20s, control21s, control22s, control23s, control24s, control25s, control26s, control27s, 
				control28s, control29s, control30s, control31s, control32s, control33s, control34s, control35s, control36s,
				furbyBGs, furby1s,
				expert1s, expert2s, expert3s, expert4s, expert5s, expert6s, expert7s,
				expert8s, expert9s, expert10s, expert11s, expert12s, expert13s, expert14s,
				wulf1s, wulf2s, wulf3s, wulf4s, wulf5s, wulf6s, wulf7s, wulf8s, wulf9s, wulf10s, wulf11s, wulf12s, wulf13s, 
				wulf14s, wulf15s, wulf16s, wulf17s, wulf18s, wulf19s, wulf20s, wulf21s, wulf22s, wulf23s, wulf24s, wulf25s,
				wulf0Ss, wulf0Us, wulf1Ss, wulf1Us, wulf2Ss, wulf2Us, wulf3Ss, wulf3Us, wulf4Ss, wulf4Us, wulf5Ss, wulf5Us, 
				wulf6Ss, wulf6Us, wulf7Ss, wulf7Us, wulf8Ss, wulf8Us, wulf9Ss, wulf9Us, wulfASs, wulfAUs, wulfBSs, wulfBUs, wulfCSs, 
				wulfCUs, wulfDSs, wulfDUs, wulfESs, wulfEUs, wulfFSs, wulfFUs, wulfGSs, wulfGUs, wulfHSs, wulfHUs, wulfISs, wulfIUs, 
				wulfJSs, wulfJUs, wulfKSs, wulfKUs, wulfLSs, wulfLUs, wulfMSs, wulfMUs, wulfNSs, wulfNUs, wulfOSs, wulfOUs, wulfPSs, 
				wulfPUs, wulfQSs, wulfQUs, wulfRSs, wulfRUs, wulfSSs, wulfSUs, wulfTSs, wulfTUs, wulfUSs, wulfUUs, wulfVSs, wulfVUs, 
				wulfWSs, wulfWUs, wulfXSs, wulfXUs, wulfYSs, wulfYUs, wulfZSs, wulfZUs,
				wulfcol1s, wulfcol2s, wulfcol3s, wulfcol4s, wulfcol5s, wulfcol6s, wulfcol7s, wulfcol8s, wulfcol9s, wulfcol10s,
				highscoreBGs, highscore1s, creditsBGs, credits1s, credits2s,
				hsnumber0s, hsnumber1s, hsnumber2s, hsnumber3s, hsnumber4s, hsnumber5s, hsnumber6s, hsnumber7s, hsnumber8s, hsnumber9s,
				colorsBGs, colors1s, colors2s, colors3s, colors4s, colors5s, colors6s, colors7s, colors8s, colors9s, colors10s,
				colors11s, colors12s, colors13s, colors14s,
				diffBGs, diff1s, diff2s, diff3s, diff4s, diff5s, diff6s, diff7s, diff8s, diff9s, diff10s,
				shapeBGs, shape1s, shape2s, shape3s, shape4s, shape5s, shape6s, shape7s, shape8s, shape9s, 
				shape10s, shape11s, shape12s,
				pauseBGs, pause1s, pause2s, pause3s, pause4s, pause5s, pause6s, pause7s,
				confirmBGs, confirm1s, confirm2s, confirm3s, confirm4s,
				
				audioUnavailables;
	
	
	private BufferedImage background = null;
	private BufferedImage zero = null;
	private BufferedImage one = null;
	private BufferedImage two = null;
	private BufferedImage three = null;
	private BufferedImage four = null;
	private BufferedImage five = null;
	private BufferedImage six = null;
	private BufferedImage seven = null;
	private BufferedImage eight = null;
	private BufferedImage nine = null;
	private BufferedImage empty = null;
	private BufferedImage plus = null;
	private BufferedImage minus = null;
	private BufferedImage star0 = null;
	private BufferedImage star1 = null;
	private BufferedImage star2 = null;
	private BufferedImage star3 = null;
	private BufferedImage star4 = null;
	private BufferedImage heart0 = null;
	private BufferedImage heart1 = null;
	private BufferedImage combo0 = null;
	private BufferedImage combo1 = null;
	private BufferedImage combo2 = null;
	private BufferedImage combo3 = null;
	private BufferedImage combo4 = null;
	private BufferedImage exp0 = null;
	private BufferedImage exp1 = null;
	private BufferedImage back2 = null;
	private BufferedImage back3 = null;
	private BufferedImage mini1 = null;
	private BufferedImage mini2 = null;
	private BufferedImage mini3 = null;
	private BufferedImage mini4 = null;
	private BufferedImage mini5 = null;
	private BufferedImage main1 = null;
	private BufferedImage main2 = null;
	private BufferedImage main3 = null;
	private BufferedImage main4 = null;
	private BufferedImage main5 = null;
	private BufferedImage main6 = null;
	private BufferedImage main7 = null;
	private BufferedImage main8 = null;
	private BufferedImage main9 = null;
	private BufferedImage main10 = null;
	private BufferedImage main11 = null;
	private BufferedImage main12 = null;
	private BufferedImage main13 = null;
	private BufferedImage main14 = null;
	private BufferedImage main15 = null;
	private BufferedImage main16 = null;
	private BufferedImage main17 = null;
	private BufferedImage main18 = null;
	private BufferedImage main19 = null;
	private BufferedImage main20 = null;
	private BufferedImage main21 = null;
	private BufferedImage main22 = null;
	private BufferedImage main23 = null;
	private BufferedImage main24 = null;
	private BufferedImage main25 = null;
	private BufferedImage main26 = null;
	private BufferedImage main27 = null;
	private BufferedImage main28 = null;
	private BufferedImage main29 = null;
	private BufferedImage miniminus = null;
	private BufferedImage miniplus = null;
	private BufferedImage color1 = null;
	private BufferedImage color2 = null;
	private BufferedImage color3 = null;
	private BufferedImage color4 = null;
	private BufferedImage color5 = null;
	private BufferedImage color6 = null;
	private BufferedImage color7 = null;
	private BufferedImage color8 = null;
	private BufferedImage control1 = null;
	private BufferedImage control2 = null;
	private BufferedImage control3 = null;
	private BufferedImage control4 = null;
	private BufferedImage control5 = null;
	private BufferedImage control6 = null;
	private BufferedImage control7 = null;
	private BufferedImage control8 = null;
	private BufferedImage control9 = null;
	private BufferedImage control10 = null;
	private BufferedImage control11 = null;
	private BufferedImage control12 = null;
	private BufferedImage control13 = null;
	private BufferedImage control14 = null;
	private BufferedImage control15 = null;
	private BufferedImage control16 = null;
	private BufferedImage control17 = null;
	private BufferedImage control18 = null;
	private BufferedImage control19 = null;
	private BufferedImage control20 = null;
	private BufferedImage control21 = null;
	private BufferedImage control22 = null;
	private BufferedImage control23= null;
	private BufferedImage control24 = null;
	private BufferedImage control25 = null;
	private BufferedImage control26 = null;
	private BufferedImage control27 = null;
	private BufferedImage control28 = null;
	private BufferedImage control29 = null;
	private BufferedImage control30 = null;
	private BufferedImage control31 = null;
	private BufferedImage control32 = null;
	private BufferedImage control33 = null;
	private BufferedImage control34 = null;
	private BufferedImage control35 = null;
	private BufferedImage control36 = null;
	private BufferedImage furbyBG = null;
	private BufferedImage furby1 = null;
	private BufferedImage expert1 = null;
	private BufferedImage expert2 = null;
	private BufferedImage expert3 = null;
	private BufferedImage expert4 = null;
	private BufferedImage expert5 = null;
	private BufferedImage expert6 = null;
	private BufferedImage expert7 = null;
	private BufferedImage expert8 = null;
	private BufferedImage expert9 = null;
	private BufferedImage expert10 = null;
	private BufferedImage expert11 = null;
	private BufferedImage expert12 = null;
	private BufferedImage expert13 = null;
	private BufferedImage expert14 = null;
	private BufferedImage wulf1 = null;
	private BufferedImage wulf2 = null;
	private BufferedImage wulf3 = null;
	private BufferedImage wulf4 = null;
	private BufferedImage wulf5 = null;
	private BufferedImage wulf6 = null;
	private BufferedImage wulf7 = null;
	private BufferedImage wulf8 = null;
	private BufferedImage wulf9 = null;
	private BufferedImage wulf10 = null;
	private BufferedImage wulf11 = null;
	private BufferedImage wulf12 = null;
	private BufferedImage wulf13 = null;
	private BufferedImage wulf14 = null;
	private BufferedImage wulf15 = null;
	private BufferedImage wulf16 = null;
	private BufferedImage wulf17 = null;
	private BufferedImage wulf18 = null;
	private BufferedImage wulf19 = null;
	private BufferedImage wulf20 = null;
	private BufferedImage wulf21 = null;
	private BufferedImage wulf22 = null;
	private BufferedImage wulf23 = null;
	private BufferedImage wulf24 = null;
	private BufferedImage wulf25 = null;
	
	private BufferedImage wulf0S = null;
	private BufferedImage wulf1S = null;
	private BufferedImage wulf2S = null;
	private BufferedImage wulf3S = null;
	private BufferedImage wulf4S = null;
	private BufferedImage wulf5S = null;
	private BufferedImage wulf6S = null;
	private BufferedImage wulf7S = null;
	private BufferedImage wulf8S = null;
	private BufferedImage wulf9S = null;
	private BufferedImage wulfAS = null;
	private BufferedImage wulfBS = null;
	private BufferedImage wulfCS = null;
	private BufferedImage wulfDS = null;
	private BufferedImage wulfES = null;
	private BufferedImage wulfFS = null;
	private BufferedImage wulfGS = null;
	private BufferedImage wulfHS = null;
	private BufferedImage wulfIS = null;
	private BufferedImage wulfJS = null;
	private BufferedImage wulfKS = null;
	private BufferedImage wulfLS = null;
	private BufferedImage wulfMS = null;
	private BufferedImage wulfNS = null;
	private BufferedImage wulfOS = null;
	private BufferedImage wulfPS = null;
	private BufferedImage wulfQS = null;
	private BufferedImage wulfRS = null;
	private BufferedImage wulfSS = null;
	private BufferedImage wulfTS = null;
	private BufferedImage wulfUS = null;
	private BufferedImage wulfVS = null;
	private BufferedImage wulfWS = null;
	private BufferedImage wulfXS = null;
	private BufferedImage wulfYS = null;
	private BufferedImage wulfZS = null;
	
	private BufferedImage wulf0U = null;
	private BufferedImage wulf1U = null;
	private BufferedImage wulf2U = null;
	private BufferedImage wulf3U = null;
	private BufferedImage wulf4U = null;
	private BufferedImage wulf5U = null;
	private BufferedImage wulf6U = null;
	private BufferedImage wulf7U = null;
	private BufferedImage wulf8U = null;
	private BufferedImage wulf9U = null;
	private BufferedImage wulfAU = null;
	private BufferedImage wulfBU = null;
	private BufferedImage wulfCU = null;
	private BufferedImage wulfDU = null;
	private BufferedImage wulfEU = null;
	private BufferedImage wulfFU = null;
	private BufferedImage wulfGU = null;
	private BufferedImage wulfHU = null;
	private BufferedImage wulfIU = null;
	private BufferedImage wulfJU = null;
	private BufferedImage wulfKU = null;
	private BufferedImage wulfLU = null;
	private BufferedImage wulfMU = null;
	private BufferedImage wulfNU = null;
	private BufferedImage wulfOU = null;
	private BufferedImage wulfPU = null;
	private BufferedImage wulfQU = null;
	private BufferedImage wulfRU = null;
	private BufferedImage wulfSU = null;
	private BufferedImage wulfTU = null;
	private BufferedImage wulfUU = null;
	private BufferedImage wulfVU = null;
	private BufferedImage wulfWU = null;
	private BufferedImage wulfXU = null;
	private BufferedImage wulfYU = null;
	private BufferedImage wulfZU = null;
	
	private BufferedImage wulfcol1 = null;
	private BufferedImage wulfcol2 = null;
	private BufferedImage wulfcol3 = null;
	private BufferedImage wulfcol4 = null;
	private BufferedImage wulfcol5 = null;
	private BufferedImage wulfcol6 = null;
	private BufferedImage wulfcol7 = null;
	private BufferedImage wulfcol8 = null;
	private BufferedImage wulfcol9 = null;
	private BufferedImage wulfcol10 = null;
	
	private BufferedImage highscoreBG = null;
	private BufferedImage highscore1 = null;
	
	private BufferedImage creditsBG = null;
	private BufferedImage credits1 = null;
	private BufferedImage credits2 = null;
	
	private BufferedImage hsnumber0 = null;
	private BufferedImage hsnumber1 = null;
	private BufferedImage hsnumber2 = null;
	private BufferedImage hsnumber3 = null;
	private BufferedImage hsnumber4 = null;
	private BufferedImage hsnumber5 = null;
	private BufferedImage hsnumber6 = null;
	private BufferedImage hsnumber7 = null;
	private BufferedImage hsnumber8 = null;
	private BufferedImage hsnumber9 = null;
	
	private BufferedImage colorsBG = null;
	private BufferedImage colors1 = null;
	private BufferedImage colors2 = null;
	private BufferedImage colors3 = null;
	private BufferedImage colors4 = null;
	private BufferedImage colors5 = null;
	private BufferedImage colors6 = null;
	private BufferedImage colors7 = null;
	private BufferedImage colors8 = null;
	private BufferedImage colors9 = null;
	private BufferedImage colors10 = null;
	private BufferedImage colors11 = null;
	private BufferedImage colors12 = null;
	private BufferedImage colors13 = null;
	private BufferedImage colors14 = null;
	
	private BufferedImage diffBG = null;
	private BufferedImage diff1 = null;
	private BufferedImage diff2 = null;
	private BufferedImage diff3 = null;
	private BufferedImage diff4 = null;
	private BufferedImage diff5 = null;
	private BufferedImage diff6 = null;
	private BufferedImage diff7 = null;
	private BufferedImage diff8 = null;
	private BufferedImage diff9 = null;
	private BufferedImage diff10 = null;
	
	private BufferedImage shapeBG = null;
	private BufferedImage shape1 = null;
	private BufferedImage shape2 = null;
	private BufferedImage shape3 = null;
	private BufferedImage shape4 = null;
	private BufferedImage shape5 = null;
	private BufferedImage shape6 = null;
	private BufferedImage shape7 = null;
	private BufferedImage shape8 = null;
	private BufferedImage shape9 = null;
	private BufferedImage shape10 = null;
	private BufferedImage shape11 = null;
	private BufferedImage shape12 = null;
	
	private BufferedImage pauseBG = null;
	private BufferedImage pause1 = null;
	private BufferedImage pause2 = null;
	private BufferedImage pause3 = null;
	private BufferedImage pause4 = null;
	private BufferedImage pause5 = null;
	private BufferedImage pause6 = null;
	private BufferedImage pause7 = null;
	
	private BufferedImage confirmBG = null;
	private BufferedImage confirm1 = null;
	private BufferedImage confirm2 = null;
	private BufferedImage confirm3 = null;
	private BufferedImage confirm4 = null;
	
	private BufferedImage audioUnavailable = null;
	
	public BufferedImage[] back = new BufferedImage[2];
	public BufferedImage[] number = new BufferedImage[11];
	public BufferedImage[] mini = new BufferedImage[5];
	public BufferedImage[] sign = new BufferedImage[4];
	public BufferedImage[] star = new BufferedImage[5];
	public BufferedImage[] heart = new BufferedImage[2];
	public BufferedImage[] combo = new BufferedImage[5];
	public BufferedImage[] exp = new BufferedImage[2];
	public BufferedImage[] main = new BufferedImage[29];
	public BufferedImage[] color = new BufferedImage[8];
	public BufferedImage[] control = new BufferedImage[36];
	public BufferedImage[] furby = new BufferedImage[14];
	public BufferedImage[] expert = new BufferedImage[15];
	public BufferedImage[] wulf = new BufferedImage[25];
	public BufferedImage[] wulfkeys = new BufferedImage[72];
	public BufferedImage[] wulfcolor = new BufferedImage[10];
	public BufferedImage[] highscore = new BufferedImage[2];
	public BufferedImage[] credits = new BufferedImage[3];
	public BufferedImage[] hsnumber = new BufferedImage[10];
	public BufferedImage[] colors = new BufferedImage[15];
	public BufferedImage[] difficulty = new BufferedImage[11];
	public BufferedImage[] shape = new BufferedImage[13];
	public BufferedImage[] pause = new BufferedImage[8];
	public BufferedImage[] confirm = new BufferedImage[5];
	
	File backgroundFolder = new File("C:\\ShapeFall\\images\\background");
	
	File[] listOfFiles;
	
	public Texture(){
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		createDirectories(loader);
		
		zero = loader.loadImage("/0.png");
		one = loader.loadImage("/1.png");
		two = loader.loadImage("/2.png");
		three = loader.loadImage("/3.png");
		four = loader.loadImage("/4.png");
		five = loader.loadImage("/5.png");
		six = loader.loadImage("/6.png");
		seven = loader.loadImage("/7.png");
		eight = loader.loadImage("/8.png");
		nine = loader.loadImage("/9.png");
		empty = loader.loadImage("/empty.png");
		plus = loader.loadImage("/+.png");
		minus = loader.loadImage("/-.png");
		star0 = loader.loadImage("/star_0.png");
		star1 = loader.loadImage("/star_1.png");
		star2 = loader.loadImage("/star_2.png");
		star3 = loader.loadImage("/star_3.png");
		star4 = loader.loadImage("/star_4.png");
		heart0 = loader.loadImage("/heart_0.png");
		heart1 = loader.loadImage("/heart_1.png");
		combo0 = loader.loadImage("/combo_0.png");
		combo1 = loader.loadImage("/combo_1.png");
		combo2 = loader.loadImage("/combo_2.png");
		combo3 = loader.loadImage("/combo_3.png");
		combo4 = loader.loadImage("/combo_4.png");
		exp0 = loader.loadImage("/exp.png");
		exp1 = loader.loadImage("/exp1.png");
		back2 = loader.loadImage("/blackscreen.png");
		mini1 = loader.loadImage("/1n.png");
		mini2 = loader.loadImage("/2n.png");
		mini3 = loader.loadImage("/3n.png");
		mini4 = loader.loadImage("/4n.png");
		mini5 = loader.loadImage("/5n.png");
		main1 = loader.loadImage("/start.png");
		main2 = loader.loadImage("/controls.png");
		main3 = loader.loadImage("/settings.png");
		main4 = loader.loadImage("/exit.png");
		main5 = loader.loadImage("/yes.png");
		main6 = loader.loadImage("/no.png");
		main7 = loader.loadImage("/resume.png");
		main8 = loader.loadImage("/newgame.png");
		main9 = loader.loadImage("/mainmenu.png");
		main10 = loader.loadImage("/difficulty.png");
		main11 = loader.loadImage("/easy.png");
		main12 = loader.loadImage("/medium.png");
		main13 = loader.loadImage("/expert.png");
		main14 = loader.loadImage("/cancel.png");
		main15 = loader.loadImage("/gamesong.png");
		main16 = loader.loadImage("/pokemon.png");
		main17 = loader.loadImage("/ghostbusters.png");
		main18 = loader.loadImage("/troll.png");
		main19 = loader.loadImage("/gm.png");
		main20 = loader.loadImage("/audio.png");
		main21 = loader.loadImage("/colors.png");
		main22 = loader.loadImage("/shape.png");
		main23 = loader.loadImage("/square.png");
		main24 = loader.loadImage("/circle.png");
		main25 = loader.loadImage("/arrow.png");
		main26 = loader.loadImage("/sounds.png");
		main27 = loader.loadImage("/music.png");
		main28 = loader.loadImage("/save.png");
		main29 = loader.loadImage("/default.png");
		miniplus = loader.loadImage("/+n.png");
		miniminus = loader.loadImage("/-n.png");
		color1 = loader.loadImage("/green.png");
		color2 = loader.loadImage("/red.png");
		color3 = loader.loadImage("/yellow.png");
		color4 = loader.loadImage("/blue.png");
		color5 = loader.loadImage("/magenta.png");
		color6 = loader.loadImage("/orange.png");
		color7 = loader.loadImage("/cyan.png");
		color8 = loader.loadImage("/pink.png");
		control1 = loader.loadImage("/control_0.png");
		control2 = loader.loadImage("/control_1.png");
		control3 = loader.loadImage("/control_2.png");
		control4 = loader.loadImage("/control_3.png");
		control5 = loader.loadImage("/control_4.png");
		control6 = loader.loadImage("/control_5.png");
		control7 = loader.loadImage("/control_6.png");
		control8 = loader.loadImage("/control_7.png");
		control9 = loader.loadImage("/control_8.png");
		control10 = loader.loadImage("/control_9.png");
		control11 = loader.loadImage("/control_a.png");
		control12 = loader.loadImage("/control_b.png");
		control13 = loader.loadImage("/control_c.png");
		control14 = loader.loadImage("/control_d.png");
		control15 = loader.loadImage("/control_e.png");
		control16 = loader.loadImage("/control_f.png");
		control17 = loader.loadImage("/control_g.png");
		control18 = loader.loadImage("/control_h.png");
		control19 = loader.loadImage("/control_i.png");
		control20 = loader.loadImage("/control_j.png");
		control21 = loader.loadImage("/control_k.png");
		control22 = loader.loadImage("/control_l.png");
		control23 = loader.loadImage("/control_m.png");
		control24 = loader.loadImage("/control_n.png");
		control25 = loader.loadImage("/control_o.png");
		control26 = loader.loadImage("/control_p.png");
		control27 = loader.loadImage("/control_q.png");
		control28 = loader.loadImage("/control_r.png");
		control29 = loader.loadImage("/control_s.png");
		control30 = loader.loadImage("/control_t.png");
		control31 = loader.loadImage("/control_u.png");
		control32 = loader.loadImage("/control_v.png");
		control33 = loader.loadImage("/control_w.png");
		control34 = loader.loadImage("/control_x.png");
		control35 = loader.loadImage("/control_y.png");
		control36 = loader.loadImage("/control_z.png");
		furbyBG = loader.loadImage("C:\\ShapeFall\\images\\MainMenu\\Background.png", true);
		furby1 = loader.loadImage("C:\\ShapeFall\\images\\MainMenu\\MainMenuOptions.png", true);
		
		expert1 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Background.png", true);
		expert2 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\arrow.png", true);
		expert3 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\AudioS.png", true);
		expert4 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\AudioU.png", true);
		expert5 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\ColorsS.png", true);
		expert6 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\ColorsU.png", true);
		expert7 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\ControlsS.png", true);
		expert8 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\ControlsU.png", true);
		expert9 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\DifficultyS.png", true);
		expert10 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\DifficultyU.png", true);
		expert11 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\MainS.png", true);
		expert12 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\MainU.png", true);
		expert13 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\ShapeS.png", true);
		expert14 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\ShapeU.png", true);
		wulf1 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\background.png", true);
		wulf2 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Arrow.png", true);
		wulf3 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\FirstColS.png", true);
		wulf4 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\FirstColU.png", true);
		wulf5 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\SecondColS.png", true);
		wulf6 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\SecondColU.png", true);
		wulf7 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\ThirdColS.png", true);
		wulf8 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\ThirdColU.png", true);
		wulf9 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\FourthColS.png", true);
		wulf10 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\FourthColU.png", true);
		wulf11 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\FifthColS.png", true);
		wulf12 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\FifthColU.png", true);
		wulf13 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\DefaultS.png", true);
		wulf14 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\DefaultU.png", true);
		wulf15 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\PauseS.png", true);
		wulf16 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\PauseU.png", true);
		wulf17 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\SaveS.png", true);
		wulf18 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\SaveU.png", true);
		wulf19 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\SettingsS.png", true);
		wulf20 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\SettingsU.png", true);
		wulf21 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\StartS.png", true);
		wulf22 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\StartU.png", true);
		wulf23 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\StarS.png", true);
		wulf24 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\StarU.png", true);
		wulf25 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Buttons\\DefaultNO.png", true);
		
		wulf0S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\0S.png", true);
		wulf0U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\0U.png", true);
		wulf1S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\1S.png", true);
		wulf1U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\1U.png", true);
		wulf2S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\2S.png", true);
		wulf2U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\2U.png", true);
		wulf3S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\3S.png", true);
		wulf3U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\3U.png", true);
		wulf4S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\4S.png", true);
		wulf4U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\4U.png", true);
		wulf5S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\5S.png", true);
		wulf5U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\5U.png", true);
		wulf6S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\6S.png", true);
		wulf6U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\6U.png", true);
		wulf7S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\7S.png", true);
		wulf7U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\7U.png", true);
		wulf8S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\8S.png", true);
		wulf8U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\8U.png", true);
		wulf9S = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\9S.png", true);
		wulf9U = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\9U.png", true);
		wulfAS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\AS.png", true);
		wulfAU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\AU.png", true);
		wulfBS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\BS.png", true);
		wulfBU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\BU.png", true);
		wulfCS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\CS.png", true);
		wulfCU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\CU.png", true);
		wulfDS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\DS.png", true);
		wulfDU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\DU.png", true);
		wulfES = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\ES.png", true);
		wulfEU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\EU.png", true);
		wulfFS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\FS.png", true);
		wulfFU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\FU.png", true);
		wulfGS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\GS.png", true);
		wulfGU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\GU.png", true);
		wulfHS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\HS.png", true);
		wulfHU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\HU.png", true);
		wulfIS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\IS.png", true);
		wulfIU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\IU.png", true);
		wulfJS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\JS.png", true);
		wulfJU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\JU.png", true);
		wulfKS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\KS.png", true);
		wulfKU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\KU.png", true);
		wulfLS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\LS.png", true);
		wulfLU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\LU.png", true);
		wulfMS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\MS.png", true);
		wulfMU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\MU.png", true);
		wulfNS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\NS.png", true);
		wulfNU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\NU.png", true);
		wulfOS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\OS.png", true);
		wulfOU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\OU.png", true);
		wulfPS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\PS.png", true);
		wulfPU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\PU.png", true);
		wulfQS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\QS.png", true);
		wulfQU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\QU.png", true);
		wulfRS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\RS.png", true);
		wulfRU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\RU.png", true);
		wulfSS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\SS.png", true);
		wulfSU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\SU.png", true);
		wulfTS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\TS.png", true);
		wulfTU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\TU.png", true);
		wulfUS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\US.png", true);
		wulfUU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\UU.png", true);
		wulfVS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\VS.png", true);
		wulfVU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\VU.png", true);
		wulfWS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\WS.png", true);
		wulfWU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\WU.png", true);
		wulfXS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\XS.png", true);
		wulfXU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\XU.png", true);
		wulfYS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\YS.png", true);
		wulfYU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\YU.png", true);
		wulfZS = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\ZS.png", true);
		wulfZU = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Keys\\ZU.png", true);
		
		wulfcol1 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareGreen.png", true);
		wulfcol2 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareRed.png", true);
		wulfcol3 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareYellow.png", true);
		wulfcol4 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareBlue.png", true);
		wulfcol5 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareMagenta.png", true);
		wulfcol6 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareOrange.png", true);
		wulfcol7 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareCyan.png", true);
		wulfcol8 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquarePink.png", true);
		wulfcol9 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquarePurple.png", true);
		wulfcol10 = loader.loadImage("C:\\ShapeFall\\images\\Settings\\Controls\\Colors\\SquareTeal.png", true);
		
		highscoreBG = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\background.png", true);
		highscore1 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\arrow.png", true);
		
		creditsBG = loader.loadImage("C:\\ShapeFall\\images\\Credits\\background.png", true);
		credits1 = loader.loadImage("C:\\ShapeFall\\images\\Credits\\arrow.png", true);
		credits2 = loader.loadImage("C:\\ShapeFall\\images\\Credits\\mainmenu.png", true);
		
		hsnumber0 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\0.png", true);
		hsnumber1 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\1.png", true);
		hsnumber2 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\2.png", true);
		hsnumber3 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\3.png", true);
		hsnumber4 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\4.png", true);
		hsnumber5 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\5.png", true);
		hsnumber6 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\6.png", true);
		hsnumber7 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\7.png", true);
		hsnumber8 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\8.png", true);
		hsnumber9 = loader.loadImage("C:\\ShapeFall\\images\\Highscores\\numbers\\9.png", true);
		
		colorsBG = loader.loadImage("C:\\ShapeFall\\images\\Color\\Background.png", true);
		colors1 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\FirstColS.png", true);
		colors2 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\FirstColU.png", true);
		colors3 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\SecondColS.png", true);
		colors4 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\SecondColU.png", true);
		colors5 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\ThirdColS.png", true);
		colors6 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\ThirdColU.png", true);
		colors7 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\FourthColS.png", true);
		colors8 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\FourthColU.png", true);
		colors9 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\FifthColS.png", true);
		colors10 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Buttons\\FifthColU.png", true);
		colors11 = loader.loadImage("C:\\ShapeFall\\images\\Color\\Arrow.png", true);
		colors12 = loader.loadImage("C:\\ShapeFall\\images\\Color\\SettingsS.png", true);
		colors13 = loader.loadImage("C:\\ShapeFall\\images\\Color\\SettingsU.png", true);
		colors14 = loader.loadImage("C:\\ShapeFall\\images\\Color\\SquareGrey.png", true);
		
		diffBG = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\background.png", true);
		diff1 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\EasyS.png", true);
		diff2 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\EasyU.png", true);
		diff3 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\MedS.png", true);
		diff4 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\MedU.png", true);
		diff5 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\ExpertS.png", true);
		diff6 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\ExpertU.png", true);
		diff7 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\SettingsS.png", true);
		diff8 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\SettingsU.png", true);
		diff9 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\Current.png", true);
		diff10 = loader.loadImage("C:\\ShapeFall\\images\\Difficulty\\Arrow.png", true);
		
		shapeBG = loader.loadImage("C:\\ShapeFall\\images\\Shape\\background.png", true);
		shape1 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\TextSquareS.png", true);
		shape2 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\TextSquareU.png", true);
		shape3 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\TextCircleS.png", true);
		shape4 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\TextCircleU.png", true);
		shape5 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\SettingsS.png", true);
		shape6 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\SettingsU.png", true);
		shape7 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\SquareS.png", true);
		shape8 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\SquareU.png", true);
		shape9 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\CircleS.png", true);
		shape10 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\CircleU.png", true);
		shape11 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\Current.png", true);
		shape12 = loader.loadImage("C:\\ShapeFall\\images\\Shape\\Arrow.png", true);
		
		pauseBG = loader.loadImage("C:\\ShapeFall\\images\\Pause\\background.png", true);
		pause1 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\ContinueS.png", true);
		pause2 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\ContinueU.png", true);
		pause3 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\RetryS.png", true);
		pause4 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\RetryU.png", true);
		pause5 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\ExitS.png", true);
		pause6 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\ExitU.png", true);
		pause7 = loader.loadImage("C:\\ShapeFall\\images\\Pause\\Arrow.png", true);
		
		confirmBG = loader.loadImage("C:\\ShapeFall\\images\\Confirm\\background.png", true);
		confirm1 = loader.loadImage("C:\\ShapeFall\\images\\Confirm\\ReturnS.png", true);
		confirm2 = loader.loadImage("C:\\ShapeFall\\images\\Confirm\\ReturnU.png", true);
		confirm3 = loader.loadImage("C:\\ShapeFall\\images\\Confirm\\ExitS.png", true);
		confirm4 = loader.loadImage("C:\\ShapeFall\\images\\Confirm\\ExitU.png", true);
		
		audioUnavailable = loader.loadImage("C:\\ShapeFall\\images\\Settings\\AudioUnavailable.png", true);
		
		backs = new SpriteSheet(background);
		zeros = new SpriteSheet(zero);
		ones = new SpriteSheet(one);
		twos = new SpriteSheet(two);
		threes = new SpriteSheet(three);
		fours = new SpriteSheet(four);
		fives = new SpriteSheet(five);
		sixs = new SpriteSheet(six);
		sevens = new SpriteSheet(seven);
		eights = new SpriteSheet(eight);
		nines = new SpriteSheet(nine);
		emptys = new SpriteSheet(empty);
		pluss = new SpriteSheet(plus);
		minuss = new SpriteSheet(minus);
		star0s = new SpriteSheet(star0);
		star1s = new SpriteSheet(star1);
		star2s = new SpriteSheet(star2);
		star3s = new SpriteSheet(star3);
		star4s = new SpriteSheet(star4);
		heart0s = new SpriteSheet(heart0);
		heart1s = new SpriteSheet(heart1);
		combo0s = new SpriteSheet(combo0);
		combo1s = new SpriteSheet(combo1);
		combo2s = new SpriteSheet(combo2);
		combo3s = new SpriteSheet(combo3);
		combo4s = new SpriteSheet(combo4);
		exp0s = new SpriteSheet(exp0);
		exp1s = new SpriteSheet(exp1);
		back2s = new SpriteSheet(back2);
		back3s = new SpriteSheet(back3);
		mini1s = new SpriteSheet(mini1);
		mini2s = new SpriteSheet(mini2);
		mini3s = new SpriteSheet(mini3);
		mini4s = new SpriteSheet(mini4);
		mini5s = new SpriteSheet(mini5);
		main1s = new SpriteSheet(main1);
		main2s = new SpriteSheet(main2);
		main3s = new SpriteSheet(main3);
		main4s = new SpriteSheet(main4);
		main5s = new SpriteSheet(main5);
		main6s = new SpriteSheet(main6);
		main7s = new SpriteSheet(main7);
		main8s = new SpriteSheet(main8);
		main9s = new SpriteSheet(main9);
		main10s = new SpriteSheet(main10);
		main11s = new SpriteSheet(main11);
		main12s = new SpriteSheet(main12);
		main13s = new SpriteSheet(main13);
		main14s = new SpriteSheet(main14);
		main15s = new SpriteSheet(main15);
		main16s = new SpriteSheet(main16);
		main17s = new SpriteSheet(main17);
		main18s = new SpriteSheet(main18);
		main19s = new SpriteSheet(main19);
		main20s = new SpriteSheet(main20);
		main21s = new SpriteSheet(main21);
		main22s = new SpriteSheet(main22);
		main23s = new SpriteSheet(main23);
		main24s = new SpriteSheet(main24);
		main25s = new SpriteSheet(main25);
		main26s = new SpriteSheet(main26);
		main27s = new SpriteSheet(main27);
		main28s = new SpriteSheet(main28);
		main29s = new SpriteSheet(main29);
		minipluss = new SpriteSheet(miniplus);
		miniminuss = new SpriteSheet(miniminus);
		colorAs = new SpriteSheet(color1);
		colorBs = new SpriteSheet(color2);
		color3s = new SpriteSheet(color3);
		color4s = new SpriteSheet(color4);
		color5s = new SpriteSheet(color5);
		color6s = new SpriteSheet(color6);
		color7s = new SpriteSheet(color7);
		color8s = new SpriteSheet(color8);
		control1s = new SpriteSheet(control1);
		control2s = new SpriteSheet(control2);
		control3s = new SpriteSheet(control3);
		control4s = new SpriteSheet(control4);
		control5s = new SpriteSheet(control5);
		control6s = new SpriteSheet(control6);
		control7s = new SpriteSheet(control7);
		control8s = new SpriteSheet(control8);
		control9s = new SpriteSheet(control9);
		control10s = new SpriteSheet(control10);
		control11s = new SpriteSheet(control11);
		control12s = new SpriteSheet(control12);
		control13s = new SpriteSheet(control13);
		control14s = new SpriteSheet(control14);
		control15s = new SpriteSheet(control15);
		control16s = new SpriteSheet(control16);
		control17s = new SpriteSheet(control17);
		control18s = new SpriteSheet(control18);
		control19s = new SpriteSheet(control19);
		control20s = new SpriteSheet(control20);
		control21s = new SpriteSheet(control21);
		control22s = new SpriteSheet(control22);
		control23s = new SpriteSheet(control23);
		control24s = new SpriteSheet(control24);
		control25s = new SpriteSheet(control25);
		control26s = new SpriteSheet(control26);
		control27s = new SpriteSheet(control27);
		control28s = new SpriteSheet(control28);
		control29s = new SpriteSheet(control29);
		control30s = new SpriteSheet(control30);
		control31s = new SpriteSheet(control31);
		control32s = new SpriteSheet(control32);
		control33s = new SpriteSheet(control33);
		control34s = new SpriteSheet(control34);
		control35s = new SpriteSheet(control35);
		control36s = new SpriteSheet(control36);
		furbyBGs = new SpriteSheet(furbyBG);
		furby1s = new SpriteSheet(furby1);
		expert1s = new SpriteSheet(expert1);
		expert2s = new SpriteSheet(expert2);
		expert3s = new SpriteSheet(expert3);
		expert4s = new SpriteSheet(expert4);
		expert5s = new SpriteSheet(expert5);
		expert6s = new SpriteSheet(expert6);
		expert7s = new SpriteSheet(expert7);
		expert8s = new SpriteSheet(expert8);
		expert9s = new SpriteSheet(expert9);
		expert10s = new SpriteSheet(expert10);
		expert11s = new SpriteSheet(expert11);
		expert12s = new SpriteSheet(expert12);
		expert13s = new SpriteSheet(expert13);
		expert14s = new SpriteSheet(expert14);
		wulf1s = new SpriteSheet(wulf1);
		wulf2s = new SpriteSheet(wulf2);
		wulf3s = new SpriteSheet(wulf3);
		wulf4s = new SpriteSheet(wulf4);
		wulf5s = new SpriteSheet(wulf5);
		wulf6s = new SpriteSheet(wulf6);
		wulf7s = new SpriteSheet(wulf7);
		wulf8s = new SpriteSheet(wulf8);
		wulf9s = new SpriteSheet(wulf9);
		wulf10s = new SpriteSheet(wulf10);
		wulf11s = new SpriteSheet(wulf11);
		wulf12s = new SpriteSheet(wulf12);
		wulf13s = new SpriteSheet(wulf13);
		wulf14s = new SpriteSheet(wulf14);
		wulf15s = new SpriteSheet(wulf15);
		wulf16s = new SpriteSheet(wulf16);
		wulf17s = new SpriteSheet(wulf17);
		wulf18s = new SpriteSheet(wulf18);
		wulf19s = new SpriteSheet(wulf19);
		wulf20s = new SpriteSheet(wulf20);
		wulf21s = new SpriteSheet(wulf21);
		wulf22s = new SpriteSheet(wulf22);
		wulf23s = new SpriteSheet(wulf23);
		wulf24s = new SpriteSheet(wulf24);
		wulf25s = new SpriteSheet(wulf25);
		
		wulf0Ss = new SpriteSheet(wulf0S);
		wulf1Ss = new SpriteSheet(wulf1S);
		wulf2Ss = new SpriteSheet(wulf2S);
		wulf3Ss = new SpriteSheet(wulf3S);
		wulf4Ss = new SpriteSheet(wulf4S);
		wulf5Ss = new SpriteSheet(wulf5S);
		wulf6Ss = new SpriteSheet(wulf6S);
		wulf7Ss = new SpriteSheet(wulf7S);
		wulf8Ss = new SpriteSheet(wulf8S);
		wulf9Ss = new SpriteSheet(wulf9S);
		wulfASs = new SpriteSheet(wulfAS);
		wulfBSs = new SpriteSheet(wulfBS);
		wulfCSs = new SpriteSheet(wulfCS);
		wulfDSs = new SpriteSheet(wulfDS);
		wulfESs = new SpriteSheet(wulfES);
		wulfFSs = new SpriteSheet(wulfFS);
		wulfGSs = new SpriteSheet(wulfGS);
		wulfHSs = new SpriteSheet(wulfHS);
		wulfISs = new SpriteSheet(wulfIS);
		wulfJSs = new SpriteSheet(wulfJS);
		wulfKSs = new SpriteSheet(wulfKS);
		wulfLSs = new SpriteSheet(wulfLS);
		wulfMSs = new SpriteSheet(wulfMS);
		wulfNSs = new SpriteSheet(wulfNS);
		wulfOSs = new SpriteSheet(wulfOS);
		wulfPSs = new SpriteSheet(wulfPS);
		wulfQSs = new SpriteSheet(wulfQS);
		wulfRSs = new SpriteSheet(wulfRS);
		wulfSSs = new SpriteSheet(wulfSS);
		wulfTSs = new SpriteSheet(wulfTS);
		wulfUSs = new SpriteSheet(wulfUS);
		wulfVSs = new SpriteSheet(wulfVS);
		wulfWSs = new SpriteSheet(wulfWS);
		wulfXSs = new SpriteSheet(wulfXS);
		wulfYSs = new SpriteSheet(wulfYS);
		wulfZSs = new SpriteSheet(wulfZS);
		
		wulf0Us = new SpriteSheet(wulf0U);
		wulf1Us = new SpriteSheet(wulf1U);
		wulf2Us = new SpriteSheet(wulf2U);
		wulf3Us = new SpriteSheet(wulf3U);
		wulf4Us = new SpriteSheet(wulf4U);
		wulf5Us = new SpriteSheet(wulf5U);
		wulf6Us = new SpriteSheet(wulf6U);
		wulf7Us = new SpriteSheet(wulf7U);
		wulf8Us = new SpriteSheet(wulf8U);
		wulf9Us = new SpriteSheet(wulf9U);
		wulfAUs = new SpriteSheet(wulfAU);
		wulfBUs = new SpriteSheet(wulfBU);
		wulfCUs = new SpriteSheet(wulfCU);
		wulfDUs = new SpriteSheet(wulfDU);
		wulfEUs = new SpriteSheet(wulfEU);
		wulfFUs = new SpriteSheet(wulfFU);
		wulfGUs = new SpriteSheet(wulfGU);
		wulfHUs = new SpriteSheet(wulfHU);
		wulfIUs = new SpriteSheet(wulfIU);
		wulfJUs = new SpriteSheet(wulfJU);
		wulfKUs = new SpriteSheet(wulfKU);
		wulfLUs = new SpriteSheet(wulfLU);
		wulfMUs = new SpriteSheet(wulfMU);
		wulfNUs = new SpriteSheet(wulfNU);
		wulfOUs = new SpriteSheet(wulfOU);
		wulfPUs = new SpriteSheet(wulfPU);
		wulfQUs = new SpriteSheet(wulfQU);
		wulfRUs = new SpriteSheet(wulfRU);
		wulfSUs = new SpriteSheet(wulfSU);
		wulfTUs = new SpriteSheet(wulfTU);
		wulfUUs = new SpriteSheet(wulfUU);
		wulfVUs = new SpriteSheet(wulfVU);
		wulfWUs = new SpriteSheet(wulfWU);
		wulfXUs = new SpriteSheet(wulfXU);
		wulfYUs = new SpriteSheet(wulfYU);
		wulfZUs = new SpriteSheet(wulfZU);
		
		wulfcol1s = new SpriteSheet(wulfcol1);
		wulfcol2s = new SpriteSheet(wulfcol2);
		wulfcol3s = new SpriteSheet(wulfcol3);
		wulfcol4s = new SpriteSheet(wulfcol4);
		wulfcol5s = new SpriteSheet(wulfcol5);
		wulfcol6s = new SpriteSheet(wulfcol6);
		wulfcol7s = new SpriteSheet(wulfcol7);
		wulfcol8s = new SpriteSheet(wulfcol8);
		wulfcol9s = new SpriteSheet(wulfcol9);
		wulfcol10s = new SpriteSheet(wulfcol10);
		
		highscoreBGs = new SpriteSheet(highscoreBG);
		highscore1s = new SpriteSheet(highscore1);
		
		creditsBGs = new SpriteSheet(creditsBG);
		credits1s = new SpriteSheet(credits1);
		credits2s = new SpriteSheet(credits2);
		
		hsnumber0s = new SpriteSheet(hsnumber0);
		hsnumber1s = new SpriteSheet(hsnumber1);
		hsnumber2s = new SpriteSheet(hsnumber2);
		hsnumber3s = new SpriteSheet(hsnumber3);
		hsnumber4s = new SpriteSheet(hsnumber4);
		hsnumber5s = new SpriteSheet(hsnumber5);
		hsnumber6s = new SpriteSheet(hsnumber6);
		hsnumber7s = new SpriteSheet(hsnumber7);
		hsnumber8s = new SpriteSheet(hsnumber8);
		hsnumber9s = new SpriteSheet(hsnumber9);
		
		colorsBGs = new SpriteSheet(colorsBG);
		colors1s = new SpriteSheet(colors1);
		colors2s = new SpriteSheet(colors2);
		colors3s = new SpriteSheet(colors3);
		colors4s = new SpriteSheet(colors4);
		colors5s = new SpriteSheet(colors5);
		colors6s = new SpriteSheet(colors6);
		colors7s = new SpriteSheet(colors7);
		colors8s = new SpriteSheet(colors8);
		colors9s = new SpriteSheet(colors9);
		colors10s = new SpriteSheet(colors10);
		colors11s = new SpriteSheet(colors11);
		colors12s = new SpriteSheet(colors12);
		colors13s = new SpriteSheet(colors13);
		colors14s = new SpriteSheet(colors14);
		
		diffBGs = new SpriteSheet(diffBG);
		diff1s = new SpriteSheet(diff1);
		diff2s = new SpriteSheet(diff2);
		diff3s = new SpriteSheet(diff3);
		diff4s = new SpriteSheet(diff4);
		diff5s = new SpriteSheet(diff5);
		diff6s = new SpriteSheet(diff6);
		diff7s = new SpriteSheet(diff7);
		diff8s = new SpriteSheet(diff8);
		diff9s = new SpriteSheet(diff9);
		diff10s = new SpriteSheet(diff10);
		
		shapeBGs = new SpriteSheet(shapeBG);
		shape1s = new SpriteSheet(shape1);
		shape2s = new SpriteSheet(shape2);
		shape3s = new SpriteSheet(shape3);
		shape4s = new SpriteSheet(shape4);
		shape5s = new SpriteSheet(shape5);
		shape6s = new SpriteSheet(shape6);
		shape7s = new SpriteSheet(shape7);
		shape8s = new SpriteSheet(shape8);
		shape9s = new SpriteSheet(shape9);
		shape10s = new SpriteSheet(shape10);
		shape11s = new SpriteSheet(shape11);
		shape12s = new SpriteSheet(shape12);
		
		pauseBGs = new SpriteSheet(pauseBG);
		pause1s = new SpriteSheet(pause1);
		pause2s = new SpriteSheet(pause2);
		pause3s = new SpriteSheet(pause3);
		pause4s = new SpriteSheet(pause4);
		pause5s = new SpriteSheet(pause5);
		pause6s = new SpriteSheet(pause6);
		pause7s = new SpriteSheet(pause7);
		
		confirmBGs = new SpriteSheet(confirmBG);
		confirm1s = new SpriteSheet(confirm1);
		confirm2s = new SpriteSheet(confirm2);
		confirm3s = new SpriteSheet(confirm3);
		confirm4s = new SpriteSheet(confirm4);
		
		audioUnavailables = new SpriteSheet(audioUnavailable);
		
		getTextures();
	}
	
	public void createDirectories(BufferedImageLoader loader){
		if(!backgroundFolder.exists()){
			backgroundFolder.mkdirs();
		}
		
		listOfFiles = backgroundFolder.listFiles();
		
		if(listOfFiles.length == 0){
			background = loader.loadImage("/background.jpg");
			BufferedImage bi = background;
		    File outputfile = new File("C:\\ShapeFall\\images\\background\\default_background.jpg");
		    try {
				ImageIO.write(bi, "jpg", outputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    listOfFiles = backgroundFolder.listFiles();
		}
		
		if(listOfFiles.length > 1){
			if(!listOfFiles[0].getName().equals("default_background.jpg")){
				background = loader.loadImage(listOfFiles[0].toString(), true);
			}
			else{
				background = loader.loadImage(listOfFiles[1].toString(), true);
			}
		}
		else{
			background = loader.loadImage(listOfFiles[0].toString(), true);
		}
	}
	
	private void getTextures(){
		
		back[0] = backs.grabImage();//background
		back[1] = back2s.grabImage();//blackscreen
		
		number[0] = zeros.grabImage();//0
		number[1] = ones.grabImage();//1
		number[2] = twos.grabImage();//2
		number[3] = threes.grabImage();//3
		number[4] = fours.grabImage();//4
		number[5] = fives.grabImage();//5
		number[6] = sixs.grabImage();//6
		number[7] = sevens.grabImage();//7
		number[8] = eights.grabImage();//8
		number[9] = nines.grabImage();//9
		number[10] = emptys.grabImage();//empty
		
		sign[0] = pluss.grabImage();//+
		sign[1] = minuss.grabImage();//-
		sign[2] = minipluss.grabImage();//mini+
		sign[3] = miniminuss.grabImage();//mini-
		
		star[0] = star0s.grabImage();//star empty
		star[1] = star1s.grabImage();//star 1/4
		star[2] = star2s.grabImage();//star 1/2
		star[3] = star3s.grabImage();//star 3/4
		star[4] = star4s.grabImage();//star full
		
		heart[0] = heart0s.grabImage();//heart empty
		heart[1] = heart1s.grabImage();//heart full
		
		combo[0] = combo0s.grabImage();//combo empty
		combo[1] = combo1s.grabImage();//combo 1/4
		combo[2] = combo2s.grabImage();//combo 1/2
		combo[3] = combo3s.grabImage();//combo 3/4
		combo[4] = combo4s.grabImage();//combo full
		
		exp[0] = exp0s.grabImage();//exp
		exp[1] = exp1s.grabImage();//exp1
		
		mini[0] = mini1s.grabImage();//1
		mini[1] = mini2s.grabImage();//2
		mini[2] = mini3s.grabImage();//3
		mini[3] = mini4s.grabImage();//4
		mini[4] = mini5s.grabImage();//5
		
		main[0] = main1s.grabImage();//start
		main[1] = main2s.grabImage();//controls
		main[2] = main3s.grabImage();//settings
		main[3] = main4s.grabImage();//exit
		main[4] = main5s.grabImage();//yes
		main[5] = main6s.grabImage();//no
		main[6] = main7s.grabImage();//resume
		main[7] = main8s.grabImage();//newgame
		main[8] = main9s.grabImage();//mainmenu
		main[9] = main10s.grabImage();//difficulty
		main[10] = main11s.grabImage();//easy
		main[11] = main12s.grabImage();//medium
		main[12] = main13s.grabImage();//expert
		main[13] = main14s.grabImage();//cancel
		main[14] = main15s.grabImage();//gamesong
		main[15] = main16s.grabImage();//pokemon
		main[16] = main17s.grabImage();//ghostbusters
		main[17] = main18s.grabImage();//trololol
		main[18] = main19s.grabImage();//gm
		main[19] = main20s.grabImage();//audio
		main[20] = main21s.grabImage();//colors
		main[21] = main22s.grabImage();//shape
		main[22] = main23s.grabImage();//square
		main[23] = main24s.grabImage();//circle
		main[24] = main25s.grabImage();//arrow
		main[25] = main26s.grabImage();//sounds
		main[26] = main27s.grabImage();//music
		main[27] = main28s.grabImage();//save
		main[28] = main29s.grabImage();//default
		
		color[0] = colorAs.grabImage();//green
		color[1] = colorBs.grabImage();//red
		color[2] = color3s.grabImage();//yellow
		color[3] = color4s.grabImage();//blue
		color[4] = color5s.grabImage();//magenta
		color[5] = color6s.grabImage();//orange
		color[6] = color7s.grabImage();//cyan
		color[7] = color8s.grabImage();//pink
		
		control[0] = control1s.grabImage();//0
		control[1] = control2s.grabImage();//1
		control[2] = control3s.grabImage();//2
		control[3] = control4s.grabImage();//3
		control[4] = control5s.grabImage();//4
		control[5] = control6s.grabImage();//5
		control[6] = control7s.grabImage();//6
		control[7] = control8s.grabImage();//7
		control[8] = control9s.grabImage();//8
		control[9] = control10s.grabImage();//9
		control[10] = control11s.grabImage();//a
		control[11] = control12s.grabImage();//b
		control[12] = control13s.grabImage();//c
		control[13] = control14s.grabImage();//d
		control[14] = control15s.grabImage();//e
		control[15] = control16s.grabImage();//f
		control[16] = control17s.grabImage();//g
		control[17] = control18s.grabImage();//h
		control[18] = control19s.grabImage();//i
		control[19] = control20s.grabImage();//j
		control[20] = control21s.grabImage();//k
		control[21] = control22s.grabImage();//l
		control[22] = control23s.grabImage();//m
		control[23] = control24s.grabImage();//n
		control[24] = control25s.grabImage();//o
		control[25] = control26s.grabImage();//p
		control[26] = control27s.grabImage();//q
		control[27] = control28s.grabImage();//r
		control[28] = control29s.grabImage();//s
		control[29] = control30s.grabImage();//t
		control[30] = control31s.grabImage();//u
		control[31] = control32s.grabImage();//v
		control[32] = control33s.grabImage();//w
		control[33] = control34s.grabImage();//x
		control[34] = control35s.grabImage();//y
		control[35] = control36s.grabImage();//z
		
		furby[0] = furbyBGs.grabImage();//background
		furby[1] = furby1s.grabImage(1, 1, 400, 159);//exitS
		furby[2] = furby1s.grabImage(1, 2, 400, 159);//exitH
		furby[3] = furby1s.grabImage(1, 3, 400, 159);//exitU
		furby[4] = furby1s.grabImage(1, 4, 400, 159);//playS
		furby[5] = furby1s.grabImage(1, 5, 400, 159);//playH
		furby[6] = furby1s.grabImage(1, 6, 400, 159);//playU
		furby[7] = furby1s.grabImage(1, 7, 400, 159);//settingsS
		furby[8] = furby1s.grabImage(1, 8, 400, 159);//settingsH
		furby[9] = furby1s.grabImage(1, 9, 400, 159);//settingsU
		furby[10] = furby1s.grabImage(2, 1, 400, 64);//highscoresS
		furby[11] = furby1s.grabImage(2, 2, 400, 64);//highscoresU
		furby[12] = furby1s.grabImage(2, 3, 400, 64);//creditsS
		furby[13] = furby1s.grabImage(2, 4, 400, 64);//creditsU
	
		expert[0] = expert1s.grabImage();//background
		expert[1] = expert2s.grabImage();//arrow
		expert[2] = expert3s.grabImage();//audio selected
		expert[3] = expert4s.grabImage();//audio unselected
		expert[4] = expert5s.grabImage();//colors selected
		expert[5] = expert6s.grabImage();//colors unselected
		expert[6] = expert7s.grabImage();//controls selected
		expert[7] = expert8s.grabImage();//controls unselected
		expert[8] = expert9s.grabImage();//difficulty selected
		expert[9] = expert10s.grabImage();//difficulty unselected
		expert[10] = expert11s.grabImage();//main selected
		expert[11] = expert12s.grabImage();//main unselected
		expert[12] = expert13s.grabImage();//shape selected
		expert[13] = expert14s.grabImage();//shape unselected
		
		wulf[0] = wulf1s.grabImage();//background
		wulf[1] = wulf2s.grabImage();//arrow		
		wulf[2] = wulf3s.grabImage();//first color s
		wulf[3] = wulf4s.grabImage();//first color u
		wulf[4] = wulf5s.grabImage();//second color s
		wulf[5] = wulf6s.grabImage();//second color u
		wulf[6] = wulf7s.grabImage();//third color s
		wulf[7] = wulf8s.grabImage();//third color u
		wulf[8] = wulf9s.grabImage();//fourth color s
		wulf[9] = wulf10s.grabImage();//fourth color u
		wulf[10] = wulf11s.grabImage();//fifth color s
		wulf[11] = wulf12s.grabImage();//fifth color u
		wulf[12] = wulf13s.grabImage();//default s
		wulf[13] = wulf14s.grabImage();//default u
		wulf[14] = wulf15s.grabImage();//pause s
		wulf[15] = wulf16s.grabImage();//pause u
		wulf[16] = wulf17s.grabImage();//save s
		wulf[17] = wulf18s.grabImage();//save u
		wulf[18] = wulf19s.grabImage();//settings s
		wulf[19] = wulf20s.grabImage();//settings u
		wulf[20] = wulf21s.grabImage();//start s
		wulf[21] = wulf22s.grabImage();//start u
		wulf[22] = wulf23s.grabImage();//star s
		wulf[23] = wulf24s.grabImage();//star u
		wulf[24] = wulf25s.grabImage();//default no
		
		wulfkeys[0] = wulf0Ss.grabImage();//0S
		wulfkeys[1] = wulf1Ss.grabImage();//1S
		wulfkeys[2] = wulf2Ss.grabImage();//2S
		wulfkeys[3] = wulf3Ss.grabImage();//3S
		wulfkeys[4] = wulf4Ss.grabImage();//4S
		wulfkeys[5] = wulf5Ss.grabImage();//5S
		wulfkeys[6] = wulf6Ss.grabImage();//6S
		wulfkeys[7] = wulf7Ss.grabImage();//7S
		wulfkeys[8] = wulf8Ss.grabImage();//8S
		wulfkeys[9] = wulf9Ss.grabImage();//9S
		wulfkeys[10] = wulfASs.grabImage();//AS
		wulfkeys[11] = wulfBSs.grabImage();//BS
		wulfkeys[12] = wulfCSs.grabImage();//CS
		wulfkeys[13] = wulfDSs.grabImage();//DS
		wulfkeys[14] = wulfESs.grabImage();//ES
		wulfkeys[15] = wulfFSs.grabImage();//FS
		wulfkeys[16] = wulfGSs.grabImage();//GS
		wulfkeys[17] = wulfHSs.grabImage();//HS
		wulfkeys[18] = wulfISs.grabImage();//IS
		wulfkeys[19] = wulfJSs.grabImage();//JS
		wulfkeys[20] = wulfKSs.grabImage();//KS
		wulfkeys[21] = wulfLSs.grabImage();//LS
		wulfkeys[22] = wulfMSs.grabImage();//MS
		wulfkeys[23] = wulfNSs.grabImage();//NS
		wulfkeys[24] = wulfOSs.grabImage();//OS
		wulfkeys[25] = wulfPSs.grabImage();//PS
		wulfkeys[26] = wulfQSs.grabImage();//QS
		wulfkeys[27] = wulfRSs.grabImage();//RS
		wulfkeys[28] = wulfSSs.grabImage();//SS
		wulfkeys[29] = wulfTSs.grabImage();//TS
		wulfkeys[30] = wulfUSs.grabImage();//US
		wulfkeys[31] = wulfVSs.grabImage();//VS
		wulfkeys[32] = wulfWSs.grabImage();//WS
		wulfkeys[33] = wulfXSs.grabImage();//XS
		wulfkeys[34] = wulfYSs.grabImage();//YS
		wulfkeys[35] = wulfZSs.grabImage();//ZS
		
		wulfkeys[36] = wulf0Us.grabImage();//0U
		wulfkeys[37] = wulf1Us.grabImage();//1U
		wulfkeys[38] = wulf2Us.grabImage();//2U
		wulfkeys[39] = wulf3Us.grabImage();//3U
		wulfkeys[40] = wulf4Us.grabImage();//4U
		wulfkeys[41] = wulf5Us.grabImage();//5U
		wulfkeys[42] = wulf6Us.grabImage();//6U
		wulfkeys[43] = wulf7Us.grabImage();//7U
		wulfkeys[44] = wulf8Us.grabImage();//8U
		wulfkeys[45] = wulf9Us.grabImage();//9U
		wulfkeys[46] = wulfAUs.grabImage();//AU
		wulfkeys[47] = wulfBUs.grabImage();//BU
		wulfkeys[48] = wulfCUs.grabImage();//CU
		wulfkeys[49] = wulfDUs.grabImage();//DU
		wulfkeys[50] = wulfEUs.grabImage();//EU
		wulfkeys[51] = wulfFUs.grabImage();//FU
		wulfkeys[52] = wulfGUs.grabImage();//GU
		wulfkeys[53] = wulfHUs.grabImage();//HU
		wulfkeys[54] = wulfIUs.grabImage();//IU
		wulfkeys[55] = wulfJUs.grabImage();//JU
		wulfkeys[56] = wulfKUs.grabImage();//KU
		wulfkeys[57] = wulfLUs.grabImage();//LU
		wulfkeys[58] = wulfMUs.grabImage();//MU
		wulfkeys[59] = wulfNUs.grabImage();//NU
		wulfkeys[60] = wulfOUs.grabImage();//OU
		wulfkeys[61] = wulfPUs.grabImage();//PU
		wulfkeys[62] = wulfQUs.grabImage();//QU
		wulfkeys[63] = wulfRUs.grabImage();//RU
		wulfkeys[64] = wulfSUs.grabImage();//SU
		wulfkeys[65] = wulfTUs.grabImage();//TU
		wulfkeys[66] = wulfUUs.grabImage();//UU
		wulfkeys[67] = wulfVUs.grabImage();//VU
		wulfkeys[68] = wulfWUs.grabImage();//WU
		wulfkeys[69] = wulfXUs.grabImage();//XU
		wulfkeys[70] = wulfYUs.grabImage();//YU
		wulfkeys[71] = wulfZUs.grabImage();//ZU
		
		wulfcolor[0] = wulfcol1s.grabImage();//green
		wulfcolor[1] = wulfcol2s.grabImage();//red
		wulfcolor[2] = wulfcol3s.grabImage();//yellow
		wulfcolor[3] = wulfcol4s.grabImage();//blue
		wulfcolor[4] = wulfcol5s.grabImage();//magenta
		wulfcolor[5] = wulfcol6s.grabImage();//orange
		wulfcolor[6] = wulfcol7s.grabImage();//cyan
		wulfcolor[7] = wulfcol8s.grabImage();//pink
		wulfcolor[8] = wulfcol9s.grabImage();//purple
		wulfcolor[9] = wulfcol10s.grabImage();//teal
		
		highscore[0] = highscoreBGs.grabImage();//background
		highscore[1] = highscore1s.grabImage();//arrow
		
		credits[0] = creditsBGs.grabImage();//background
		credits[1] = credits1s.grabImage();//arrow
		credits[2] = credits2s.grabImage();//mainmenu
		
		hsnumber[0] = hsnumber0s.grabImage();//0
		hsnumber[1] = hsnumber1s.grabImage();//1
		hsnumber[2] = hsnumber2s.grabImage();//2
		hsnumber[3] = hsnumber3s.grabImage();//3
		hsnumber[4] = hsnumber4s.grabImage();//4
		hsnumber[5] = hsnumber5s.grabImage();//5
		hsnumber[6] = hsnumber6s.grabImage();//6
		hsnumber[7] = hsnumber7s.grabImage();//7
		hsnumber[8] = hsnumber8s.grabImage();//8
		hsnumber[9] = hsnumber9s.grabImage();//9
		
		colors[0] = colorsBGs.grabImage();//background
		colors[1] = colors1s.grabImage();//first color s
		colors[2] = colors2s.grabImage();//first color u
		colors[3] = colors3s.grabImage();//second color s
		colors[4] = colors4s.grabImage();//second color u
		colors[5] = colors5s.grabImage();//third color s
		colors[6] = colors6s.grabImage();//third color u
		colors[7] = colors7s.grabImage();//fourth color s
		colors[8] = colors8s.grabImage();//fourth color u
		colors[9] = colors9s.grabImage();//fifth color s
		colors[10] = colors10s.grabImage();//fifth color u
		colors[11] = colors11s.grabImage();//arrow
		colors[12] = colors12s.grabImage();//settings s
		colors[13] = colors13s.grabImage();//settings u
		colors[14] = colors14s.grabImage();//gray square
		
		difficulty[0] = diffBGs.grabImage();//background
		difficulty[1] = diff1s.grabImage();//easy s
		difficulty[2] = diff2s.grabImage();//easy u
		difficulty[3] = diff3s.grabImage();//medium s
		difficulty[4] = diff4s.grabImage();//medium u
		difficulty[5] = diff5s.grabImage();//expert s
		difficulty[6] = diff6s.grabImage();//expert u
		difficulty[7] = diff7s.grabImage();//settings s
		difficulty[8] = diff8s.grabImage();//settings u
		difficulty[9] = diff9s.grabImage();//current
		difficulty[10] = diff10s.grabImage();//arrow
		
		shape[0] = shapeBGs.grabImage();//background
		shape[1] = shape1s.grabImage();//text square s
		shape[2] = shape2s.grabImage();//text square u
		shape[3] = shape3s.grabImage();//text circle s
		shape[4] = shape4s.grabImage();//text circle u
		shape[5] = shape5s.grabImage();//settings s
		shape[6] = shape6s.grabImage();//settings u
		shape[7] = shape7s.grabImage();//square s
		shape[8] = shape8s.grabImage();//square u
		shape[9] = shape9s.grabImage();//circle s
		shape[10] = shape10s.grabImage();//circle u
		shape[11] = shape11s.grabImage();//current
		shape[12] = shape12s.grabImage();//arrow
		
		pause[0] = pauseBGs.grabImage();//background
		pause[1] = pause1s.grabImage();//continue s
		pause[2] = pause2s.grabImage();//continue u
		pause[3] = pause3s.grabImage();//retry s
		pause[4] = pause4s.grabImage();//retry s
		pause[5] = pause5s.grabImage();//exit s
		pause[6] = pause6s.grabImage();//exit s
		pause[7] = pause7s.grabImage();//arrow
		
		confirm[0] = confirmBGs.grabImage();//background
		confirm[1] = confirm1s.grabImage();//return s
		confirm[2] = confirm2s.grabImage();//return u
		confirm[3] = confirm3s.grabImage();//exit s
		confirm[4] = confirm4s.grabImage();//exit u
		
		expert[14] = audioUnavailables.grabImage();//audio unavailable
		
	}
}
