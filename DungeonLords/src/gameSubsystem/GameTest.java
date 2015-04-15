package gameSubsystem;
import java.util.ArrayList;

/**Class: GameTest.java
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

public class GameTest
{

	/**
	 * this will be a method to test my game class and its methods
	 * @param args
	 */
	public static void main(String[] args)
	{
		//////////////////////////////////
		// create a dungeon for my game //
		//////////////////////////////////

		//create a new player
		Player p = new Player("Anthony");
		//create an array list of room exits
		ArrayList<Room> exit = new ArrayList<Room>();
		//create rooms for the dungeon
		Room r1 = new Room("room 1", "the ok room", exit, true);
		Room r2 = new Room("room 2", "the good room", exit, false);
		Room r3 = new Room("room 3", "the great room", exit, true);
		//put the rooms in an array list
		ArrayList<Room> al = new ArrayList<Room>();
		al.add(r1); al.add(r2); al.add(r3);
		//add the player and the rooms to the dungeon
		Dungeon d = new Dungeon(p, al);

		/////////////////////////////
		// put my dungeon together //
		/////////////////////////////

		Game g = new Game(d);
		System.out.println(g.getGameDungeon().getUser().getPlayerName()); //expected output Anthony

		//////////////////////////////////////////////
		// create another dungeon to alter the game //
		//////////////////////////////////////////////

		//create a new player
		Player p2 = new Player("Joey");
		//create an array list of room exits
		ArrayList<Room> exit2 = new ArrayList<Room>();
		//create rooms for the dungeon
		Room r4 = new Room("room 4", "the awesome room", exit2, true);
		Room r5 = new Room("room 5", "the gnarly room", exit2, true);
		Room r6 = new Room("room 6", "the tubular room", exit2, true);
		//put the rooms in an array list
		ArrayList<Room> al2 = new ArrayList<Room>();
		al2.add(r4); al2.add(r5); al2.add(r6);
		//setting the dungeon to the new player and room variables
		Dungeon d2 = new Dungeon(p2, al2);
		
		//altering the game dungeon
		g.setGameDungeon(d2);
		
		//testing to see if the changes took effect
		System.out.println(g.getGameDungeon().getUser().getPlayerName()); //expected output Joey
		
	}

}
