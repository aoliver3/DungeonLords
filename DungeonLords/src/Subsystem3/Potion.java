/**
 * 
 */
package Subsystem3;

/**
 * @author aharr_000
 *
 */
public class Potion extends Item
{
	
	//Instance Variables
	
	private int manaRegen;
	private int healthRegen;
	
	//Constructors & Methods
	
	public Potion(String name, String description, int limit, int quantity)
	{
		super(name, description, limit, quantity);
	}


	public Potion(String name, String description, int limit, int quantity,
			int manaRegen, int healthRegen)
	{
		super(name, description, limit, quantity);
		this.manaRegen = manaRegen;
		this.healthRegen = healthRegen;
	}

	public void usePotion (Potion p)
	{
		int health = p.getHealthRegen();
		int mana = p.getManaRegen();
		
		System.out.println("You have regained " + health + " points and " + mana + " mana points ");
		
		// need to add health and mana to user's hp and mana
	}

	/**
	 * @return the manaRegen
	 */
	public int getManaRegen()
	{
		return manaRegen;
	}


	/**
	 * @return the healthRegen
	 */
	public int getHealthRegen()
	{
		return healthRegen;
	}


	/**
	 * @param manaRegen the manaRegen to set
	 */
	public void setManaRegen(int manaRegen)
	{
		this.manaRegen = manaRegen;
	}


	/**
	 * @param healthRegen the healthRegen to set
	 */
	public void setHealthRegen(int healthRegen)
	{
		this.healthRegen = healthRegen;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Potion [manaRegen=" + manaRegen + ", healthRegen="
				+ healthRegen + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + healthRegen;
		result = prime * result + manaRegen;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Potion other = (Potion) obj;
		if (healthRegen != other.healthRegen)
			return false;
		if (manaRegen != other.manaRegen)
			return false;
		return true;
	}

}
