package section5SocketChannel;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.SocketChannel;

/**
 * Demonstrate asyncchronous connection of a SocketChannel.
 * 演示一个socketchannel的异步连接
 * @author lixiong
 * @date 2014-10-27 
 */
public class ConnectAsync
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		String host = "localhost";
		int port = 1234;
		if(args.length == 2)
		{
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		
		InetSocketAddress addr = new InetSocketAddress(host,port);
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);
		System.out.println("Initiating connection");
		sc.connect(addr);
		//测试连接超时，失败！设定阻塞时间。
//		try
//		{
//			sc.socket().connect(addr, 19000); 
//		}
//		catch (IllegalBlockingModeException e)
//		{
//			// TODO: handle exception
//			e.printStackTrace();
//		}
			
		while(!sc.finishConnect())
		{
			System.out.println("尚未完成连接！！");
			//doSomethingUseful();
		}
		System.out.println("connection established");
		//Do something with the connected socket
		//The SocketChannel is still nonblocking
		sc.close();	
	}
}
