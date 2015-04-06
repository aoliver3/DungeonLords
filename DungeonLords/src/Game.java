import java.util.ArrayList;

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
	private Dungeon gameDungeon;
	
	
	public void saveGame()
	{
		
	}
	
	public void loadGame()
	{
		
	}
	
	public String look()
	{
		
	}
	
	public void move()
	{
		
	}
	
	//check for = monster
	public void attack()
	{
		
	}
	
	//check for bonfire in Room
	public void rest()
	{
		if (gameDungeon.getUser().getCurrentRoom().hasBonfire() = true)
		{
			gameDungeon.getUser().setCurrentHealth(gameDungeon.getUser().getMaxHealth());
			gameDungeon.getUser().getCurrentRoom().useBonfire();
		}
		else
		{
			System.out.println("You can not rest without a bonfire present.");
		}
	}
	
	public void pickUp()
	{
		
	}
	
	public void equip()
	{
		if (gameDungeon.getUser().get)
	}
	
	public void use()
	{
		
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
}
