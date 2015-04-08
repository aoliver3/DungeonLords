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
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Monster getRoomMonster()
	{
		return roomMonster;
	}

	public void setRoomMonster(Monster roomMonster)
	{
		this.roomMonster = roomMonster;
	}

	public Puzzle getRoomPuzzle()
	{
		return roomPuzzle;
	}

	public void setRoomPuzzle(Puzzle roomPuzzle)
	{
		this.roomPuzzle = roomPuzzle;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ArrayList<Room> getExits()
	{
		return exits;
	}

	public void setExits(ArrayList<Room> exits)
	{
		this.exits = exits;
	}

	public boolean isBonfire()
	{
		return bonfire;
	}

	public void setBonfire(boolean bonfire)
	{
		this.bonfire = bonfire;
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
