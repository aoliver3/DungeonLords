
package Subsystem3;

/**Class: SpellScroll
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class creates SpellScrolls to be used by the Player in the game DungeonLords 
 * 
 * Purpose: The purpose of this class is to create SpellScroll objects that can be used by players
 */
public class Weapon extends Item
{
	// Instance Variable
	
	private int damage;
	
	
	//Constructors & Methods
	
	
	/**
	 * Constructs a weapon object
	 * @param name - name of the weapon
	 * @param description - description of the weapon
	 * @param limit - maximum amount of the weapon the user can have at one time
	 * @param quantity - how many of this particular weapon
	 * @param damage - the amount of damage this weapons deals to monsters
	 */
	public Weapon(String name, String description, int limit, int quantity,
			int damage)
	{
		super(name, description, limit, quantity);
		this.damage = damage;
	}

	/**
	 * @return the damage
	 */
	public int getDamage()
	{
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Weapon" + "[name=" + getName() + "]" + "[damage=" + damage + "]" + "[description=" + getDescription() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + damage;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (damage != other.damage)
			return false;
		return true;
	}
	
	

}
