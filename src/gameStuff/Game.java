package gameStuff;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import worldStuff.World;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static int width = 323;
	public static int height = width / 17 * 12;
	public static int scale = 3;
	public static int sLines = 60;
	public static int lineSpacing = 10;
	public static double ups = 100.0; // Desired updates per second.
	public static int menuContext = 0;
	public static String title = "The Days of Daniel";
	
	private String[] stringOutput = new String[sLines];
	private String[] stringOutputB = new String[sLines];
	private String[] stringOutputC = new String[sLines];

	private Thread thread;
	private JFrame frame;
	private Keyboard keys;
	private boolean running = false;
	public boolean resetFont = false;
	public boolean sB = false, sC = false;
	
	public BufferStrategy bs;
	public Font fo = new Font("Courier", Font.PLAIN, 17);
	
	private World wld;
		
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		frame = new JFrame();
		keys = new Keyboard();
		addKeyListener(keys);
	}
	
	public static void main(String[] args) {
		Game game = new Game();

		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setIgnoreRepaint(true);
		game.frame.setVisible(true);
	
		game.start();
		game.requestFocus();
	}
	
	public synchronized void start() {
		clearText();
		newGameView();
		running = true;
		thread = new Thread(this, "Main");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		
		bs = getBufferStrategy();
		if (getBufferStrategy() == null) {
			createBufferStrategy(2);
			bs = getBufferStrategy();
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setFont(fo);
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		long now;
		final double ns = 1000000000.0 / ups;
		double delta = 0.0;
		int frames = 0;
		int updates = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			if (resetFont) {
				g.setFont(fo);
				resetFont = false;
			}
			
			render(g, stringOutput, stringOutputB, stringOutputC);
			bs.show();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " UPS  |  " + frames + " FPS");
				updates = 0;
				frames = 0;
			}
			
		}
		stop();
	}
	
	public void update() {
		keys.update();
		if (keys.up) pressedUP(); if (keys.down) pressedDown(); 
		if (keys.left) pressedLeft(); if (keys.right) pressedRight();	
		if (keys.n) pressedN();	if (keys.s) pressedS(); 
		if (keys.g) pressedG(); if (keys.l) pressedL(); 
		if (keys.w) pressedW(); if (keys.e) pressedE();
		if (keys.space) pressedSpace();	if (keys.enter) pressedEnter(); 
		if (keys.esc) pressedEsc(); if (keys.one) pressedOne();
		if (keys.two) pressedTwo(); if (keys.three) pressedThree();
		if (keys.four) pressedFour(); if (keys.five) pressedFive();
		if (keys.six) pressedSix(); if (keys.seven) pressedSeven();
		if (keys.eight) pressedEight(); if (keys.nine) pressedNine();
	}
	
	public void render(Graphics2D g, String[] strings, String[] stringsB, String[] stringsC) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width * scale, height * scale);
		g.setColor(Color.ORANGE);
		for (int i = 0; i < strings.length; i++) {
			g.drawString(strings[i], 15, 30 + ((i * lineSpacing) * 2));
		}		
		if (sB) {
			g.setColor(Color.GRAY);
			for (int i = 0; i < stringsB.length; i++) {
				g.drawString(stringsB[i], 15, 30 + ((i * lineSpacing) * 2));
			}
		}		
		if (sC) {
			g.setColor(Color.WHITE);
			for (int i = 0; i < stringsB.length; i++) {
				g.drawString(stringsC[i], 15, 30 + ((i * lineSpacing) * 2));
			}
		}
	}
	
	// menu contexts...
	// 0 = start screen, 1 = base view, 2 = statistics, 3 = travel, 4 = wait, 5 = Explore...
	
	public void pressedUP() {
		switch (menuContext) {

		case 1: 
			break;
			
		case 2:

			break;
			
		case 5:
			wld.characterNorth(wld.player);
			exploreView();

		default:
			
		}
	}
	
	public void pressedDown() {
		switch (menuContext) {

		case 1: 
			break;
			
		case 2:

			break;
			
		case 5:
			wld.characterSouth(wld.player);
			exploreView();

		default:
			
		}
	}
	
	public void pressedLeft() {
		switch (menuContext) {

		case 1: 
			break;
			
		case 2:

			break;
			
		case 4:
			wld.time.minusWD();
			waitView();
			break;
			
		case 5:
			wld.characterWest(wld.player);
			exploreView();

		default:
			
		}
	}
	
	public void pressedRight() {
		switch (menuContext) {

		case 1: 
			break;
			
		case 2:

			break;
			
		case 4:
			wld.time.plusWD();
			waitView();
			break;
			
		case 5:
			wld.characterEast(wld.player);
			exploreView();

		default:
			
		}
	}
	
	public void pressedN() {

		switch (menuContext) {

		case 0: // Start Screen...
			lineSpacing = 10;
			fo = new Font("Courier New", Font.PLAIN, 19);
			lineSpacing = 10;
			resetFont = true;
			wld = new World();
			baseView();
			menuContext = 1;
			break;
		
		case 1: 
			break;
			
		case 2:

			break;

		default:
			;
		}
	}
	
	public void pressedE() {
		switch (menuContext) {

		case 1:
			exploreView();
			menuContext = 5;
			break;
			
		case 2:

			break;

		default:
			
		}
	}
	
	public void pressedS() {
		switch (menuContext) {

		case 1:
			clearText();
			statsView();
			menuContext = 2;
			break;
			
		case 2:

			break;

		default:
			
		}
	}
	
	public void pressedG() {
		switch (menuContext) {

		case 1: 
			baseView();
			travelView();
			menuContext = 3;
			break;
			
		case 2:

			break;

		default:
			
		}
	}
	
	public void pressedW() {
		switch (menuContext) {

		case 1: 
			baseView();
			waitView();
			menuContext = 4;
			break;
			
		case 2:

			break;

		default:
			
		}
	}
	
	public void pressedL() {
		switch (menuContext) {
		
		case 1:
			for (int i = 0; i < wld.worldCells[wld.getCurrentCell()].getDescription().length; i++) {
				stringOutput[5 + i] = wld.worldCells[wld.getCurrentCell()].getDescription()[i];
			}
			String[] folks = new String[] {"", "", "", "", "", "", "", "", ""}; 
			int fks = 0;
			// Will have to update all this when there are more possible people.
			for (int f = 0; f < wld.randos.length; f++) {
				folks[f] = "";
				if (wld.randos[f].getInCell() == wld.getCurrentCell()) { 
					folks[fks] = wld.randos[f].getName(); fks++; }
			}
			if (folks[0] != "") {
				stringOutput[10] = "People here:";
				stringOutput[12] = folks[0] + "   " + folks[1] + "   " + folks[2];
				stringOutput[13] = folks[3] + "   " + folks[4] + "   " + folks[5];
				
			}
			 
			break;
			
		default:
		
		}
	}
	
	public void pressedEnter() {

		switch (menuContext) {

		case 1: 
			break;
			
		case 2:
			baseView();
			menuContext = 1;
			break;
			
		case 3:
			baseView();
			menuContext = 1;
			break;

		case 4:
			wld.addNeedsByMinutes(wld.time.wait);
			wld.time.addMinutes(wld.time.wait);
			wld.time.resetWait();
			wld.spawnRandos();
			baseView();
			menuContext = 1;
			break;
			
		default:
			
		}
	}
	
	public void pressedEsc() {

		switch (menuContext) {

		case 0:
			// Do nothing...
			break;

		default:
			sB = false; sC = false;
			baseView();
			menuContext = 1;	
			break;
		}
	}
	
	public void pressedSpace() {

		switch (menuContext) {

		case 1: 
			break;
			
		case 2:

			break;

		default:
			
		}
	}
	
	public void pressedOne() {
		switch (menuContext) {
		
		case 3:
			tryToTravel(1);
			break;

		default:
			
		}
	}
	
	public void pressedTwo() {
		switch (menuContext) {

		case 3:
			tryToTravel(2);
			break;

		default:
			
		}
	}
	
	public void pressedThree() {
		switch (menuContext) {

		case 3:
			tryToTravel(3);
			break;

		default:
			
		}
	}
	
	public void pressedFour() {
		switch (menuContext) {

		case 3:
			tryToTravel(4);
			break;

		default:
			
		}
	}
	
	public void pressedFive() {
		switch (menuContext) {

		case 3:
			tryToTravel(5);
			break;

		default:
			
		}
	}
	
	public void pressedSix() {
		switch (menuContext) {

		case 3:
			tryToTravel(6);
			break;

		default:
			
		}
	}
	
	public void pressedSeven() {
		switch (menuContext) {
	
		case 3:
			tryToTravel(7);
			break;

		default:
			
		}
	}
	
	public void pressedEight() {
		switch (menuContext) {
	
		case 3:
			tryToTravel(8);
			break;

		default:
			
		}
	}
	
	public void pressedNine() {
		switch (menuContext) {
	
		case 3:
			tryToTravel(9);
			break;

		default:
			
		}
	}
	
	public void newGameView() {
		fo = new Font("Courier", Font.PLAIN, 10);
		resetFont = true;
		lineSpacing = 6;
		stringOutput[0] = " /######## /##                       /#######                                                 /######        /#######                      /##           /##";
		stringOutput[1] = "|__  ##__/| ##                      | ##__  ##                                               /##__  ##      | ##__  ##                    |__/          | ##";
		stringOutput[2] = "   | ##   | #######   /######       | ##  \\ ##  /######  /##   /##  /#######        /###### | ##  \\__/      | ##  \\ ##  /######  /#######  /##  /###### | ##";
		stringOutput[3] = "   | ##   | ##__  ## /##__  ##      | ##  | ## |____  ##| ##  | ## /##_____/       /##__  ##| ####          | ##  | ## |____  ##| ##__  ##| ## /##__  ##| ##";
		stringOutput[4] = "   | ##   | ##  \\ ##| ########      | ##  | ##  /#######| ##  | ##|  ######       | ##  \\ ##| ##_/          | ##  | ##  /#######| ##  \\ ##| ##| ########| ##";
		stringOutput[5] = "   | ##   | ##  | ##| ##_____/      | ##  | ## /##__  ##| ##  | ## \\____  ##      | ##  | ##| ##            | ##  | ## /##__  ##| ##  | ##| ##| ##_____/| ##";
		stringOutput[6] = "   | ##   | ##  | ##|  #######      | #######/|  #######|  ####### /#######/      |  ######/| ##            | #######/|  #######| ##  | ##| ##|  #######| ##";
		stringOutput[7] = "   |__/   |__/  |__/ \\_______/      |_______/  \\_______/ \\____  ##|_______/        \\______/ |__/            |_______/  \\_______/|__/  |__/|__/ \\_______/|__/";
		stringOutput[8] = "                                                         /##  | ##   ";
		stringOutput[9] = "                                                        |  ######/";
		stringOutput[10] = "                                                         \\______/";
		stringOutput[15] = "                                                         __           __  ___     __  __  __                 ______        __";
		stringOutput[16] = "                         ___ _   ___ ____ ___ _  ___    / /  __ __   /  |/  /__ _/ /_/ /_/ /  ___ _    __   / __/ /  __ __/ /____ ";
		stringOutput[17] = "                        / _ `/  / _ `/ _ `/  ' \\/ -_)  / _ \\/ // /  / /|_/ / _ `/ __/ __/ _ \\/ -_) |/|/ /  _\\ \\/ _ \\/ // / __/ -_)";
		stringOutput[18] = "                        \\_,_/   \\_, /\\_,_/_/_/_/\\__/  /_.__/\\_, /  /_/  /_/\\_,_/\\__/\\__/_//_/\\__/|__,__/  /___/_//_/\\_,_/\\__/\\__/ ";
		stringOutput[19] = "                               /___/                       /___/ ";
		
		stringOutput[48] = "                                     _  __          ___  __ ";
		stringOutput[49] = "                                    / |/ /  ____   / _ \\/ /__ ___ __   ___ _   ___  ___ _    __   ___ ____ ___ _  ___ ";
		stringOutput[50] = "                                   /    /  /___/  / ___/ / _ `/ // /  / _ `/  / _ \\/ -_) |/|/ /  / _ `/ _ `/  ' \\/ -_)";
		stringOutput[51] = "                                  /_/|_/         /_/  /_/\\_,_/\\_, /   \\_,_/  /_//_/\\__/|__,__/   \\_, /\\_,_/_/_/_/\\__/";
		stringOutput[52] = "                                                             /___/                              /___/   ";
	}
	
	public void baseView() {
		clearText();
		stringOutput[0] = wld.time.getTimeAsString();
		stringOutput[1] = "Location: " + wld.getLocationAsString();
		stringOutput[32] = "[L]ook | [E]xplore | [D]o | [G]o | [W]ait | [I]nventory | [S]tats";
	}
	
	public void travelView() {
		stringOutput [5] = "Where do you want to go?";
		for (int i = 0; i < wld.getCurrentExitNodes().length; i++) {
			stringOutput [i + 7] = "" + (i + 1) + ": " + wld.worldCells[wld.getCurrentExitNodes()[i]].name;
		}
		stringOutput[32] = "ESC or Enter - Go back";
	}
	
	public void waitView() {
		stringOutput[5] = "Wait how long?";
		stringOutput[7] = "< " + wld.time.wait + " > minutes";
		stringOutput[32] = "ESC or Enter - Go back";
	}
	
	public void exploreView() {
		baseView();
		sB = true; sC = true;
		for (int i = 0; i < wld.worldCells[wld.getCurrentCell()].getLayoutS().length; i++) {
			stringOutputB[5 + i] = wld.worldCells[wld.getCurrentCell()].getLayoutS()[i];
		}
		for (int x = 0; x < wld.player.getX(); x++) {
			stringOutputC[wld.player.getY() + 5] += " "; 
		}
		stringOutputC[wld.player.getY() + 5] += "@";
		stringOutput[32] = "X = " + wld.player.getX() + " | Y = " + wld.player.getY();
	}
	
	public void statsView() {
		stringOutput[0] = "" + wld.player.getName() + ", a " + wld.player.getAge() + " year old " + wld.player.getSexAsString() + ".";
		stringOutput[2] = "Strength:   " + wld.player.getStrength();
		stringOutput[3] = "Agility:    " + wld.player.getAgility();
		stringOutput[4] = "Intellect:  " + wld.player.getIntellect();
		stringOutput[5] = "Charisma:   " + wld.player.getCharisma();
		stringOutput[7] = "Hunger:     " + wld.player.getHunger();
		stringOutput[8] = "Thirst:     " + wld.player.getThirst();
		stringOutput[9] = "Tiredness:  " + wld.player.getTiredness();
		stringOutput[10] = "Stress:     " + wld.player.getStress();	
		stringOutput[11] = "Toilet 1:   " + wld.player.getPee();
		stringOutput[12] = "Toilet 2:   " + wld.player.getPoo();
		stringOutput[14] = "Health:     " + wld.player.getHealth();
		stringOutput[16] = "< >";		
		stringOutput[32] = "ESC or Enter - Go back";
	}
	
	public void tryToTravel(int cell) {
		if (wld.getCurrentExitNodes().length >= cell) {
			wld.gotoCell(wld.getCurrentCell(), wld.getCurrentExitNodes()[cell - 1]);
			menuContext = 1;
			baseView();
		} else {
			return;
		}
	}
	
	public void clearText() {
		for (int i = 0; i < stringOutput.length; i++) {
			stringOutput[i] = ""; stringOutputB[i] = ""; stringOutputC[i] = "";
		}
	}
	
}
