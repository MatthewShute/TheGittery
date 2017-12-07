package worldStuff;

import java.util.Random;

public class Layout {

	public int height = 5, width = 13;
	public char[][] charLayout;
	public String[] stringLayout;
	private Random rnd = new Random();
		
	public String[] makeLayout() {
		return stringLayout;
	}
	
	public String[] makeGenericLayout(boolean isInterior, int[] exits, int minHeight) {
		if (isInterior) {
			int r = rnd.nextInt(3);
			if (r == 0) { 
				height = rnd.nextInt(6) + minHeight; width = 8;
				stringLayout = new String[height];
				charLayout = new char[height][width];
				stringLayout[0] = "########";
				for (int i = 1; i < height; i++) { stringLayout[i] = "#      #"; }
				stringLayout[height - 1] = "########";
				stringLayout[rnd.nextInt(height - 2) + 1] = "|      #";
				if (exits.length > 1) { stringLayout[rnd.nextInt(height - 2) + 2] = "#      |"; }
				if (exits.length > 2) { stringLayout[height - 1] = "###_####"; }
				if (exits.length > 3) { stringLayout[0] = "####¯###"; }
				formatLayout();
			} if (r == 1) {
				height = rnd.nextInt(5) + minHeight; width = 10;
				stringLayout = new String[height];
				charLayout = new char[height][width];
				stringLayout[0] = "##########";
				for (int i = 1; i < height; i++) { stringLayout[i] = "#        #"; }
				stringLayout[height - 1] = "##########";
				stringLayout[rnd.nextInt(height - 2) + 1] = "|        #";
				if (exits.length > 1) { stringLayout[rnd.nextInt(height - 2) + 2] = "#        |"; }
				if (exits.length > 2) { stringLayout[height - 1] = "#####_####"; }
				if (exits.length > 3) { stringLayout[0] = "####¯#####"; }
				formatLayout();
			} if (r == 2) {
				height = rnd.nextInt(8) + minHeight; width = 6;
				stringLayout = new String[height];
				charLayout = new char[height][width];
				stringLayout[0] = "######";
				for (int i = 1; i < height; i++) { stringLayout[i] = "#    #"; }
				stringLayout[height - 1] = "######";
				stringLayout[rnd.nextInt(height - 2) + 1] = "|    #";
				if (exits.length > 1) { stringLayout[rnd.nextInt(height - 2) + 2] = "#    |"; }
				if (exits.length > 2) { stringLayout[height - 1] = "###_##"; }
				if (exits.length > 3) { stringLayout[0] = "##¯###"; }
				formatLayout(); }
		} else {
			int r = rnd.nextInt(2);
			if (r == 0) {
			height = rnd.nextInt(18) + minHeight; width = 10;
			stringLayout = new String[height];
			charLayout = new char[height][width];
			stringLayout[0] = "#........#";
			for (int i = 1; i < height; i++) { stringLayout[i] = "#..    ..#"; }
			stringLayout[height - 1] = "#........#";
			formatLayout(); } else {
				height = 8; width = 20;
				stringLayout = new String[height];
				charLayout = new char[height][width];
				stringLayout[0] = "####################";
				stringLayout[1] = "....................";
				stringLayout[2] = "....................";
				stringLayout[3] = ".                  .";
				stringLayout[4] = ".                  .";
				stringLayout[5] = "....................";
				stringLayout[6] = "....................";
				stringLayout[7] = "####################";
				formatLayout();
			}
		}
		return stringLayout;
	}
	
	public void formatLayout() {
		char[] line = new char[width];
		String fLine = "";
		for (int h = 0; h < height; h++) {
			line = stringLayout[h].toCharArray();
			for (int w = 0; w < width; w++) {
				if (line[w] == '#') line[w] = "\u2588".toCharArray()[0];
				charLayout[h][w] = line[w];		
			}
			for (int l = 0; l < line.length; l++) { fLine += String.valueOf(line[l]); }			
			stringLayout[h] = fLine; fLine = "";
		}
	}
	
	public char[][] getLayoutC(String[] s, int wid) {
		char[] line = new char[wid];
		int hig = s.length;
		char[][] c = new char[hig][wid];
		for (int h = 0; h < hig; h++) {
			line = s[h].toCharArray();
			for (int w = 0; w < wid; w++) {
				c[h][w] = line[w];		
			}
		}
		return c;
	}
	
}
