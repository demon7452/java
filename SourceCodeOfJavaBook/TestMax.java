public class TestMax
{
	public static void main(String[] args)
	{
		int number1=9;
		int number2=2;
		int max=max(number1,number2);
		System.out.println("the maximum of "+number1+" and "+number2+" is "+max);
	}
	public static int max(int number1,int number2)
	{
		int max;
		if(number1>number2)
			max=number1;
		else
			max=number2;
		return max;
	}
}