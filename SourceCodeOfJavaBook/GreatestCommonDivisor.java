import javax.swing.JOptionPane;
public class GreatestCommonDivisor
{
	public static void main(String[] args)
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
		
			String s1=JOptionPane.showInputDialog("enter the first integer:");
			int n1=Integer.parseInt(s1);
		
			String s2=JOptionPane.showInputDialog("enter the second integer:");
			int n2=Integer.parseInt(s2);
		
			int k=1;
			int gcd=0;
			while(k<=n1&&k<=n2)
			{
				if(n1%k==0&&n2%k==0)
					gcd=k;
				k++;
			}
			JOptionPane.showMessageDialog(null,"the gcd of "+n1+" and "+n2+" is "+gcd);
			option=JOptionPane.showConfirmDialog(null,"continue?");
		}
	}
}