package adventure_game;

import java.util.Scanner;

public class Game {
	static Scanner scan = new Scanner(System.in);

	Player player;

	Location location;

	public void logIn() {
		// scan=new Scanner(System.in);
		System.out.println("Welcome to Adventure Game");
		System.out.println("Please enter your name");
		String name = scan.next();
		player=new Player(name);		
		player.selectChar();
		while(true) {start();}
		
	}

	public void start() {
		System.out.println("---------------------");
		System.out.println("Make your choose");
		System.out.println("1-Safe house,your house that hasn't enemy here");
		System.out.println("2-Cave,you might  see zombie here");
		System.out.println("3-Forest,you might  see bear here");
		System.out.println("4-River,you might  see vampire here");
		System.out.println("5-Toolstore,you can buy weapon here");
		int selectLoc = scan.nextInt();
		while (selectLoc < 0 || selectLoc > 5) {
			System.out.println("Please choose a number between 1-5");
			selectLoc = scan.nextInt();
		}
		switch (selectLoc) {
		case 1:
			location = new SafeHouse(player);
			break;
		case 2:
			location= new Cave(player);
			break;
		case 3:
			location= new Forest(player);
			break;
		case 4:
			location= new River(player);
			break;
		case 5:
			location= new ToolStore(player);			
			break;
		default:
			location = new SafeHouse(player);
			break;
		}
		
		location.getLocation();
	}
}
