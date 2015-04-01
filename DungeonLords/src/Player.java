/**Class: Player.java
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

public class Player
{
	private String playerName;
	private int playerHealth;
	private int playerMana;
	private int playaerDamage;
	private Inventory playerInventory;
	private Room currentRoom;
	
	public Player(String playerName, Inventory playerInventory)
	{
		super();
		this.playerName = playerName;
		this.playerHealth = 150;
		this.playerMana = 100;
		this.playaerDamage = 0;
		this.playerInventory = playerInventory;
		this.currentRoom = null;  //Entrance Room
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public int getPlayerHealth()
	{
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth)
	{
		this.playerHealth = playerHealth;
	}

	public int getPlayerMana()
	{
		return playerMana;
	}

	public void setPlayerMana(int playerMana)
	{
		this.playerMana = playerMana;
	}

	public int getPlayaerDamage()
	{
		return playaerDamage;
	}

	public void setPlayaerDamage(int playaerDamage)
	{
		this.playaerDamage = playaerDamage;
	}

	public Inventory getPlayerInventory()
	{
		return playerInventory;
	}
	
	/**
	 * sets the newly created players current location to the Entrance Room
	 */
	public void setStartingRoom()
	{
		
	}
	
}
