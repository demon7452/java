import javax.swing.JOptionPane;
public class TestArray
{
	public static void main(String[] args)
	{
		final int totalNumbers=6;
		int[] numbers=new int[totalNumbers];
		
		for(int i=0;i<numbers.length;i++)
		{
			String numString=JOptionPane.showInputDialog("enter a nubmer:");
			numbers[i]=Integer.parseInt(numString);
		}
		int max=numbers[0];
		for(int i=1;i<numbers.length;i++)
		{
			if(numbers[i]>max)
				max=numbers[i];
		}
		int count=0;
		for(int i=0;i<numbers.length;i++)
		{
			if(numbers[i]==max)
				count++;
		}
		
		String output="the arry is:";
		for(int i=0;i<numbers.length;i++)
		{
			output+=numbers[i]+" ";
		}
		output+="\nthe lagest number is "+max+"\nthe occurrence of the largest number is "+count;
		JOptionPane.showMessageDialog(null,output);
	}
}