import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
			Socket incomingSocket = serverSocket.accept();//ServerSocket.accep()返回一个套接字对象，并进入连接阻塞
			try
			{
				InputStream inStream = incomingSocket.getInputStream();
				OutputStream outStream = incomingSocket.getOutputStream();
				
				Scanner in = new Scanner(inStream);//获取客户端输入数据
				PrintWriter out = new PrintWriter(outStream,true /* autoFlush */ );//自动清空并发送？
				
				out.println("hello! print 'bye' to exit!");//成功连接进行问候
				System.out.println("客户端链接：" + incomingSocket.getRemoteSocketAddress());
				boolean done = false;
				while(!done && in.hasNextLine())
				{
					String lineString = in.nextLine();
					System.out.println("client: "+lineString);
					out.println("received: "+lineString);
					if(lineString.trim().equals("bye"))
						done = true;
				}
				System.out.println("断开连接！");
				out.println("close link");
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				e.printStackTrace();
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