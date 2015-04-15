package gameSubsystem;
/**Class: PlayerTest.java
 * @author Anthony Oliver
 * @version 1.0 <p>
 * Course : ITEC 3150 Spring 2015
 * Written: Apr 12, 2015
 *
 *
 * This class – now describe what the class does
 *
 * Purpose: – Describe the purpose of this class
 */

public class PlayerTest
{

	/**
	 * this method test my player class and its methods
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create a new player to test ethods
		Player p = new Player("Anthony");
		System.out.println(p.getPlayerName());  //expected Anthony
		System.out.println(p.getCurrentHealth());  //expected 150
		System.out.println(p.getMaxHealth());  //expected 150
		System.out.println(p.getPlayaerDamage());  //expected 0
		System.out.println(p.getPlayerMana());// expected 100
		
		//changing players attributes
		p.setMaxHealth(200);
		p.setCurrentHealth(175);
		p.setPlayerName("Joey");
		p.setPlayaerDamage(25);
		p.setPlayerMana(50);
		
		System.out.println("");
		//reprinting to make sure the change took effect
		System.out.println(p.getPlayerName());  //expected Joey
		System.out.println(p.getCurrentHealth());  //expected 175
		System.out.println(p.getMaxHealth());  //expected 200
		System.out.println(p.getPlayaerDamage());  //expected 25
		System.out.println(p.getPlayerMana());  //expected 50

	}

}
