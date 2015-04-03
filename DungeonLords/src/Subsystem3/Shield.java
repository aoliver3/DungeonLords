/**
 * 
 */
package Subsystem3;

/**
 * @author aharr_000
 *
 */
public class Shield extends Item
{
	
	// Instance Variables
	
	private int flatBlock;
	private int percentBlock;
	private int refelctDmg;

	//Constructors & Methods
	
	public Shield(String name, String description, int limit, int quantity)
	{
		super(name, description, limit, quantity);
		// TODO Auto-generated constructor stub
	}

	public Shield(String name, String description, int limit, int quantity,
			int flatBlock, int percentBlock, int refelctDmg)
	{
		super(name, description, limit, quantity);
		this.flatBlock = flatBlock;
		this.percentBlock = percentBlock;
		this.refelctDmg = refelctDmg;
	}
	
	public void equipShield (Shield s)
	{
		Inventory.equipItem(s);
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
	 * @return the refelctDmg
	 */
	public int getRefelctDmg()
	{
		return refelctDmg;
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
	 * @param refelctDmg the refelctDmg to set
	 */
	public void setRefelctDmg(int refelctDmg)
	{
		this.refelctDmg = refelctDmg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Shield [flatBlock=" + flatBlock + ", percentBlock="
				+ percentBlock + ", refelctDmg=" + refelctDmg + "]";
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
		result = prime * result + refelctDmg;
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
		if (refelctDmg != other.refelctDmg)
			return false;
		return true;
	}
	
	
	
	

}
