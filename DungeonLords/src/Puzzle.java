
public class Puzzle 
{
	String startText;
	String completeText;
	Item reward;
	Boolean completed;
	Object solution;
	
	public Puzzle(String startText, String completeText, Item reward)
	{
		this.startText = startText;
		this.completeText = completeText;
		this.reward = reward;
		this.completed = false;
	}
	
	public boolean isSolved()
	{
		return completed;
	}
	
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
}