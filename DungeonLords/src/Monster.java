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
	
	public boolean isDefeated()
	{
		return defeated;
	}
	
	public void die()
	{
		defeated=false;
	}
	
	public int takeDamage(int dmg)
	{
		health= health-dmg;
		if(health<=0)
		{
			die();
			return 0;		}
		else return health;
	}
	
	public int attack(int i)
	{
		Attack act = attackList.get(i);
		System.out.println(name+ " uses " + act.getName() + ", " + act.getDescription());
		return act.getDamage();
	}
}
