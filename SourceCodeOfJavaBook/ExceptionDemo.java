import java.util.Scanner;
public class ExceptionDemo
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter an integer:");
		int number = scanner.nextInt();

		//Display the result
		System.out.println("the number entered is " + number);
	}
}
