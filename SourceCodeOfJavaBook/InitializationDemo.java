public class InitializationDemo
{
	public double a=0;
	//public static double b=0;
	public static void main(String[] args)
	{
		new InitializationDemo();
	}
	public InitializationDemo()
	{
		new M();
	}
	public InitializationDemo(double newa)
	{
		  System.out.println(a);
			a=newa;
		  System.out.println(a);
	}
	{
		System.out.println("2 initializationDemo's instance block");
	}
	static
	{
		System.out.println("1 initializationDemo's static block");
	}
}
class M extends N
{
	M()
	{
		System.out.println("8 M's cnostructor body");
	}
	{
		System.out.println("7 M's instance initialization block");
	}
	static
	{
		System.out.println("4 M's static initialization block");
	}
}
class N  
{
	N()
	{
		System.out.println("6 N's cnostructor body");
	}
	{
		System.out.println("5 N's instance initialization block");
	}
	static
	{
		System.out.println("3 N's static initialization block");
	}
}
