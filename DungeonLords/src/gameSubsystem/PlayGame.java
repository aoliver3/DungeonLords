/**Class: PlayGame.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 20, 2015
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class
 */
package gameSubsystem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Subsystem3.Armor;
import Subsystem3.Item;
import Subsystem3.Potion;
import Subsystem3.Shield;
import Subsystem3.Weapon;
import roomMonsterPuzzle.Room;
import roomMonsterPuzzle.RoomCreator;

public class PlayGame
{
	BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); //used to read input from the user
	boolean playAgain = true; //tells the game when to stop running

	/**
	 * method to display message at the start
	 * of the game
	 */
	public void startGame()
	{
		System.out.println("Would you like to start a new adventure,");
		System.out.println("or continue from a previous time? Enter a number...");
		System.out.println("1-New Game");
		System.out.println("2-Load Game");
		System.out.println("3-Exit Game");
	}

	/**
	 * method that creates a new game, ask the player for
	 * a name for their character and creates a new Player 
	 * object, also creates the dungeon and its rooms
	 * @return a new game object
	 * @throws IOException input/output exception
	 */
	public Game createNewGame() throws IOException
	{
		System.out.println("What is your name warrior?");
		String newbie = userInput.readLine();
		Dungeon newDungeon = new Dungeon(new Player(newbie), RoomCreator.rooms());
		Game newGame = new Game(newDungeon);

		///starting items for a new player
		Item a1 = new Armor ("Adventurer's Armor", "Armor given to adventurers", 12, 1, 25);
		Item p1 = new Potion ("Health Potion", "Restores health points", 12, 1, 0, 75);
		Item p2 = new Potion ("Mana Potion", "Restores mana points", 12, 1, 75, 0);
		Item s1 = new Shield ("Adventurer's Shield", "Shield given to adventurers", 12, 1, 1, 0, 0);
		Item w1 = new Weapon ("Adventurer's Sword", "Sword given to adventurers", 12, 1, 5);
		
		//add the starting items to players inventory
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(a1);
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(s1);
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(w1);
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(p1);
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(p1);
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(p2);
		newGame.getGameDungeon().getUser().getPlayerInventory().getBag().add(p2);

		System.out.println("Good luck on your journey " + newbie);
		return newGame;
	}

	/**
	 * method that loads a saved player and his dungeon
	 * into the game
	 * @return the saved player and his dungeon
	 * @throws ClassNotFoundException class not found exception
	 * @throws IOException input/output exception
	 */
	public Game loadSavedPlayer() throws ClassNotFoundException, IOException
	{

		Game savedGame = new Game(new Dungeon(new Player("temp"), new ArrayList<Room>()));
		savedGame.loadGame();
		System.out.println("Welocome back brave warrior " + savedGame.getGameDungeon().getUser().getPlayerName());
		return savedGame;
	}

	/**
	 * method that displays a list of commands and
	 * ask the user what to do
	 */
	public void commands()
	{
		String[] commands = {"0-Save Game", "1-Look", "2-Move", "3-Rest", 
				"4-Pick Up", "5-Equip", "6-Throw", "7-Drop", "8-Use"};

		System.out.println("What shall we do next? Enter a number...");

		//print the commands
		for (int i = 0; i< commands.length; i++)
		{
			System.out.println(commands[i]);
		}
	}

	/**
	 * method that trys to execute the users input
	 * @param runningGame a Game object
	 * @throws IOException input/output exception
	 */
	public void runGame(Game runningGame) throws IOException
	{
		while (playAgain = true)
		{
			commands();
			String userCommand = userInput.readLine();
			try
			{
				int input = Integer.parseInt(userCommand);
				if (input == 0)
				{
					runningGame.saveGame();
					playAgain = false;
				} else if (input == 1)
				{
					runningGame.look();
				} else if (input == 2)
				{
					runningGame.move();
				} else if (input == 3)
				{
					runningGame.rest();
				} else if (input == 4)
				{
					runningGame.pickUp();
				} else if (input == 5)
				{
					runningGame.equip();
				} else if (input == 6)
				{
					runningGame.throwItem();
				} else if (input == 7)
				{
					runningGame.drop();
				} else if (input == 8)
				{
					runningGame.use();
				} else
				{
					System.out.println("This is not a valid command");
				}
			}
			catch (Exception e)
			{
				System.out.println("This is not a valid command");
				//System.out.println(e);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		//start the game up
		PlayGame pg = new PlayGame();

		System.out.println("Welcome to Dungeon Lords...");

		while (pg.playAgain = true)
		{
			//game start display screen
			pg.startGame();

			String input = pg.userInput.readLine();

			//create new game with a new player and new set of rooms
			try
			{
				int input2 = Integer.parseInt(input);

				if (input2 > 3 || input2 < 1) //out of bounds number
				{
					System.out.println("Invalid command");
				} else 
				{
					if(input2 == 1) //input is 1
					{
						Game newGame = pg.createNewGame();
						pg.runGame(newGame);
					} else if (input2 == 2) //input is 2
					{
						Game loadedGame = pg.loadSavedPlayer();
						pg.runGame(loadedGame);
					} else //input is 3
					{
						System.out.println("Until next time warrior... Goodbye!");
						pg.playAgain = false;
					}
				}
			}
			catch (Exception e)
			{
				System.out.println("Invalid command");
			}
		}
		System.out.println("Until next time warrior... Goodbye!");
	}
}
