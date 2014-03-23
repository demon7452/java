import lixiong.*;
public class TestPolymorphismCasting
{
	public static void main(String[] args)
	{
		Object object1=new Circle(2);
		Object object2=new Rectangle(3,3);

		displayObject(object1);
		displayObject(object2);
	}
	public static void displayObject(Object object)
	{
		if(object instanceof Circle)
		{
			System.out.println("the circle area is "+((Circle)object).getArea());
			System.out.println("the circle diameter is "+((Circle)object).getDiameter());
		}
		else if(object instanceof Rectangle)
		{
			System.out.println("the rectangle area is "+((Rectangle)object).getArea());
		}
	}
}
