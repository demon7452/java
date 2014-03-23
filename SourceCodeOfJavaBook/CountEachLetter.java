import javax.swing.JOptionPane;
public class CountEachLetter
{
	public static void main(String[] args)
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
			String s=JOptionPane.showInputDialog("enter a string:");
			int[] counts=countLetters(s);
			String output="";
			for(int i=0;i<counts.length;i++)
			{
				if(counts[i]!=0)
					output+=(char)('0'+i)+" appears "+counts[i]+((counts[i]==1)?" time\n":" times\n");
			}
			JOptionPane.showMessageDialog(null,output);
			option=JOptionPane.showConfirmDialog(null,"enter another string?");
		}	
	}
	public static int[] countLetters(String s)
	{
		int[] counts=new int[75];
		for(int i=0;i<s.length();i++)
		{
			if(Character.isLowerCase(s.charAt(i)))
				counts[s.charAt(i)-'0']++;
			else if(Character.isUpperCase(s.charAt(i)))
				counts[s.charAt(i)-'0']++;
			else if(Character.isDigit(s.charAt(i)))
				counts[s.charAt(i)-'0']++;
		}
		return counts;
	}
}
