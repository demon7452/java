import javax.swing.JOptionPane;
public class CountLettersArray
{
  /**Main method*/
	public static void main(String[] args)
	{
		//Declare and create an array
		char[] chars=createArray();
		String output="the lowercase letters are:\n"+displayArray(chars);
		//Count the occurrences of each letter
		int[] counts=countLetters(chars);
		output=output+"the occurences of each letter are:\n"+displayCounts(counts);
		JOptionPane.showMessageDialog(null,output);
	}
	public static char[] createArray()
	{
		char[] chars=new char[100];
		for(int i=0;i<chars.length;i++)
			chars[i]=RandomCharacter.getRandomLowerCaseLetter();
		return chars;
	}
	public static String displayArray(char[] chars)
	{
		String output="";
		for(int i=0;i<chars.length;i++)
		{
			if((i+1)%20==0)
			   output+=chars[i]+"\n";
			 else 
			   output+=chars[i]+" ";
		}
		return output;
	}
	public static int[] countLetters(char[] chars)
	{
		int[] counts=new int[26];
		for(int i=0;i<chars.length;i++)
		    counts[chars[i]-'a']++;
		return counts;
	}
	public static String displayCounts(int[] counts)
	{
		String output="";
		for(int i=0;i<counts.length;i++)
		{
			if((i+1)%10==0)
				output+=counts[i]+" "+(char)(i+'a')+"\n";
			else 
				output+=counts[i]+" "+(char)(i+'a')+" ";
		}
		return output;
	}
}
