import java.util.ArrayList;

public class Monster 
{

	String name;
	String description;
	int health;
	boolean defeated;
	Item loot;
	ArrayList<Attack> attackList;
	
	public Monster(String name, String description, int health,	
			Item loot, ArrayList<Attack> attackList)
	{
		this.name = name;
		this.description = description;
		this.health = health;
		this.defeated = false;
		this.loot = loot;
		this.attackList = attackList;
	}
}
