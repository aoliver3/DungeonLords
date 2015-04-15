package gameSubsystem;
import java.util.ArrayList;

/**Class: Dungeon.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015
 *
 *
 * This class – This class creates a Dungeon Object to house the current users game
 *
 * Purpose: – This class holds all of the pieces of each newly created game including
 * 			a player, the rooms, monsters, puzzles and items.
 */

public class Dungeon
{
	private Player user;  //the users player object
	private ArrayList<Room> Dungeon;  //array list of the games rooms
	
	/**
	 * This is a constructor for the Dungeon class
	 * @param user player object
	 * @param dungeon array list of Room objects
	 */
	public Dungeon(Player user, ArrayList<Room> dungeon)
	{
		super();
		this.user = user;
		this.Dungeon = dungeon;
	}

	/**
	 * accesses the dungeons Player object
	 * @return Player object
	 */
	public Player getUser()
	{
		return user;
	}

	/**
	 * mutates the the dungeons Player object
	 * @param user Player object
	 */
	public void setUser(Player user)
	{
		this.user = user;
	}

	/**
	 * accesses the dungeons array list of rooms
	 * @return array list of Room objects
	 */
	public ArrayList<Room> getDungeon()
	{
		return Dungeon;
	}

	/**
	 * mutates the dungeons array list of Room objects
	 * @param dungeon array list of Room objects
	 */
	public void setDungeon(ArrayList<Room> dungeon)
	{
		Dungeon = dungeon;
	}

}
