import javax.swing.JOptionPane;
public class MultiplicationTable
{
	public static void main(String[] args)
	{
		String output="      Multiplication Table\n"
					+"-----------------------------------\n";
		output+=String.format("%3s","|");
		for(int i=1;i<10;i++)
			output+=String.format("%3d",i);
		output+="\n";
		for(int j=1;j<10;j++)
		{
			output+=String.format("%2d%s",j,"|");
			for(int h=1;h<10;h++)
			{		
				output+=String.format("%3d",(j*h));	
			}
			output+="\n";		
		}
		System.out.println(output);
		JOptionPane.showMessageDialog(null,output);
	}
}