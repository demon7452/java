package section5SocketChannel;

import java.net.InetSocketAddress;
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
