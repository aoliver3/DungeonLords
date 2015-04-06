import java.util.ArrayList;

/**Class: Dungeon.java
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

public class Dungeon
{
	private Player user;
	private ArrayList<Room> Dungeon;
	
	public Dungeon(Player user, ArrayList<Room> dungeon)
	{
		super();
		this.user = user;
		this.Dungeon = dungeon;
	}

	public Player getUser()
	{
		return user;
	}

	public void setUser(Player user)
	{
		this.user = user;
	}

	public ArrayList<Room> getDungeon()
	{
		return Dungeon;
	}

	public void setDungeon(ArrayList<Room> dungeon)
	{
		Dungeon = dungeon;
	}

}
