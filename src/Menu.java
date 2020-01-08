public class Menu {
	public Menu() {
		
	}
	
	public void mainMenu() {
		System.out.println("**********************************************************" 
							+ "\n" + "  Welcome to....  "
							+ "\n" + "  _____     _                       _____         _ _ 			"
							+ "\n" + " |_   _|   (_)                     |_   _|       (_) |			"
							+ "\n" + "   | | __ _ ___      ____ _ _ __     | |_ __ __ _ _| |			"
							+ "\n" + "   | |/ _` | \\ \\ /\\ / / _` | '_ \\    | | '__/ _` | | |		"
							+ "\n" + "   | | (_| | |\\ V  V / (_| | | | |   | | | | (_| | | |			"
							+ "\n" + "   \\_/\\__,_|_| \\_/\\_/ \\__,_|_| |_|   \\_/_|  \\__,_|_|_|		"
							+ "\n" + "**********************************************************");
	}

	public void clearScreen() {
		
	}
	
	public void professionChoices() {
		System.out.println("What's your profession?");
		System.out.println("1) Businessman");
		System.out.println("2) Farmer");
		System.out.println("3) Understand the choices.");
	}
	
	public void dailyChoices() {
		clearScreen();
		System.out.println("What will you do today?");
		System.out.println("1) Rest for the next day.");
		System.out.println("2) Change pace.");
		System.out.println("3) Adjust food consumption.");
		System.out.println("4) Look for 7-11.");
		System.out.println("5) Gather food.");
		System.out.println("6) Continue on journey.");
		System.out.println("7) Understand the choices.");
		System.out.println("8) Quit game.");
	}
	
	public void userChoice(int a) {
		switch(a) {
			case 1:
				System.out.println("The crew rests for a day.");
				break;
			case 2:
				System.out.println("What pace do you want to travel at?");
				System.out.println("1) Slow.");
				System.out.println("2) Fast.");
				break;
			case 3:
				System.out.println("Which food consumption rate do you want to set as?");
				System.out.println("1) Sparingly.");
				System.out.println("2) Mediocre.");
				System.out.println("3) Overwhelming.");
				break;
			case 4:
				System.out.println("You attempt to look for a store."); //Beta.
				break;
			case 5:
				System.out.println("You attempt to hunt.");
				System.out.println("How much weapon supply are you going to use?");
				break;
			case 6:
				System.out.println("You continue on your journey.");
				break;
			case 7:
				System.out.println("1) Resting for a day consumes a day's supplies without progress, but is most reccomended for recuperation.");
				System.out.println("2) Changing pace affects the speed. Progression often comes at the cost of disasters.");
				System.out.println("3) Managing food consumption can greatly influence the health of your crew.");
				System.out.println("4) Try your luck at finding a convenience store.");
				System.out.println("5) Hunting gives a random chance to increase food supply.");
				System.out.println("6) If nothing seems wrong, then you mind as well continue.");
				System.out.println("7) You just chose this option.");
				break;
			case 8:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Please choose an option.");
				break;
		}
	}
	
	public void shopItems() {
		clearScreen();
		System.out.println("What will you buy?");
		System.out.println("1) Food");
		System.out.println("2) Transport Accessories (Spare Parts)");
		System.out.println("3) Weapon Supplies");
		System.out.println("4) Wifi Access");
		System.out.println("5) Understand the choices.");
		System.out.println("6) Exit shop.");
	}
	
	public void shopChoice(int a) {
		switch(a) {
			case 1:
				System.out.println("1 food pack costs 100. (1 pack = 300 points)");
				System.out.println("How many packs will you buy?");
				break;
			case 2:
				System.out.println("1 spare part costs 200.");
				System.out.println("How many spare parts will you buy?");
				break;
			case 3:
				System.out.println("1 weapon supply costs 15.");
				System.out.println("How many weapon supplies will you buy?");
				break;
			case 4:
				System.out.println("That will be 80 please.");
				break;
			case 5:
				System.out.println("The average food consumption rate per person per day is 50.");
				System.out.println("One or two spare parts is usually enough at a time.");
				System.out.println("One weapon supply can potentially get you a kill while hunting or fend off certain dangers.");
				System.out.println("There's nothing useful about getting Wifi access. It's just a money sink if you have too much.");
				break;
			case 6:
				break;
			default:
				System.out.println("Please choose an option.");
				break;
		}
	}
}
