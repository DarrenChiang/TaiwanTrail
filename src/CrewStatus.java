public class CrewStatus {
	private int money, food, progress, spareparts, wep, foodcon = 50, pace = 5, day = 1, crewnumber;
	private boolean skill;
	
	public CrewStatus(int a, int b) {
		if(a == 1) {
			money = 12000;
			skill = false;
		}
		else if (a == 2) {
			money = 6000;
			skill = true;
		}
		
		crewnumber = b;
	}
	
	public boolean returnSkill() {
		return skill;
	}
	
	public int returnFoodCon() {
		return foodcon;
	}
	
	public void killmember(boolean a) {
		if(a == true) {
			crewnumber--;
		}
	}
	
	public boolean win() {
		if(crewnumber > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int returnCrewNumber() {
		return crewnumber;
	}
	
	public void printStatus() {
		System.out.println("Day:\t\t" + day);
		System.out.println("Progress:\t" + progress + "%");
		System.out.println("Your money:\t" + money);
		System.out.println("Food supply:\t" + food);
		System.out.println("Spare parts:\t" + spareparts);
		System.out.println("Weapon supply:\t" + wep);
	}
	
	public void changeProgress(int a) {
		progress = (300 - a) / 3;
	}
	
	public int returnProgress() {
		return progress;
	}
	
	public void nextDay() {
		day++;
	}
	
	public int returnDay() {
		return day;
	}
	
	public void setFoodCon(int a) {
		switch(a) {
			case 1:
				foodcon = 25;
				break;
			case 2:
				foodcon = 50;
				break;
			case 3:
				foodcon = 75;
				break;
			case 4:
				foodcon = 0;
				break;
			default:
				break;
		}
	}
	
	public void setPace(int a) {
		switch(a) {
			case 1: 
				pace = 5;
				break;
			case 2:
				pace = 10;
				break;
			default:
				break;
		}
	}
	
	public int returnPace() {
		return pace;
	}
	
	public void changeMoney(int a) {
		money = money + a;
		if(money < 0) {
			money = 0;
		}
	}
	
	public void changeFood(int a) {
		food = food + a;
		if(food < 0) {
			food = 0;
		}
	}
	
	public void changeSpareParts(int a) {
		spareparts = spareparts + a;
		if(spareparts < 0) {
			spareparts = 0;
		}
	}
	
	public void changeWep(int a) {
		wep = wep + a;
		if(wep < 0) {
			wep = 0;
		}
	}
	
	public int returnMoney() {
		return money;
	}
	
	public int returnFood() {
		return food;
	}
	
	public int returnParts() {
		return spareparts;
	}
	
	public int returnWep() {
		return wep;
	}
}
