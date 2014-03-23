import java.util.*;
public class HandleExceptionDemo 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		boolean continueInput = true;

		do
		{
			try
			{
				System.out.print("enter an integer:");
				int number = scanner.nextInt();
				//Display the result
				System.out.println("the number you entered is " + number);
				continueInput = false;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("try again.(Incorrect input:an integer is required)");
				scanner.nextLine();//Discard input
			}
		}while(continueInput);
		int number2 = Integer.MAX_VALUE + 1;
		System.out.println(number2);
	}
}
