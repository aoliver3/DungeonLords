
package Subsystem3;

/**Class: SpellScroll
 * @author Aaron Harris
 * @version 1.0
 * Course: Software Development I Spring 2015
 * 
 * This class creates SpellScrolls to be used by the Player in the game DungeonLords 
 * 
 * Purpose: The purpose of this class is to create SpellScroll objects that can be used by players
 */
public class SpellScroll extends Item
{
	// Instance Variables
	private int manaCost;
	private String attribute;

	//Constructors & Methods
	
	/**
	 * Constructs a SpellScroll object
	 * @param name - name of the SpellScroll
	 * @param description - description of the SpellScroll
	 * @param limit - the maximum amount of a particular SpellScroll a user can have at one time
	 * @param quantity - number the user has
	 * @param manaCost - the amount of mana needed by the user to cast this spell
	 * @param attribute - special ability that this scroll has
	 */

	public SpellScroll(String name, String description, int limit,
			int quantity, int manaCost, String attribute)
	{
		super(name, description, limit, quantity);
		this.manaCost = manaCost;
		this.attribute = attribute;
	}
	

	/**
	 * @return the manaCost
	 */
	public int getManaCost()
	{
		return manaCost;
	}

	/**
	 * @return the attribute
	 */
	public String getAttribute()
	{
		return attribute;
	}

	/**
	 * @param manaCost the manaCost to set
	 */
	public void setManaCost(int manaCost)
	{
		this.manaCost = manaCost;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(String attribute)
	{
		this.attribute = attribute;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "SpellScroll [manaCost=" + manaCost + ", attribute=" + attribute
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + manaCost;
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
		SpellScroll other = (SpellScroll) obj;
		if (attribute == null)
		{
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (manaCost != other.manaCost)
			return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		// SpellScroll sp1 = new SpellScroll ("Acid Cloud", "Creates an acid cloud over the enemy", 12, 1, 0, 75); // restores 75 health points
	}

	
	

}
