package characterStuff;

import java.util.Random;

public class GameCharacter {

	private String name;
	private int age, daysPlayed, inCell;
	private int x = 2, y = 2;
	private double xD = 2.0, yD = 2.0;
	private boolean isThePlayer;
	private boolean isMale;
	private double strength, agility, intellect, charisma, health;
	private double hunger, thirst, tiredness, pee, poo, stress;
	public Random rnd = new Random();
	
	public GameCharacter () {
		setThePlayer(true);
		setInCell(7);
		setName("Daniel Breswick");
		setAge(13); setDaysPlayed(0);
		setMale(true);
		setStrength(4); setAgility(5); setIntellect(6); setCharisma(5); setHealth(100);
		setHunger(35.0); setThirst(40.0); setTiredness(45.0); setPee(10.0); setPoo(2.0); setStress(10.0);
	}
	
	public GameCharacter (String nameGiven, boolean isMaleGiven) {
		setInCell(7);
		setName(nameGiven);
		setAge(13); setDaysPlayed(0);
		setMale(isMaleGiven);
		setStrength(4); setAgility(5); setIntellect(6); setCharisma(5); setHealth(100);
		setHunger(35.0); setThirst(40.0); setTiredness(25.0); setPee(10.0); setPoo(2.0); setStress(10.0);	
	}
	
	public void randomizeCharacter() {
		// TODO flesh this out to create varied randos.
		setMale(rnd.nextBoolean());
		if (isMale()) { setName("Unknown Male"); } else { setName("Unknown Female"); }
		setAge(rnd.nextInt(60) + 10);
		setStrength(rnd.nextInt(9) + 1); setAgility(rnd.nextInt(9) + 1); 
		setIntellect(rnd.nextInt(9) + 1); setCharisma(rnd.nextInt(9) + 1);
		setThePlayer(false);
	}

	public boolean isThePlayer() {
		return isThePlayer;
	}

	public void setThePlayer(boolean isThePlayer) {
		this.isThePlayer = isThePlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDaysPlayed() {
		return daysPlayed;
	}

	public void setDaysPlayed(int daysPlayed) {
		this.daysPlayed = daysPlayed;
	}
	
	public void addDaysPlayed(int daysPlayed) {
		this.daysPlayed += daysPlayed;
	}
	
	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	public String getSexAsString(){
		String sex = "female";
		if (isMale) sex = "male";
		return sex;
	}

	public double getHunger() {
		return hunger;
	}

	public void addHunger(double hunger) {
		this.hunger += hunger;
	}
	
	public void setHunger(double hunger) {
		this.hunger = hunger;
	}

	public double getThirst() {
		return thirst;
	}

	public void addThirst(double thirst) {
		this.thirst += thirst;
	}
	
	public void setThirst(double thirst) {
		this.thirst = thirst;
	}

	public double getTiredness() {
		return tiredness;
	}

	public void addTiredness(double tiredness) {
		this.tiredness += tiredness;
	}
	
	public void setTiredness(double tiredness) {
		this.tiredness = tiredness;
	}

	public double getPee() {
		return pee;
	}

	public void addPee(double pee) {
		this.pee += pee;
	}
	
	public void setPee(double pee) {
		this.pee = pee;
	}

	public double getPoo() {
		return poo;
	}

	public void addPoo(double poo) {
		this.poo += poo;
	}
	
	public void setPoo(double poo) {
		this.poo = poo;
	}
	
	public double getStress() {
		return stress;
	}

	public void addStress(double stress) {
		this.stress += stress;
	}
	
	public void setStress(double stress) {
		this.stress = stress;
	}

	public int getInCell() {
		return inCell;
	}

	public void setInCell(int inCell) {
		this.inCell = inCell;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public double getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public double getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public double getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}
	
	public void validateNeeds() {
		
		hunger = Math.round(hunger * 100.0) / 100.0;
		thirst = Math.round(thirst * 100.0) / 100.0;
		tiredness = Math.round(tiredness * 100.0) / 100.0;
		pee = Math.round(pee * 100.0) / 100.0;
		poo = Math.round(poo * 100.0) / 100.0;
		stress = Math.round(stress * 100.0) / 100.0;
		
		if (hunger < 0.0) hunger = 0.0;
		if (hunger > 100.0) hunger = 100.0;
		if (thirst < 0.0) thirst = 0.0;
		if (thirst > 100.0) thirst = 100.0;
		if (tiredness < 0.0) tiredness = 0.0;
		if (tiredness > 100.0) tiredness = 100.0;
		if (pee < 0.0) pee = 0.0;
		if (pee > 100.0) pee = 100.0;	
		if (poo < 0.0) poo = 0.0;
		if (poo > 100.0) poo = 100.0;
		if (stress < 0.0) stress = 0.0;
		if (stress > 100.0) stress = 100.0;	
	}
	
	public void moveWest() {
		setxD(getxD() - 0.09); setX((int) getxD());
		checkMove();
	}
	
	public void moveEast() {
		setxD(getxD() + 0.09); setX((int) getxD());
		checkMove();
	}
	
	public void moveNorth() {
		setyD(getyD() - 0.07); setY((int) getyD());
		checkMove();
	}
	
	public void moveSouth() {
		setyD(getyD() + 0.07); setY((int) getyD());
		checkMove();
	}
	
	public void checkMove() {
		if (getX() < 0) setX(0);
		if (getX() > 84) setX(84);
		if (getxD() < 0.0) setxD(0.0);
		if (getxD() > 84.0) setxD(84.0);
		if (getY() < 0) setY(0);
		if (getY() > 25) setY(25);
		if (getyD() < 0.0) setyD(0.0);
		if (getyD() > 25.0) setyD(25.0);
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getxD() {
		return xD;
	}

	public void setxD(double xD) {
		this.xD = xD;
	}

	public double getyD() {
		return yD;
	}

	public void setyD(double yD) {
		this.yD = yD;
	}
	
}
