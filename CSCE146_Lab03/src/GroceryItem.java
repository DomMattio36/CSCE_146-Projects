//written by Dominic Mattio :)
public class GroceryItem {

	private String name;
	private double value;
	
	public GroceryItem() 
	{
		name = ("none");
		value = 0.0;
	}
	
	public GroceryItem(String s, double d) 
	{
		if(s!=null && d>=0.0) 
		{
		
		name = (s);
		value = d;
		}
		else 
		{
			System.out.println("Invalid parameters");
			name = ("none");
			value = 0.0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null)
			this.name = name;
		else 
			this.name = "none";
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		if(value >= 0)
			this.value = value;
		else
			this.value= 0.0;
	}
	public String toString() 
	{
		String s;
		s = ("Grocery Item Name: " + name + "Value: " + value);
		return s;
	}
	public boolean equals(GroceryItem other) 
	{
		if(this.getName().equals(other.getName()) && this.getValue() == other.getValue()) 
		{
			return true;
		}
		else
			return false;
	}
}
