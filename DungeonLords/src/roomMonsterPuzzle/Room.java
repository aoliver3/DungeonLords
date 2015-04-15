package roomMonsterPuzzle;

import gameSubsystem.Game;
import gameSubsystem.Player;
import Subsystem3.Item;

public class Room 
{
	private String name;
	private Monster roomMonster;
	private Puzzle roomPuzzle;
	private String description;
	//private ArrayList<Room> exits;
	private boolean bonfire;

	/**
	 * default room constructor
	 * @param name
	 * @param description
	 * @param bonfire
	 */
	public Room(String name, String description,  boolean bonfire) 
	{
		this.name = name;
		this.roomMonster = null;
		this.roomPuzzle = null;
		this.description = description;
		//this.exits = exits;
		this.bonfire = bonfire;
	}

	/**
	 * method will be run whenever a player enters room and start a battle or puzzle depending on the rooms contents
	 * @param p
	 */
	public void enter(Game g)
	{
		System.out.println(description);
		if(roomMonster!=null && !roomMonster.isDefeated())
		{
			new Battle(g, roomMonster);
		}
		if(roomPuzzle!=null && !roomPuzzle.isSolved())
		{
			//start puzzle
		}
	}

	/**
	 * checks for a monster or puzzle and returns their reward if theyre defeated/solved
	 * @return
	 */
	public Item getReward()
	{
		if (roomMonster!=null)
		{
			System.out.println("You found a " + roomMonster.getLoot().getName());
			return roomMonster.getLoot();
		}
		else if (roomPuzzle!=null)
		{
			System.out.println("You found a " + roomPuzzle.getReward().getName()
					);
			return roomPuzzle.getReward();
		}
		else return null;
	}

	/**
	 * checks if room has a bonfire
	 * @return
	 */
	public boolean hasBonfire()
	{
		return bonfire;
	}

	/**
	 * uses the bonfire and sets its attribute to false
	 */
	public void useBonfire()
	{
		bonfire = false;
	}

	/**
	 * sets the room monster
	 * @param m
	 */
	public void spawnMonster(Monster m)
	{
		this.roomMonster = m;
	}

	/**
	 * sets the room puzzle
	 * @param p
	 */
	public void spawnPuzzle(Puzzle p)
	{
		this.roomPuzzle=p;
	}

	/**
	 * getter for room name
	 * @return
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * getter for room monster
	 * @return
	 */
	public Monster getRoomMonster() 
	{
		return roomMonster;
	}

	/**
	 * getter for room puzzle
	 * @return
	 */
	public Puzzle getRoomPuzzle() 
	{
		return roomPuzzle;
	}

	/**
	 * Getter for room description
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}
}
