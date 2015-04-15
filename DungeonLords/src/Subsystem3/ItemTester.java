
package Subsystem3;

import java.util.ArrayList;

/**Class: ItemTester
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class tests all the Item classes (Potion, Armor, Shield, SpellScroll, Weapon) by creating an object of each
 * and calling methods from the Inventory class.
 * 
 * Purpose: To make sure that the item classes are working correctly
 */
public class ItemTester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Inventory i = new Inventory ();
		Weapon w1 = new Weapon ("Knife", "sharp blade used for stabbing", 12, 1, 100);
		i.addItem(w1);
		
		
		Armor a1 = new Armor ("Iron Chest", "Silver Vest That Reflects Monster Damage", 12, 1, 50);
		i.addItem(a1);
		
		Shield s1 = new Shield ("Cardboard Box", "Box used to reflect attacks", 12, 50, 3, 3, 3);
		i.addItem(s1);
		
		Potion p1 = new Potion ("Health Potion", "Restores Health", 12, 2, 0, 75);
		i.addItem(p1);
		
		SpellScroll sp1 = new SpellScroll("Thunder Spell", "This spell casts a big thunderstorm and deals damage to everything in it's way", 1, 1, 50, "Deals 50 damage");
		i.addItem(sp1);
		
		System.out.println(i.getBag());
		
		i.setWeaponSlot(w1);
		i.setArmorSlot(a1);
		i.setShieldSlot(s1);
		
		System.out.println(i.getWeaponSlot());
		System.out.println(i.getArmorSlot());
		System.out.println(i.getShieldSlot());
		
		i.dropItem(w1);
		i.dropItem(a1);
		i.dropItem(s1);
		i.dropItem(p1);
		i.dropItem(sp1);
		
		System.out.println(i.getBag());

		System.out.println(i.inventoryFull());

	}

}
