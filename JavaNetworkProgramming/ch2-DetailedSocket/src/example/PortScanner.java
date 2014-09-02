package example;

import java.io.IOException;
import java.net.Socket;

public class PortScanner
{
	public void scan(String host) 
	{
		Socket socket = null;
		for(int port = 1; port < 1024;  port++)
		{
			try
			{
				socket = new Socket(host,port);  //当host取值localhost时，表示客户端与服务器在同一主机上
				System.out.println("there is a server on port" +  port);
			}
			catch(IOException e)  //new Socket()会抛出一个IOException
			{
				System.out.println("can not connect to port" + port);
			}
			finally
			{
				try
				{
					if(socket != null)
						socket.close();   //关闭连接
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String [] args)
	{
		String host = "localhost";
		if(args.length > 0)
			host = args[0];
		new PortScanner().scan(host);
	}
	
	
	
	
}