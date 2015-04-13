package roomMonsterPuzzle;
import Subsystem3.*;

public class Monster 
{
	String name;
	String description;
	int health;
	boolean defeated;
	Item loot;
	Attack attack;

	public Monster(String name, String description, int health,	
			Item loot, Attack attack)
	{
		this.name = name;
		this.description = description;
		this.health = health;
		this.defeated = false;
		this.loot = loot;
		this.attack = attack;
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
			return 0;
		}
		else return health;
	}

	public int attack()
	{

		System.out.println(name+ " uses " + attack.getName() + ", " + attack.getDescription());
		return attack.getDamage();
	}

	public String getName() 
	{
		return name;
	}

	public String getDescription() 
	{
		return description;
	}

	public int getHealth() 
	{
		return health;
	}

	public Item getLoot() 
	{
		if(defeated)
		{
			return loot;
		}
		else return null;
	}

	public Attack getAttack()
	{
		return attack;
	}

}
