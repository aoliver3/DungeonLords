package roomMonsterPuzzle;

import java.util.ArrayList;

import GameDungeon.Player;
import Subsystem3.Item;


public class Room 
{
	String name;
	Monster roomMonster;
	Puzzle roomPuzzle;
	String description;
	ArrayList<Room> exits;
	boolean bonfire;

	public Room(String name, String description, ArrayList<Room> exits, boolean bonfire) 
	{
		this.name = name;
		this.roomMonster = null;
		this.roomPuzzle = null;
		this.description = description;
		this.exits = exits;
		this.bonfire = bonfire;
	}

	public void enter(Player p)
	{
		System.out.println(description);
		if(roomMonster!=null && !roomMonster.isDefeated())
		{
			new Battle(p, roomMonster);
		}
		if(roomPuzzle!=null && !roomPuzzle.isSolved())
		{
			//start puzzle
		}
	}
	
	public Item getReward()
	{
		if (roomMonster!=null)
		{
			return roomMonster.getLoot();
		}
		else if (roomPuzzle!=null)
		{
			return roomPuzzle.getReward();
		}
		else return null;
	}
	
	public boolean hasBonfire()
	{
		return bonfire;
	}
	
	public void useBonfire()
	{
		bonfire = false;
	}
	
	public void spawnMonster(Monster m)
	{
		this.roomMonster = m;
	}

	public void spawnPuzzle(Puzzle p)
	{
		this.roomPuzzle=p;
	}
	
	public String getName() 
	{
		return name;
	}

	public Monster getRoomMonster() {
		return roomMonster;
	}

	public Puzzle getRoomPuzzle() {
		return roomPuzzle;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<Room> getExits() {
		return exits;
	}
}
