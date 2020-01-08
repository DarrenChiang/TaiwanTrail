public class Character {
	private String name;
	private int health = 100, dangerlevel = 0;
	boolean dead = false; 
	
	public Character() {
		name = "";
	}
	
	public void setName(String a) {
		name = a;
	}
	
	public String returnName() {
		return name;
	}
	
	public int returnHealth() {
		return health;
	}
	
	public void setDangerLevel(int a) {
		dangerlevel = a;
	}
	
	public void changeDangerLevel(int a) {
		dangerlevel = dangerlevel + a;
	}
	
	public int returnDanger() {
		return dangerlevel;
	}
	
	public void changeHealth(int a) {
		health = health + a;
		if(health < 0) {
			health = 0;
		}
		else if(health > 100) {
			health = 100;
		}
	}
	
	public void printStatus() {
		if(health <= 0) {
			System.out.println(name + " has died.");
		}
		else {
			System.out.println(name + "'s current health is at " + health + "%.");
		}
	}
	
	public boolean dead() {
		if(health <= 0) {
			dead = true;
		}
		return dead;
	}
}
