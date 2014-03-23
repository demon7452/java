import javax.swing.JOptionPane;
public class CheckPalindrome
{
	public static void main(String[] args)
	{
		int option=JOptionPane.YES_OPTION;
		while(option==JOptionPane.YES_OPTION)
		{
			String s=JOptionPane.showInputDialog("enter a string:");
			String output="";
			if(isPalindrome(s))
				output=s+" is a palindrome.";
			else
				output=s+" is not a palindrome.";
			JOptionPane.showMessageDialog(null,output);
			option=JOptionPane.showConfirmDialog(null,"enter another?");
		}
	}
	public static boolean isPalindrome(String s)
	{
		int low=0;
		int high=s.length()-1;
		while(low<high)
		{
			if(s.charAt(low)!=s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}
}
