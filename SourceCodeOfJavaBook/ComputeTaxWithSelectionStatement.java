import javax.swing.JOptionPane;
public class ComputeTaxWithSelectionStatement
{
	public static void main(String[] args)
	{
		String statusString=JOptionPane.showInputDialog(
			"enter the filing status:\n"+
			"(0-single filer,1-married jointly,\n"+
			"2-married separately,3-head of household)");
		int status=Integer.parseInt(statusString);
		String incomeString;
		double income=0;
		if(status==0||status==1||status==2||status==3)
		{
			 incomeString=JOptionPane.showInputDialog(
				"enter the taxable income:");
			 income=Double.parseDouble(incomeString);
		}
		else
		{
			System.out.println("error:invalid status");
			System.exit(0);
		}
		double tax=0;
		if(status==0)
		{
			if(income<=6000)
			  tax=income*0.10;
			else if(income<=27950)
			  tax=6000*0.10+(income-6000)*0.15;
			else if(income<=67700)
			  tax=6000*0.10+(27950-6000)*0.15+(income-27950)*0.27;
			else if(income<=141250)	
			  tax=6000*0.10+(27950-6000)*0.15+(67700-27950)*0.27+(income-67700)*0.30;
			else if(income<=307050)
			  tax=6000*0.10+(27950-6000)*0.15+(67700-27950)*0.27+(140250-67700)*0.30+(income-141250)*0.35;
			else 
			  tax=6000*0.10+(27950-6000)*0.15+(67700-27950)*0.27+(140250-67700)*0.30+(307050-141250)*0.35+(income-307050)*0.386;  			
		}
		else if(status==1)
		{
		}
		else if(status==2)
		{
		}
		else
		{
		}

		
		JOptionPane.showMessageDialog(null,"tax is "+(int)(tax*100)/100.0);
	}
}