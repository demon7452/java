import java.util.Date;
public class Loan
{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private Date loanDate;
	
	public Loan()
	{
		this(7.5,30,1000000);
	}
	public Loan(double annualInterestRate,int numberOfYears,double loanAmount)
	{
		this.annualInterestRate=annualInterestRate;
		this.numberOfYears=numberOfYears;
		this.loanAmount=loanAmount;
		loanDate=new Date();
	}

	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	public double getLoanAmount()
	{
		return loanAmount;
	}
	public String getLoanDate()
	{
		return loanDate.toString();
	}

	public double getMonthlyPayment()
	{
		double monthlyInterestRate=annualInterestRate/1200;
		double monthlyPayment=loanAmount*monthlyInterestRate/(1-(Math.pow(1/(1+monthlyInterestRate),numberOfYears*12)));
		return monthlyPayment;
	}
	public double getTotalPayment()
	{
		double totalPayment=getMonthlyPayment()*numberOfYears*12;
		return (int)(totalPayment*100)/100.0;
	}
}
