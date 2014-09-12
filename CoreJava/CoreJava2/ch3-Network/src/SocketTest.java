import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program makes a socket connection to the atomic clock in Boulder,Colorado,and
 * prints the time that the server sends
 * @author demon7452
 * @version 2014-9-12
 */
public class SocketTest
{
	public static void main(String[] args)
	{
		try 
		{
			Socket s = new Socket("132.163.4.103",13);//ip对应的域名是time-A.timefreq.bldrdoc.gov
			try 
			{
				InputStream iStream = s.getInputStream();
				Scanner in = new Scanner(iStream);
				while (in.hasNextLine())
				{
					String line = in.nextLine();
					System.out.println(line);
				}
			} 
			finally
			{
				s.close();//close connection
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}