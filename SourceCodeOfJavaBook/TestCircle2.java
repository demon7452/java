public class TestCircle2
{
	public static void main(String[] args)
	{
		Circle2 c1=new Circle2();

		System.out.println("before creating c2,c1 radius is "+c1.radius+" and numberOfObjects is "+c1.numberOfObjects);

		Circle2 c2=new Circle2(5);
		System.out.println("after creating c2,c2 radius is "+c2.radius+" and numberOfObjects is "+c2.numberOfObjects);
	}
}
