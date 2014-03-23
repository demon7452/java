import javax.swing.JOptionPane;
public class addCaltulator
{
	public static void main(String[] args)
	{
	int sum=0;
	int i=0;
	String numString="";
	String output="";
	while(!numString.equals("9999"))
	{
		numString=JOptionPane.showInputDialog("enter a number");
		i=Integer.parseInt(numString);
		sum+=i;
		output+=numString+"\n";
	}
	sum=sum-9999;
	output+="the sum is "+sum;
	JOptionPane.showMessageDialog(null,output);
	}
}
