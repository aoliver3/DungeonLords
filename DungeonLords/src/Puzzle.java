
public class Puzzle 
{
	String startText;
	String completeText;
	Item reward;
	Boolean completed;
	
	public Puzzle(String startText, String completeText, Item reward, Boolean completed)
	{
		this.startText = startText;
		this.completeText = completeText;
		this.reward = reward;
		this.completed = completed;
	}
	
}
