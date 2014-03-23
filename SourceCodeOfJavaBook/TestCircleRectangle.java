import lixiong.GeometricObject;
import lixiong.Circle;
import lixiong.Rectangle;
public class TestCircleRectangle
{
	public static void main(String[] args)
	{
		GeometricObject newGeometric=new GeometricObject();
		System.out.println(newGeometric.getDateCreated());

		Circle circle=new Circle(1);
		System.out.println("a circle "+circle.toString());
		System.out.println(circle.getArea()+"  "+circle.getPerimeter());

		Rectangle rectangle=new Rectangle(2,4);
		System.out.println("a rectangle "+rectangle.toString());
		System.out.println(rectangle.getArea()+"  "+rectangle.getPerimeter());

	}
}
