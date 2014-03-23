import javax.swing.JOptionPane;
public class ComputeTaxWithArray
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
	public static double computeTax(int status,double	income)
	{
		double[] rates={0.10,0.15,0.27,0.30,0.35,0.386};
		int[][] brackets=
		{
			{6000,27950,67700,141250,307050},
			{12000,46700,112850,171950,307050},
			{6000,23350,56425,85975,153525},
			{10000,37450,96700,156600,307050}
		};
		double tax=0;
		if(income<=brackets[status][0])
				tax=income*0.1;
		else if(income<=brackets[status][1])
				tax=brackets[status][0]*0.1+(income-brackets[status][0])*0.15;
		else if(income<=brackets[status][2])
				tax=brackets[status][0]*0.1+(brackets[status][1]-brackets[status][0])*0.15+(income-brackets[status][1])*0.27;
		else if(income<=brackets[status][3])
				tax=brackets[status][0]*0.1+(brackets[status][1]-brackets[status][0])*0.15+(brackets[status][2]-brackets[status][1])*0.27+(income-brackets[status][2])*0.3;
		else if(income<=brackets[status][4])
				tax=brackets[status][0]*0.1+(brackets[status][1]-brackets[status][0])*0.15+(brackets[status][2]-brackets[status][1])*0.27+(brackets[status][3]-brackets[status][2])*0.3+(income-brackets[status][3])*0.35;
		else
				tax=brackets[status][0]*0.1+(brackets[status][1]-brackets[status][0])*0.15+(brackets[status][2]-brackets[status][1])*0.27+(brackets[status][3]-brackets[status][2])*0.3+(brackets[status][4]-brackets[status][3])*0.35+(income-brackets[status][4])*0.386;
		return tax;
	}
}
