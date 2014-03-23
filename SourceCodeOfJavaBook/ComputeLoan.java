import javax.swing.JOptionPane;

public class ComputeLoan{
	public static void main(String[] args){
		String annualrate=JOptionPane.showInputDialog(null,"enter yearly interset rate,for example 8.35:","输入年利率:",
		JOptionPane.QUESTION_MESSAGE);
	
	    double yearly=Double.parseDouble(annualrate);
		
		double monthly=yearly/1200;
		//JOptionPane.showMessageDialog(null,monthly);
		
		String yearsstring=JOptionPane.showInputDialog(null,"enter number of years as an integer,\nfor example 5:","输入年数",
		JOptionPane.QUESTION_MESSAGE);
		
		int years=Integer.parseInt(yearsstring);
		
		String loanstring=JOptionPane.showInputDialog(null,"enter loan amount,for example 40000.4:","输入本金",
		JOptionPane.QUESTION_MESSAGE);
		
		double loanamount=Double.parseDouble(loanstring);
		
		double monthlypayment=loanamount*monthly/(1-1/Math.pow(1+monthly,years*12));
		double totalpayment=monthlypayment*12*years;
		monthlypayment=(int)(monthlypayment*100)/100.0;
		totalpayment=(int)(totalpayment*100)/100.0;
		
		String output="the monthly payment is "+monthlypayment+"\nthe total payment is "+totalpayment;
		
		JOptionPane.showMessageDialog(null,output,"输出税额",JOptionPane.INFORMATION_MESSAGE);
		
		
	}
}