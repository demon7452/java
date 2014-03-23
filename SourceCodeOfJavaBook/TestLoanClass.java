import javax.swing.JOptionPane;
public class TestLoanClass
{
	public static void main(String[] args)
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
			String annualInterestRateString=JOptionPane.showInputDialog("enter yearly interest rate,for example 8.25:");
			double annualInterestRate=Double.parseDouble(annualInterestRateString);

			String numberOfYearsString=JOptionPane.showInputDialog("enter number of years as an integer,\nfor example 5:");
			int numberOfYears=Integer.parseInt(numberOfYearsString);

			String loanAmountString=JOptionPane.showInputDialog("enter loan amount,for example 120000.95:");
			double loanAmount=Double.parseDouble(loanAmountString);

			Loan loan=new Loan(annualInterestRate,numberOfYears,loanAmount);

			double monthlyPayment=(int)(loan.getMonthlyPayment()*100)/100.0;
			double totalPayment=loan.getTotalPayment();
			String output="the loan was created on "+loan.getLoanDate()+"\nthe monthly payment is "+monthlyPayment+"\nthe total payment is "+totalPayment;
			JOptionPane.showMessageDialog(null,output);
			option=JOptionPane.showConfirmDialog(null,"do you want to try again?");
		}
	}
}
