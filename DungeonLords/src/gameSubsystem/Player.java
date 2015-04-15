package gameSubsystem;
import roomMonsterPuzzle.Room;
import Subsystem3.Inventory;

/**Class: Player.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015
 *
 *
 * This class – This is the Player class object for the Dungeon Lords RPG
 *
 * Purpose: – This class holds all of the stats and attributes of game users
 */

public class Player
{
	private String playerName;  //player name
	private int currentHealth;  //player current health
	private int maxHealth;  //players max health
	private int playerMana;  //players current mana
	private int playaerDamage;  //players current damage
	private Inventory playerInventory;  //players inventory of items
	private Room currentRoom;  //the current room object the player resides in

	/**
	 * This method is the constructor for the Player object class
	 * @param playerName name of the player
	 */
	public Player(String playerName)
	{
		super();
		this.playerName = playerName;
		this.currentHealth = 150;
		this.maxHealth = 150;
		this.playerMana = 100;
		this.playaerDamage = 0;
		this.playerInventory = new Inventory();
		this.currentRoom = null;  //Entrance Room
	}

	/**
	 * method to access the player object name
	 * @return player name
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * method to mutate the player object name
	 * @param playerName player name
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	/**
	 * method to access the players current amount of mana available
	 * @return players current amount of mana available
	 */
	public int getPlayerMana()
	{
		return playerMana;
	}

	/**
	 * method to mutate the players current amount of mana available
	 * also checks to make sure the method does not set the players
	 * available amount of mana above 100
	 * @param mana amount of mana
	 */
	public void setPlayerMana(int mana)
	{
		if (mana > 100)
			this.playerMana = 100;
		else
			this.playerMana = mana;
	}

	/**
	 * method to access players current damage amount
	 * @return amount of players damage
	 */
	public int getPlayaerDamage()
	{
		return playaerDamage;
	}

	/**
	 * method to mutate the players current damage amount
	 * @param playaerDamage amount of players damage
	 */
	public void setPlayaerDamage(int playaerDamage)
	{
		this.playaerDamage = playaerDamage;
	}

	/**
	 * method to access the players inventory of items
	 * @return players inventory of items
	 */
	public Inventory getPlayerInventory()
	{
		return playerInventory;
	}

	/**
	 * method to access the players current room they are in
	 * @return players current room they are in
	 */
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	/**
	 * method to mutate the players current room they are in
	 * @param currentRoom Room object
	 */
	public void setCurrentRoom(Room currentRoom)
	{
		this.currentRoom = currentRoom;
	}

	/**
	 * method to access the players current amount of health
	 * @return players current amount of health
	 */
	public int getCurrentHealth()
	{
		return currentHealth;
	}

	/**
	 * method to mutate the players amount of current health
	 * also checks to make sure the players health
	 * does not exceed the players max amount of health
	 * @param health amount of health
	 */
	public void setCurrentHealth(int health)
	{
		if (health > maxHealth)
			currentHealth = maxHealth;
		else
			this.currentHealth = health;
	}

	/**
	 * method to access the players max amount of health
	 * @return players max amount of health
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}

	/**
	 * method to mutate the players max amount of health
	 * @param maxHealth max amount of health
	 */
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}

}
