package roomMonsterPuzzle;

import GameDungeon.Player;
public class BattleTest 
{

	public static void main(String[] args)
	{
		Player user = new Player("GOODGUY", null);
		user.setPlayaerDamage(40);
		Monster enemy = new Monster("BADGUY", "a scary bad guy", 60, null, new Attack("slash", 40, 1, "he swings his sword"));
		new Battle(user,enemy);
	}

}
