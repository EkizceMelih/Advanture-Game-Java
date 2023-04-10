package adventure_game;

import java.util.Scanner;

public class Player {
	Scanner scan = new Scanner(System.in);

	
	private int heal, damage, money,firstlyHeal;
	private String name, charName;
	private Inventory inv;
	public Player(String name){
		this.inv=new Inventory();
	}

	public void selectChar() {
		
		switch (charMenu()) {
		case 1:
			initCharacter("Samurai", 7, 32, 10);
			break;
		case 2:
			initCharacter("Archer", 9, 24,8);
			break;
		case 3:
			initCharacter("Knight", 24, 40, 12);
			break;
		}
		System.out.println("Your charachter has been created");
		System.out.println("Character:"+getCharName());
	}
    public void initCharacter(String charName,int damage,int heal,int money) {
    	setCharName(charName);
		setDamage(damage);
		setHeal(heal);
		setMoney(money);
		setFirstlyHeal(heal);
    	
    }
	public int charMenu() {
		int charId;
		System.out.println("Select your character");
		System.out.println("1-Samurai Damage:7  Health:32	Money:10");
		System.out.println("2-Archer  Damage:9  Health:24	Money: 8");
		System.out.println("3-Knight  Damage:4  Health:40	Money:12");
		charId = scan.nextInt();
		while (charId < 1 || charId > 3) {
			System.out.println("Please enter a number between 1-3");
			charId = scan.nextInt();
		}
		
		return charId;
	}
	public int totalDamage() {
		return this.getDamage()+this.getInv().getDamage();
	}
	public int getFirstlyHeal() {
		return firstlyHeal;
	}
	public void setFirstlyHeal(int firstlyHeal) {
		this.firstlyHeal = firstlyHeal;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
