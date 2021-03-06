
package Subsystem3;

import java.util.ArrayList;

/**Class: Potion
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class creates Potions to be used by the Player in the game DungeonLords 
 * 
 * Purpose: The purpose of this class is to create potion objects that can be used by players
 */
public class Potion extends Item
{
	
	//Instance Variables
	
	private int manaRegen;
	private int healthRegen;
	
	//Constructors & Methods
	/**
	 * Constructs potion object
	 * @param name - name of the potion
	 * @param description - description of the potion
	 * @param limit - maximum amount of potions this user can have
	 * @param quantity - number of potions with the same name
	 * @param manaRegen - the amount of mana that this potion restores to the player
	 * @param healthRegen - the amount of health that this potion restores to the player
	 */
	public Potion(String name, String description, int limit, int quantity,
			int manaRegen, int healthRegen)
	{
		super(name, description, limit, quantity);
		this.manaRegen = manaRegen;
		this.healthRegen = healthRegen;
	}


	/**
	 * @return the manaRegen
	 */
	public int getManaRegen()
	{
		return manaRegen;
	}


	/**
	 * @return the healthRegen
	 */
	public int getHealthRegen()
	{
		return healthRegen;
	}


	/**
	 * @param manaRegen the manaRegen to set
	 */
	public void setManaRegen(int manaRegen)
	{
		this.manaRegen = manaRegen;
	}


	/**
	 * @param healthRegen the healthRegen to set
	 */
	public void setHealthRegen(int healthRegen)
	{
		this.healthRegen = healthRegen;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Potion [manaRegen=" + manaRegen + ", healthRegen="
				+ healthRegen + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + healthRegen;
		result = prime * result + manaRegen;
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
		Potion other = (Potion) obj;
		if (healthRegen != other.healthRegen)
			return false;
		if (manaRegen != other.manaRegen)
			return false;
		return true;
	}
	
	public static ArrayList<Potion> createPotions ()
	{
		Potion p1 = new Potion ("Health Potion", "Restores health points", 12, 1, 0, 75); // restores 75 health points
		Potion p2 = new Potion ("Mana Potion", "Restores mana points", 12, 1, 75, 0); // restores 75 mana points 
		Potion p3 = new Potion ("Potion of Solidarity", "Special Potion of solidarity", 12, 1, 0, 0); // freezes enemy for 2 turns
		Potion p4 = new Potion ("Beserk Potion", "Increase Attack Power", 12, 1, 0, 0); // increase player's attack by 25% for 3 turns
		
		ArrayList<Potion> potions = new ArrayList<Potion>();
		potions.add(p1);
		potions.add(p2);
		potions.add(p3);
		potions.add(p4);
		
		return potions;
	}

}
