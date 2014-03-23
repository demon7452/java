import javax.swing.JOptionPane;
public class LeapYear
{
	public static void main(String[] args)
	{
		int loopChar='y';
		while(loopChar=='y')
		{
			String yearstring=JOptionPane.showInputDialog("enter a year:");
			int year=Integer.parseInt(yearstring);
			boolean isleapyear=(year%4==0&&year%100!=0)||(year%400==0);
			//JOptionPane.showMessageDialog(null,year+(isleapyear?" is":" is not")+" a leap year");
			String loopString=JOptionPane.showInputDialog(year+(isleapyear?" is":" is not")+" a leap year"+"\nenter \"y \"to continue or \"n\" to quit:");
		    loopChar=Character.parse(loopString);
		}
	}
}