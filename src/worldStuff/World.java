package worldStuff;

import java.util.Random;
import characterStuff.GameCharacter;

public class World {
	
	public Time time;
	public WorldCell[] worldCells;
	public int worldSize = 600, startingCells = 40, n = 0;
	public int travelTimes[][];
	public GameCharacter player;
	public GameCharacter[] randos = new GameCharacter[4];
	Random rnd = new Random();
	
	public World() {
		// Default constructor...
		time = new Time();

		worldCells = new WorldCell[worldSize];
		for (int i = 0; i < worldCells.length; i++) {
			worldCells[i] = new WorldCell(i, "", true, new int[] {1});
		}
		
		travelTimes = new int[worldCells.length][worldSize];
		
		worldCells[0] = new WorldCell(n++, "Home - Your Bedroom", true, new int[] {1});
		worldCells[1] = new WorldCell(n++, "Home - Upstairs Landing", true, new int[] {0, 2, 12, 3});
		worldCells[2] = new WorldCell(n++, "Home - Mom's & Dad's Room", true, new int[] {1});
		worldCells[3] = new WorldCell(n++, "Home - Hallway", true, new int[] {1, 4, 5, 7});
		worldCells[4] = new WorldCell(n++, "Home - Living Room", true, new int[] {3});
		worldCells[5] = new WorldCell(n++, "Home - Kitchen", true, new int[] {3, 6});
		worldCells[6] = new WorldCell(n++, "Home - Back Garden", false, new int[] {5, 13});
		worldCells[7] = new WorldCell(n++, "Knavestride Road", false, new int[] {3, 8, 9, 37, 38});
		worldCells[8] = new WorldCell(n++, "Dryad Hill", false, new int[] {7, 10});
		worldCells[9] = new WorldCell(n++, "Knightsbloom Road", false, new int[] {7, 8});
		worldCells[10] = new WorldCell(n++, "Goodyear Road", false, new int[] {8, 11, 28});
		worldCells[11] = new WorldCell(n++, "School Gates", false, new int[] {10, 14});
		worldCells[12] = new WorldCell(n++, "Home - Bathroom", true, new int[] {1});
		worldCells[13] = new WorldCell(n++, "Home - Garden Shed", true, new int[] {6});
		worldCells[14] = new WorldCell(n++, "Schoolyard", false, new int[] {11, 15, 25});
		worldCells[15] = new WorldCell(n++, "School - Front entrance", true, new int[] {14, 16, 19, 20});	
		worldCells[16] = new WorldCell(n++, "School - Toilets", true, new int[] {15, 17, 18});			
		worldCells[17] = new WorldCell(n++, "School - Boys toilets", true, new int[] {16});
		worldCells[18] = new WorldCell(n++, "School - Girls toilets", true, new int[] {16});
		worldCells[19] = new WorldCell(n++, "School - Cloakroom", true, new int[] {15});
		worldCells[20] = new WorldCell(n++, "School - Corridor A", true, new int[] {15, 21, 23, 343, 344, 345, 349});
		worldCells[21] = new WorldCell(n++, "School - Corridor B", true, new int[] {20, 22, 341, 350, 351, 352});
		worldCells[22] = new WorldCell(n++, "School - Corridor C", true, new int[] {21, 24, 25, 353, 348});
		worldCells[23] = new WorldCell(n++, "School - Assembly Hall", true, new int[] {20});
		worldCells[24] = new WorldCell(n++, "School - Dining Hall", true, new int[] {22});
		worldCells[25] = new WorldCell(n++, "School - Sports Field", false, new int[] {22, 14, 26, 27, 39});
		worldCells[26] = new WorldCell(n++, "School - PE: Boys Changing Rooms", true, new int[] {25});
		worldCells[27] = new WorldCell(n++, "School - PE: Girls Chaning Rooms", true, new int[] {25});
		worldCells[28] = new WorldCell(n++, "Birchthorn Road", false, new int[] {10, 29});
		worldCells[29] = new WorldCell(n++, "Birchthorn Park", false, new int[] {28, 30, 31, 34});
		worldCells[30] = new WorldCell(n++, "Birchthorn Lake", false, new int[] {29, 35});
		worldCells[31] = new WorldCell(n++, "Birchthorn Park Toilets", false, new int[] {29, 32, 33});
		worldCells[32] = new WorldCell(n++, "Birchthorn Toilet (Male)", true, new int[] {31});
		worldCells[33] = new WorldCell(n++, "Birchthorn Toilet (Female)", true, new int[] {31});
		worldCells[34] = new WorldCell(n++, "Birchthorn Park Play Area", false, new int[] {29});	
		worldCells[35] = new WorldCell(n++, "Canals", false, new int[] {30, 36});
		worldCells[36] = new WorldCell(n++, "Canals (Road Underpass)", false, new int[] {35, 37});
		worldCells[37] = new WorldCell(n++, "Knavestride Road (Lower)", false, new int[] {36, 7, 246});
		worldCells[38] = new WorldCell(n++, "Knavestride Road (Upper)", false, new int[] {7, 243});
		worldCells[39] = new WorldCell(n++, "Quarry", false, new int[] {25, 40});

		for (int i = startingCells; i < (startingCells + 200); i++) {
				worldCells[i] = new WorldCell(i, "Nameless Street " + i, false, workOutGenericExits(i)); n++;
				// TODO: generate names.
		}
		
		// TODO: finish these.
		worldCells[240] = new WorldCell(n++, "Electronics Store", true, new int[] {173});
		worldCells[241] = new WorldCell(n++, "Wadeley Way", false, new int[] {173});	
		worldCells[242] = new WorldCell(n++, "Chelmsley Park", false, new int[] {174});
		worldCells[243] = new WorldCell(n++, "Hazel Lane", false, new int[] {175, 244, 38});
		worldCells[244] = new WorldCell(n++, "Hazel Common", false, new int[] {175, 243});
		worldCells[245] = new WorldCell(n++, "The Green Man", true, new int[] {176});
		worldCells[246] = new WorldCell(n++, "Moleford Junction", false, new int[] {37, 177, 247});
		worldCells[247] = new WorldCell(n++, "Car Park", false, new int[] {246});
		worldCells[248] = new WorldCell(n++, "Commercial District", false, new int[] {178});
		worldCells[249] = new WorldCell(n++, "Lower Doddington", false, new int[] {250, 179});
		worldCells[250] = new WorldCell(n++, "Upper Doddington", false, new int[] {249, 179});
		worldCells[251] = new WorldCell(n++, "Elder Gardens", false, new int[] {180});
		worldCells[252] = new WorldCell(n++, "Glowerthorn Gardens", false, new int[] {181});
		worldCells[253] = new WorldCell(n++, "Gascoigne Gardens", false, new int[] {181});
		worldCells[254] = new WorldCell(n++, "Catskil Road", false, new int[] {182});
		worldCells[255] = new WorldCell(n++, "Corner Shop", true, new int[] {183});
		worldCells[256] = new WorldCell(n++, "Paul's Pies", true, new int[] {183});
		worldCells[257] = new WorldCell(n++, "Skate Park", false, new int[] {184});
		worldCells[258] = new WorldCell(n++, "Aqueduct: North", false, new int[] {185});
		worldCells[259] = new WorldCell(n++, "Aqueduct: South", false, new int[] {185});
		worldCells[260] = new WorldCell(n++, "Dentists", true, new int[] {186});
		worldCells[261] = new WorldCell(n++, "Fangorn Tavern", true, new int[] {187});
		worldCells[262] = new WorldCell(n++, "Burchill Way", false, new int[] {187});
		worldCells[263] = new WorldCell(n++, "Lazer Quest", true, new int[] {188});
		worldCells[264] = new WorldCell(n++, "Gretchen's Olde Booke Emporium", true, new int[] {189});
		worldCells[265] = new WorldCell(n++, "Simon's Seedy Magazines", true, new int[] {189});
		worldCells[266] = new WorldCell(n++, "Sandy Lane", false, new int[] {190});
		worldCells[267] = new WorldCell(n++, "Beech Road", false, new int[] {191});
		worldCells[268] = new WorldCell(n++, "Thomson Terrace", false, new int[] {191});
		worldCells[269] = new WorldCell(n++, "Burnsawl's Candles", true, new int[] {192});
		worldCells[270] = new WorldCell(n++, "Perry Place", false, new int[] {193});
		worldCells[271] = new WorldCell(n++, "McGee Gardens", false, new int[] {193});
		worldCells[272] = new WorldCell(n++, "Station Road", false, new int[] {194});
		worldCells[273] = new WorldCell(n++, "Rackham Row", false, new int[] {195});
		worldCells[274] = new WorldCell(n++, "Yewtree Lane", false, new int[] {195});
		worldCells[275] = new WorldCell(n++, "Duskdale Avenue", false, new int[] {196});
		worldCells[276] = new WorldCell(n++, "Poplar Way", false, new int[] {197, 277});
		worldCells[277] = new WorldCell(n++, "Poplar Library", true, new int[] {197, 276});
		worldCells[278] = new WorldCell(n++, "Haider Palisade", false, new int[] {198});
		worldCells[279] = new WorldCell(n++, "Gerald's Way", false, new int[] {199});
		worldCells[280] = new WorldCell(n++, "Howard's Way", false, new int[] {199});
		worldCells[281] = new WorldCell(n++, "Almalexia Avenue", false, new int[] {200});
		worldCells[282] = new WorldCell(n++, "Mail's End", false, new int[] {201});
		worldCells[283] = new WorldCell(n++, "Maelstrom Mile", false, new int[] {202});
		worldCells[284] = new WorldCell(n++, "Juniper Gully", false, new int[] {202});
		worldCells[294] = new WorldCell(n++, "Kevin's Groceries", true, new int[] {209});
		worldCells[295] = new WorldCell(n++, "Ice Rink", true, new int[] {209});
		worldCells[296] = new WorldCell(n++, "Lettuce Lane", false, new int[] {210});
		worldCells[297] = new WorldCell(n++, "Lemon Lane", false, new int[] {211});
		worldCells[298] = new WorldCell(n++, "Lennon Lane", false, new int[] {211});
		worldCells[305] = new WorldCell(n++, "Urban Sprawl", false, new int[] {216});
		worldCells[306] = new WorldCell(n++, "Shady Crescent", false, new int[] {217});
		worldCells[307] = new WorldCell(n++, "Gull Towers", false, new int[] {216});
		worldCells[318] = new WorldCell(n++, "The Big Grey", false, new int[] {225});
		worldCells[319] = new WorldCell(n++, "Taylor Way", false, new int[] {225});
		worldCells[321] = new WorldCell(n++, "Safiyah's Stars", true, new int[] {227});
		worldCells[323] = new WorldCell(n++, "Sierra Drive", false, new int[] {228});
		worldCells[324] = new WorldCell(n++, "Dandilion Drive", false, new int[] {229});
		worldCells[325] = new WorldCell(n++, "Blackberry Fields", false, new int[] {229});
		worldCells[326] = new WorldCell(n++, "Blanie's Bargains", true, new int[] {230});
		worldCells[330] = new WorldCell(n++, "Benjamin Heights", false, new int[] {233});
		worldCells[331] = new WorldCell(n++, "Akkadia Arcade", true, new int[] {233});
		worldCells[336] = new WorldCell(n++, "Greenhill Cul-De-Sac", false, new int[] {237});
		worldCells[337] = new WorldCell(n++, "Jasper's Joke Shop", false, new int[] {237});
		worldCells[338] = new WorldCell(n++, "Dudley's Moor", false, new int[] {238});
		worldCells[341] = new WorldCell(n++, "School - Corridor D", true, new int[] {21, 342, 346, 347});
		worldCells[342] = new WorldCell(n++, "School - Psychology Class", true, new int[] {341});
		worldCells[343] = new WorldCell(n++, "School - English Class", true, new int[] {20});
		worldCells[344] = new WorldCell(n++, "School - Maths Class", true, new int[] {20});
		worldCells[345] = new WorldCell(n++, "School - Science Class 1", true, new int[] {20});
		worldCells[346] = new WorldCell(n++, "School - Science Class 2", true, new int[] {341});
		worldCells[347] = new WorldCell(n++, "School - Science Class 3", true, new int[] {341});
		worldCells[348] = new WorldCell(n++, "School - Geography Class", true, new int[] {22});
		worldCells[349] = new WorldCell(n++, "School - History Class", true, new int[] {20});
		worldCells[350] = new WorldCell(n++, "School - Art Class", true, new int[] {21});
		worldCells[351] = new WorldCell(n++, "School - Music Class", true, new int[] {21});
		worldCells[352] = new WorldCell(n++, "School - Drama Class", true, new int[] {21});
		worldCells[353] = new WorldCell(n++, "School - Library", true, new int[] {22});
		worldCells[599] = new WorldCell(n++, "Rando Holding Pen", true, new int[] {599});
		
		for (int x = 0; x < (worldCells.length - 1); x ++) {
			for (int y = 0; y < (worldCells.length - 1); y ++) {
				travelTimes[x][y] = 0;
			}
		}
		
		travelTimes[7][8] = 4;	travelTimes[7][9] = 3;	travelTimes[8][10] = 15; travelTimes[10][11] = 5;
		travelTimes[7][37] = 12;	travelTimes[7][38] = 6;	travelTimes[36][37] = 2;	travelTimes[35][36] = 10;		
		travelTimes[30][35] = 6;	travelTimes[29][30] = 4;	travelTimes[28][29] = 15;	travelTimes[10][28] = 12;
		// TODO: generate travel times.
				
		for (int x = 0; x < (worldCells.length - 1); x ++) {
			for (int y = 0; y < (worldCells.length - 1); y ++) {
				if (travelTimes[x][y] != 0) travelTimes[y][x] = travelTimes[x][y]; // Travel time, return journeys.
			}
		}
		
		for (int i = 0; i < worldCells.length; i++) {
			worldCells[i].setDecription(new String[] {"Description not yet written!"}); // TODO: generate descriptions that aren't hand-written.
		}
		
		worldCells[3].setDecription(new String[] {"Home sweet home. From this narrow hallway you can reach all the downstairs rooms of", "the house. Here you also find a staircase leading upstairs. The front door leading", "to the street is also here, opposite the stairs."});
		worldCells[7].setDecription(new String[] {"This is an exceedingly familiar road, owing to the fact that you've lived here for", "the majority of your life so far. This is a slightly run-down part of the suburbs,", "with more grey concrete than greenery, but the surroundings are not overtly menacing", "or unpleasant. You can find your house on this road."});
		// TODO: write the important ones.
		
		player = new GameCharacter(); spawnRandos();
	}
	
	public String getLocationAsString() {
		return worldCells[player.getInCell()].name;
	}
	
	public int[] getCurrentExitNodes() {
		return worldCells[player.getInCell()].getExitNodes();
	}
	
	public int[] workOutGenericExits(int cell) {
		
		cell -= startingCells; 
		int exits[];
		int steps[] = new int[worldSize], stepsBack[] = new int[worldSize];
		int s = 0, sb = 0, ex1 = 0, ex2 = 0, ex3 = 0;
		
		for (int i = 0; i < worldSize; i++) {
			if (i % 2 == 0) s++;
			if (i % 3 == 0) sb--;
			steps[i] = s; stepsBack[i] = sb;
		}
		
		if (cell % 2 == 0) {
			ex1 = cell + steps[cell];
			ex3 = cell + stepsBack[cell];
			ex1 += startingCells; ex3 += startingCells;
			exits = new int[] {ex1, ex3};
			return exits;
		} else {
			ex1 = cell + steps[cell];
			ex2 = ex1 + 1;
			ex3 = cell + stepsBack[cell];
			ex1 += startingCells; ex2 += startingCells; ex3 += startingCells;
			exits = new int[] {ex1, ex2, ex3};
			return exits;
		}
	}
	
	public void gotoCell(int fromCell, int toCell) {
		if (travelTimes[fromCell][toCell] == 0) {
			time.addSeconds(5);
			addNeedsByMinutes(0);

		} else {
			time.addMinutes(travelTimes[fromCell][toCell]);
			addNeedsByMinutes(travelTimes[fromCell][toCell]);
		}
		player.setInCell(toCell);
		player.setX(2); player.setY(2); player.setxD(2); player.setyD(2); // 2,2 : Temporary default starting position.
		spawnRandos();
	}
	
	public void characterWest (GameCharacter c) {
		char[][] l = worldCells[getCurrentCell(c)].getLayoutC();
		int y = c.getY(), x = c.getX();
		if (x == 0) {c.setX(0); c.setxD(0); return;}
		if (l[y][x - 1] == '\u2588') return;
			c.moveWest();
			if (c.isThePlayer()) { addSlightNeeds(); time.addCentiseconds(10); }
	}
	
	public void characterEast (GameCharacter c) {
		char[][] l = worldCells[getCurrentCell(c)].getLayoutC();
		int y = c.getY(), x = c.getX(), width = worldCells[getCurrentCell(c)].width;
		if (x == width - 1) {c.setX(width - 1); c.setxD(width - 1); return;}
		if (l[y][x + 1] == '\u2588') return;
			c.moveEast();
			if (c.isThePlayer()) { addSlightNeeds(); time.addCentiseconds(10); }
	}
	
	public void characterNorth (GameCharacter c) {
		char[][] l = worldCells[getCurrentCell(c)].getLayoutC();
		int y = c.getY(), x = c.getX();
		if (y == 0) {c.setY(0); c.setyD(0); return;}
		if (l[y - 1][x] == '\u2588') return;
			c.moveNorth();
			if (c.isThePlayer()) { addSlightNeeds(); time.addCentiseconds(10); }
	}
	
	public void characterSouth (GameCharacter c) {
		char[][] l = worldCells[getCurrentCell(c)].getLayoutC();
		int y = c.getY(), x = c.getX(), height = worldCells[getCurrentCell(c)].height;
		if (y == height - 1) { c.setY(height - 1); c.setyD(height - 1); return;}
		if (l[y + 1][x] == '\u2588') return; 
			c.moveSouth();
			if (c.isThePlayer()) { addSlightNeeds(); time.addCentiseconds(10); }
	}
	
	public int getCurrentCell () {
		return player.getInCell();
	}
	
	public int getCurrentCell (GameCharacter c) {
		return c.getInCell();
	}
	
	public int getCurrentCellWidth() {
		return worldCells[getCurrentCell()].width;
	}
	
	public int getCurrentCellHeight() {
		return worldCells[getCurrentCell()].height;
	}
	
	public void addSlightNeeds() {
		player.addHunger(0.008);
		player.addThirst(0.009);
		player.addTiredness(0.0035);
		player.validateNeeds();
	}
	
	public void addNeedsByMinutes(int minutes) {
		if (minutes == 0) {
			player.addHunger(0.01);
			player.addThirst(0.011);
			player.addTiredness(0.007);
			player.validateNeeds();
		} else {
			player.addHunger(0.12 * minutes);
			player.addThirst(0.135 * minutes);
			player.addTiredness(0.07 * minutes);
			player.validateNeeds();
		}
	}
	
	public void spawnRandos() {
		for (int r = 0; r < randos.length; r++) {
			randos[r] = new GameCharacter(); randos[r].randomizeCharacter();
			randos[r].setX(3); randos[r].setY(r + 1);
			randos[r].setInCell(599);
			if (rnd.nextInt(4) == 1) { randos[r].setInCell(getCurrentCell()); }
		}
	}
	
}
