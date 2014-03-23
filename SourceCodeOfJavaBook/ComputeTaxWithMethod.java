import javax.swing.JOptionPane;
public class ComputeTaxWithMethod
{
	public static void main(String[] args)
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
			String statusString=JOptionPane.showInputDialog("enter the filling status:\n0--single filers\n1--married file jointly\n2--married separately\n3--head of household");
			int status=Integer.parseInt(statusString);
			if(status==0||status==1||status==2||status==3)
			{
				String incomeString=JOptionPane.showInputDialog("enter the taxable income:");
				double income=Double.parseDouble(incomeString);
				JOptionPane.showMessageDialog(null,"the filling status is "+status+"\nthe income is "+income+"\n the tax is "+(int)(computeTax(status,income)*100)/100.0);
			}
			else 
				option=JOptionPane.showConfirmDialog(null,"you enter the wrong status!\ndo you want to try again:");
			option=JOptionPane.showConfirmDialog(null,"do you want to try again:");
		}
	}
	public static double computeTax(double income,int r1,int r2,int r3,int r4,int r5)
	{
		  double tax=0;
			if(income<=r1)
				tax=income*0.1;
			else if(income<=r2)
				tax=r1*0.1+(income-r1)*0.15;
			else if(income<=r3)
				tax=r1*0.1+(r2-r1)*0.15+(income-r2)*0.27;
			else if(income<=r4)
				tax=r1*0.1+(r2-r1)*0.15+(r3-r2)*0.27+(income-r3)*0.3;
			else if(income<=r5)
				tax=r1*0.1+(r2-r1)*0.15+(r3-r2)*0.27+(r4-r3)*0.3+(income-r4)*0.35;
			else
				tax=r1*0.1+(r2-r1)*0.15+(r3-r2)*0.27+(r4-r3)*0.3+(r5-r4)*0.35+(income-r5)*0.386;
			return tax;
	}
	public static double computeTax(int status,double	income)
	{
		switch(status)
		{
			case 0:
				return computeTax(income,6000,27950,67700,141250,307050);
			case 1:
				System.out.println("agin");
				return computeTax(income,12000,46700,112850,171950,307050);
			case 2:	
				return computeTax(income,6000,23350,56425,85975,153525);
			case 3:
				return computeTax(income,10000,37450,96700,156600,307050);
			default: return 0;
		}
	}
}
