package roomMonsterPuzzle;

import java.util.ArrayList;

public class RoomCreator 
{
	public ArrayList<Room> createRooms()
	{
		ArrayList<Room> r = new ArrayList<Room>();
		
		r.add(new Room("Entrance", "A small room with a stairway leading to a sealed door on one end and an open door on the other", true));
		r.add(new Room("Hallway", "Description", true));
		r.add(new Room("Fountain Room", "Description", true));
		r.add(new Room("Lab", "Description", true));
		r.add(new Room("Library", "Description", true));
		r.add(new Room("Trinket Room", "Description", true));
		r.add(new Room("Mausoleum", "Description", true));
		r.add(new Room("Lich's Lair", "Description", true));
		r.add(new Room("Ogre's Lair", "Description", true));
		r.add(new Room("Jester's Lair", "Description", true));
		r.add(new Room("Treasure Room", "Description", true));
		r.add(new Room("Dark Room", "Description", true));
		r.add(new Room("Sphinx's Chamber", "Description", true));
		r.add(new Room("Prison", "Description", true));
		r.add(new Room("Alter", "Description", true));
		r.add(new Room("Coin Puzzle Room", "Description", true));
		r.add(new Room("Math Puzzle Room", "Description", true));
		r.add(new Room("Sins Puzzle Room", "Description", true));
		r.add(new Room("Sacrifice Puzzle Room", "Description", true));
		r.add(new Room("Butchers Room", "Description", true));
		r.add(new Room("Horse Statue Room", "Description", true));
		r.add(new Room("Lion Statue Room", "Description", true));
		r.add(new Room("Dragon Statue Room", "Description", true));
		r.add(new Room("Knight Statue Room", "Description", true));
		r.add(new Room("Ruined Room", "Description", true));
		r.add(new Room("Dining Room", "Description", true));
		r.add(new Room("Pillar Room", "Description", true));
		r.add(new Room("Trophy Room", "Description", true));
		r.add(new Room("Grand Hall", "Description", true));
		r.add(new Room("Tapestry Room", "Room with many colorful tapestries on the wall", true));
		
		return r;
	}
}
