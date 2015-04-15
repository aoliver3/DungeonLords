package gameSubsystem;
import java.io.*;
import java.util.ArrayList;

import roomMonsterPuzzle.Room;
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
	BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

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

	/**
	 * method to move the player to the next room in the dungeon,
	 * determines which room the player is currently in and
	 * advances them to the next room
	 */
	public void move()
	{
		int x = 0;
		for (Room r: gameDungeon.getDungeon())
		{
			x = x + 1;
			if (gameDungeon.getUser().getCurrentRoom().getName().equalsIgnoreCase(r.getName()))
			{
				//set players current room to next room in the array
				gameDungeon.getUser().setCurrentRoom(gameDungeon.getDungeon().get(x + 1));
			}
		}
		System.out.println("You have advanced to the " + gameDungeon.getUser().getCurrentRoom().getName());
		gameDungeon.getUser().getCurrentRoom().enter(gameDungeon);
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
			System.out.println("You feel fully rested. Your health is full.");
		}
		else
		{
			System.out.println("It's dark in here. To dangerous to rest.");
		}
	}

	/**
	 * method to allow a player to put an item in their inventory should
	 * they meet the puzzle solved or monster defeated requirements and
	 * said monster or puzzle contains a reward
	 */
	public void pickUp()
	{
		Item i = gameDungeon.getUser().getCurrentRoom().getReward();
		if (i != null)
		{
			gameDungeon.getUser().getPlayerInventory().addItem(i);
		} 
		else 
		{
			System.out.println("There's nothing to pick up.");
		}
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
			else
			{
				System.out.println("You don't have the item " + it);
			}
		}
	}

	public void throwItem()
	{
		System.out.println("You have thrown an item. Hope it wasn't important!");
	}

	/**
	 * method to allow a player to try and drop a selected
	 * item from their inventory, the method will display a
	 * return message if the item was dropped or not
	 * @param i item object
	 */
	public void drop(String i)
	{
		if (gameDungeon.getUser().getPlayerInventory().contains(i))
		{
			System.out.println("You have dropped " + i);
			gameDungeon.getUser().getPlayerInventory().getBag().remove(i);
		} else {
			System.out.println("You don't have any of those items");
		}
	}

	/**
	 * method that will determine if the players inventory contains
	 * the required item and if it does then it will use that item
	 * in the correct manner
	 * @param i item object
	 * @throws IOException 
	 */
	public void use() throws IOException
	{
		//check to see if bag has any items
		if (gameDungeon.getUser().getPlayerInventory().getBag().size() != 0)
		{
			//ask user which item to use
			System.out.println("What item would you like to use?");
			int numOfItems = 1;
			//display list of items
			for (Item i: gameDungeon.getUser().getPlayerInventory().getBag())
			{
				System.out.println(numOfItems + ": " +i.getName());
				numOfItems = numOfItems + 1;
			}
			String in = userInput.readLine();
			//check user input for valid index number
			try
			{
				int input = Integer.parseInt(in);
				
				if (input > numOfItems)
				{
					System.out.println("No such item exist.");
				}
				else if (gameDungeon.getUser().getPlayerInventory().getBag().get(input).getName().equalsIgnoreCase("health potion"))
				{
					gameDungeon.getUser().setCurrentHealth(gameDungeon.getUser().getCurrentHealth() + 75);
					System.out.println("You have used a health potion and regained 75 health.");
					gameDungeon.getUser().getPlayerInventory().getBag().remove(input);
				}
				else if (gameDungeon.getUser().getPlayerInventory().getBag().get(input).getName().equalsIgnoreCase("mana potion"))
				{
					gameDungeon.getUser().setPlayerMana(gameDungeon.getUser().getPlayerMana() + 75);
					System.out.println("You have used a mana potion and regained 75 mana.");
					gameDungeon.getUser().getPlayerInventory().getBag().remove(input);
				}
				else
				{
					System.out.println("This is not a useable item.");
				}
			}
			catch (Exception e)
			{
				System.out.println("No such item exist.");
			}
		}
		else
		{
			System.out.println("You don't have any items to use.");
		}
	}
}
