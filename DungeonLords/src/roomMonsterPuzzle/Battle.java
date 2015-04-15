package roomMonsterPuzzle;
import java.io.*;
import gameSubsystem.*;

public class Battle 
{
	Game game;
	Player user;
	Monster enemy;
	BufferedReader inFromUser;


	public Battle(Game g, Monster enemy)
	{
		this.game = g;
		this.user = g.getGameDungeon().getUser();
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
					game.flee();
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

	private void enemyTurn(double round)
	{
		if(enemy.getClass().equals(Monster.class))
		{
			user.setCurrentHealth(user.getCurrentHealth()-enemy.attack());
			System.out.println(user.getPlayerName() + " takes " + enemy.getAttack().getDamage() + " damage and has " + user.getCurrentHealth() + " health");
		}
		else
		{
			Boss boss = (Boss) enemy;
			user.setCurrentHealth(user.getCurrentHealth() - boss.attack());
		}
	}
}
