import javax.swing.JOptionPane;

public class ComputeChange{
	public static void main(String[] args){
		String input="enter an amount in double,for example 11.35";
		String amountstring=JOptionPane.showInputDialog(input);
		
		double amount=Double.parseDouble(amountstring);
		int remainingamount=(int)(amount*100);
		
		int numberofyuan=remainingamount/100;
		remainingamount=remainingamount%100;
		
		int numberofjiao=remainingamount/10;
		remainingamount%=10;
		
		int numberoffen=remainingamount;
		
		String output="your amount "+amount+" consists of\n"
		+numberofyuan+"Ôª\n"+numberofjiao+"½Ç\n"+numberoffen+"·Ö";
		
		JOptionPane.showMessageDialog(null,output);
		
	}
}