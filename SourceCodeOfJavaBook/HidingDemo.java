public class HidingDemo
{
	public static void main(String[] args)
	{
		A x=new B();
		System.out.println(x.i);
		System.out.println(((B)x).i);

		System.out.println(x.j);
		System.out.println(((B)x).j);

		System.out.println(x.m1());
		System.out.println(((B)x).m1());

		System.out.println(x.m2()); 
	}
}
class A
{
	public int i=1;
	public static int j=11;

	public static String m1()
	{
		return "A's static m1";
	}
	public String m2()
	{
		return "A's instance m2";
	}
}
class B extends A
{
	public int i=2;
	public static int j=12;
	public static String m1()
	{
		return "B's static m1";
	}
	public String m2()
	{
		return "B's instance m2";
	}
}
