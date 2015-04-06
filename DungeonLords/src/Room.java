import java.util.ArrayList;


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

	public void enter()
	{
		if(roomMonster!=null && !roomMonster.isDefeated())
		{
			//start Battle
		}
		if(roomPuzzle!=null && !roomPuzzle.isSolved())
		{
			//start puzzle
		}
		else
		{
			System.out.println(description);
		}
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
}
