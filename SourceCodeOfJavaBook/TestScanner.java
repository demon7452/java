import java.util.Scanner;
public class TestScanner{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("enter an integer:");
		int intvalue=scanner.nextInt();
		System.out.println("you entered the integer "+intvalue);
		
		System.out.print("enter a double value:");
		double doublevalue=scanner.nextDouble();
		System.out.println("you entered the double value "+doublevalue);
		
		System.out.print("enter a string without space:");
		String string=scanner.next();
		System.out.println("you entered the string "+string);
	}
}