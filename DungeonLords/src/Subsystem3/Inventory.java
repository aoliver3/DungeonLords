
package Subsystem3;

import java.util.ArrayList;

/**Class: Inventory
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class creates an inventory object for each player in the game DungeonLords
 * 
 * Purpose: The purpose of this class is to store items the user obtains during their progress of DungeonLords
 */
public class Inventory
{
	// Instance Variables
	private Weapon weaponSlot;
	private Armor armorSlot;
	private Shield shieldSlot;
	private ArrayList<Item> bag;
	
	// Constructors & Methods
	
	/**
	 * Constructs an Inventory object
	 * @param weaponSlot - current weapon equipped used by the user
	 * @param armorSlot - current armor equipped by the user
	 * @param shieldSlot - current shield equipped by the user
	 * @param bag - items currently not being used by the user
	 */
	public Inventory(Weapon weaponSlot, Armor armorSlot, Shield shieldSlot,
			ArrayList<Item> bag)
	{
		super();
		this.weaponSlot = weaponSlot;
		this.armorSlot = armorSlot;
		this.shieldSlot = shieldSlot;
		this.bag = bag;
	}
	
	/**
	 * Constructs an Inventory object
	 */
	public Inventory()
	{
		this.weaponSlot = null;
		this.armorSlot = null;
		this.shieldSlot = null;
		bag = new ArrayList<Item>();
	}
	
	/**
	 * dropItem - this method removes an item from the player's inventory
	 * @param i - item to be removed
	 */
	public void dropItem (Item i)
	{
		bag.remove(i);
		System.out.println("You have dropped " + i.getName());
	}
	
	
	
	/**
	 * equipItem - this method equips an item from a players bag to a players current item slot depending on what type of item it is.
	 * @param i - the item to be equipped
	 */
	
	public void equipItem (Item i)
	{
		if (i instanceof Weapon)
		{
			bag.add(getWeaponSlot());
			setWeaponSlot((Weapon) i);
			bag.remove(i);
		}
		
		if (i instanceof Armor)
		{
			bag.add(getArmorSlot());
			setArmorSlot((Armor) i);
			bag.remove(i);
		}
		
		if (i instanceof Shield)
		{
			bag.add(getShieldSlot());
			setShieldSlot((Shield) i);
			bag.remove(i);
		}
		
	}
	
	/**
	 * inventoryFull - checks to see if the user's inventory is full
	 * @return true if the user has 12 or more items
	 */
	
	public boolean inventoryFull()
	{
		if (bag.size()==12)
		{
			return true;
		}
		else
			
		return false;
		
	}
	

	/**
	 * addItem - adds an item to the user's inventory
	 * @param i - the item to be added
	 */
	public void addItem (Item i)
	{
		
		// check to see if inventory is full before adding item
		if (inventoryFull()==false)
		{
			bag.add(i);
			System.out.println("You have added a " + i.getName() + " to your inventory ");
		}
		
		else
			
		{
			System.out.println("Your inventory is full, you must drop an item before adding another");
		}
	}

	/**
	 * @return the weaponSlot
	 */
	public Weapon getWeaponSlot()
	{
		return weaponSlot;
	}

	/**
	 * @return the armorSlot
	 */
	public Armor getArmorSlot()
	{
		return armorSlot;
	}

	/**
	 * @return the shieldSlot
	 */
	public Shield getShieldSlot()
	{
		return shieldSlot;
	}

	/**
	 * @return the bag
	 */
	public ArrayList<Item> getBag()
	{
		return bag;
	}

	/**
	 * @param weaponSlot the weaponSlot to set
	 */
	public void setWeaponSlot(Weapon weaponSlot)
	{
		this.weaponSlot = weaponSlot;
	}

	/**
	 * @param armorSlot the armorSlot to set
	 */
	public void setArmorSlot(Armor armorSlot)
	{
		this.armorSlot = armorSlot;
	}

	/**
	 * @param shieldSlot the shieldSlot to set
	 */
	public void setShieldSlot(Shield shieldSlot)
	{
		this.shieldSlot = shieldSlot;
	}

	/**
	 * @param bag the bag to set
	 */
	public void setBag(ArrayList<Item> bag)
	{
		this.bag = bag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Inventory [weaponSlot=" + weaponSlot + ", armorSlot="
				+ armorSlot + ", shieldSlot=" + shieldSlot + ", bag=" + bag
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((armorSlot == null) ? 0 : armorSlot.hashCode());
		result = prime * result + ((bag == null) ? 0 : bag.hashCode());
		result = prime * result
				+ ((shieldSlot == null) ? 0 : shieldSlot.hashCode());
		result = prime * result
				+ ((weaponSlot == null) ? 0 : weaponSlot.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (armorSlot == null)
		{
			if (other.armorSlot != null)
				return false;
		} else if (!armorSlot.equals(other.armorSlot))
			return false;
		if (bag == null)
		{
			if (other.bag != null)
				return false;
		} else if (!bag.equals(other.bag))
			return false;
		if (shieldSlot == null)
		{
			if (other.shieldSlot != null)
				return false;
		} else if (!shieldSlot.equals(other.shieldSlot))
			return false;
		if (weaponSlot == null)
		{
			if (other.weaponSlot != null)
				return false;
		} else if (!weaponSlot.equals(other.weaponSlot))
			return false;
		return true;
	}
	
	
	
}
