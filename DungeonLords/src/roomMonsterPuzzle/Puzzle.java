package roomMonsterPuzzle;
import gameSubsystem.Dungeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Subsystem3.*;

public class Puzzle 
{
	private String puzzleName;
	private BufferedReader inFromUser;
	private Item reward;//reward for the puzzle
	private Boolean completed;//tells if the puzzle is completed
	private Object solution;//the solution for the puzzle, some puzzles solutions have different types

	/**
	 * Default constructor for puzzle, solution must be set separately
	 * @param startText
	 * @param completeText
	 * @param reward
	 */
	public Puzzle(String name, Item reward)
	{
		puzzleName=name;
		this.reward = reward;
		this.completed = false;
		this.inFromUser = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * returns true if puzzle has been solved
	 * @return
	 */
	public boolean isSolved()
	{
		return completed;
	}

	/**
	 * sets the puzzles solution
	 * @param solution
	 */
	public void setSolution(Object solution) 
	{
		this.solution = solution;
	}

	/**
	 * checks to see if the users input is the correct solution and changes the puzzle to completed if its correct
	 * @param o
	 * @return
	 */
	public boolean verrifyAttempt(Object o)
	{
		if(o.equals(solution))
		{
			completed=true;
			return true;
		}
		else return false;
	}

	/**
	 * getter for reward, returns null if puzzle hasnt been solved
	 * @return
	 */
	public Item getReward() 
	{
		if(completed)
		{
			
			return reward;
		}
		else return null;
	}

	/**
	 * checks if puzzle is completed
	 * @return
	 */
	public Boolean getCompleted() 
	{
		return completed;
	}

	/**
	 * returns solution of puzzle
	 * @return
	 */
	public Object getSolution() 
	{
		return solution;
	}

	public void startPuzzle(Dungeon d)
	{
		try
		{
			if (puzzleName.equals("Darkness Puzzle"))
			{
				solution = "right";
				System.out.println("The room is so dark you cant see a thing, you feel around on the wall and find three levers, which should you pull(left, right, center?");
				boolean attempt = verrifyAttempt(inFromUser.readLine());
				while(!attempt)
				{
					System.out.println("An arrow shoots out of the wall and you take 10 damage");
					d.getUser().setCurrentHealth(d.getUser().getCurrentHealth()-10);
					System.out.println("Try another lever...");
					attempt = verrifyAttempt(inFromUser.readLine());
				}
				System.out.println("Torches light up along the wall and you can now see the room clearly");

			}else if(puzzleName.equals("Sphinxs Riddle"))
			{
				solution = true;
				System.out.println("A huge sphinx statue stands in front of you blocking your way, as the statue stands motionless a voice is projected into your head.");
				System.out.println("What walks on four legs in the morning, two in the day, and 3 at night?");
				String answer = inFromUser.readLine();
				while(!completed)
				{
					if (answer.equals("human") || answer.equalsIgnoreCase("man") || answer.equalsIgnoreCase("Person"))
					{
						verrifyAttempt(true);
						System.out.println("The statue sinks into the ground and the way is now clear.");
					}
					else
					{
						System.out.println("The statue is unresponsive, perhaps you should try again.");
						answer=inFromUser.readLine();
					}
				}
			}else if(puzzleName.equals("Coin Puzzle"))
			{
				solution = "snake, none, man, spider";
				System.out.println("You see a tablet with an inscription and a stack of three coins as well as four slots the same size as the coins,");
				System.out.println("each coin has a different image, a man, a spider and a snake, the inscription reads...");
				while(!completed)
				{
					System.out.println("“The snake sits at one end. The old man does not sit beside the snake and sits to the spider’s left.”");
					System.out.println("Which order should you place the coins? (Example: none, spider, snake, man)");
					System.out.println("*no caps*");
					verrifyAttempt(inFromUser.readLine());
				}
				System.out.println("The coins lock into place and the door forward is unlocked.");
			}else if(puzzleName.equals("Sacrifice Puzzle"))
			{
				System.out.println("In the middle of the room there is a pedastal and a deep well, the pedastal has some writing etched into it.");
				System.out.println("It reads 'Drop any two items into this well and you will be allowed to pass'");
				//ask user which item to use
				for(int x = 0; x<2; x ++)
				{
					System.out.println("What item would you like to drop?");
					int numOfItems = 0;
					//display list of items
					for (Item i: d.getUser().getPlayerInventory().getBag())
					{
						System.out.println("Item " + numOfItems + ": " +i.getName());
						numOfItems = numOfItems + 1;
					}
					String in = inFromUser.readLine();
					//check user input for valid index number
					try
					{
						int input = Integer.parseInt(in);

						if (input > numOfItems)
						{
							System.out.println("No such item exist.");
						}
						else 
						{
							d.getUser().getPlayerInventory().getBag().remove(input);
						}

					}
					catch (Exception e)
					{
						System.out.println("No such item exist.");
					}
				}
				System.out.println("Your items drop down the well and never make a noise, however you do notice a click, perhaps the door unlocked");
				verrifyAttempt(true);
			}else if(puzzleName.equals("Math Puzzle"))
			{
				int num1;
				int num2;
				while(!completed)
				{
					System.out.println("Exercise your mind and solve this problem!");
					num1= (int) (Math.random()*100);
					num2 = (int) (Math.random()*100);
					setSolution(num1*num2);
					System.out.println("What is " + num1 + " multiplied by " + num2 + "?");
					try
					{
						verrifyAttempt(Integer.parseInt(inFromUser.readLine()));
					}catch(Exception e)
					{
						System.out.println("Invalid input");	
					}
				}
				System.out.println("Congratulations! You can do basic math!");
			}else if(puzzleName.equals("Sins Puzzle"))
			{
				ArrayList<String> sins = new ArrayList<String>();
				setSolution(true);
				sins.add("gluttony");sins.add("wrath");sins.add("lust");sins.add("envy");sins.add("greed");sins.add("pride");sins.add("sloth");
				System.out.println("You enter the room and are instantly frozen and a distant voice calls out...");
				System.out.println("'To remove this curse you must name the 7 deadly sins, one at a time'");
				while(!sins.isEmpty())
				{
					String sin = inFromUser.readLine().toLowerCase();
					if(sins.contains(sin))
					{
						sins.remove(sin);
						System.out.println("One less deadly sin... " + sins.size() + " more sins to discover...");
					}else System.out.println("That was not a correct sin, try again");
				}
				verrifyAttempt(true);
				System.out.println("You have completed the deadly sins puzzle and may now procede.");
			}else if(puzzleName.equals("Phoenix Puzzle"))
			{
				solution = true;
				System.out.println("There is a riddle written into the pillar....");

				System.out.println("My end is a new begining, from the ashes I rise, what am I?");
				if(inFromUser.readLine().equalsIgnoreCase("phoenix"))
				{
					reward = new Potion("Phoenix Statue" , "A mysterious statue with a faint glow", 1,1,1,1);
					System.out.println("A hidden compartment opens up and a small phoenix statue is revealed, you should take this with you");
				} else System.out.println("The riddle fades from the pillar...");
				verrifyAttempt(true);
			}
		} catch(Exception e)
		{

		}
	}
}
