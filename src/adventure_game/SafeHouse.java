package adventure_game;

public  class SafeHouse extends NormalLocation{

	SafeHouse(Player player) {
		super(player,"Safe House");
		// TODO Auto-generated constructor stub
	} 
	public boolean getLocation() {
		player.setHeal(player.getFirstlyHeal());
		System.out.println("Your health is full now");
		System.out.println("Your in safe house now");
		return true;
	}
	
	

}
