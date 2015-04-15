package gameSubsystem;
import java.util.ArrayList;

import roomMonsterPuzzle.Room;

/**Class: DungeonTest.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 12, 2015
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class
 */

public class DungeonTest
{
	
	/**
	 * method to test my Dungeon class methods
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create a new player
		Player p = new Player("Anthony");
		//create an array list of room exits
		ArrayList<Room> exit = new ArrayList<Room>();
		//create rooms for the dungeon
		Room r1 = new Room("room 1", "the ok room", true);
		Room r2 = new Room("room 2", "the good room", true);
		Room r3 = new Room("room 3", "the great room", true);
		//put the rooms in an array list
		ArrayList<Room> al = new ArrayList<Room>();
		al.add(r1); al.add(r2); al.add(r3);
		//add the player and the rooms to the dungeon
		Dungeon d = new Dungeon(p, al);

		//testing the dungeon to see if it accepted the player and dungeon
		System.out.println(d.getUser().getPlayerName()); //expected to get the players name Anthony
		System.out.println(d.getDungeon().toString()); //should contain room r1, r2 & r3

		///////////////////////////////////////
		// will try to alter the dungeon now //
		///////////////////////////////////////

		//create a new player
		Player p2 = new Player("Joey");
		//create an array list of room exits
		//ArrayList<Room> exit2 = new ArrayList<Room>();
		//create rooms for the dungeon
		Room r4 = new Room("room 4", "the awesome room", true);
		Room r5 = new Room("room 5", "the gnarly room", true);
		Room r6 = new Room("room 6", "the tubular room", true);
		//put the rooms in an array list
		ArrayList<Room> al2 = new ArrayList<Room>();
		al2.add(r4); al2.add(r5); al2.add(r6);
		//setting the dungeon to the new player and room variables
		d.setUser(p2);
		d.setDungeon(al2);

		//testing the dungeon to see if it accepted the second player and dungeon
		System.out.println(d.getUser().getPlayerName()); //expected to get the players name Joey
		System.out.println(d.getDungeon().toString()); //should contain room r4, r5 & r6
	}

}
