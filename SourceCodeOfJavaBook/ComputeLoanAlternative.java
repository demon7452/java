import java.util.Scanner;
public class ComputeLoanAlternative{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.print("enter yearly interest rate,for example 8.25:");
		double annualrate=input.nextDouble();
		double monthly=annualrate/1200;
		
		System.out.print("enter number of years as an inter,\nfor example 5:");
		int numberofyears=input.nextInt();
		
		System.out.print("enter loan amount, for example 12000.95:");
		double loanamount=input.nextDouble();
		
		double monthlypayment=loanamount*monthly/(1-1/Math.pow(1+monthly,numberofyears*12));
		double total=monthlypayment*12*numberofyears;
		
		monthlypayment=(int)(monthlypayment*100)/100.0;
		total=(int)(total*100)/100.0;
		System.out.println("the monthly payment is "+monthlypayment);
		System.out.println("the total payment is "+total);
	}
}