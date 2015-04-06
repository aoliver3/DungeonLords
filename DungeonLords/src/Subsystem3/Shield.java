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
	private int reflectDmg;

	//Constructors & Methods
	
	public Shield(String name, String description, int limit, int quantity)
	{
		super(name, description, limit, quantity);
		// TODO Auto-generated constructor stub
	}

	public Shield(String name, String description, int limit, int quantity,
			int flatBlock, int percentBlock, int reflectDmg)
	{
		super(name, description, limit, quantity);
		this.flatBlock = flatBlock;
		this.percentBlock = percentBlock;
		this.reflectDmg = reflectDmg;
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
