import javax.swing.JOptionPane;
public class SentinelValue
{
	public static void main(String[] args)
	{
		String dataString=JOptionPane.showInputDialog("enter an integer:\n(the program exit if the input is 0))");
		int data=Integer.parseInt(dataString);
		String output="  "+dataString;
		int sum=0;
		while(data!=0)
		{
			sum+=data;
			dataString=JOptionPane.showInputDialog(output+"\nenter an integer:\n(the program exit if the input is 0))");
			data=Integer.parseInt(dataString);
			if(data!=0)
				output=output+"\n+"+dataString;		
		}
		JOptionPane.showMessageDialog(null,output+"\nthe sum is "+sum,"consequence",JOptionPane.INFORMATION_MESSAGE);
	}
}