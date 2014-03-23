public class Borrower extends Person
{
	private Loan loan;

	public Borrower()
	{
		super();
	}
	public Borrower(Name name,Address address)
	{
		super(name,address);
	}
	public Loan getLoan()
	{
		return loan;
	}
	public void setLoan(Loan loan)
	{
		this.loan=loan;
	}
	public String toString()
	{
		return super.toString()+"monthly payment is "+loan.getMonthlyPayment()+"\n"+"total payment is "+loan.getTotalPayment();
	}
}
