
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
	 * useItem - this method is for spells & potions only. Each potion/spell does different things depending on which one the player wants to use
	 * @param i - the item the user wants to use
	 */
	
	public void useItem (Item i)
	{
		if (i instanceof Potion && i.getName().equalsIgnoreCase("Health Potion"));
		{
			Player.setHealth(health + 75);
			System.out.println("You have just used a Health Potion, your health is now " + Player.getHealth());
			bag.remove(i);
		}
		
		if (i instanceof Potion && i.getName().equalsIgnoreCase("Mana Potion"));
		{
			Player.setMana(mana + 75);
			System.out.println("You have just used a Mana Potion, your mana is now " + Player.getMana());
			bag.remove(i);
		}
		
		if (i instanceof Potion && i.getName().equalsIgnoreCase("Potion of Solidarity"));
		{
			// freeze enemy for two turns
			System.out.println("You have just used the Potion of Solidarity, this monster cannot attack for 2 turns");
			bag.remove(i);
		}
		
		if (i instanceof Potion && i.getName().equalsIgnoreCase("Berserk Potion"));
		{
			//multiply user's damage by 25% for 3 turns, can only be used in combat
			Player.setDamage(damage * 0.25);
			System.out.println("You have just used a Bersek Potion, your damage will be multipled by 25% for 3 turns");
			bag.remove(i);
		}
		
		if (i instanceof SpellScroll && i.getName().equalsIgnoreCase("Acid Cloud"));
		{
			Player.setMana(mana - 20);
			// 20 mana. Does 0 damage to the target on cast, but inflicts the target wit 
			// DoT effect that passively inflicts 8 damage per turn for 3 turns.
			System.out.println("You have just used the Acid Cloud spell, this monster will lose 8 health points per turn for 3 turns");
			bag.remove(i);
		}
		
		if (i instanceof SpellScroll && i.getName().equalsIgnoreCase("Sonic Boom"));
		{
			Player.setMana(mana - 20);
			//Does 12 damage to target on cast, but stuns them, leaving them
			//unable to attack on their next move. Start with this spell.
			System.out.println("You have just used the Sonic Boom spell, this monster has lost 12 health points and is unable to attack on their next move");
			bag.remove(i);
		}
		
		if (i instanceof SpellScroll && i.getName().equalsIgnoreCase("Flood"));
		{
			Player.setMana(mana - 50);
			
			//Instantly kills whatever enemy is in the room, excluding bosses, to whom
			//it simply does a heavy 40 damage.
			System.out.println("You have used the Flood spell, this monster is now dead");
			bag.remove(i);
		}
		
		if (i instanceof SpellScroll && i.getName().equalsIgnoreCase("Spark"));
		{
			Player.setMana(mana - 10);
			// Lights up a dark room used for a puzzle
			System.out.println("You have used the Spark spell, you can now see in this room");
			bag.remove(i);
		}
		
		if (i instanceof SpellScroll && i.getName().equalsIgnoreCase("Fodder"));
		{
			Player.setMana(mana - 20);
			// Summons a rain of magical arrows, dealing 15 damage. Always hits first
			Monster.setHealth(health - 15);
			System.out.println("You have used the Fodder spell, this monster has lost 15 health points");
			bag.remove(i);
		}
		
		if (i instanceof SpellScroll && i.getName().equalsIgnoreCase("Fireball"));
		{
			Player.setMana(mana - 20);
			// Throws a fireball at a target, dealing 18 damage. Start with this spell
			Monster.setHealth(health - 18);
			bag.remove(i);
		}
	}
	
	/**
	 * equipItem - this method equips an item from a players bag to a players current item slot depending on what type of item it is.
	 * @param i - the item to be equipped
	 */
	
	public void equipItem (Item i)
	{
		if (i instanceof Weapon)
		{
			setWeaponSlot((Weapon) i);
			bag.remove(i);
		}
		
		if (i instanceof Armor)
		{
			setArmorSlot((Armor) i);
			bag.remove(i);
		}
		
		if (i instanceof Shield)
		{
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
