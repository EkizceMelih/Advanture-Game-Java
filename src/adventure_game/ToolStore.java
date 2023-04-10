package adventure_game;

import java.util.Scanner;

public  class ToolStore extends NormalLocation {

	ToolStore(Player player) {
		super(player, "Store");
		// TODO Auto-generated constructor stub
	}

	public boolean getLocation() {

		int select = storeMenu();
		while(select>1 || select<4) {
			switch (select) {
			case 1:
				int selectedWeapon = weapons();
				
				switch (selectedWeapon) {
				case 1:
					System.out.println("selectedweapon: "+selectedWeapon+" select :"+select );
					if(player.getMoney()>=10) {
						player.getInv().setDamage(4);
						player.getInv().setWeaponName("Bow");
						player.setMoney(player.getMoney()-10);
						 select = storeMenu();
						break;
					}
					else {
						
						System.out.println("Your money is low for product ");
						break;
					}
					
				case 2:
					if(player.getMoney()>=14) {
						player.getInv().setDamage(5);
						player.getInv().setWeaponName("Spare");
						player.setMoney(player.getMoney()-14);
						 select = storeMenu();
						break;
					}
					else {
						
						System.out.println("Your money is low for product ");
						break;
					}
					
				case 3:
					if(player.getMoney()>=18) {
						player.getInv().setDamage(6);
						player.getInv().setWeaponName("Sword");
						player.setMoney(player.getMoney()-18);
						 select = storeMenu();
						break;
					}
					else {
						
						System.out.println("Your money is low for product ");
						break;
					}
				case 4:
					storeMenu();
					break;
					
				}
				break;
			case 2:
				int selectedArmor=armors();
				switch(selectedArmor) {
				case 1:
					if(player.getMoney()>=10) {
						player.getInv().setArmor(3);
						player.getInv().setArmorName("Boot");
						player.setMoney(player.getMoney()-10);
						 select = storeMenu();
						break;
					}
					else {
						System.out.println("Your money is low for product ");
						break;
					}
					
				case 2:
					if(player.getMoney()>=14) {
						player.getInv().setArmor(4);
						player.getInv().setArmorName("Helmet");
						player.setMoney(player.getMoney()-14);
						 select = storeMenu();
						 break;
					}
					else {
						System.out.println("Your money is low for product ");
						break;
					}
					
				case 3:
					if(player.getMoney()>=20) {
						player.getInv().setArmor(6);
						player.getInv().setArmorName("Shield");
						player.setMoney(player.getMoney()-20);
						 select = storeMenu();
						break;
					}
					else {
						System.out.println("Your money is low for product ");
						break;
					}
				case 4:
					storeMenu();
					break;

					
				
				}
				break;
			case 3:
				
				
				break;
			

			}
			break;
		}
		
		return true;
	}

	public int storeMenu() {
		System.out.println("Your money: " + player.getMoney());
		System.out.println("1.Weapons");
		System.out.println("2.Armors");
		System.out.println("3.Exit");
		System.out.println("Choose one");
		int choosedSelect = scan.nextInt();
		while (choosedSelect < 1 || choosedSelect > 3) {
			System.out.println("Please enter a number between 1-3");
			choosedSelect = scan.nextInt();
		}
		return choosedSelect;
	}

	public int weapons() {
		System.out.println("Your money: " + player.getMoney());
		System.out.println("1.Bow  Price: 10");
		System.out.println("2.Spare  Price: 14");
		System.out.println("3.Sword   Price: 18");
		System.out.println("4.Exit");
		int choosedSelect = scan.nextInt();
		while (choosedSelect < 1 || choosedSelect > 4) {
			System.out.println("Please enter a number between 1-3");
			choosedSelect = scan.nextInt();
		}
		return choosedSelect;
	}
	public int armors() {
		System.out.println("Your money: " + player.getMoney());
		System.out.println("1.Boot   Price:10");
		System.out.println("2.Helmet  Price:14");
		System.out.println("3.Shield   Price:20");
		System.out.println("4.Exit");
		int choosedSelect = scan.nextInt();
		while (choosedSelect < 1 || choosedSelect > 4) {
			System.out.println("Please enter a number between 1-3");
			choosedSelect = scan.nextInt();
		}
		return choosedSelect;
	}

}
