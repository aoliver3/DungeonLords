/**
 * 
 */
package Subsystem3;

/**
 * @author aharr_000
 *
 */
public class Weapon extends Item
{
	// Instance Variable
	
	private int damage;
	
	
	//Constructors & Methods
	
	public Weapon(String name, String description, int limit, int quantity,
			int damage)
	{
		super(name, description, limit, quantity);
		this.damage = damage;
	}

	public Weapon(String name, String description, int limit, int quantity)
	{
		super(name, description, limit, quantity);
		// TODO Auto-generated constructor stub
	}
	
	public void equipWeapon (Weapon w)
	{
		Inventory.equipItem(w);
	}

	/**
	 * @return the damage
	 */
	public int getDamage()
	{
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Weapon" + "[name=" + getName() + "]" + "[damage=" + damage + "]" + "[description=" + getDescription() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + damage;
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
		Weapon other = (Weapon) obj;
		if (damage != other.damage)
			return false;
		return true;
	}
	
	

}
