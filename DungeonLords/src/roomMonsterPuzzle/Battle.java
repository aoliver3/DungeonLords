package roomMonsterPuzzle;
import java.io.*;

import Subsystem3.Item;
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
		System.out.println(enemy.getDescription());
		System.out.println("you have encountered " + enemy.getName());
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
			}else if (user.getPlayerInventory().getBag().contains(new Potion("Phoenix Statue" , "A mysterious statue with a faint glow", 1,1,1,1)))
			{
				user.setCurrentHealth(user.getMaxHealth());
				System.out.println("The pheonix statue explodes in flames from your inventory and you are revived, simultainiously burning your enemy!");
				enemy.die();
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
			String command = "help";
			while(command.equalsIgnoreCase("help"))
			{
				System.out.println("What would you like to do?");
				System.out.println("1: Attack");
				System.out.println("2: Use item");
				System.out.println("3: Flee");
				command = inFromUser.readLine();
				if(command.equalsIgnoreCase("1"))
				{
					enemy.takeDamage(user.getPlayerInventory().getWeaponSlot().getDamage());
					System.out.println(user.getPlayerName() + " attacks " + enemy.getName() + "!");
					System.out.println(enemy.getName() + " takes " + user.getPlayerInventory().getWeaponSlot().getDamage() + " damage and has " + enemy.getHealth() + " health.");
				}
				else if(command.equals("2"))
				{
					//game.useItem();
					if (user.getPlayerInventory().getBag().size() != 0)
					{
						//ask user which item to use
						System.out.println("What item would you like to use? Enter a number...");
						int numOfItems = 0;
						//display list of items
						for (Item i: user.getPlayerInventory().getBag())
						{
							System.out.println("Item " + numOfItems + ": " +i.getName());
							numOfItems = numOfItems + 1;
						}
						String in = inFromUser.readLine();
						//check user input for valid index number
						try
						{
							int input = Integer.parseInt(in);

							if (input > numOfItems)
							{
								System.out.println("No such item exist.");
							}
							else if (user.getPlayerInventory().getBag().get(input).getName().equalsIgnoreCase("health potion"))
							{
								user.setCurrentHealth(user.getCurrentHealth() + 75);
								System.out.println("You have used a health potion and regained 75 health.");
								user.getPlayerInventory().getBag().remove(input);
							}
							else if (user.getPlayerInventory().getBag().get(input).getName().equalsIgnoreCase("mana potion"))
							{
								user.setPlayerMana(user.getPlayerMana() + 75);
								System.out.println("You have used a mana potion and regained 75 mana.");
								user.getPlayerInventory().getBag().remove(input);
							}
							else
							{
								System.out.println("This is not a useable item.");
							}
						}
						catch (Exception e)
						{
							System.out.println("No such item exist.");
						}
					}
					else
					{
						System.out.println("You don't have any items to use.");
					}
				} else if(command.equals("3"))
				{
					System.out.println("You decide to run!");
					flee();
					throw new FleeException();
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
			int damage = enemy.attack();
			
			if (user.getPlayerInventory().getShieldSlot()!=null)
			{
				Shield current = user.getPlayerInventory().getShieldSlot();
				damage = (int) ((enemy.getAttack().getDamage()-current.getFlatBlock())*(1-current.getPercentBlock()));
			}
			user.setCurrentHealth(user.getCurrentHealth()-damage);
			System.out.println(user.getPlayerName() + " takes " + damage + " damage and has " + user.getCurrentHealth() + " health!");
		}
		else
		{
			Boss boss = (Boss) enemy;
			user.setCurrentHealth(user.getCurrentHealth() - boss.attack());
		}
	}
}
