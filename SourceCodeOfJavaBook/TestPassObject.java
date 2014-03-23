public class TestPassObject
{
	public static void main(String[] args)
	{
		Circle3 myCircle=new Circle3(1);
		System.out.println("the  radius is "+myCircle.getRadius());
		int n=5;
		System.out.println("the n is "+n);
		printAreas(myCircle,n);
		System.out.println("after printAreas the  radius is "+myCircle.getRadius());
		System.out.println("after printAreas the  n is "+n);

	}
	public static void printAreas(Circle3 c,int times)
	{
		while(times>=1)
		{
		  	System.out.println("the area of the circle of radius "+c.getRadius()+" is "+c.getArea());
				c.setRadius(c.getRadius()+1);
				times--;
		}
	}
}
