package roomMonsterPuzzle;

import Subsystem3.Potion;

public class RoomPuzzleMonsterTest 
{
	public static void main(String[] args)
	{	
		//contructing test objects
		Attack a = new Attack("Test Attack", 1, 1, "The attack is a Test!");
		Monster m = new Monster("Test Monster", "Its a Test!", 50, new Potion("M Potion", "Potion from Monster", 1, 1, 1, 1), a);
		Puzzle p = new Puzzle("Start Puzzle", "Complete Puzzle", new Potion("P Potion", "Potion from puzzle", 1, 1,1,1));
		Room r = new Room("Test Room", "This room is Testy!", true);
		
		//Monster Test
		System.out.println("Monster Testing");
		System.out.println("Name: " + m.getName());
		System.out.println("Description: " + m.getDescription());
		System.out.println("Health: " + m.getHealth());
		System.out.println("Is he defeated: " + m.isDefeated());
		System.out.println("Loot(Should return null): " + m.getLoot());
		System.out.println("Attack: " + m.getAttack());
		
		m.die();
		System.out.println("Should return fals: " + m.isDefeated());
		
		System.out.println("Monster takes 30 dmg should have 20 health left: " + m.takeDamage(30));
		
		System.out.println("Monster attacks and should do 1 damage: " + m.attack());
		
		m.die();
		System.out.println("Monster should be defeated: " + m.isDefeated());
		System.out.println("Potion should be returned: " + m.getLoot());
		
		//Puzzle Test
		System.out.println("---------------");
		System.out.println("Puzzle Testing");
		p.setSolution("correct");
		
		System.out.println("Start Text: " + p.getStartText());
		System.out.println("Complete Text: "+ p.getCompleteText());
		System.out.println("Reward(Should be null): "+ p.getReward());
		System.out.println("Solution: " + p.getSolution());

		System.out.println("Testing verify method with invalid answer: " + p.verrifyAttempt("wrong"));
		System.out.println("Testing verify method with valid answer: " + p.verrifyAttempt("correct"));
		System.out.println("Reward should now be returned: " + p.getReward());

		//Room Test
		System.out.println("---------------");
		System.out.println("Room Testing");
		System.out.println("Name: " + r.getName());
		System.out.println("description: "+r.getDescription());
		System.out.println("Bonfire: " + r.hasBonfire());
		System.out.println("Monster(null): " + r.getRoomMonster());
		System.out.println("Puzzle(null): " + r.getRoomPuzzle());
		r.spawnMonster(m);
		r.spawnPuzzle(p);
		System.out.println("Monster: " + r.getRoomMonster());
		System.out.println("Puzzle: " + r.getRoomPuzzle());
		r.useBonfire();
		System.out.println("Bonfire should be gone(return false): " + r.hasBonfire());


	}
}
