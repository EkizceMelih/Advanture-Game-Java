package adventure_game;

public abstract class BattleLocation extends Location {
	protected  Obstacle obstacle;
	protected String award;
	
	BattleLocation(Player player,String name,Obstacle obstacle,String award) {
		super(player);
		this.name=name;
		this.obstacle=obstacle;
		this.award=award;
		// TODO Auto-generated constructor stub
	}
	public boolean getLocation() {
		int obsCount=obstacle.obsCount();
		System.out.println("You are here now: "+ this.getName());
		System.out.println("Be Careful");
		System.out.println("There has "+ obsCount +" "+obstacle.getName());
		System.out.println("Run or Fight");
		System.out.println("If you want to run press r else press f");
		String r_or_f=scan.nextLine();
		r_or_f=r_or_f.toUpperCase();
		
		
		if(r_or_f.equals("F")) {
			if(combat(obsCount)) {
				System.out.println("You have killed all obstacle at "+this.getName());
				if(this.award.equals("Food")&& player.getInv().isFood()==false) {
					System.out.println("You won this award: "+this.award);
					player.getInv().setFood(true);
				}
				else if(this.award.equals("Water")&& player.getInv().isWater()==false) {
					System.out.println("You won this award: "+this.award);
					player.getInv().setWater(true);
				}
				else if(this.award.equals("Firewood")&& player.getInv().isFirewood()==false) {
					System.out.println("You won this award: "+this.award);
					player.getInv().setFirewood(true);
				}
				return true;
			}
			else {
				System.out.println("You are died");
				return false;
			}			
		}
	return true;
	}
	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defaultObsHealth=obstacle.getHealth();
			playerStats();
			enemyStats();
			while(player.getHeal()>0 && obstacle.getHealth()>0) {
				System.out.println("<F>ight or <R>un");
				String selectedCase=scan.nextLine();
				selectedCase=selectedCase.toUpperCase();
				if(selectedCase.equals("F")) {
					System.out.println("You attacked");
					obstacle.setHealth(obstacle.getHealth()-player.totalDamage());
					afterHit();
					if(obstacle.getHealth()>0) {
						System.out.println(obstacle.getName()+" health:"+ obstacle.getHealth());
						System.out.println();
						System.out.println(obstacle.getName()+"hit you");
						player.setHeal(player.getHeal()-(obstacle.getDamage()-player.getInv().getArmor()));
						afterHit();
					}
					
				}
				else {
					break;
				}
			}
			if(obstacle.getHealth()<=0 && player.getHeal()>0) {
				System.out.println("All enemies have been destroyed");
				player.setMoney(player.getMoney()+(obstacle.getAward()));
				System.out.println("Your money: "+player.getMoney());
				obstacle.setHealth(defaultObsHealth);
			}
			else {
				return false;
			}
		}
		
		return true;
		
	}
	public void afterHit() {
		System.out.println("Players health:"+player.getHeal());
		System.out.println(obstacle.getName()+" health:"+ obstacle.getHealth());
	}
	public void playerStats() {
		System.out.println("Player stats\n-------------");
		System.out.println("Health:"+player.getHeal());
		System.out.println("Damage:"+player.getDamage());
		System.out.println("Damage:"+player.getInv().getArmor());
		System.out.println("Money: "+player.getMoney());
		if(player.getInv().getWeaponName()!="") {
			System.out.println("Weapon: "+player.getInv().getWeaponName());
		}
		if(player.getInv().getArmorName()!="") {
			System.out.println("Weapon: "+player.getInv().getArmorName());
		}
		System.out.println("-------------");
		
		
	}
	public void enemyStats() {
		System.out.println(obstacle.getName()+" stats\n-------------");
		System.out.println("Health: "+obstacle.getHealth());
		System.out.println("Damage: "+obstacle.getDamage());
		System.out.println("Prize: "+obstacle.getAward());
		System.out.println("-------------");
		
	}

}
