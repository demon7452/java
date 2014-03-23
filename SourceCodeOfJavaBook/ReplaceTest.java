import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
public class ReplaceTest
{
	public static void main(String[] args) throws Exception
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
			String sourceFileString="";
			File sourceFile=new File(sourceFileString);
			int option1=0;
			while(option1==JOptionPane.YES_OPTION)
			{
			  sourceFileString=JOptionPane.showInputDialog("enter the source file name like input.txt:");
			  sourceFile=new File(sourceFileString);
				if(!sourceFile.exists())
				{
				   option1=JOptionPane.showConfirmDialog(null,"the source file"+sourceFileString+" does not exist,\ndo you want to try again?");
				}
				else
					option1=9;
			}
			if(option1==JOptionPane.NO_OPTION)
			{
			  option=JOptionPane.showConfirmDialog(null,"do you want to replace another text?");
				continue;
			}

			String targetFileString="";
			File targetFile=new File(targetFileString);
			int option2=JOptionPane.NO_OPTION;
			while(option2==JOptionPane.NO_OPTION)
			{
			  targetFileString=JOptionPane.showInputDialog("enter the target file name like output.txt:");
			  targetFile=new File(targetFileString);
				if(targetFile.exists())
				{
				   option2=JOptionPane.showConfirmDialog(null,"the target file"+targetFileString+" already exist,\ndo you want to continue?");
				}
				else
					option2=JOptionPane.YES_OPTION;
			}
			String oldString=JOptionPane.showInputDialog("enter the string you want to replace:");
			String newString=JOptionPane.showInputDialog("enter the string after replacing:");

			Scanner input=new Scanner(sourceFile);
			PrintWriter output=new PrintWriter(targetFile);
			while(input.hasNext())
			{
				String s1=input.nextLine();
				String s2=s1.replaceAll(oldString,newString);
				output.println(s2);
			}
			input.close();
			output.close();

			option=JOptionPane.showConfirmDialog(null,"do you want to replace another text?");
		}
	}
}
