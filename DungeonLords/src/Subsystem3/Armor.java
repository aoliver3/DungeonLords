package Subsystem3;

/**Class: Armor
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class creates Armor objects for users to be used in the game DungeonLords and stored in the user's inventory
 * 
 * Purpose: The purpose of this class is to create armor that can be used in game by the player.
 */
public class Armor extends Item
{
	// Instance Variables
	
	private int bonusHP;
	
	//Constructors & Methods
	/**
	 * Constructs an Armor object
	 * @param name - name of the armor object
	 * @param description - description of the armor object
	 * @param limit - the maxmimum amount a user can hold of this item
	 * @param quantity - how many armor objects the user has with the same name
	 * @param bonusHP - the amount of bonus health points the user gains from equipping this armor
	 */

	public Armor(String name, String description, int limit, int quantity,
			int bonusHP)
	{
		super(name, description, limit, quantity);
		this.bonusHP = bonusHP;
	}
	

	/**
	 * @return the bonusHP
	 */
	public int getBonusHP()
	{
		return bonusHP;
	}

	/**
	 * @param bonusHP the bonusHP to set
	 */
	public void setBonusHP(int bonusHP)
	{
		this.bonusHP = bonusHP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Armor" + "[name=" + getName() + "]" + "[bonusHP=" + bonusHP + "]" + "[description=" + getDescription() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bonusHP;
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
		Armor other = (Armor) obj;
		if (bonusHP != other.bonusHP)
			return false;
		return true;
	}
	
	

}
