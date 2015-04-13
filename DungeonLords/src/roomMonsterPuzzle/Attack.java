package roomMonsterPuzzle;

public class Attack 
{
	String name;
	int damage;
	int cooldown;
	String description;
	
	public Attack(String name, int damage, int cooldown, String description)
	{
		this.name = name;
		this.damage = damage;
		this.cooldown = cooldown;
		this.description = description;
	}

	public String getName() 
	{
		return name;
	}

	public int getDamage() 
	{
		return damage;
	}

	public int getCooldown() 
	{
		return cooldown;
	}

	public String getDescription() 
	{
		return description;
	}
	
	
}
