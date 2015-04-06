package Subsystem3;
/**
 * 
 */



/**
 * @author aharr_000
 *
 */
public class Armor extends Item
{
	// Instance Variables
	
	private int bonusHP;
	
	//Constructors & Methods

	public Armor(String name, String description, int limit, int quantity)
	{
		super(name, description, limit, quantity);
		// TODO Auto-generated constructor stub
	}

	public Armor(String name, String description, int limit, int quantity,
			int bonusHP)
	{
		super(name, description, limit, quantity);
		this.bonusHP = bonusHP;
	}
	
	public void equipArmor (Armor a)
	{
		Inventory.equipItem(a);
		System.out.println("You have just equipped " + a.getName() );
	}

	/**
	 * @return the bonusHP
	 */
	public int getBonusHP()
	{
		return bonusHP;
	}

	/**
	 * @param bonusHP the bonusHP to set
	 */
	public void setBonusHP(int bonusHP)
	{
		this.bonusHP = bonusHP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Armor" + "[name=" + getName() + "]" + "[bonusHP=" + bonusHP + "]" + "[description=" + getDescription() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bonusHP;
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
		Armor other = (Armor) obj;
		if (bonusHP != other.bonusHP)
			return false;
		return true;
	}
	
	

}
