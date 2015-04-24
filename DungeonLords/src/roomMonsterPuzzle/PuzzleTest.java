package roomMonsterPuzzle;

import gameSubsystem.Dungeon;
import gameSubsystem.Player;

import java.util.ArrayList;

public class PuzzleTest {

	public static void main(String[] args) 
	{
		ArrayList<Puzzle> p = new ArrayList<Puzzle>();
		p.add(new Puzzle("Phoenix Puzzle", null));
		System.out.println("created");
		p.get(0).startPuzzle(new Dungeon(new Player("joey"), RoomCreator.rooms()));
		System.out.println("finished");
	}

}
