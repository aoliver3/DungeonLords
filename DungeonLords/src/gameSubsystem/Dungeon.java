package gameSubsystem;
import java.io.Serializable;
import java.util.ArrayList;

import roomMonsterPuzzle.Room;

/**Class: Dungeon.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 1, 2015
 *
 *
 * This class � This class creates a Dungeon Object to house the current users game
 *
 * Purpose: � This class holds all of the pieces of each newly created game including
 * 			a player, the rooms, monsters, puzzles and items.
 */

public class Dungeon implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player user;  //the users player object
	private ArrayList<Room> dungeon;  //array list of the games rooms
	
	/**
	 * This is a constructor for the Dungeon class
	 * @param user player object
	 * @param dungeon array list of Room objects
	 */
	public Dungeon(Player user, ArrayList<Room> dungeon)
	{
		super();
		this.user = user;
		this.dungeon = dungeon;
		user.setCurrentRoom(dungeon.get(0));
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
		return dungeon;
	}

	/**
	 * mutates the dungeons array list of Room objects
	 * @param dungeon array list of Room objects
	 */
	public void setDungeon(ArrayList<Room> dungeon)
	{
		this.dungeon = dungeon;
	}

}
