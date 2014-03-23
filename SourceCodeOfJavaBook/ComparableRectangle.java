public class ComparableRectangle extends Rectangle implements Comparable
{
	public ComparableRectangle(double width,double height)
	{
		super(width,height);
	}
	public int compareTo(Object o)
	{
		if(getArea()>((ComparableRectangle)o).getArea())
			return 1;
		else if(getArea()<((ComparableRectangle)o).getArea())
			return -1;
		else 
			return 0;
	}
	public static void main(String[] args)
	{
		ComparableRectangle a=new ComparableRectangle(3,5);
		ComparableRectangle b=new ComparableRectangle(5,7);

		int max=a.compareTo(b);
		System.out.println(max);
	}
}
