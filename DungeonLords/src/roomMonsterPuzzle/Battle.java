package roomMonsterPuzzle;
import java.io.*;

import Subsystem3.Potion;
import Subsystem3.Shield;
import gameSubsystem.*;

public class Battle 
{
	Dungeon d;
	Player user;
	Monster enemy;
	BufferedReader inFromUser;


	public Battle(Dungeon d, Monster enemy)
	{
		this.d = d;
		this.user = d.getUser();
		this.enemy = enemy;
		inFromUser = new BufferedReader(new InputStreamReader(System.in));

		startBattle();
	}

	private void startBattle()
	{
		System.out.println("you have encountered " + enemy.getDescription());
		try
		{	
			if(Math.random()>.5)
			{

				for(double round = 0; enemy.getHealth()>0 && user.getCurrentHealth()>0; round=round+.5)
				{
					if(round%1.0==0)
					{

						playerTurn();

					}else
					{
						enemyTurn(round);
					}
				}
			}else
			{
				for(double round = 0; enemy.getHealth()>0 && user.getCurrentHealth()>0; round=round+.5)
				{
					if(round%1.0==0)
					{
						enemyTurn(round);
						if(user.getCurrentHealth()<=0 && user.getPlayerInventory().getBag().contains(new Potion("Phoenix Statue", "A mysterious statue with a faint glow", 1,1,1,1)))
						{
							user.setCurrentHealth(user.getMaxHealth());
						}
					}else
					{
						playerTurn();
					}
				}
			}
			if(enemy.getHealth()<=0)
			{
				System.out.println("You have defeated the " + enemy.getName()); //+ ", " + enemy.getLoot().getName() + " dropped to the ground");
			}else System.out.println(enemy.getName() + " has killed you, GAME OVER");
		}
		catch(FleeException fe)
		{
		}
	}

	private void playerTurn() throws FleeException
	{
		try
		{
			System.out.println("What would you like to do?");
			String command = "help";
			while(command.equalsIgnoreCase("help"))
			{
				command = inFromUser.readLine();
				if(command.equalsIgnoreCase("attack"))
				{
					enemy.takeDamage(user.getPlayaerDamage());
					System.out.println(user.getPlayerName() + " attacks " + enemy.getName() + "!");
					System.out.println(enemy.getName() + " takes " + user.getPlayaerDamage() + " damage and has " + enemy.getHealth() + " health.");
				}
				else if(command.equals("use item"))
				{
					//game.useItem();
					System.out.println("Used an item!");
				} else if(command.equals("flee"))
				{
					System.out.println("You decide to run!");
					flee();
					throw new FleeException();
				}else if (command.equalsIgnoreCase("help"))
				{
					System.out.println("Commands");
					System.out.println("--------");
					System.out.println("attack : attacks the enemy with your weapon");
					System.out.println("use item : uses an item that you have");
					System.out.println("flee : attempts to run from the battle and return to the previous room");
				}
				else 
				{
					System.out.println("Invalid command, try again");
					command = "help";
				}
			}
		}
		catch(Exception e)
		{

		}
		finally
		{

		}
	}

	public void flee()
	{
		int x = 0;
		while(!d.getDungeon().get(x).equals(user.getCurrentRoom()))
		{
			x++;
		}
		user.setCurrentRoom(d.getDungeon().get(x-1));

		System.out.println("You have returned to the " + d.getUser().getCurrentRoom().getName());
	}


	private void enemyTurn(double round)
	{
		if(enemy.getClass().equals(Monster.class))
		{
			Shield current = user.getPlayerInventory().getShieldSlot();
			int damage = (int) ((enemy.attack()-current.getFlatBlock())*current.getPercentBlock());
			user.setCurrentHealth(user.getCurrentHealth()-damage);
			System.out.println(user.getPlayerName() + " takes " + damage + " damage and has " + user.getCurrentHealth() + " health!");
			if (current.getreflectDmg()>0)
			{
				System.out.println("Your shield reflects " + current.getreflectDmg() + " damage back at the enemy!");
			}
		}
		else
		{
			Boss boss = (Boss) enemy;
			user.setCurrentHealth(user.getCurrentHealth() - boss.attack());
		}
	}
}
