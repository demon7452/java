import java.io.File;
import java.io.PrintWriter;
public class WriteData
{
	public static void main(String[] args)throws Exception
	{
		File file=new File("image/out.txt");
		if(!file.exists())
		{
			System.out.println("file already exists");
			System.exit(0);
		}
		PrintWriter output=new PrintWriter(file);
		output.print("john T Smith ");
		output.println(90);
		output.print("eric K johnes ");
		output.println(80);
		output.close();
	}
}
