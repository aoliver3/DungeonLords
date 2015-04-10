import java.io.*;
import java.util.ArrayList;

import Subsystem3.Item;
import Subsystem3.Potion;
import Subsystem3.SpellScroll;

/**Class: Game.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class
 */

public class Game
{
	private Dungeon gameDungeon;  //the player and his dungeon

	/**
	 * constructor method to create a new game class
	 * @param gameDungeon dungeon containing player and rooms
	 */
	public Game(Dungeon gameDungeon)
	{
		super();
		this.gameDungeon = gameDungeon;
	}

	/**
	 * method to access the game dungeon object
	 * @return
	 */
	public Dungeon getGameDungeon()
	{
		return gameDungeon;
	}

	/**
	 * method to set the game dungeon object
	 * @param gameDungeon
	 */
	public void setGameDungeon(Dungeon gameDungeon)
	{
		this.gameDungeon = gameDungeon;
	}

	/**
	 * method to save the current players progress in the dungeon
	 * @throws IOException input/output exception
	 */
	public void saveGame() throws IOException
	{
		File savedPlayers = new File("SavedPlayers");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(savedPlayers));
		try
		{
			out.writeObject(gameDungeon);
		}
		finally
		{
			out.close();
		}
	}

	/**
	 * method to load a saved players previous game
	 * @throws IOException input/output exception
	 * @throws ClassNotFoundException class not found exception
	 */
	public void loadGame() throws IOException, ClassNotFoundException
	{
		File savedPlayers = new File("SavedPlayers");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(savedPlayers));
		try
		{
			setGameDungeon((Dungeon) in.readObject());
		}
		finally
		{
			in.close();
		}
	}

	/**
	 * method to display the description of the players current room
	 */
	public void look()
	{
		System.out.println(gameDungeon.getUser().getCurrentRoom().getDescription());
	}

	public void move()
	{

	}

	public void attack()
	{
		//get player damagae
		//get monsters health
		//monsters health - player damage
	}

	/**
	 * method to allow a player to check for a bonfire in their current room.
	 * if a bonfire is present then this method will set the players current
	 * health to their maximum health value
	 */
	public void rest()
	{
		if (gameDungeon.getUser().getCurrentRoom().hasBonfire() == true)
		{
			gameDungeon.getUser().setCurrentHealth(gameDungeon.getUser().getMaxHealth());
			gameDungeon.getUser().getCurrentRoom().useBonfire();
		}
		else
		{
			System.out.println("You can not rest without a bonfire present.");
		}
	}

	/**
	 * method to allow a player to put an item in their inventory should
	 * they meet the puzzle solved or monster defeated requirements and
	 * said monster or puzzle contains a reward
	 */
	public void pickUp()
	{
		gameDungeon.getUser().getPlayerInventory().addItem(gameDungeon.getUser().getCurrentRoom().getReward());
	}

	/**
	 * method that will check if the player has the required item in their
	 * inventory. if they do then they will equip this item and gain its
	 * equipped attributes
	 * @param it
	 */
	public void equip(String it)
	{
		ArrayList<Item> bag = gameDungeon.getUser().getPlayerInventory().getBag();
		
		for (Item i: bag)
		{
			if (i.getName().equalsIgnoreCase(it))
			{
				gameDungeon.getUser().getPlayerInventory().equipItem(i);
				System.out.println("You have equiped the " + i.getName());
			}
			
		}
		
		
		//if (gameDungeon.getUser().getPlayerInventory().bag.contains((Item) i))
	}

	public void flee()
	{

	}

	public void solve()
	{

	}

	public void throwItem()
	{

	}

	public void drop()
	{

	}
	
	/**
	 * method that will determine if the players inventory contains
	 * the required item and if it does then it will use that item
	 * in the correct manner
	 * @param i item object
	 */
	public void use(Item i)
	{
		Player p = gameDungeon.getUser();
		if (i instanceof Potion && i.getName()=="Health Potion");
		{
			p.setCurrentHealth(p.getCurrentHealth() + 75);
			System.out.println("You have just used a Health Potion, your health is now " + p.getCurrentHealth());
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof Potion && i.getName()=="Mana Potion");
		{
			p.setPlayerMana(p.getPlayerMana() + 75);
			System.out.println("You have just used a Mana Potion, your mana is now " + p.getPlayerMana());
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof Potion && i.getName()=="Potion of Solidarity");
		{
			// freeze enemy for two turns
			System.out.println("You have just used the Potion of Solidarity, this monster cannot attack for 2 turns");
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof Potion && i.getName()=="Berserk Potion");
		{
			//multiply user's damage by 25% for 3 turns, can only be used in combat
			p.setPlayaerDamage((int)(p.getPlayaerDamage() * 1.25));
			System.out.println("You have just used a Bersek Potion, your damage will be multipled by 25% for 3 turns");
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof SpellScroll && i.getName()=="Acid Cloud");
		{
			p.setPlayerMana(p.getPlayerMana() - 20);
			// 20 mana. Does 0 damage to the target on cast, but inflicts the target wit 
			// DoT effect that passively inflicts 8 damage per turn for 3 turns.
			System.out.println("You have just used the Acid Cloud spell, this monster will lose 8 health points per turn for 3 turns");
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof SpellScroll && i.getName()=="Sonic Boom");
		{
			p.setPlayerMana(p.getPlayerMana() - 20);
			//Does 12 damage to target on cast, but stuns them, leaving them
			//unable to attack on their next move. Start with this spell.
			System.out.println("You have just used the Sonic Boom spell, this monster has lost 12 health points and is unable to attack on their next move");
			p.getPlayerInventory().dropItem(i);;
		}

		if (i instanceof SpellScroll && i.getName()=="Flood");
		{
			p.setPlayerMana(p.getPlayerMana() - 50);

			//Instantly kills whatever enemy is in the room, excluding bosses, to whom
			//it simply does a heavy 40 damage.
			System.out.println("You have used the Flood spell, this monster is now dead");
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof SpellScroll && i.getName()=="Spark");
		{
			p.setPlayerMana(p.getPlayerMana() - 10);
			// Lights up a dark room used for a puzzle
			System.out.println("You have used the Spark spell, you can now see in this room");
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof SpellScroll && i.getName()=="Fodder");
		{
			p.setPlayerMana(p.getPlayerMana() - 20);
			// Summons a rain of magical arrows, dealing 15 damage. Always hits first
			Monster.setHealth(health - 15);
			System.out.println("You have used the Fodder spell, this monster has lost 15 health points");
			p.getPlayerInventory().dropItem(i);
		}

		if (i instanceof SpellScroll && i.getName()=="Fireball");
		{
			p.setPlayerMana(p.getPlayerMana() - 20);
			// Throws a fireball at a target, dealing 18 damage. Start with this spell
			Monster.setHealth(health - 18);
			p.getPlayerInventory().dropItem(i);;
		}
	}
}
