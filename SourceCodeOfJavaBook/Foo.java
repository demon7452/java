public class Foo
{
	static int i=5;
	static int k=2;
	public static void main(String[] args)
	{
		int j=i;
		m();
	}
	public static void m()
	{
		System.out.println("hello");
	}
	public static int m2(int i,int j)
	{
		return (int)(Math.pow(i,j));
	}
}
