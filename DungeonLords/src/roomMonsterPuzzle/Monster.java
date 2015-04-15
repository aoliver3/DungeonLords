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

	/**
	 * Default Monster Constructor
	 * @param name
	 * @param description
	 * @param health
	 * @param loot
	 * @param attack
	 */
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

	/**
	 * returns if the monster has been defeated or not
	 * @return
	 */
	public boolean isDefeated()
	{
		return defeated;
	}

	/**
	 * Will be used in the battle class, sets defeated to true
	 */
	public void die()
	{
		defeated=true;
	}

	/**
	 * used in battle class, monster takes damage and dies if it goes below zero hp
	 * @param dmg
	 * @return
	 */
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

	/**
	 * sops a notification of the attack, and returns the damage done.
	 * @return
	 */
	public int attack()
	{

		System.out.println(name+ " uses " + attack.getName() + ", " + attack.getDescription());
		return attack.getDamage();
	}

	/**
	 * Getter for monster name
	 * @return
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * getter for monster description
	 * @return
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * getter for monster health
	 * @return
	 */
	public int getHealth() 
	{
		return health;
	}

	/**
	 * getter for monster loot, returns null if monster hasnt been defeated
	 * @return
	 */
	public Item getLoot() 
	{
		if(defeated)
		{
			return loot;
		}
		else return null;
	}

	/**
	 * getter for monster attack
	 * @return
	 */
	public Attack getAttack()
	{
		return attack;
	}

}
