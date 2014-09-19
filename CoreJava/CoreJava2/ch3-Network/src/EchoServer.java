import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This program implements a simple server that listens to port 8189 and echoes back all
 * client input
 * @author demon7452
 * @version 2014-9-18
 */
public class EchoServer
{
	public static void main(String[] args)
	{
		try 
		{
			//establish a server socket
			ServerSocket serverSocket = new ServerSocket(8189);
			
			//wait for client connection
			Socket incomingSocket = serverSocket.accept();
			try
			{
				
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
			}
			finally
			{
				if(incomingSocket != null)
					incomingSocket.close();
			}
		}
		catch (IOException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}