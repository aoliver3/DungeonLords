package roomMonsterPuzzle;

public class Attack 
{
	String name;
	int damage;
	int cooldown;
	String description;

	/**
	 * default attack constructor
	 * @param name
	 * @param damage
	 * @param cooldown
	 * @param description
	 */
	public Attack(String name, int damage, int cooldown, String description)
	{
		this.name = name;
		this.damage = damage;
		this.cooldown = cooldown;
		this.description = description;
	}

	/**
	 * gets the attacks name
	 * @return
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * gets the attacks damage
	 * @return
	 */
	public int getDamage() 
	{
		return damage;
	}

	/**
	 * gets the attacks cooldown
	 * @return
	 */
	public int getCooldown() 
	{
		return cooldown;
	}

	/**
	 * gets the attacks description
	 * @return
	 */
	public String getDescription() 
	{
		return description;
	}
}
