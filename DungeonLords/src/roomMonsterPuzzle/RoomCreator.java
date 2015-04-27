package roomMonsterPuzzle;

import java.util.ArrayList;

import Subsystem3.Armor;
import Subsystem3.Potion;
import Subsystem3.Shield;
import Subsystem3.Weapon;

public class RoomCreator 
{

	private static ArrayList<Puzzle> puzzles()
	{
		ArrayList<Weapon> w = Weapon.createWeapons();
		ArrayList<Shield> s = Shield.createShields();
		Potion pot = Potion.createPotions().get(0);
		
		ArrayList<Puzzle> p = new ArrayList<Puzzle>();

		p.add(new Puzzle("Darkness Puzzle", pot));//6
		p.add(new Puzzle("Sphinxs Riddle", pot));//4
		p.add(new Puzzle("Coin Puzzle", s.get(1)));//5
		p.add(new Puzzle("Sacrifice Puzzle", w.get(3)));//7
		p.add(new Puzzle("Math Puzzle", pot));//2
		p.add(new Puzzle("Sins Puzzle", s.get(2)));//3
		p.add(new Puzzle("Phoenix Puzzle", null));//1

		return p;
	}

	private static ArrayList<Monster> monsters()
	{
		ArrayList<Potion> p = Potion.createPotions();
		ArrayList<Weapon> w = Weapon.createWeapons();
		ArrayList<Armor> a = Armor.createArmors();
		ArrayList<Monster> m = new ArrayList<Monster>();
		
		m.add(new Monster("Skeleton", "A skeleton stumbles out of a coffin and charges at you!", 40, a.get(1), new Attack("Sword Strike", 8, 0, "The skeleton swings his sword at you!")));//5
		m.add(new Monster("Franken-Dog", "A monstrosity of stiched corpses notices you and comes chasing!", 50, p.get(0), new Attack("Swipe", 7, 0, "The Franken swipes at you with his claws!")));//1
		m.add(new Monster("Hound", "A snarling mangy dog jumps up to protect his collection of bones!", 40, a.get(2), new Attack("Bite", 7, 0, "The Hound lunges at you and bites you!")));//2
		m.add(new Monster("Archer", "You see someone sneaking around in the shadows, suddenly a man jumps out and aims his bow at you!", 45, w.get(1), new Attack("Shoot", 8, 0, "The Archer takes aim and fires an arrow!")));//4
		m.add(new Monster("Troll", "A large disfigured, almost human like, creature becomes enraged at the sight of you and attacks!", 50, w.get(2), new Attack("Smash", 10, 0, "The Troll swings his large fist at you!")));//3
		m.add(new Monster("Ozzy the Ogre", "A huge ogre is sitting in the middle of the room napping, you try to sneak past but step on an old bone. The loud snap immeaditly awakens and angers the ogre!", 200, p.get(0), new Attack("Pound", 10, 0, "Ozzy smashes down on you with a clinched fist!")));//3
		m.add(new Monster("Vile Lich Varnoth", "You see the shadow of a hobbled old man project from behind some pillars, but as he emerges he takes the shape of an undead sorceror!", 120, p.get(0), new Attack("Smite", 10, 0, "Varnoth casts a dark bolt at you!")));//3
		m.add(new Monster("Demon Jester Shaco", "The room is perfectly silent apart from a maniacle laugh that seems to be getting closer, when suddenly a demonic jester jumps from the ceiling and attacks!", 140, p.get(0), new Attack("Backstab", 15, 0, "Shaco fades into the shadows then strikes you from behind!")));//3

		
		return m;
	}

	public static ArrayList<Room> rooms()
	{
		ArrayList<Room> r = new ArrayList<Room>();
		ArrayList<Monster> m = monsters();
		ArrayList<Puzzle> p = puzzles();

		r.add(new Room("Entrance", "A small room with a stairway leading to a sealed door on one end and an open door on the other", true));
		r.add(new Room("Hallway", "A narrow hallway with a small fire", true));
		r.add(new Room("Pillar Room", "a room with a large pillar in the middle that has a ring of torches near its top ", true));
		r.get(2).spawnPuzzle(p.get(6));
		r.add(new Room("Math Puzzle Room", "a room with an odd mechanism on the wall, but otherwise empty", false));
		r.get(3).spawnPuzzle(p.get(4));
		r.add(new Room("Fountain Room", "an open room with a dried up fountain in the middle", false));
		r.get(4).spawnMonster(m.get(3));
		r.add(new Room("Library", "a large room filled with book cases, although most of the books are spread about on the floor", false));
		r.add(new Room("Trinket Room", "a small room filled with many broken trinkets", false));
		r.add(new Room("Lab", "a dark room that appears to be home to countless twisted experiments", false));
		r.get(7).spawnMonster(m.get(1));
		r.add(new Room("Lich's Lair", "Description", true));
		r.get(8).spawnMonster(m.get(6));
		r.add(new Room("Sphinx's Chamber", "a room that is strangely empty now that the statue has vanished", false));
		r.get(9).spawnPuzzle(p.get(1));
		r.add(new Room("Alter", "a small room with an alter sitting in front of a fire", false));
		r.add(new Room("Mausoleum", "a room full of coffins, some even have old skeletons in them", false));
		r.get(11).spawnMonster(m.get(2));
		r.add(new Room("Prison", "a hallway lined with cells on both sides, all full of prisoners, no longer living of course", false));
		r.add(new Room("Coin Puzzle Room", "Description", false));
		r.get(13).spawnPuzzle(p.get(2));
		r.add(new Room("Tapestry Room", "Room with many colorful tapestries on the wall", true));
		r.add(new Room("Trophy Room", "The room is filled with a large number of taxidermyed animals", false));
		r.add(new Room("Ruined Room", "a room full of crumbling pillars and cracked walls", false));
		r.get(16).spawnMonster(m.get(4));
		r.add(new Room("Ogre's Lair", "Description", true));
		r.get(17).spawnMonster(m.get(5));
		r.add(new Room("Dark Room", "an empty room with a few levers on the wall", false));
		r.get(18).spawnPuzzle(p.get(1));
		r.add(new Room("Horse Statue Room", "an empty room with a large horse statue in the middle", false));
		r.add(new Room("Lion Statue Room", "an empty room with a large lion statue in the middle", false));
		r.add(new Room("Dragon Statue Room", "an empty room with a large dragon statue in the middle", false));
		r.add(new Room("Knight Statue Room", "an empty room with a large knight statue in the middle", false));
		r.add(new Room("Sins Puzzle Room", "an empty room with an eery pressence in the air", false));
		r.get(23).spawnPuzzle(p.get(5));
		r.add(new Room("Sacrifice Puzzle Room", "a large room with a deep well in the middle that seems to have no bottom", false));
		r.get(24).spawnPuzzle(p.get(3));
		r.add(new Room("Dining Room", "a large room with a long table set for a feast, but with no food in sight", true));
		r.add(new Room("Butchers Room", "a room with blood stained walls and tools covered in dried blood", false));
		r.get(26).spawnMonster(m.get(2));
		r.add(new Room("Jester's Lair", "Description", true));
		r.get(27).spawnMonster(m.get(7));
		r.add(new Room("Grand Hall", "The room is full of elaborate decorations and a monstorous gilded door at the opposite end", false));
		r.add(new Room("Treasure Room", "Congratulations you have reached the treasure room! You are now rich beyond your wildest dreams!", false));

		return r;
	}
}
