public class House implements Cloneable,Comparable
{
	private int id;
	private double area;
	private java.util.Date whenBuilt;

	public House(int id,double area)
	{
		this.id=id;
		this.area=area;
		whenBuilt=new java.util.Date();
	}

	public int getId()
	{
		return id;
	}

	public double getArea()
	{
		return area;
	}
	
	public java.util.Date getWhenBuilt()
	{
		return whenBuilt;
	}

	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch(CloneNotSupportedException ex)
		{
			return null;
		}
	}

	public int compareTo(Object o)
	{
		if(area>((House)o).getArea())
			return 1;
		else if(area<((House)o).area)
			return -1;
		else 
			return 0;
	}

	public static void main(String[] args)
	{
		House house1=new House(1,1750.33);
		House house2=(House)house1.clone();

		System.out.println(house1==house2);
		System.out.println(house1.getWhenBuilt()==house2.getWhenBuilt());
	}
}
