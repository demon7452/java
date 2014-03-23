import javax.swing.JOptionPane;
public class PalindromeIgnoreNonAlphanumeric
{
	public static void main(String[] args)
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
			String s=JOptionPane.showInputDialog("enter a string:");
			String output="ignore nonalphanumeric characters,"+s+(isPalindrome(s)?" is a palindrome!":" is not a palindrome!");
			JOptionPane.showMessageDialog(null,output);
			option=JOptionPane.showConfirmDialog(null,"enter another?");
		}
	}
	public static boolean isPalindrome(String s)
	{
		String s1=filter(s);
		String s2=reverse(s1);
		return s2.equals(s1);
	}
	public static String filter(String s)
	{
		StringBuffer strBuf=new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			if(Character.isLetterOrDigit(s.charAt(i)))
				strBuf.append(s.charAt(i));
		}
		return strBuf.toString();
	}
	public static String reverse(String s)
	{
		StringBuffer strBuf=new StringBuffer(s);
		strBuf.reverse();
		return strBuf.toString();
	}
}
