package adventure_game;

public abstract class NormalLocation extends Location {

	NormalLocation(Player player,String name) {
		super(player);
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public abstract  boolean getLocation();

}
