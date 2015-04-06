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
	private int currentHealth;
	private int maxHealth:
	private int playerMana;
	private int playaerDamage;
	private Inventory playerInventory;
	private Room currentRoom;
	
	public Player(String playerName, Inventory playerInventory)
	{
		super();
		this.playerName = playerName;
		this.currentHealth = 150;
		this.maxHealth = 150;
		this.playerMana = 100;
		this.playaerDamage = 0;
		this.playerInventory = playerInventory;
		this.currentRoom = null;  //Entrance Room
	}

	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
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

	public Room getCurrentRoom()
	{
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom)
	{
		this.currentRoom = currentRoom;
	}

	public int getCurrentHealth()
	{
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
}
