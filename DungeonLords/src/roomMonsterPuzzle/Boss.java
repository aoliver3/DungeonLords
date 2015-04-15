package roomMonsterPuzzle;

import java.util.ArrayList;

import Subsystem3.Item;

public class Boss extends Monster 
{
	ArrayList<Attack> attackList;
	
	public Boss(String name, String description, int health, Item loot, ArrayList<Attack> attack) 
	{
		super(name, description, health, loot, null);
		this.attackList=attack;
	}

	public ArrayList<Attack> getAttackList() 
	{
		return attackList;
	}

	public void setAttackList(ArrayList<Attack> attackList) 
	{
		this.attackList = attackList;
	}

	public int attack(int turn)
	{
		return attackList.get(turn).getDamage();
	}
}
