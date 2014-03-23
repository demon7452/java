public class TestMethodOverloading
{
	public static void main(String[] args)
	{
		System.out.println("the maximum between 3 and 4 is "+max(3,4));
		System.out.println("the maximum between 3.0 and 4.5 is "+max(3.0,4.5));
		System.out.println("the maximum between 3.0 and 5.4 and 10.14 is "+max(3.0,5.4,10.14));
	}
	public static int max(int n1,int n2)
	{
		if(n1>n2)
			return n1;
		else
			return n2;
	}
	public static double max(double n1,double n2)
	{
		if(n1>n2)
			return n1;
		else
			return n2;
	}
	public static double max(double n1,double n2,double n3)
	{
		return max(max(n1,n2),n3);
	}
}
