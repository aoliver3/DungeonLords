package roomMonsterPuzzle;

import gameSubsystem.Dungeon;
import gameSubsystem.Game;
import gameSubsystem.Player;

public class BattleTest {

	public static void main(String[] args)
	{
		Player p = new Player("Joey");
		p.setPlayaerDamage(25);
		Dungeon d = new Dungeon(p, RoomCreator.rooms());
		p.setCurrentRoom(d.getDungeon().get(0));
		d.getDungeon().get(1).spawnMonster(new Monster("Enemy", "an enemy", 50, null, new Attack("slash", 20, 0, "swings his sword")));
		
		Game g = new Game(d);
		g.move();
	}

}
