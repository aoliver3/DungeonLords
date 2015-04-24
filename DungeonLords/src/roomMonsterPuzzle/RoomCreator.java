package roomMonsterPuzzle;

import java.util.ArrayList;

import Subsystem3.Potion;

public class RoomCreator 
{
	
	private static ArrayList<Puzzle> puzzles()
	{
		ArrayList<Puzzle> p = new ArrayList<Puzzle>();
		Potion pot = Potion.createPotions().get(0);
		
		p.add(new Puzzle("Darkness Puzzle", pot));
		p.add(new Puzzle("Sphinxs Riddle", pot));
		p.add(new Puzzle("Coin Puzzle", pot));
		p.add(new Puzzle("Sacrifice Puzzle", pot));
		p.add(new Puzzle("Math Puzzle", pot));
		p.add(new Puzzle("Sins Puzzle", pot));
		p.add(new Puzzle("Phoenix Puzzle", pot));
		
		return p;
	}
	
	private static ArrayList<Monster> monsters()
	{
		ArrayList<Potion> p = Potion.createPotions();
		ArrayList<Monster> m = new ArrayList<Monster>();
		m.add(new Monster("Skeleton", "description", 40, p.get(0), new Attack("Sword Strike", 8, 0, "The skeleton swings his sword at you!")));
		m.add(new Monster("Franken-Dog", "description", 50, p.get(0), new Attack("Swipe", 7, 0, "The Franken swipes at you with his claws!")));
		m.add(new Monster("Hound", "description", 40, p.get(0), new Attack("Bite", 7, 0, "The Hound lunges at you and bites you!")));
		m.add(new Monster("Archer", "description", 45, p.get(0), new Attack("Shoot", 8, 0, "The Archer takes aim and fires an arrow!")));
		m.add(new Monster("Troll", "description", 50, p.get(0), new Attack("Smash", 10, 0, "The Troll swings his large fist at you!")));

		return m;
	}
	
	public static ArrayList<Room> rooms()
	{
		ArrayList<Room> r = new ArrayList<Room>();
		ArrayList<Monster> m = monsters();
		ArrayList<Puzzle> p = puzzles();
		r.add(new Room("Entrance", "A small room with a stairway leading to a sealed door on one end and an open door on the other", true));
		r.add(new Room("Pillar Room", "a room with a large pillar in the middle that has a ring of torches near its top ", true));
		r.add(new Room("Hallway", "A narrow hallway with a small fire", true));
		r.add(new Room("Fountain Room", "an open room with a dried up fountain in the middle", true));
		r.add(new Room("Library", "a large room filled with book cases, although most of the books are spread about on the floor", true));
		r.add(new Room("Trinket Room", "a small room filled with many broken trinkets", true));
		r.add(new Room("Tapestry Room", "Room with many colorful tapestries on the wall", true));
		r.add(new Room("Lab", "a dark room that appears to be home to countless twisted experiments", true));
		r.add(new Room("Lich's Lair", "Description", true));
		r.add(new Room("Mausoleum", "a room full of coffins, some even have old skeletons in them", true));
		r.add(new Room("Dark Room", "an empty room with a few levers on the wall", true));
		r.add(new Room("Sphinx's Chamber", "a room that feels oddly empty now that the statue has vanished", true));
		r.add(new Room("Prison", "a hallway lined with cells on both sides, all full of prisoners, no longer living of course", true));
		r.add(new Room("Alter", "a small room with an alter sitting in front of a fire", true));
		r.add(new Room("Coin Puzzle Room", "Description", true));
		r.add(new Room("Math Puzzle Room", "a room with an odd mechanism on the wall, but otherwise empty", true));
		r.add(new Room("Sins Puzzle Room", "an empty room with an eery pressence in the air", true));
		r.add(new Room("Sacrifice Puzzle Room", "a large room with a deep well in the middle that seems to have no bottom", true));
		r.add(new Room("Ogre's Lair", "Description", true));
		r.add(new Room("Butchers Room", "a room with blood stained walls and tools covered in dried blood", true));
		r.add(new Room("Horse Statue Room", "an empty room with a large horse statue in the middle", true));
		r.add(new Room("Lion Statue Room", "an empty room with a large lion statue in the middle", true));
		r.add(new Room("Dragon Statue Room", "an empty room with a large dragon statue in the middle", true));
		r.add(new Room("Knight Statue Room", "an empty room with a large knight statue in the middle", true));
		r.add(new Room("Ruined Room", "a room full of crumbling pillars and cracked walls", true));
		r.add(new Room("Dining Room", "a large room with a long table set for a feast, but with no food in sight", true));
		r.add(new Room("Trophy Room", "The room is filled with a large number of taxidermyed animals", true));
		r.add(new Room("Jester's Lair", "Description", true));
		r.add(new Room("Grand Hall", "The room is full of elaborate decorations and a monstorous gilded door at the opposite end", true));
		r.add(new Room("Treasure Room", "Congratulations you have reached the treasure room! You are now rich beyond your wildest dreams!", true));

		return r;
	}
}
