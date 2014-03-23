public class CircleWithException
{
	/** The radius of the circle*/
	private double radius;

	/** The number of the objects created*/
	private static int numberOfObjects = 0;

	/** Construct a circle with a specified radius*/
	public CircleWithException(double newRadius)
	{
		setRadius(newRadius);
		numberOfObjects++;
	}

	/** Set a new radius */
	public void setRadius(double newRadius)throws IllegalArgumentException
	{
		if(newRadius >= 0)
		{
			radius = newRadius;
		}
		else
			throw new IllegalArgumentException("Radius cannot be negative");
	}

	/** Return numberOfObjects */
	public static int getNumberOfObjects()
	{
		return numberOfObjects;
	}
	
	/** Main method*/
	public static void main(String[] args)
	{
		try
		{
			CircleWithException c1 = new CircleWithException(5);
			CircleWithException c2 = new CircleWithException(-5);
			CircleWithException c3 = new CircleWithException(0);
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex);
			StackTraceElement[] traceElement = ex.getStackTrace();
			for(int i = 0; i < traceElement.length; i++)
			{
				System.out.println("method "+ traceElement[i].getMethodName() + "(" + traceElement[i].getClassName() + traceElement[i].getLineNumber() + ")");
			}
		}
		System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
	}
}
