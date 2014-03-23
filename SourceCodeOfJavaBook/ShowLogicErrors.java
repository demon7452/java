public class ShowLogicErrors
{
	public static void main(String[] args)
	{
		int number1=3;
		int number2=3;
		number2+=number1+number2;
		System.out.println("number2 is "+number2);
	}
}
