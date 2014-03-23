import javax.swing.JOptionPane;
public class PrintPyramid
{
	public static void main(String [] args)
	{
		int option=0;
		do
		{
			String lineString=JOptionPane.showInputDialog("enter the lines of pyramid(1-13):");
			int lines=Integer.parseInt(lineString);
			if(lines<1||lines>13)
			{
				option=JOptionPane.showConfirmDialog(null,"you enter a wrong line!"+"\ntry again?");
			}
			else
			{
				for(int row=1;row<=lines;row++)
				{
					for(int column=1;column<=lines-row;column++)
						System.out.printf("%3s"," ");
					for(int num=row;num>=1;num--)
						System.out.printf("%3d",num);
					for(int num=2;num<=row;num++)
						System.out.printf("%3d",num);
					System.out.println();
				}
				
				option=JOptionPane.showConfirmDialog(null,"print pyramid once more?");
			}
		}while(option==JOptionPane.YES_OPTION);
		
	}
}