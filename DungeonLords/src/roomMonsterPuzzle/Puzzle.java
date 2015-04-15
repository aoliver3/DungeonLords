package roomMonsterPuzzle;
import Subsystem3.*;

public class Puzzle 
{
	private String startText;//text that appears at start of puzzle
	private String completeText;//text that appears after completing a puzzle
	private Item reward;//reward for the puzzle
	private Boolean completed;//tells if the puzzle is completed
	private Object solution;//the solution for the puzzle, some puzzles solutions have different types

	/**
	 * Default constructor for puzzle, solution must be set separately
	 * @param startText
	 * @param completeText
	 * @param reward
	 */
	public Puzzle(String startText, String completeText, Item reward)
	{
		this.startText = startText;
		this.completeText = completeText;
		this.reward = reward;
		this.completed = false;
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
			System.out.println(completeText);
			return true;
		}
		else return false;
	}

	/**
	 * getter for start text
	 * @return
	 */
	public String getStartText() 
	{
		return startText;
	}

	/**
	 * getter for complete text
	 * @return
	 */
	public String getCompleteText() 
	{
		return completeText;
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
}
