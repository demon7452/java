public class TotalArea
{
	public static void main(String[] args)
	{
		Circle3[] circleArray;
		circleArray=createCircleArray();
		printCircleArray(circleArray);
	}
	public static Circle3[] createCircleArray()
	{
		Circle3[] circleArray=new Circle3[10];
		for(int i=0;i<circleArray.length;i++)
			circleArray[i]=new Circle3(Math.random()*100);
		return circleArray;
	}
	public static void printCircleArray(Circle3[] circleArray)
	{
		System.out.println("Radius\t\t\t\t"+"area");
		for(int i=0;i<circleArray.length;i++)
			System.out.println(circleArray[i].getRadius()+"\t\t"+circleArray[i].getArea());
		System.out.println("--------------------------------");
		System.out.println("the total areas of circles is  "+sum(circleArray));
	}
	public static double sum(Circle3[] circleArray)
	{
		double sum=0;
		for(int i=0;i<circleArray.length;i++)
			sum+=circleArray[i].getArea();
		return sum;
	}
}
