import java.util.Scanner;
import java.util.Random;

public class TaiwanTrail {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Random rng = new Random();
		Events event = new Events();
		Menu menu = new Menu();
		String name, replay = "n";
		int inputchoice = 0, chance, save, save2;
		
		menu.mainMenu();
		
		do {
			System.out.println("Play? (y/n): ");
			replay = reader.nextLine();
		}
		while(!(replay.equals("y")) && !(replay.equals("n")));
		
		if(replay.equals("y")) {
			do {
				System.out.print("How many people are in the crew? (max: 4) ");
				inputchoice = reader.nextInt();
				if(inputchoice > 4 || inputchoice < 1) {
					System.out.println("Please keep your crew from 1 to 4.");
				}
			}
			while(inputchoice > 4 || inputchoice < 1);
			
			save = inputchoice;
		
			Character[] characters = new Character[inputchoice];
		
			reader.nextLine();
		
			for(int i = 0; i < characters.length; i++) {
				characters[i] = new Character();
				System.out.println("\nEnter character " + (i + 1) + "'s name.");
				name = reader.nextLine();
				characters[i].setName(name);
			}
			
			System.out.println();
		
			do {
				menu.professionChoices();
				inputchoice = reader.nextInt();
				if(inputchoice == 3) {
					System.out.println("A banker comes with money but has no skill. A farmer has less money but can fix up broken stuff.");
				}
			}
			while(inputchoice > 2 || inputchoice < 1);
			
			boolean trap = false;
			
			if(inputchoice == 1) {
				trap = true;
			}
		
			CrewStatus crew = new CrewStatus(inputchoice, save);
			
			boolean stay = true;
			
			System.out.println();
			
			while(stay == true) {
				do {
					System.out.println("Your money:\t" + crew.returnMoney());
					System.out.println("Food supply:\t" + crew.returnFood());
					System.out.println("Spare parts:\t" + crew.returnParts());
					System.out.println("Weapon supply:\t" + crew.returnWep());
					menu.shopItems();
					inputchoice = reader.nextInt();
				}
				while(inputchoice > 6 || inputchoice < 1);
				
				menu.shopChoice(inputchoice);
				
				if(inputchoice == 6) {
					stay = false;
				}
				else if(inputchoice == 1) {
					do {
						inputchoice = reader.nextInt();
					}
					while(inputchoice < 0 || inputchoice > crew.returnMoney() / 100);
					crew.changeMoney(inputchoice * -100);
					crew.changeFood(inputchoice * 300);
				}
				else if(inputchoice == 2) {
					do {
						inputchoice = reader.nextInt();
					}
					while(inputchoice < 0 || inputchoice > crew.returnMoney() / 200);
					crew.changeMoney(inputchoice * -200);
					crew.changeSpareParts(inputchoice);
				}
				else if(inputchoice == 3) {
					do {
						inputchoice = reader.nextInt();
					}
					while(inputchoice < 0 || inputchoice > crew.returnMoney() / 20);
					crew.changeMoney(inputchoice * -20);
					crew.changeWep(inputchoice);
				}
				else if(inputchoice == 4) {
					crew.changeMoney(-80);
				}				
			}
			
			System.out.println();
			
			boolean win = true, rest = false, rushing = false, luck = false, moved = false, daypassed = false;
			int rep, lol, r = 0;
			
			for(int p = 300; p > 0;) {
				if(event.randomEvents() >= 4) {
					luck = true;
				}
				else {
					luck = false;
				}
				if(crew.returnFood() == 0) {
					crew.setFoodCon(4);
				}
				for(int d = 0; d < characters.length; d++) {
					characters[d].printStatus();
					crew.killmember(characters[d].dead());
					if(daypassed == true) {
						if(characters[d].dead == false) {
							if(crew.returnFoodCon() == 0) {
								characters[d].changeHealth(-20);
								characters[d].setDangerLevel(4);
							}
							else if(crew.returnFoodCon() == 25) {
								characters[d].changeHealth(-9);
								characters[d].setDangerLevel(2);
							}
							else if(crew.returnFoodCon() == 75 || rest == true) {
								characters[d].changeHealth(8);
								characters[d].setDangerLevel(0);
							}
							if(characters[d].dead == false) {
								rep = characters[d].returnHealth();
								if(trap == true) {
									r = 1;
								}
								if(rushing == true && moved == true) {
									lol = 2;
								}
								else {
									lol = 1;
								}
								characters[d].changeHealth(event.characterFate(characters[d].returnDanger() + (lol + r)));
								if(rep != characters[d].returnHealth()) {
									System.out.println(characters[d].returnName() + " got sick!");
								}
							}
						}
					}
				}
				if(moved == true) {
					if(event.randomEvents() > 4) {
						switch(event.randomEvents()) {
							case 1:
								System.out.println("There was a thief!");
								if(crew.returnWep() > 0 && event.randomEvents() > 2) {
									save = event.randomEvents();
									save2 = crew.returnWep();
									crew.changeWep(-(save));
									System.out.println("You successfuly fended off the attack! " + (save2 - crew.returnWep()) + " weapon points were used.");
								}
								else {
									save = event.randomEvents() * 100;
									System.out.println("The thief stole " + save + " food points!");
									crew.changeFood(-(save));
								}
								break;
							case 2:
								System.out.println("There was a car accident!");
								save = rng.nextInt(crew.returnCrewNumber());
								characters[save].changeHealth(-20);
								System.out.println(characters[save].returnName() + " got injured! You need to rest three days.");
								for(int y = 0; y <= 3; y++) {
									crew.nextDay();
									crew.changeFood(-(crew.returnCrewNumber() * crew.returnFoodCon()));
								}
								break;
							case 3:
								System.out.println("Your crew got lost!");
								for(int u = event.randomEvents(); u > 0; u--) {
									crew.nextDay();
									crew.changeFood(-(crew.returnCrewNumber() * crew.returnFoodCon()));
								}
								System.out.println("A few days were lost trying to get back on track.");
								break;
							case 4:
								System.out.println("Your transport broke down!");
								if(crew.returnSkill() == true) {
									System.out.println("Your skills allow you to fix the transport fast.");
									if(crew.returnParts() == 0) {
										System.out.println("However, you ran out of parts. You'll have to wait one day.");
										crew.nextDay();
										crew.changeFood(-(crew.returnCrewNumber() * crew.returnFoodCon()));
									}
									else {
										crew.changeSpareParts(-1);
									}
								}
								else {
									System.out.println("Fixing it will require some time.");
									for(int w = event.randomEvents(); w > 0; w--) {
										crew.nextDay();
										crew.changeFood(-(crew.returnCrewNumber() * crew.returnFoodCon()));
									}
								}
								break;
							case 5:
								System.out.println("Your crew comes across abandoned supplies. You found: ");
								if(event.randomEvents() == 5) {
									save = event.randomEvents() * 200;
									System.out.println(save + " food points.");
									crew.changeFood(save);
									save = event.randomEvents();
									System.out.println(save + " spare parts.");
									crew.changeSpareParts(save);
									save = event.randomEvents() * 3;
									System.out.println(save + " weapon points.");
									crew.changeWep(save);
									save = event.randomEvents() * 1000;
									System.out.println(save + " money.");
									crew.changeMoney(save);
								}
								else {
									save = event.randomEvents() * 75;
									System.out.println(save + " food points.");
									crew.changeFood(save);
									save = event.randomEvents();
									System.out.println(save + " weapon points.");
									crew.changeWep(save);
									save = event.randomEvents() * 500;
									System.out.println(save + " money.");
									crew.changeMoney(save);
								}
								break;
							default:
								break;
						}
					}
				}
				rest = false;
				moved = false;
				daypassed = false;
				crew.changeProgress(p);
				crew.printStatus();
				menu.dailyChoices();
				if(crew.win() == false) {
					p = 0;
					win = false;
					System.out.println("Everyone died!");
				}
				else {
					inputchoice = reader.nextInt();
					menu.userChoice(inputchoice);
					if(inputchoice == 8) {
						p = 0;
						win = false;
					}
					else if(inputchoice == 6) {
						p = p - crew.returnPace();
						crew.nextDay();
						daypassed = true;
						crew.changeFood(-(crew.returnCrewNumber() * crew.returnFoodCon()));
						moved = true;
					}
					else if(inputchoice == 5) {
						do {
							inputchoice = reader.nextInt();		
						}
						while(inputchoice > crew.returnWep());
						chance = rng.nextInt(inputchoice + 1);
						System.out.println("You obtained " + chance * 400 + " food points.");
						crew.changeFood(chance * 400);
						crew.changeWep(-(inputchoice));
					}
					else if(inputchoice == 4) {
						if(luck == true) {
							while(stay == true) {
								do {
									System.out.println("Your money:\t" + crew.returnMoney());
									System.out.println("Food supply:\t" + crew.returnFood());
									System.out.println("Spare parts:\t" + crew.returnParts());
									System.out.println("Weapon supply:\t" + crew.returnWep());
									menu.shopItems();
									inputchoice = reader.nextInt();
								}
								while(inputchoice > 6 || inputchoice < 1);
				
								menu.shopChoice(inputchoice);
				
								if(inputchoice == 6) {
									stay = false;
								}
								else if(inputchoice == 1) {
									do {
										inputchoice = reader.nextInt();
									}
									while(inputchoice < 0 || inputchoice > crew.returnMoney() / 100);
									crew.changeMoney(inputchoice * -100);
									crew.changeFood(inputchoice * 300);
								}
								else if(inputchoice == 2) {
									do {
										inputchoice = reader.nextInt();
									}
									while(inputchoice < 0 || inputchoice > crew.returnMoney() / 200);
									crew.changeMoney(inputchoice * -200);
									crew.changeSpareParts(inputchoice);
								}
								else if(inputchoice == 3) {
									do {
										inputchoice = reader.nextInt();
									}
									while(inputchoice < 0 || inputchoice > crew.returnMoney() / 20);
									crew.changeMoney(inputchoice * -20);
									crew.changeWep(inputchoice);
								}
								else if(inputchoice == 4) {
									crew.changeMoney(-80);
								}				
							}
						}
						else {
							System.out.println("There appears to be no store around.");
						}
					}
					else if(inputchoice == 3) {
						do {
							inputchoice = reader.nextInt();
						}
						while(inputchoice > 3 || inputchoice < 1);
						crew.setFoodCon(inputchoice);
					}
					else if(inputchoice == 2) {
						do {
							inputchoice = reader.nextInt();
						}
						while(inputchoice > 2 || inputchoice < 1);
						crew.setPace(inputchoice);
						if(crew.returnPace() == 10) {
							rushing = true;
						}
						else {
							rushing = false;
						}
					}
					else if(inputchoice == 1) {
						crew.nextDay();
						daypassed = true;
						crew.changeFood(-(crew.returnCrewNumber() * crew.returnFoodCon()));
						rest = true;
					}
				}
			}
			if(win == true) {
				System.out.print("You win!");
			}
		}
	}
}
