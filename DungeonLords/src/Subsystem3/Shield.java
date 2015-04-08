
package Subsystem3;

/**Class: Shield
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class creates Shields to be used by the Player in the game DungeonLords 
 * 
 * Purpose: The purpose of this class is to create Shield objects that can be used by players
 */
public class Shield extends Item
{
	
	// Instance Variables
	
	private int flatBlock;
	private int percentBlock;
	private int reflectDmg;

	//Constructors & Methods
	
	/**
	 * Constructs a Shield object
	 * @param name - name of the shield
	 * @param description - description of the shield
	 * @param limit - max amount of this particular shield the user can have at one time
	 * @param quantity - how many of this particular shield the user has in their inventory
	 * @param flatBlock - amount of damage to be absorbed by this shield
	 * @param percentBlock - the percentage of time that this shield will block an attack
	 * @param reflectDmg - amount of damage this shield reflects
	 */

	public Shield(String name, String description, int limit, int quantity,
			int flatBlock, int percentBlock, int reflectDmg)
	{
		super(name, description, limit, quantity);
		this.flatBlock = flatBlock;
		this.percentBlock = percentBlock;
		this.reflectDmg = reflectDmg;
	}
	
	/**
	 * @return the flatBlock
	 */
	public int getFlatBlock()
	{
		return flatBlock;
	}

	/**
	 * @return the percentBlock
	 */
	public int getPercentBlock()
	{
		return percentBlock;
	}

	/**
	 * @return the reflectDmg
	 */
	public int getreflectDmg()
	{
		return reflectDmg;
	}

	/**
	 * @param flatBlock the flatBlock to set
	 */
	public void setFlatBlock(int flatBlock)
	{
		this.flatBlock = flatBlock;
	}

	/**
	 * @param percentBlock the percentBlock to set
	 */
	public void setPercentBlock(int percentBlock)
	{
		this.percentBlock = percentBlock;
	}

	/**
	 * @param reflectDmg the reflectDmg to set
	 */
	public void setreflectDmg(int reflectDmg)
	{
		this.reflectDmg = reflectDmg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		
		return "Shield" + "[name=" + getName() + "]" + "[flatBlock=" + flatBlock + "]" + "[percentBlock=" + percentBlock + "]" + "[reflectDmg=" + reflectDmg + "]" + "[description=" + getDescription() + "]" ;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + flatBlock;
		result = prime * result + percentBlock;
		result = prime * result + reflectDmg;
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
		Shield other = (Shield) obj;
		if (flatBlock != other.flatBlock)
			return false;
		if (percentBlock != other.percentBlock)
			return false;
		if (reflectDmg != other.reflectDmg)
			return false;
		return true;
	}
	
	
	
	

}
