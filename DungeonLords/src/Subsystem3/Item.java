/**
 * 
 */
package Subsystem3;

/**
 * @author aharr_000
 *
 */
public abstract class Item 
{
	//Instance Variables
	private String name;
	private String description;
	private int limit;
	private int quantity;
	
	//Constructors & Methods

	public Item(String name, String description, int limit, int quantity)
	{
		super();
		this.name = name;
		this.description = description;
		this.limit = limit;
		this.quantity = quantity;
	}

	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() 
	{
		return limit;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() 
	{
		return quantity;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) 
	{
		this.limit = limit;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Item [name=" + name + ", description=" + description
				+ ", limit=" + limit + ", quantity=" + quantity + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + limit;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (limit != other.limit)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}



}
